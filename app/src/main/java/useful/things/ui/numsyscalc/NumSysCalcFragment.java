package useful.things.ui.numsyscalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import useful.things.NumSysConvension;
import useful.things.R;

public class NumSysCalcFragment extends Fragment {
    EditText vvodtxt1, vvodtxt2;
    RadioGroup radioGroup1, radioGroup2, radioGroup3;
    String numb1, numb2;
    TextView txt0, txt1, txt2, txt3;
    private NumSysCalcViewModel navNumSysCalcViewModel;
    int a, b;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        navNumSysCalcViewModel = ViewModelProviders.of(this).get(NumSysCalcViewModel.class);
        View root = inflater.inflate(R.layout.fragment_numsyscalc, container, false);
        vvodtxt1 = (EditText) root.findViewById(R.id.vvodtxt1);
        vvodtxt2 = (EditText) root.findViewById(R.id.vvodtxt2);
        txt0 = (TextView) root.findViewById(R.id.txt0);
        txt1 = (TextView) root.findViewById(R.id.txt1);
        txt2 = (TextView) root.findViewById(R.id.txt2);
        txt3 = (TextView) root.findViewById(R.id.txt3);
        radioGroup1 = (RadioGroup) root.findViewById(R.id.radiogroup1);
        radioGroup2 = (RadioGroup) root.findViewById(R.id.radiogroup2);
        radioGroup3 = (RadioGroup) root.findViewById(R.id.radiogroup3);
// binary  decimal   hexadecimal  octal
// (String number,String in, String out){
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbbinary1:
                        numb1 = "";
                        numb1 = NumSysConvension.NumSysConvension(vvodtxt1.getText().toString(), "binary", "decimal");
                        break;
                    case R.id.rbdecimal1:
                        numb1 = "";
                        numb1 = vvodtxt1.getText().toString();
                        break;
                    case R.id.rbhex1:
                        numb1 = "";
                        numb1 = NumSysConvension.NumSysConvension(vvodtxt1.getText().toString(), "hexadecimal", "decimal");
                        break;
                    case R.id.rboctal1:
                        numb1 = "";
                        numb1 = NumSysConvension.NumSysConvension(vvodtxt1.getText().toString(), "octal", "decimal");
                        break;
                    default:
                        break;
                }
            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbbinary2:
                        numb2 = "";
                        numb2 = NumSysConvension.NumSysConvension(vvodtxt2.getText().toString(), "binary", "decimal");
                        break;
                    case R.id.rbdecimal2:
                        numb2 = "";
                        numb2 = vvodtxt2.getText().toString();
                        break;
                    case R.id.rbhex2:
                        numb2 = "";
                        numb2 = NumSysConvension.NumSysConvension(vvodtxt2.getText().toString(), "hexadecimal", "decimal");
                        break;
                    case R.id.rboctal2:
                        numb2 = "";
                        numb2 = NumSysConvension.NumSysConvension(vvodtxt2.getText().toString(), "octal", "decimal");
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (vvodtxt1.getText().toString().equals("") || vvodtxt2.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Вы ничего не ввели", Toast.LENGTH_SHORT).show();

                } else {

                    try {
                        a = Integer.parseInt(numb1);
                        b = Integer.parseInt(numb2);
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                    }
                    switch (checkedId) {
                        case R.id.btnplus:
                            try {
                                a += b;
                                txt0.setText(Integer.toBinaryString(a) + " " + getResources().getString(R.string.in_the_binary_system));
                                txt1.setText(Integer.toOctalString(a) + " " + getResources().getString(R.string.in_the_octal_system));
                                txt2.setText(String.valueOf(a) + " " + getResources().getString(R.string.in_the_decimal_system));
                                txt3.setText(Integer.toHexString(a).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case R.id.btnminus:
                            try {
                                a -= b;
                                txt0.setText(Integer.toBinaryString(a) + " " + getResources().getString(R.string.in_the_binary_system));
                                txt1.setText(Integer.toOctalString(a) + " " + getResources().getString(R.string.in_the_octal_system));
                                txt2.setText(String.valueOf(a) + " " + getResources().getString(R.string.in_the_decimal_system));
                                txt3.setText(Integer.toHexString(a).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;

                        case R.id.btnmulti:
                            try {
                                a *= b;
                                txt0.setText(Integer.toBinaryString(a) + " " + getResources().getString(R.string.in_the_binary_system));
                                txt1.setText(Integer.toOctalString(a) + " " + getResources().getString(R.string.in_the_octal_system));
                                txt2.setText(String.valueOf(a) + " " + getResources().getString(R.string.in_the_decimal_system));
                                txt3.setText(Integer.toHexString(a).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;

                        case R.id.btndiv:
                            try {
                                a /= b;
                                txt0.setText(Integer.toBinaryString(a) + " " + getResources().getString(R.string.in_the_binary_system));
                                txt1.setText(Integer.toOctalString(a) + " " + getResources().getString(R.string.in_the_octal_system));
                                txt2.setText(String.valueOf(a) + " " + getResources().getString(R.string.in_the_decimal_system));
                                txt3.setText(Integer.toHexString(a).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;

                        default:
                            break;
                    }
                }
            }
        });
        return root;
    }
}