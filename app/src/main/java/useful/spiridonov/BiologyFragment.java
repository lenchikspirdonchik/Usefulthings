package useful.spiridonov;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BiologyFragment extends Fragment {
    TextView rachet, trip, chain;

    public static String[] myy(String[] frst, String[] scnd) {
        char[] buff;
        for (int i = 0; i < frst.length; i++) {
            scnd[i] = frst[i].toUpperCase();
            buff = new char[frst[i].length()];
            for (int j = 0; j < scnd[i].length(); j++) {
                buff[j] = scnd[i].charAt(j);
            }
            for (int ii = 0; ii < buff.length; ii++) {
                switch (buff[ii]) {
                    case 'А':
                        buff[ii] = 'Т';
                        break;
                    case 'Ц':
                        buff[ii] = 'Г';
                        break;
                    case 'Г':
                        buff[ii] = 'Ц';
                        break;
                    case 'Т':
                        buff[ii] = 'А';
                        break;
                }
                scnd[i] = String.valueOf(buff);
            }
        }
        return scnd;
    }

    public static String aminokislota(char a, char b, char c) {
        String res = "error";
        if ((a == 'У' & b == 'Ц') || ((a == 'А' & b == 'Г') && (c == 'У' || c == 'Ц'))) res = "Сер";
        if ((a == 'Ц' & b == 'У') || ((a == 'У' & b == 'У') && (c == 'А' || c == 'Г'))) res = "Лей";
        if ((a == 'Ц' & b == 'Г') || ((a == 'А' & b == 'Г') && (c == 'А' || c == 'Г'))) res = "Арг";
        if (a == 'А' & b == 'У' & (c == 'У' || c == 'Ц' || c == 'А')) res = "Иле";
        if (a == 'У' & b == 'У' & (c == 'У' || c == 'Ц')) res = "Фсн";
        if (a == 'У' & b == 'А' & (c == 'У' || c == 'Ц')) res = "Тир";
        if (a == 'У' & b == 'Г' & (c == 'У' || c == 'Ц')) res = "Цис";
        if (a == 'Ц' & b == 'А' & (c == 'У' || c == 'Ц')) res = "Гис";
        if (a == 'Ц' & b == 'А' & (c == 'А' || c == 'Г')) res = "Гли";
        if (a == 'А' & b == 'А' & (c == 'У' || c == 'Ц')) res = "Асн";
        if (a == 'А' & b == 'А' & (c == 'А' || c == 'Г')) res = "Лиз";
        if (a == 'Г' & b == 'А' & (c == 'У' || c == 'Ц')) res = "Асп";
        if (a == 'Г' & b == 'А' & (c == 'А' || c == 'Г')) res = "Глу";
        if (a == 'У' & b == 'Г' & c == 'Г') res = "Три";
        if (a == 'А' & b == 'У' & c == 'Г') res = "Мет";
        if (a == 'Ц' & b == 'Ц') res = "Про";
        if (a == 'А' & b == 'Ц') res = "Тре";
        if (a == 'Г' & b == 'У') res = "Вал";
        if (a == 'Г' & b == 'Ц') res = "Ала";
        if (a == 'Г' & b == 'Г') res = "Гли";
        return res;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_biology, container, false);
        chain = root.findViewById(R.id.txt_shain);
        trip = root.findViewById(R.id.txt_triplet);
        rachet = root.findViewById(R.id.txtrachet);
        Button btn = root.findViewById(R.id.btn_rachet);


        View.OnClickListener rach = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int triplet = Integer.parseInt(trip.getText().toString());
                char[] buff;
                String[] frstchain = chain.getText().toString().split("-");
                String[] scndchain = new String[frstchain.length];
                //тат-цца-ттц-гцц-тга
                //расчет нижней транскрибируемой цепи:
                rachet.setText(rachet.getText().toString() + "Нижняя транскрибируемая цепь: ");
                scndchain = myy(frstchain, scndchain);
                for (int i = 0; i < scndchain.length; i++) {
                    if (i == scndchain.length - 1)
                        rachet.setText(rachet.getText().toString() + scndchain[i] + "\n");
                    else
                        rachet.setText(rachet.getText().toString() + scndchain[i] + "-");
                }
                rachet.setText(rachet.getText().toString() + "\n");

                //расчет тРНК:
                String[] tRNK = new String[scndchain.length];
                scndchain = myy(scndchain, tRNK);


                //расчет кодона
                triplet--;
                buff = new char[tRNK[triplet].length()];
                rachet.setText(rachet.getText().toString() + "Кодон: ");
                for (int i = 0; i < buff.length; i++) {
                    buff[i] = tRNK[triplet].charAt(2 - i);
                    switch (buff[i]) {
                        case 'А':
                            buff[i] = 'У';
                            break;
                        case 'Ц':
                            buff[i] = 'Г';
                            break;
                        case 'Г':
                            buff[i] = 'Ц';
                            break;
                        case 'Т':
                            buff[i] = 'А';
                            break;
                        case 'У':
                            buff[i] = 'А';
                            break;
                        default:
                            buff[i] = 'E';
                            break;
                    }
                    rachet.setText(rachet.getText().toString() + buff[i]);
                }
                rachet.setText(rachet.getText().toString() + "\n");
                //расчет генетического года по таблице
                rachet.setText(rachet.getText().toString() + "Аминокислота: " + aminokislota(buff[0], buff[1], buff[2]));

            }
        };
        btn.setOnClickListener(rach);
        return root;
    }
}