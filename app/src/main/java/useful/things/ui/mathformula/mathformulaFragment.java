package useful.things.ui.mathformula;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import useful.things.R;

import static android.R.layout.simple_spinner_dropdown_item;

public class mathformulaFragment extends Fragment {
    Spinner spinmain, spformula;
    String[] data = new String[5];
    String[] data2 = new String[5];

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_mathformula, container, false);
        spinmain = (Spinner) root.findViewById(R.id.spinmain);
        spformula = (Spinner) root.findViewById(R.id.spinformula);
        data[0] = getString(R.string.mult_formulas);
        data[1] = getString(R.string.Quadratic_equation);
        data[2] = getString(R.string.Trigonometry);
        data[3] = getString(R.string.Triangles);
        data[4] = getString(R.string.Areaofshapes);
        data2[0] = getString(R.string.square_sum);
        data2[1] = getString(R.string.Squared_difference);
        data2[2] = getString(R.string.Difference_squares);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data);
        adapter.setDropDownViewResource(simple_spinner_dropdown_item);
        spinmain.setAdapter(adapter);

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data2);
        adapter2.setDropDownViewResource(simple_spinner_dropdown_item);
        // spinmain.setAdapter(adapter2);

        spinmain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (spinmain.getSelectedItemPosition()) {
                    case 0:
                        spformula.setAdapter(adapter2);
                        spformula.setVisibility(View.VISIBLE);


                    default:
                        spformula.setVisibility(View.VISIBLE);
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
                Toast.makeText(getActivity(), "u're right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return root;
    }


}