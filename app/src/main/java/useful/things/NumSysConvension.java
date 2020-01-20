package useful.things;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

// binary  decimal   hexadecimal  octal
public  class NumSysConvension extends AppCompatActivity {
    public static String NumSysConvension (String number,String in, String out){
        BigInteger dec;

        switch(in) {
            case "binary":
                try {
                    dec = new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(number))).toString(10), 2);
                    switch (out) {
                        case "decimal": return (dec.toString());
                        case "hexadecimal":return (Integer.toHexString(Integer.parseInt(dec.toString())).toUpperCase());
                        case "octal":return (Integer.toOctalString(Integer.parseInt(in)));
                    }
                }
                catch (Exception e) {
                    return "error";
                }
                break;

            case "decimal":
                try {
                    dec = BigInteger.valueOf(Long.parseLong(number));
                    switch (out) {
                        case "binary": return Integer.toBinaryString(Integer.parseInt(dec.toString()));
                        case "hexadecimal":return (Integer.toHexString(Integer.parseInt(dec.toString())).toUpperCase());
                        case "octal":return (Integer.toOctalString(Integer.parseInt(dec.toString())));
                    }
                }
                catch (Exception e) {
                    return "error";
                }
                break;

            case "hexadecimal":
                try {
                    dec = BigInteger.valueOf(hextodec(number.toUpperCase()));
                    switch (out) {
                        case "binary": return Integer.toBinaryString(Integer.parseInt(dec.toString()));
                        case "decimal": return (dec.toString());
                        case "octal":return (Integer.toOctalString(Integer.parseInt(dec.toString())));
                    }
                }
                catch (Exception e) {
                    return "error";
                }
                break;

            case "octal":
                try {
                    dec = new BigInteger(new BigInteger(String.valueOf(Integer.parseInt(number))).toString(10), 8);
                    switch (out) {
                        case "binary": return Integer.toBinaryString(Integer.parseInt(number));
                        case "decimal": return (dec.toString());
                        case "hexadecimal":return (Integer.toHexString(Integer.parseInt(dec.toString())).toUpperCase());
                    }
                }
                catch (Exception e) {
                    return "error";
                }
                break;
        }
        return "error";
    }

    public static int hextodec(String hex) {
        String digits = "0123456789ABCDEF";
        int val = 0;
        for (int i = 0; i < hex.length(); i++) {
            char j = hex.charAt(i);
            int k = digits.indexOf(j);
            val = 16*val + k;
        }
        return val;
    }

}