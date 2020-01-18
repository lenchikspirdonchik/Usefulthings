package useful.things.ui.numsysconv;

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

import useful.things.R;

public class NumSysConvFragment extends Fragment {
    EditText vvodtxt;
    TextView txt0;
    TextView txt1;
    TextView txt2;
    TextView txtotvet;
    RadioGroup radioGroup;
    private NumSysConvViewModel numSysConvViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_numsysconv, container, false);
       /* final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        vvodtxt = (EditText) root.findViewById(R.id.vvodtxt);
        txt0 = (TextView) root.findViewById(R.id.txt0);
        txt1 = (TextView) root.findViewById(R.id.txt1);
        txt2 = (TextView) root.findViewById(R.id.txt2);
        txtotvet = (TextView) root.findViewById(R.id.txtotvet);
        radioGroup = (RadioGroup) root.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (vvodtxt.getText().toString().equals("") || vvodtxt.getText().toString().equals(getResources().getString(R.string.VvodNextNumSys))) {
                    //Toast.makeText(SlideshowFragment.this, "Вы ничего не ввели", Toast.LENGTH_SHORT).show();

                } else {
                    BigInteger dec;
                    switch (checkedId) {
                        case R.id.rbbinary:
                            try {
                                dec = new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString()))).toString(10), 2);
                                txtotvet.setText(getResources().getString(R.string.in_the_binary_system) + " " + getResources().getString(R.string.Number) + " " + vvodtxt.getText().toString() + " " + getResources().getString(R.string.Equal) + ":");
                                txt0.setText(Integer.toOctalString(Integer.parseInt(dec.toString())) + " " + getResources().getString(R.string.in_the_octal_system));
                                txt1.setText(Integer.toHexString(Integer.parseInt(dec.toString())).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));
                                txt2.setText(String.valueOf(dec) + " " + getResources().getString(R.string.in_the_decimal_system));
                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case R.id.rbdecimal:
                            try {
                                txtotvet.setText(getResources().getString(R.string.in_the_decimal_system) + " " + getResources().getString(R.string.Number) + " " + vvodtxt.getText().toString() + " " + getResources().getString(R.string.Equal) + ":");
                                txt0.setText(Integer.toBinaryString(Integer.parseInt(vvodtxt.getText().toString())) + " " + getResources().getString(R.string.in_the_binary_system));
                                txt1.setText(Integer.toOctalString(Integer.parseInt(vvodtxt.getText().toString())) + " " + getResources().getString(R.string.in_the_octal_system));
                                txt2.setText(Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));
                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case R.id.rbhex:
                            try {
                                dec = BigInteger.valueOf(hextodec(vvodtxt.getText().toString().toUpperCase()));
                                txtotvet.setText(getResources().getString(R.string.Hexadecimal) + " " + getResources().getString(R.string.Number) + " " + vvodtxt.getText().toString().toUpperCase() + " " + getResources().getString(R.string.Equal) + ":");
                                txt0.setText(Integer.toBinaryString(Integer.parseInt(dec.toString())) + " " + getResources().getString(R.string.in_the_binary_system));
                                txt1.setText(Integer.toOctalString(Integer.parseInt(dec.toString())) + " " + getResources().getString(R.string.in_the_octal_system));
                                txt2.setText(String.valueOf(dec) + " " + getResources().getString(R.string.in_the_decimal_system));
                            } catch (Exception e) {
                                Toast.makeText(getActivity(), getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case R.id.rboctal:
                            try {
                                dec = new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString()))).toString(10), 8);
                                txtotvet.setText(getResources().getString(R.string.in_the_octal_system) + " " + getResources().getString(R.string.Number) + " " + vvodtxt.getText().toString() + " " + getResources().getString(R.string.Equal) + ":");
                                txt0.setText(Integer.toBinaryString(Integer.parseInt(dec.toString())) + " " + getResources().getString(R.string.in_the_binary_system));
                                txt1.setText(Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));
                                txt2.setText(String.valueOf(dec) + " " + getResources().getString(R.string.in_the_decimal_system));
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
}
/*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("txtotvet", txtotvet.getText().toString());
        outState.putString("txt0", txt0.getText().toString());
        outState.putString("txt1", txt1.getText().toString());
        outState.putString("txt2", txt2.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        txtotvet.setText(savedInstanceState.getString("txtotvet"));
        txt0.setText(savedInstanceState.getString("txt0"));
        txt1.setText(savedInstanceState.getString("txt1"));
        txt2.setText(savedInstanceState.getString("txt2"));
    }
}*/