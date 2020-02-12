package useful.spiridonov.ui.numsyscalc;

import android.content.Context;
import android.content.SharedPreferences;
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

import useful.spiridonov.NumSysConvension;
import useful.spiridonov.R;

public class NumSysCalcFragment extends Fragment {
    EditText vvodtxt1, vvodtxt2;
    RadioGroup radioGroup1, radioGroup2, radioGroup3;
    String numb1, numb2;
    static final String KEY_TXTVVOD1 = "txtvvod1", KEY_TXTVVOD2 = "txtvvod2", KEY_TXTRES = "txtres";
    int a, b;
    TextView txtotvet;
    private SharedPreferences msp;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_numsyscalc, container, false);
        msp = this.getActivity().getSharedPreferences("NumSysCalcFragment", Context.MODE_PRIVATE);
        vvodtxt1 = root.findViewById(R.id.vvodtxt1);
        vvodtxt2 = root.findViewById(R.id.vvodtxt2);
        txtotvet = root.findViewById(R.id.txtotvet);
        radioGroup1 = root.findViewById(R.id.radiogroup1);
        radioGroup2 = root.findViewById(R.id.radiogroup2);
        radioGroup3 = root.findViewById(R.id.radiogroup3);
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
                                txtotvet.setText(Integer.toBinaryString(a) + " " + getResources().getString(R.string.in_the_binary_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toOctalString(a) + " " + getResources().getString(R.string.in_the_octal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + a + " " + getResources().getString(R.string.in_the_decimal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toHexString(a).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case R.id.btnminus:
                            try {
                                a -= b;
                                txtotvet.setText(Integer.toBinaryString(a) + " " + getResources().getString(R.string.in_the_binary_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toOctalString(a) + " " + getResources().getString(R.string.in_the_octal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + a + " " + getResources().getString(R.string.in_the_decimal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toHexString(a).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;

                        case R.id.btnmulti:
                            try {
                                a *= b;
                                txtotvet.setText(Integer.toBinaryString(a) + " " + getResources().getString(R.string.in_the_binary_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toOctalString(a) + " " + getResources().getString(R.string.in_the_octal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + a + " " + getResources().getString(R.string.in_the_decimal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toHexString(a).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;

                        case R.id.btndiv:
                            try {
                                a /= b;
                                txtotvet.setText(Integer.toBinaryString(a) + " " + getResources().getString(R.string.in_the_binary_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toOctalString(a) + " " + getResources().getString(R.string.in_the_octal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + a + " " + getResources().getString(R.string.in_the_decimal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toHexString(a).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));

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

    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = msp.edit();
        editor.putString(KEY_TXTRES, txtotvet.getText().toString());
        editor.putString(KEY_TXTVVOD1, vvodtxt1.getText().toString());
        editor.putString(KEY_TXTVVOD2, vvodtxt2.getText().toString());
        editor.apply();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (msp.contains(KEY_TXTRES)) txtotvet.setText(msp.getString(KEY_TXTRES, ""));
        if (msp.contains(KEY_TXTVVOD1)) vvodtxt1.setText(msp.getString(KEY_TXTVVOD1, ""));
        if (msp.contains(KEY_TXTVVOD2)) vvodtxt2.setText(msp.getString(KEY_TXTVVOD2, ""));
    }
}