package useful.things;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculator = findViewById(R.id.btn_calc);
        Button numeralsystems = findViewById(R.id.btn_numsys);
        Button calcform = findViewById(R.id.btn_calcform);


        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);

            }
        });
    }


}
