package useful.things;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class CalculatorActivity extends AppCompatActivity {

    TextView txt;
    char signbuff;
    int buffer=0;
    String buff="";
    Button bplus;
    Button bminus;
    Button bmulti;
    Button bdiv;
    Button equel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        bplus =(Button) findViewById(R.id.plus);
        bminus =(Button) findViewById(R.id.minus);
        bmulti =(Button) findViewById(R.id.multyply);
        bdiv =(Button) findViewById(R.id.division);
        equel =(Button) findViewById(R.id.equal);
        txt = (TextView) findViewById(R.id.txt);
    equel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (signbuff){
                case '+':
                    buffer += Integer.parseInt(buff);
                    txt.setText(String.valueOf(buffer));
                    break;
                case '-':
                    buffer -= Integer.parseInt(buff);
                    txt.setText(String.valueOf(buffer));
                    break;
                case '*':
                    buffer *= Integer.parseInt(buff);
                    txt.setText(String.valueOf(buffer));
                    break;
                case '/':
                    buffer /= Integer.parseInt(buff);
                    txt.setText(String.valueOf(buffer));
                    break;
            }
        }
    });
    }


    public void setNumb(View view) {
        Button numb = (Button)view;
        txt.setText(txt.getText().toString()+numb.getText().toString());
       // buff=(txt.getText().toString()+numb.getText().toString());
        buff+=numb.getText().toString();
        //setenablesign(true);
    }
//app:srcCompat="@drawable/calculatorscreen"
    public void sign(View view) {
        Button sign = (Button) view;
        signbuff = sign.getText().charAt(0);
        buffer = Integer.parseInt(buff.toString());
        txt.setText(txt.getText().toString()+sign.getText().toString());
        buff="";
        setenablesign(false);
    }

    public void setenablesign (boolean isenable){
        if (isenable==true){
            bplus.setEnabled(true);
            bminus.setEnabled(true);
            bmulti.setEnabled(true);
            bdiv.setEnabled(true);
        }
        else {
            bplus.setEnabled(false);
            bminus.setEnabled(false);
            bmulti.setEnabled(false);
            bdiv.setEnabled(false);
        }
    }
}
