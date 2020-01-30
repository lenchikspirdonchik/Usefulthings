package useful.spiridonov;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    int SPLASH_DISPLAY_LENGHT = 1500;
    int hoho = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final TextView txt = findViewById(R.id.txt2);
        txt.setText(". ");
        for (int i = 0; i < 8; i++) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    txt.setText(txt.getText().toString() + ". ");
                    hoho += 1000;

                }
            }, hoho);
        }







        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mainIntent = new Intent(StartActivity.this, MainActivity.class);
                StartActivity.this.startActivity(mainIntent);
                StartActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }



}
