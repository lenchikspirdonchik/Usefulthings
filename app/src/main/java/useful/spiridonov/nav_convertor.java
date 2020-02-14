package useful.spiridonov;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import static android.R.layout.simple_spinner_dropdown_item;


public class nav_convertor extends Fragment {
    Spinner spinmain, spinfrom, spinto;
    TextView txtres;
    EditText txtvvod;
    int mainspinner;
    LinearLayout linervvod;
    ArrayList<String> data = new ArrayList<>(), datalenght = new ArrayList<>(), dataweight = new ArrayList<>(),
            dataspeed = new ArrayList<>(), datainfo = new ArrayList<>();
    
    ArrayAdapter<String> adaptermain, adapterlenght, adapterweight, adapterspeed, adapterinfro;
    Double[] lenghtarray = new Double[7], weightarray = new Double[5], speedarray = new Double[5], infoarray = new Double[10];

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_convertor, container, false);
        spinmain = root.findViewById(R.id.spinmain);
        spinfrom = root.findViewById(R.id.spinfrom);
        spinto = root.findViewById(R.id.spinto);
        txtres = root.findViewById(R.id.txtres);
        txtvvod = root.findViewById(R.id.txtvvod);
        linervvod = root.findViewById(R.id.linervvod);
        createme();
        spinmain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                linervvod.setVisibility(View.INVISIBLE);
                txtres.setText(" ");
                switch (spinmain.getSelectedItemPosition()) {
                    case 0:
                        break;
                    case 1:
                        mainspinner = 1;
                        spinfrom.setAdapter(adapterlenght);
                        spinto.setAdapter(adapterlenght);
                        linervvod.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        mainspinner = 2;
                        spinfrom.setAdapter(adapterweight);
                        spinto.setAdapter(adapterweight);
                        linervvod.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mainspinner = 3;
                        spinfrom.setAdapter(adapterspeed);
                        spinto.setAdapter(adapterspeed);
                        linervvod.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        mainspinner = 4;
                        spinfrom.setAdapter(adapterinfro);
                        spinto.setAdapter(adapterinfro);
                        linervvod.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        mainspinner = 5;
                        /*spinfrom.setAdapter();
                        spinto.setAdapter();
                        linervvod.setVisibility(View.VISIBLE);*/
                        break;
                    default:
                        linervvod.setVisibility(View.INVISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        spinfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                rachet();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                rachet();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        txtvvod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rachet();
            }
        });
        return root;
    }

    public void rachet() {
        Double fromspinner, tospinner;
        Double[] buff;
            switch (mainspinner) {
                case 1:
                    buff = lenghtarray;
                    break;
                case 2:
                    buff = weightarray;
                    break;
                case 3:
                    buff = speedarray;
                    break;
                case 4:
                    buff = infoarray;
                    break;
                default:
                    buff = new Double[0];
            }
        try {
            fromspinner = Double.parseDouble(txtvvod.getText().toString()) * buff[(int) spinfrom.getSelectedItemId()];
            tospinner = fromspinner / buff[(int) spinto.getSelectedItemId()];
            txtres.setText(String.format("%10.5f", tospinner));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createme() {
        data.add(getString(R.string.nav_convertor));
        data.add(getString(R.string.lenght));
        data.add(getString(R.string.weight));
        data.add(getString(R.string.speed));
        data.add(getString(R.string.amount_info));
        lenghtarray[0] = 0.001;
        lenghtarray[1] = 0.01;
        lenghtarray[2] = 0.1;
        lenghtarray[3] = 1.0;
        lenghtarray[4] = 1000.0;
        lenghtarray[5] = 0.0254;
        lenghtarray[6] = 1609.344;
        datalenght.add(getString(R.string.millimeter));
        datalenght.add(getString(R.string.centimeter));
        datalenght.add(getString(R.string.decimeter));
        datalenght.add(getString(R.string.meter));
        datalenght.add(getString(R.string.kilometer));
        datalenght.add(getString(R.string.inch));
        datalenght.add(getString(R.string.mile));

        weightarray[0] = 0.001;
        weightarray[1] = 1.0;
        weightarray[2] = 1000.0;
        weightarray[3] = 0.0283495;
        weightarray[4] = 0.453592;
        dataweight.add(getString(R.string.gram));
        dataweight.add(getString(R.string.kilogram));
        dataweight.add(getString(R.string.ton));
        dataweight.add(getString(R.string.ounce));
        dataweight.add(getString(R.string.lbs));

        speedarray[0] = 1.60934;
        speedarray[1] = 1.09727727271047;
        speedarray[2] = 3.6;
        speedarray[3] = 1.0;
        speedarray[4] = 1.852;
        dataspeed.add(getString(R.string.milehour));
        dataspeed.add(getString(R.string.footsecond));
        dataspeed.add(getString(R.string.metersecond));
        dataspeed.add(getString(R.string.kilometerhour));
        dataspeed.add(getString(R.string.knots));

        infoarray[0] = 0.000000125;
        infoarray[1] = 0.000125;
        infoarray[2] = 0.125;
        infoarray[3] = 125.0;
        infoarray[4] = 0.000001;
        infoarray[5] = 0.001;
        infoarray[6] = 1.0;
        infoarray[7] = 1000.0;
        infoarray[8] = 1000000.0;
        infoarray[9] = 1000000000.0;
        datainfo.add(getString(R.string.bit));
        datainfo.add(getString(R.string.kilobit));
        datainfo.add(getString(R.string.megabit));
        datainfo.add(getString(R.string.gigabit));
        datainfo.add(getString(R.string.bytee));
        datainfo.add(getString(R.string.kilobyte));
        datainfo.add(getString(R.string.megabyte));
        datainfo.add(getString(R.string.gigabyte));
        datainfo.add(getString(R.string.terabyte));
        datainfo.add(getString(R.string.petabyte));


        adaptermain = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data);
        adaptermain.setDropDownViewResource(simple_spinner_dropdown_item);
        spinmain.setAdapter(adaptermain);

        adapterlenght = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, datalenght);
        adapterlenght.setDropDownViewResource(simple_spinner_dropdown_item);

        adapterweight = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, dataweight);
        adapterweight.setDropDownViewResource(simple_spinner_dropdown_item);

        adapterspeed = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, dataspeed);
        adapterspeed.setDropDownViewResource(simple_spinner_dropdown_item);

        adapterinfro = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, datainfo);
        adapterinfro.setDropDownViewResource(simple_spinner_dropdown_item);
    }
}
