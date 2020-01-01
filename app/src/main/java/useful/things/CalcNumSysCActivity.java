package useful.things;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class CalcNumSysCActivity extends AppCompatActivity {
    EditText vvodtxt1, vvodtxt2;
    RadioGroup radioGroup1, radioGroup2,radioGroup3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcnumsus);
        vvodtxt1=(EditText)findViewById(R.id.vvodtxt1);
        vvodtxt2=(EditText)findViewById(R.id.vvodtxt2);
        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radiogroup3);



        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (vvodtxt1.getText().toString().equals("") || vvodtxt2.getText().toString().equals("")){
                    Toast.makeText(CalcNumSysCActivity.this, "Вы ничего не ввели", Toast.LENGTH_SHORT).show();

                }else {
                    switch (checkedId) {
                        case R.id.btnplus:
                            try {
                               //int a= NumSysConvension(vvodtxt1.getText().toString(), );

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
