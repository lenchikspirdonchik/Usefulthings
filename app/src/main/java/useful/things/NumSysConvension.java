/*package useful.things;

import android.widget.Switch;
import android.widget.Toast;

import java.math.BigInteger;

public class NumSysConvension {
    public String NumSysConvension (int number,String in, String out){
        BigInteger dec;
        switch (in) {
            case "binary":
                try {
                    dec = new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString()))).toString(10), 2);
                    if (out =="decimal") return (Integer.toOctalString(Integer.parseInt(dec.toString())));
                    if (out =="hexadecimal")txt1.setText(Integer.toHexString(Integer.parseInt(dec.toString())).toUpperCase() + " " + getResources().getString(R.string.in_the_hexadecimal_system));
                    if (out =="octal") txt2.setText(String.valueOf(dec) + " " + getResources().getString(R.string.in_the_decimal_system));

                }
                catch (Exception e) {
                    Toast.makeText(NumSysCtivity.this, getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                }

                break;
            case "decimal":
                try {
                    txtotvet.setText(getResources().getString(R.string.in_the_decimal_system)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString()+" "+getResources().getString(R.string.Equal) +":");
                    txt0.setText(Integer.toBinaryString(Integer.parseInt(vvodtxt.getText().toString())) + " "+getResources().getString(R.string.in_the_binary_system));
                    txt1.setText(Integer.toOctalString(Integer.parseInt(vvodtxt.getText().toString()))+ " "+getResources().getString(R.string.in_the_octal_system));
                    txt2.setText(Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                }
                catch (Exception e) {
                    Toast.makeText(NumSysCtivity.this, getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                }

                break;
            case "hexadecimal":
                try {
                    dec = BigInteger.valueOf(hextodec(vvodtxt.getText().toString().toUpperCase()));
                    txtotvet.setText(getResources().getString(R.string.Hexadecimal)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString().toUpperCase()+" "+getResources().getString(R.string.Equal) +":");
                    txt0.setText(Integer.toBinaryString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_binary_system));
                    txt1.setText(Integer.toOctalString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_octal_system));
                    txt2.setText(String.valueOf(dec)+ " "+getResources().getString(R.string.in_the_decimal_system));
                }
                catch (Exception e) {
                    Toast.makeText(NumSysCtivity.this, getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                }
                break;
            case "octal":
                try {
                    dec =new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(vvodtxt.getText().toString()))).toString(10),8);
                    txtotvet.setText(getResources().getString(R.string.in_the_octal_system)+" "+getResources().getString(R.string.Number)+" " + vvodtxt.getText().toString()+" "+getResources().getString(R.string.Equal) +":");
                    txt0.setText(Integer.toBinaryString(Integer.parseInt(dec.toString()))+ " "+getResources().getString(R.string.in_the_binary_system));
                    txt1.setText(Integer.toHexString(Integer.parseInt(vvodtxt.getText().toString())).toUpperCase()+ " "+getResources().getString(R.string.in_the_hexadecimal_system));
                    txt2.setText(String.valueOf(dec)+ " "+getResources().getString(R.string.in_the_decimal_system));
                    break;
                }
                catch (Exception e) {
                    Toast.makeText(NumSysCtivity.this, getResources().getText(R.string.errnumsys), Toast.LENGTH_SHORT).show();
                }
            default:
                break;
        }
        return 0;
    }
}

// end

        }*/