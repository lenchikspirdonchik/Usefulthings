package useful.things;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class CalculatorActivity extends AppCompatActivity {

    TextView txt;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b00, bpoint, bplus, bminus, bmulti, bdiv, bequel, bdelete, bdelonechar;
     char opt = ' ';
     boolean go = true, addWrite = true, bool = false;
     double val = 1;
     String buffertxt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        txt = (TextView) findViewById(R.id.txt);
        bplus = (Button) findViewById(R.id.plus);
        bminus = (Button) findViewById(R.id.minus);
        bmulti = (Button) findViewById(R.id.multyply);
        bdiv = (Button) findViewById(R.id.division);
        bequel = (Button) findViewById(R.id.equal);
        bdelete = (Button) findViewById(R.id.delete);
        bdelonechar = (Button) findViewById(R.id.delonechar);
        b1 = (Button) findViewById(R.id.btn_1);
        b2 = (Button) findViewById(R.id.btn_2);
        b3 = (Button) findViewById(R.id.btn_3);
        b4 = (Button) findViewById(R.id.btn_4);
        b5 = (Button) findViewById(R.id.btn_5);
        b6 = (Button) findViewById(R.id.btn_6);
        b7 = (Button) findViewById(R.id.btn_7);
        b8 = (Button) findViewById(R.id.btn_8);
        b9 = (Button) findViewById(R.id.btn_9);
        b0 = (Button) findViewById(R.id.btn_0);
        b00 = (Button) findViewById(R.id.btn_00);
        bpoint = (Button) findViewById(R.id.btn_point);

        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              txt.setText("");
                opt = ' ';
                val = 0;
                buffertxt="";
            }
        });
        bdelonechar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String str = txt.getText().toString();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < (str.length() - 1); i++) {
            str2.append(str.charAt(i));
        }
        if (str2.toString().equals("")) {
            txt.setText("0");
        } else {
            txt.setText(str2.toString());
        }
    }
});

        View.OnClickListener btnnum = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button numbtn = (Button) v;
                if (addWrite) {
                    if (Pattern.matches("[0]*", txt.getText().toString())) {
                        txt.setText(numbtn.getText().toString());
                    } else {
                        txt.setText(txt.getText().toString()+numbtn.getText().toString());
                    }
                } else {
                    txt.setText(txt.getText().toString());
                    addWrite = true;
                }
                go = true;
            }
        };

        View.OnClickListener btncalculat = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button calculatbtn = (Button) v;
                opt=calculatbtn.getText().toString().charAt(0);
                if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", txt.getText().toString()))
                    if (go) {
                        val = calc(val, txt.getText().toString(), opt);
                        if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                            txt.setText(String.valueOf((int) val));
                        } else {
                            txt.setText(String.valueOf(val));
                        }
                        opt=calculatbtn.getText().toString().charAt(0);
                        go = false;
                        addWrite = false;
                    } else {
                        opt=calculatbtn.getText().toString().charAt(0);
                    }
            }
        };



bpoint.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (addWrite) {
            txt.setText(txt.getText().toString() + ".");
        } else {
            txt.setText("0.");
            addWrite = true;
        }
        go = true;
    }
});
bequel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", txt.getText().toString()))
            if (go) {
                val = calc(val, txt.getText().toString(), opt);
                if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                    txt.setText(String.valueOf((int) val));
                } else {
                    txt.setText(String.valueOf(val));
                }
                opt = '=';
                addWrite = false;
            }
    }
});
        b1.setOnClickListener(btnnum);
        b2.setOnClickListener(btnnum);
        b3.setOnClickListener(btnnum);
        b4.setOnClickListener(btnnum);
        b5.setOnClickListener(btnnum);
        b6.setOnClickListener(btnnum);
        b7.setOnClickListener(btnnum);
        b8.setOnClickListener(btnnum);
        b9.setOnClickListener(btnnum);
        b0.setOnClickListener(btnnum);
        b00.setOnClickListener(btnnum);
        bplus.setOnClickListener(btncalculat);
        bminus.setOnClickListener(btncalculat);
        bdiv.setOnClickListener(btncalculat);
        bmulti.setOnClickListener(btncalculat);
    }
// val = calc(val, txt.getText().toString(), opt);
     public double calc(double x, String input, char opt) {
        double y = Double.parseDouble(input);
        if (opt == '+') {
            return x + y;
        } else if (opt == '-') {
            return x - y;
        } else if (opt == '*') {
            return x * y;
        } else if (opt == '/') {
            return x / y;
        } else if (opt == '%') {
            return x % y;
        } else {
            return y;
        }
    }
}
