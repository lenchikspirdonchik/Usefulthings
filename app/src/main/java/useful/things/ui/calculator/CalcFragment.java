package useful.things.ui.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.regex.Pattern;

import useful.things.R;

public class CalcFragment extends Fragment {
    TextView txt;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b00, bpoint, bplus, bminus, bmulti, bdiv, bequel, bdelete, bdelonechar;
    char opt = ' ';
    boolean go = true, addWrite = true;
    double val = 0;
    String buffer="";
    private CalcViewModel calcViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calcViewModel =
                ViewModelProviders.of(this).get(CalcViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calc, container, false);
       /* final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        txt = (TextView) root.findViewById(R.id.txt);
        bplus = (Button)root.findViewById(R.id.plus);
        bminus = (Button) root.findViewById(R.id.minus);
        bmulti = (Button) root.findViewById(R.id.multyply);
        bdiv = (Button) root.findViewById(R.id.division);
        bequel = (Button) root.findViewById(R.id.equal);
        bdelete = (Button) root.findViewById(R.id.delete);
        bdelonechar = (Button) root.findViewById(R.id.delonechar);
        b1 = (Button) root.findViewById(R.id.btn_1);
        b2 = (Button) root.findViewById(R.id.btn_2);
        b3 = (Button) root.findViewById(R.id.btn_3);
        b4 = (Button) root.findViewById(R.id.btn_4);
        b5 = (Button) root.findViewById(R.id.btn_5);
        b6 = (Button) root.findViewById(R.id.btn_6);
        b7 = (Button) root.findViewById(R.id.btn_7);
        b8 = (Button) root.findViewById(R.id.btn_8);
        b9 = (Button) root.findViewById(R.id.btn_9);
        b0 = (Button) root.findViewById(R.id.btn_0);
        b00 = (Button) root.findViewById(R.id.btn_00);
        bpoint = (Button) root.findViewById(R.id.btn_point);

        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
                opt = ' ';
                val = 0;
                buffer="";
            }
        });
        bdelonechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = txt.getText().toString();
                StringBuilder str2 = new StringBuilder();
                for (int i = 0; i < (str.length() - 1); i++) str2.append(str.charAt(i));
                if (str2.toString().equals("")) {
                    txt.setText("0");
                    buffer="0";
                }
                else {
                    txt.setText(str2.toString());
                    buffer=(str2.toString());
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
                        buffer=(numbtn.getText().toString());
                    } else {
                        txt.setText(txt.getText().toString() + numbtn.getText().toString());
                        buffer=(txt.getText().toString() + numbtn.getText().toString());
                    }
                } else {
                    txt.setText(numbtn.getText().toString());
                    addWrite = true;
                }
                go = true;
            }
        };

        View.OnClickListener btncalculat = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button calculatbtn = (Button) v;
                //opt=calculatbtn.getText().toString().charAt(0);
                if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", txt.getText().toString()))
                    if (go) {
                        val = calc(val, txt.getText().toString(), opt);
                        if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) txt.setText(String.valueOf((int) val));
                        else txt.setText(String.valueOf(val));
                        opt = calculatbtn.getText().toString().charAt(0);
                        go = false;
                        addWrite = false;
                    } else {
                        opt = calculatbtn.getText().toString().charAt(0);
                        txt.setText(String.valueOf((int) val));
                    }
            }
        };

        bpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addWrite) txt.setText(txt.getText().toString() + ".");
                else {
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
                        if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) txt.setText(String.valueOf((int) val));
                        else txt.setText(String.valueOf(val));
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



        return root;
    }
    public double calc(double x, String input, char opt) {
        double y = Double.parseDouble(input);
        switch (opt){
            case '+':return x + y;
            case '-':return x - y;
            case '*':return x * y;
            case '/':return x / y;
            case '%':return x % y;
            default:return y;

        }
    }
}