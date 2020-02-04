package useful.spiridonov.ui.mathformula;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import useful.spiridonov.R;
import useful.spiridonov.rachetformul;

import static android.R.layout.simple_spinner_dropdown_item;

public class mathformulaFragment extends Fragment {
    Spinner spinmain, spformula;
    TextView txtNaz, txtres;
    EditText txta, txtb, txtc, txtd;
    Button count;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<String> data2 = new ArrayList<>();
    ArrayList<String> data3 = new ArrayList<>();
    int mainspinner;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_mathformula, container, false);
        spinmain = root.findViewById(R.id.spinmain);
        spformula = root.findViewById(R.id.spinformula);
        txtNaz = root.findViewById(R.id.txtNaz);
        txtres = root.findViewById(R.id.txtres);
        txta = root.findViewById(R.id.txta);
        txtb = root.findViewById(R.id.txtb);
        txtc = root.findViewById(R.id.txtc);
        //txtd =(EditText)root.findViewById(R.id.txtd);
        count = root.findViewById(R.id.btnrachet);
        data.add(getString(R.string.mult_formulas));
        data.add(getString(R.string.Quadratic_equation));
        data.add(getString(R.string.Trigonometry));
        data.add(getString(R.string.Triangles));
        data.add(getString(R.string.Areaofshapes));
        data2.add(getString(R.string.square_sum));
        data2.add(getString(R.string.Squared_difference));
        data2.add(getString(R.string.Difference_squares));
        data2.add(getString(R.string.cube_sum));
        data2.add(getString(R.string.cube_difference));
        data2.add(getString(R.string.sum_cubes));
        data3.add(getString(R.string.discriminant));
        data3.add(getString(R.string.root_square_equa));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data);
        adapter.setDropDownViewResource(simple_spinner_dropdown_item);
        spinmain.setAdapter(adapter);

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data2);
        adapter2.setDropDownViewResource(simple_spinner_dropdown_item);

        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data3);
        adapter3.setDropDownViewResource(simple_spinner_dropdown_item);

        spinmain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txta.setVisibility(View.INVISIBLE);
                txtb.setVisibility(View.INVISIBLE);
                txtc.setVisibility(View.INVISIBLE);
                txta.setText(" ");
                txtb.setText(" ");
                txtc.setText(" ");
                switch (spinmain.getSelectedItemPosition()) {
                    case 0:
                        mainspinner = 0;
                        spformula.setVisibility(View.VISIBLE);
                        spformula.setAdapter(adapter2);
                        break;
                    case 1:
                        mainspinner = 1;
                        spformula.setVisibility(View.VISIBLE);
                        spformula.setAdapter(adapter3);
                        break;
                    case 2:
                        mainspinner = 2;
                        spformula.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mainspinner = 3;
                        spformula.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        mainspinner = 4;
                        spformula.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        mainspinner = 5;
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
                txta.setVisibility(View.INVISIBLE);
                txtb.setVisibility(View.INVISIBLE);
                txtc.setVisibility(View.INVISIBLE);
                txta.setText(" ");
                txtb.setText(" ");
                txtc.setText(" ");
                switch (spformula.getSelectedItemPosition()) {
                    case 0:
                        layoutrachet(mainspinner, 0);
                        break;
                    case 1:
                        layoutrachet(mainspinner, 1);
                        break;
                    case 2:
                        layoutrachet(mainspinner, 2);
                        break;
                    case 3:
                        layoutrachet(mainspinner, 3);
                        break;
                    case 4:
                        layoutrachet(mainspinner, 4);
                        break;
                    case 5:
                        layoutrachet(mainspinner, 5);
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

    public void layoutrachet(int spinm, int spinfor) {
        try {


            switch (spinm) {
                case 0:
                    switch (spinfor) {
                        case 0:
                            txtNaz.setText(data2.get(0));
                            txta.setVisibility(View.VISIBLE);
                            txtb.setVisibility(View.VISIBLE);
                            txtc.setVisibility(View.INVISIBLE);
                            count.setVisibility(View.VISIBLE);
                            count.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    txtres.setText(getResources().getString(R.string.answer) + " " + rachetformul.square_sum(Double.parseDouble(txta.getText().toString()), Double.parseDouble(txtb.getText().toString())));
                                }
                            });
                            break;
                        case 1:
                            txtNaz.setText(data2.get(1));
                            txta.setVisibility(View.VISIBLE);
                            txtb.setVisibility(View.VISIBLE);
                            count.setVisibility(View.VISIBLE);
                            count.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    txtres.setText(getResources().getString(R.string.answer) + " " + rachetformul.Squared_difference(Double.parseDouble(txta.getText().toString()), Double.parseDouble(txtb.getText().toString())));
                                }
                            });
                            break;
                        case 2:
                            txtNaz.setText(data2.get(2));
                            txta.setVisibility(View.VISIBLE);
                            txtb.setVisibility(View.VISIBLE);
                            count.setVisibility(View.VISIBLE);
                            count.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    txtres.setText(getResources().getString(R.string.answer) + " " + rachetformul.Difference_squares(Double.parseDouble(txta.getText().toString()), Double.parseDouble(txtb.getText().toString())));
                                }
                            });
                            break;
                        case 3:
                            txtNaz.setText(data2.get(3));
                            txta.setVisibility(View.VISIBLE);
                            txtb.setVisibility(View.VISIBLE);
                            count.setVisibility(View.VISIBLE);
                            count.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    txtres.setText(getResources().getString(R.string.answer) + " " + rachetformul.cube_sum(Double.parseDouble(txta.getText().toString()), Double.parseDouble(txtb.getText().toString())));
                                }
                            });
                            break;
                        case 4:
                            txtNaz.setText(data2.get(4));
                            txta.setVisibility(View.VISIBLE);
                            txtb.setVisibility(View.VISIBLE);
                            count.setVisibility(View.VISIBLE);
                            count.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    txtres.setText(getResources().getString(R.string.answer) + " " + rachetformul.cube_difference(Double.parseDouble(txta.getText().toString()), Double.parseDouble(txtb.getText().toString())));
                                }
                            });
                            break;
                        case 5:
                            txtNaz.setText(data2.get(5));
                            txta.setVisibility(View.VISIBLE);
                            txtb.setVisibility(View.VISIBLE);
                            count.setVisibility(View.VISIBLE);
                            count.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    txtres.setText(getResources().getString(R.string.answer) + " " + rachetformul.cube_summ(Double.parseDouble(txta.getText().toString()), Double.parseDouble(txtb.getText().toString())));
                                }
                            });
                            break;
                    }
                    break;
                case 1:
                    switch (spinfor) {
                        case 0:
                            txtNaz.setText(data3.get(0));
                            txta.setVisibility(View.VISIBLE);
                            txtb.setVisibility(View.VISIBLE);
                            txtc.setVisibility(View.VISIBLE);
                            count.setVisibility(View.VISIBLE);
                            count.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    txtres.setText(getResources().getString(R.string.answer) + " " + rachetformul.diskemenant(Double.parseDouble(txta.getText().toString()), Double.parseDouble(txtb.getText().toString()), Double.parseDouble(txtc.getText().toString())));
                                }
                            });
                            break;
                        case 1:
                            txtNaz.setText(data3.get(1));
                            txta.setVisibility(View.VISIBLE);
                            txtb.setVisibility(View.VISIBLE);
                            txtc.setVisibility(View.VISIBLE);
                            count.setVisibility(View.VISIBLE);
                            count.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    double dic = rachetformul.diskemenant(Double.parseDouble(txta.getText().toString()), Double.parseDouble(txtb.getText().toString()), Double.parseDouble(txtc.getText().toString()));
                                    if (dic > 0.0) {
                                        txtres.setText(getResources().getString(R.string.answer) + "\n1 " + getResources().getString(R.string.root) + " " +
                                                rachetformul.quad_equa_plus(
                                                        Double.parseDouble(txta.getText().toString()),
                                                        Double.parseDouble(txtb.getText().toString()), dic)
                                                + "\n2 " + getResources().getString(R.string.root) + " " +
                                                rachetformul.quad_equa_minus(
                                                        Double.parseDouble(txta.getText().toString()),
                                                        Double.parseDouble(txtb.getText().toString()), dic
                                                ));
                                    }
                                    if (dic == 0.0) {
                                        txtres.setText(getResources().getString(R.string.answer) + "\n1 " + getResources().getString(R.string.root) + " " +
                                                rachetformul.quad_equa_zero(
                                                        Double.parseDouble(txta.getText().toString()),
                                                        Double.parseDouble(txtb.getText().toString())));
                                    }
                                    if (dic < 0.0)
                                        txtres.setText(getResources().getString(R.string.no_root));
                                }
                            });
                            break;
                    }
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:

                    break;
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
        }

    }
}