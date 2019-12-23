package useful.things;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NumSysCtivity extends AppCompatActivity {
    EditText vvodtxt;
    Button btn_count;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numsys);
        vvodtxt=(EditText)findViewById(R.id.vvodtxt);
        btn_count=(Button)findViewById(R.id.btn_count);
        txt=(TextView)findViewById(R.id.textView);

        vvodtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vvodtxt.setText("");
            }
        });

        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(vvodtxt.getText().toString());
                
                txt.setText("Десятичное число "+ a +" равно" + a);
            }
        });
    }
}
