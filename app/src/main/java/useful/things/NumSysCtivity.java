package useful.things;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NumSysCtivity extends AppCompatActivity {
    EditText vvodtxt;
    Button btn_count;
    TextView txtbin;
    TextView txtoct;
    TextView txthex;
    TextView txtotvet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numsys);
        vvodtxt=(EditText)findViewById(R.id.vvodtxt);
        btn_count=(Button)findViewById(R.id.btn_count);
        txtbin=(TextView)findViewById(R.id.txtbin);
        txtoct=(TextView)findViewById(R.id.txtoctal);
        txthex=(TextView)findViewById(R.id.txthex);
        txtotvet=(TextView)findViewById(R.id.txtotvet);
        vvodtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vvodtxt.setText("");
            }
        });

        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vvodtxt.getText().toString().equals("") || vvodtxt.getText().toString().equals(getResources().getString(R.string.VvodNextNumSys))){
                    Toast.makeText(NumSysCtivity.this, "Вы ничего не ввели", Toast.LENGTH_LONG).show();

                }else { txtotvet.setText("Десятичное число "+ vvodtxt.getText().toString() +" равно:");
                    txtbin.setText(Integer.toBinaryString(Integer.parseInt(vvodtxt.getText().toString())) + " в двоичной системе");
                    txtoct.setText(Integer.toOctalString(Integer.parseInt(vvodtxt.getText().toString())) + " в восьмиричной системе");
                    txthex.setText(Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase() + " в шестандцатиричной системе");
                }


            }
        });
    }
}
