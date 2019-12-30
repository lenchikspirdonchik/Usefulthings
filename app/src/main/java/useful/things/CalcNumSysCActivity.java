package useful.things;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CalcNumSysCActivity extends AppCompatActivity {
    EditText vvodtxt1;
    EditText vvodtxt2;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcnumsus);
        vvodtxt1=(EditText)findViewById(R.id.vvodtxt1);
        vvodtxt2=(EditText)findViewById(R.id.vvodtxt2);

    }
}
