package useful.spiridonov.ui.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.regex.Pattern;

import useful.spiridonov.Calc;
import useful.spiridonov.R;

public class CalcFragment extends Fragment {
    TextView txt;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b00, bpoint, bplus, bminus, bmulti, bdiv, bequel, bdelete, bdelonechar, rightbr, leftbr;
    char opt = ' ';
    boolean go = true, addWrite = true, ifequal = false, flagaction = false;
    double val = 0;
    String buffer = "", res = "";
    private CalcViewModel calcViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        calcViewModel = ViewModelProviders.of(this).get(CalcViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calc, container, false);
        txt = root.findViewById(R.id.txt);
        bplus = root.findViewById(R.id.plus);
        bminus = root.findViewById(R.id.minus);
        bmulti = root.findViewById(R.id.multyply);
        bdiv = root.findViewById(R.id.division);
        bequel = root.findViewById(R.id.equal);
        bdelete = root.findViewById(R.id.delete);
        bdelonechar = root.findViewById(R.id.delonechar);
        b1 = root.findViewById(R.id.btn_1);
        b2 = root.findViewById(R.id.btn_2);
        b3 = root.findViewById(R.id.btn_3);
        b4 = root.findViewById(R.id.btn_4);
        b5 = root.findViewById(R.id.btn_5);
        b6 = root.findViewById(R.id.btn_6);
        b7 = root.findViewById(R.id.btn_7);
        b8 = root.findViewById(R.id.btn_8);
        b9 = root.findViewById(R.id.btn_9);
        b0 = root.findViewById(R.id.btn_0);
        b00 = root.findViewById(R.id.btn_00);
        bpoint = root.findViewById(R.id.btn_point);
        rightbr = root.findViewById(R.id.rightBr);
        leftbr = root.findViewById(R.id.leftBr);
        ArrayList<Button> buttonArrayList = new ArrayList<>();
        ArrayList<Button> buttonactionArrayList = new ArrayList<>();
        buttonactionArrayList.add(bplus);
        buttonactionArrayList.add(bminus);
        buttonactionArrayList.add(bmulti);
        buttonactionArrayList.add(bdiv);
        buttonactionArrayList.add(rightbr);
        buttonactionArrayList.add(leftbr);
        buttonArrayList.add(b1);
        buttonArrayList.add(b2);
        buttonArrayList.add(b3);
        buttonArrayList.add(b4);
        buttonArrayList.add(b5);
        buttonArrayList.add(b6);
        buttonArrayList.add(b7);
        buttonArrayList.add(b8);
        buttonArrayList.add(b9);
        buttonArrayList.add(b0);
        buttonArrayList.add(b00);


        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(" ");
                opt = ' ';
                val = 0;
                buffer = "";
                ifequal = false;
                flagaction = false;
            }
        });
        bdelonechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = txt.getText().toString();
                StringBuilder str2 = new StringBuilder();
                for (int i = 0; i < (str.length() - 1); i++) str2.append(str.charAt(i));
                if (str2.toString().equals("")) {
                    txt.setText(" ");
                    opt = ' ';
                    val = 0;
                    buffer = " ";
                    ifequal = false;
                    flagaction = false;
                } else {
                    txt.setText(str2.toString());
                    buffer = (str2.toString());
                }
            }
        });

        View.OnClickListener btnnum = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button numbtn = (Button) v;
                if (ifequal == true) {
                    txt.setText(numbtn.getText().toString());
                    buffer = numbtn.getText().toString();
                    ifequal = false;

                } else {
                    if (addWrite) {
                        if (Pattern.matches("[0]*", buffer)) {
                            txt.setText(numbtn.getText().toString());
                            buffer = (numbtn.getText().toString());
                        } else {
                            buffer = (buffer + numbtn.getText().toString());
                            txt.setText(buffer);
                        }
                    } else {
                        txt.setText(numbtn.getText().toString());
                        buffer = numbtn.getText().toString();
                        addWrite = true;
                    }
                    go = true;
                }
            }
        };

        View.OnClickListener btncalculat = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button calculatbtn = (Button) v;
                if (ifequal == true) {
                    ifequal = false;
                    buffer = res + calculatbtn.getText().toString();
                    txt.setText(buffer);
                } else {
                    buffer = (buffer + calculatbtn.getText().toString());
                    txt.setText(buffer);
                }
                flagaction = true;
            }
        };

        bpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString() + ".");
                buffer = (txt.getText().toString() + ".");
            }
        });
        bequel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagaction == true) {
                    try {
                        res = Calc.Ideone.Calc(buffer);

                        if (res.equals("Infinity"))
                            Toast.makeText(getActivity(), getResources().getString(R.string.divonzero), Toast.LENGTH_SHORT).show();
                        else {
                            if (res.equals("E"))
                                Toast.makeText(getActivity(), getResources().getString(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                            else {
                                buffer = res;
                                txt.setText(txt.getText().toString() + "=" + res);
                            }
                        }
                        ifequal = true;
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), getResources().getString(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                    }
                }
                flagaction = false;
            }
        });


        for (Button haha : buttonArrayList
        ) {
            haha.setOnClickListener(btnnum);
        }
        for (Button hoho : buttonactionArrayList
        ) {
            hoho.setOnClickListener(btncalculat);
        }
        return root;
    }
}