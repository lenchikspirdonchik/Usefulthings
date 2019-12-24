package useful.things;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class NumSysCtivity extends AppCompatActivity {
    EditText vvodtxt;
    TextView txtbin;
    TextView txtoct;
    TextView txthex;
    TextView txtdec;
    TextView txtotvet;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numsys);
        vvodtxt=(EditText)findViewById(R.id.vvodtxt);
        txtbin=(TextView)findViewById(R.id.txtbin);
        txtoct=(TextView)findViewById(R.id.txtoctal);
        txthex=(TextView)findViewById(R.id.txthex);
        txtdec=(TextView)findViewById(R.id.txtdec);
        txtotvet=(TextView)findViewById(R.id.txtotvet);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        vvodtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vvodtxt.setText("");
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (vvodtxt.getText().toString().equals("") || vvodtxt.getText().toString().equals(getResources().getString(R.string.VvodNextNumSys))){
                    Toast.makeText(NumSysCtivity.this, "Вы ничего не ввели", Toast.LENGTH_SHORT).show();

                }else {
                    BigInteger dec;
                    switch (checkedId) {
                        case R.id.rbbinary:
                             dec =new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString()))).toString(10),2);
                            txtbin.setText("");
                            txtotvet.setText(getResources().getString(R.string.in_the_binary_system)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString()+" "+getResources().getString(R.string.Equal) +":");
                            txtoct.setText(Integer.toOctalString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_octal_system));
                            txthex.setText(Integer.toHexString(Integer.parseInt(dec.toString())).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                            txtdec.setText(String.valueOf(dec)+ " "+getResources().getString(R.string.in_the_decimal_system));

                            break;
                        case R.id.rbdecimal:
                            txtdec.setText("");
                            txtotvet.setText(getResources().getString(R.string.in_the_decimal_system)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString()+" "+getResources().getString(R.string.Equal) +":");
                            txtbin.setText(Integer.toBinaryString(Integer.parseInt(vvodtxt.getText().toString())) + " "+getResources().getString(R.string.in_the_binary_system));
                            txtoct.setText(Integer.toOctalString(Integer.parseInt(vvodtxt.getText().toString()))+ " "+getResources().getString(R.string.in_the_octal_system));
                            txthex.setText(Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));


                            break;
                        case R.id.rbhex:
                            dec = BigInteger.valueOf(hextodec(vvodtxt.getText().toString().toUpperCase()));
                            txthex.setText("");
                            txtotvet.setText(getResources().getString(R.string.Hexadecimal)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString().toUpperCase()+" "+getResources().getString(R.string.Equal) +":");
                            txtbin.setText(Integer.toBinaryString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_binary_system));
                            txtoct.setText(Integer.toOctalString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_octal_system));
                            txtdec.setText(String.valueOf(dec)+ " "+getResources().getString(R.string.in_the_decimal_system));

                            break;
                        case R.id.rboctal:
                            txtoct.setText("");
                            dec =new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString()))).toString(10),8);
                            txtotvet.setText(getResources().getString(R.string.in_the_octal_system)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString()+" "+getResources().getString(R.string.Equal) +":");
                            txtbin.setText(Integer.toBinaryString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_binary_system));
                            txthex.setText(Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                            txtdec.setText(String.valueOf(dec)+ " "+getResources().getString(R.string.in_the_decimal_system));


                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }
    public static int hextodec(String hex) {
        String digits = "0123456789ABCDEF";
        int val = 0;
        for (int i = 0; i < hex.length(); i++) {
            char j = hex.charAt(i);
            int k = digits.indexOf(j);
            val = 16*val + k;
        }
        return val;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("txtotvet", txtotvet.getText().toString());
        outState.putString("txtbin", txtbin.getText().toString());
        outState.putString("txthex", txthex.getText().toString());
        outState.putString("txtdec", txtdec.getText().toString());
        outState.putString("txtoct", txtoct.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        txtotvet.setText(savedInstanceState.getString("txtotvet"));
        txtbin.setText(savedInstanceState.getString("txtbin"));
        txthex.setText(savedInstanceState.getString("txthex"));
        txtdec.setText(savedInstanceState.getString("txtdec"));
        txtoct.setText(savedInstanceState.getString("txtoct"));
    }
}
