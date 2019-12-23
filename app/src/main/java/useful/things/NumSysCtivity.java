package useful.things;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
                            txtotvet.setText(getResources().getString(R.string.Binary)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString()+" "+getResources().getString(R.string.Equal) +":");
                            txtbin.setText(vvodtxt.getText().toString() + " "+getResources().getString(R.string.in_the_binary_system));
                            txtoct.setText(Integer.toOctalString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_octal_system));
                            txthex.setText(Integer.toHexString(Integer.parseInt(dec.toString())).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                            txtdec.setText(String.valueOf(dec)+ " "+getResources().getString(R.string.in_the_decimal_system));

                            break;
                        case R.id.rbdecimal:
                            txtotvet.setText(getResources().getString(R.string.decimal)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString()+" "+getResources().getString(R.string.Equal) +":");
                            txtbin.setText(Integer.toBinaryString(Integer.parseInt(vvodtxt.getText().toString())) + " "+getResources().getString(R.string.in_the_binary_system));
                            txtoct.setText(Integer.toOctalString(Integer.parseInt(vvodtxt.getText().toString()))+ " "+getResources().getString(R.string.in_the_octal_system));
                            txthex.setText(Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                            txtdec.setText(vvodtxt.getText().toString()+ " "+getResources().getString(R.string.in_the_decimal_system));


                            break;
                        case R.id.rbhex:
                           /* dec =new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString().toUpperCase()))).toString(10),16);
                            txtotvet.setText(getResources().getString(R.string.Hexadecimal)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString().toUpperCase()+" "+getResources().getString(R.string.Equal) +":");
                            txtbin.setText(Integer.toBinaryString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_binary_system));
                            txtoct.setText(Integer.toOctalString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_octal_system));
                            txthex.setText(vvodtxt.getText().toString().toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                            txtdec.setText(String.valueOf(dec)+ " "+getResources().getString(R.string.in_the_decimal_system));*/

                            break;
                        case R.id.rboctal:
                           /* dec =new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString().toUpperCase()))).toString(10),16);
                            txtotvet.setText(getResources().getString(R.string.Hexadecimal)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString().toUpperCase()+" "+getResources().getString(R.string.Equal) +":");
                            txtbin.setText(Integer.toBinaryString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_binary_system));
                            txtoct.setText(Integer.toOctalString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_octal_system));
                            txthex.setText(vvodtxt.getText().toString().toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                            txtdec.setText(String.valueOf(dec)+ " "+getResources().getString(R.string.in_the_decimal_system));*/


                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }
}
