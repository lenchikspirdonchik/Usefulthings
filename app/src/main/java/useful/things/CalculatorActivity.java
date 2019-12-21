package useful.things;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class CalculatorActivity extends AppCompatActivity {

    TextView txt;
    int signbuff=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button b0 = findViewById(R.id.b0);
        txt = (TextView) findViewById(R.id.txt);








    }


    public void setNumb(View view) {
        Button numb = (Button)view;
        txt.setText(txt.getText().toString()+numb.getText().toString());
    }

    public void sign(View view) {
        Button sign = (Button)view;
        if (sign.getText().toString().equals("+")) signbuff=0;
        else if (sign.getText().toString().equals("-")) signbuff=1;
        else if (sign.getText().toString().equals("*")) signbuff=2;
        else signbuff=3;
        txt.setText(txt.getText().toString()+sign.getText().toString());
    }
}
