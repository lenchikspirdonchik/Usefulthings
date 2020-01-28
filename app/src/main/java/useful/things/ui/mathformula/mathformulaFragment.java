package useful.things.ui.mathformula;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import useful.things.R;

import static android.R.layout.simple_spinner_dropdown_item;

public class mathformulaFragment extends Fragment {
    Spinner spinmain, spformula;
    //String[] data = new String[5];
    //String[] data2 = new String[5];
    ArrayList<String> data = new ArrayList<>();
    ArrayList<String> data2 = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_mathformula, container, false);
        spinmain = (Spinner) root.findViewById(R.id.spinmain);
        spformula = (Spinner) root.findViewById(R.id.spinformula);
        data.add(getString(R.string.mult_formulas));
        data.add(getString(R.string.Quadratic_equation));
        data.add(getString(R.string.Trigonometry));
        data.add(getString(R.string.Triangles));
        data.add(getString(R.string.Areaofshapes));
        data2.add(getString(R.string.square_sum));
        data2.add(getString(R.string.Squared_difference));
        data2.add(getString(R.string.Difference_squares));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data);
        adapter.setDropDownViewResource(simple_spinner_dropdown_item);
        spinmain.setAdapter(adapter);

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data2);
        adapter2.setDropDownViewResource(simple_spinner_dropdown_item);
        // spinmain.setAdapter(adapter2);

        spinmain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spinmain.getSelectedItemPosition()) {
                    case 0:
                        spformula.setVisibility(View.VISIBLE);
                        spformula.setAdapter(adapter2);
                        break;
                    case 1:
                        spformula.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        spformula.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        spformula.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        spformula.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        spformula.setVisibility(View.VISIBLE);
                        break;
                    default:
                        spformula.setVisibility(View.INVISIBLE);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        spformula.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spformula.getSelectedItemPosition()) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return root;
    }


}