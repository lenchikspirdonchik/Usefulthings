package useful.things;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class CalcNumSysCActivity extends AppCompatActivity {
    EditText vvodtxt1, vvodtxt2;
    RadioGroup radioGroup1, radioGroup2,radioGroup3;
    String numb1, numb2;
    TextView txt0, txt1, txt2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcnumsus);
        vvodtxt1=(EditText)findViewById(R.id.vvodtxt1);
        vvodtxt2=(EditText)findViewById(R.id.vvodtxt2);
        txt0=(TextView) findViewById(R.id.txt0);
        txt1=(TextView) findViewById(R.id.txt1);
        txt2=(TextView) findViewById(R.id.txt2);
        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radiogroup3);
// binary  decimal   hexadecimal  octal
// (String number,String in, String out){
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbbinary1:
               numb1=NumSysConvension.NumSysConvension(vvodtxt1.getText().toString(),"binary","decimal");
                break;
            case R.id.rbdecimal1:
                numb1=vvodtxt1.getText().toString();
                break;
            case R.id.rbhex1:
                numb1=NumSysConvension.NumSysConvension(vvodtxt1.getText().toString(),"hexadecimal","decimal");
            break;
            case R.id.rboctal1:
                numb1=NumSysConvension.NumSysConvension(vvodtxt1.getText().toString(),"octal","decimal");
                break;
            default:
                break;
        }
    }
});
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbbinary2:
                        numb2=NumSysConvension.NumSysConvension(vvodtxt1.getText().toString(),"binary","decimal");
                        break;
                    case R.id.rbdecimal2:
                        numb2=vvodtxt1.getText().toString();
                        break;
                    case R.id.rbhex2:
                        numb2=NumSysConvension.NumSysConvension(vvodtxt1.getText().toString(),"hexadecimal","decimal");
                        break;
                    case R.id.rboctal2:
                        numb2=NumSysConvension.NumSysConvension(vvodtxt1.getText().toString(),"octal","decimal");
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (vvodtxt1.getText().toString().equals("") || vvodtxt2.getText().toString().equals("")){
                    Toast.makeText(CalcNumSysCActivity.this, "Вы ничего не ввели", Toast.LENGTH_SHORT).show();

                }else {
                    int a = Integer.parseInt(numb1);
                    switch (checkedId) {
                        case R.id.btnplus:
                            try {
                                a+=Integer.parseInt(numb2);
                                txt0.setText(Integer.toOctalString(a)+ " "+getResources().getString(R.string.in_the_octal_system));
                                txt1.setText(Integer.toHexString(a).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                                txt2.setText(String.valueOf(a)+ " "+getResources().getString(R.string.in_the_decimal_system));

                            }
                            catch (Exception e) {
                                Toast.makeText(CalcNumSysCActivity.this, getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case R.id.btnminus:
                            try {
                                a-=Integer.parseInt(numb2);
                                txt0.setText(Integer.toOctalString(a)+ " "+getResources().getString(R.string.in_the_octal_system));
                                txt1.setText(Integer.toHexString(a).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                                txt2.setText(String.valueOf(a)+ " "+getResources().getString(R.string.in_the_decimal_system));

                            }
                            catch (Exception e) {
                                Toast.makeText(CalcNumSysCActivity.this, getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;

                        case R.id.btnmulti:
                            try {
                                a*=Integer.parseInt(numb2);
                                txt0.setText(Integer.toOctalString(a)+ " "+getResources().getString(R.string.in_the_octal_system));
                                txt1.setText(Integer.toHexString(a).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                                txt2.setText(String.valueOf(a)+ " "+getResources().getString(R.string.in_the_decimal_system));

                            }
                            catch (Exception e) {
                                Toast.makeText(CalcNumSysCActivity.this, getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;

                        case R.id.btndiv:
                            try {
                                a/=Integer.parseInt(numb2);
                                txt0.setText(Integer.toOctalString(a)+ " "+getResources().getString(R.string.in_the_octal_system));
                                txt1.setText(Integer.toHexString(a).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                                txt2.setText(String.valueOf(a)+ " "+getResources().getString(R.string.in_the_decimal_system));

                            }
                            catch (Exception e) {
                                Toast.makeText(CalcNumSysCActivity.this, getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;

                            default:
                            break;
                    }
                }
            }
        });
    }


}
