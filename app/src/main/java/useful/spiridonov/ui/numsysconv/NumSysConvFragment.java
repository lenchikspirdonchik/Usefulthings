package useful.spiridonov.ui.numsysconv;

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

import java.math.BigInteger;

import useful.spiridonov.R;

public class NumSysConvFragment extends Fragment {
    EditText vvodtxt;
    TextView txtotvet;
    RadioGroup radioGroup;
    static final String KEY_TXTVVOD = "txtvvod", KEY_TXTRES = "txtres";
    private SharedPreferences msp;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_numsysconv, container, false);
        msp = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        vvodtxt = root.findViewById(R.id.vvodtxt);
        txtotvet = root.findViewById(R.id.txtotvet);
        radioGroup = root.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (vvodtxt.getText().toString().equals("") || vvodtxt.getText().toString().equals(getResources().getString(R.string.VvodNextNumSys))) {
                } else {
                    BigInteger dec;
                    switch (checkedId) {
                        case R.id.rbbinary:
                            try {
                                dec = new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString()))).toString(10), 2);
                                txtotvet.setText(getResources().getString(R.string.in_the_binary_system) + " " + getResources().getString(R.string.Number) + " " + vvodtxt.getText().toString() + " " + getResources().getString(R.string.Equal) + ":");
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toOctalString(Integer.parseInt(dec.toString())) + " " + getResources().getString(R.string.in_the_octal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toHexString(Integer.parseInt(dec.toString())).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + dec + " " + getResources().getString(R.string.in_the_decimal_system));
                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case R.id.rbdecimal:
                            try {
                                txtotvet.setText(getResources().getString(R.string.in_the_decimal_system) + " " + getResources().getString(R.string.Number) + " " + vvodtxt.getText().toString() + " " + getResources().getString(R.string.Equal) + ":");
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toBinaryString(Integer.parseInt(vvodtxt.getText().toString())) + " " + getResources().getString(R.string.in_the_binary_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toOctalString(Integer.parseInt(vvodtxt.getText().toString())) + " " + getResources().getString(R.string.in_the_octal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));
                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case R.id.rbhex:
                            try {
                                dec = BigInteger.valueOf(hextodec(vvodtxt.getText().toString().toUpperCase()));
                                txtotvet.setText(getResources().getString(R.string.Hexadecimal) + " " + getResources().getString(R.string.Number) + " " + vvodtxt.getText().toString().toUpperCase() + " " + getResources().getString(R.string.Equal) + ":");
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toBinaryString(Integer.parseInt(dec.toString())) + " " + getResources().getString(R.string.in_the_binary_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toOctalString(Integer.parseInt(dec.toString())) + " " + getResources().getString(R.string.in_the_octal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + dec + " " + getResources().getString(R.string.in_the_decimal_system));
                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case R.id.rboctal:
                            try {
                                dec = new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString()))).toString(10), 8);
                                txtotvet.setText(getResources().getString(R.string.in_the_octal_system) + " " + getResources().getString(R.string.Number) + " " + vvodtxt.getText().toString() + " " + getResources().getString(R.string.Equal) + ":");
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toBinaryString(Integer.parseInt(dec.toString())) + " " + getResources().getString(R.string.in_the_binary_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));
                                txtotvet.setText(txtotvet.getText().toString() + "\n" + dec + " " + getResources().getString(R.string.in_the_decimal_system));
                                break;
                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }
                        default:
                            break;
                    }
                }
            }
        });
        return root;
    }

    public static int hextodec(String hex) {
        String digits = "0123456789ABCDEF";
        int val = 0;
        for (int i = 0; i < hex.length(); i++) {
            char j = hex.charAt(i);
            int k = digits.indexOf(j);
            val = 16 * val + k;
        }
        return val;
    }


    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = msp.edit();
        editor.putString(KEY_TXTRES, txtotvet.getText().toString());
        editor.putString(KEY_TXTVVOD, vvodtxt.getText().toString());
        editor.apply();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (msp.contains(KEY_TXTRES)) txtotvet.setText(msp.getString(KEY_TXTRES, ""));
        if (msp.contains(KEY_TXTVVOD)) vvodtxt.setText(msp.getString(KEY_TXTVVOD, ""));

    }
}