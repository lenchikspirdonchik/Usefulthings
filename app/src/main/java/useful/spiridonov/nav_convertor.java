package useful.spiridonov;

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

import static android.R.layout.simple_spinner_dropdown_item;


public class nav_convertor extends Fragment {
    Spinner spinmain, spinone, spintwo;
    TextView txtNaz, txtres;
    EditText txta, txtb;
    Button count;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<String> data2 = new ArrayList<>();
    ArrayList<String> data3 = new ArrayList<>();
    int mainspinner;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_convertor, container, false);
        spinmain = root.findViewById(R.id.spinmain);
        spinone = root.findViewById(R.id.spinone);
        spintwo = root.findViewById(R.id.spintwo);
        txtNaz = root.findViewById(R.id.txtNaz);
        txtres = root.findViewById(R.id.txtres);
        txta = root.findViewById(R.id.txta);
        txtb = root.findViewById(R.id.txtb);
        count = root.findViewById(R.id.btnrachet);

        data.add(getString(R.string.lenght));

        data2.add(getString(R.string.square_sum));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data);
        adapter.setDropDownViewResource(simple_spinner_dropdown_item);
        spinmain.setAdapter(adapter);

        final ArrayAdapter<String> adapterlenght = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, data2);
        adapterlenght.setDropDownViewResource(simple_spinner_dropdown_item);


        spinmain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txta.setVisibility(View.INVISIBLE);
                txtb.setVisibility(View.INVISIBLE);
                txta.setText(" ");
                txtb.setText(" ");
                switch (spinmain.getSelectedItemPosition()) {
                    case 0:
                        mainspinner = 0;
                        spinone.setAdapter(adapterlenght);
                        spintwo.setAdapter(adapterlenght);
                        spinone.setVisibility(View.VISIBLE);
                        spintwo.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        mainspinner = 1;
                        spinone.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        mainspinner = 2;
                        spinone.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mainspinner = 3;
                        spinone.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        mainspinner = 4;
                        spinone.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        mainspinner = 5;
                        spinone.setVisibility(View.VISIBLE);
                        break;
                    default:
                        spinone.setVisibility(View.INVISIBLE);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        spinone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txta.setVisibility(View.INVISIBLE);
                txtb.setVisibility(View.INVISIBLE);
                txta.setText(" ");
                txtb.setText(" ");
                switch (spinone.getSelectedItemPosition()) {
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
        } catch (Exception e) {
            Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
        }

        switch (spinm) {
            case 0:
                switch (spinfor) {
                    case 0:

                        txtNaz.setText(data2.get(0));
                        txta.setVisibility(View.VISIBLE);
                        txtb.setVisibility(View.VISIBLE);
                        count.setVisibility(View.VISIBLE);
                        count.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                } catch (NumberFormatException e) {
                                    Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                                }
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
                                try {
                                } catch (NumberFormatException e) {
                                    Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                                }
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
                                try {
                                } catch (NumberFormatException e) {
                                    Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                                }
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
                                try {
                                } catch (NumberFormatException e) {
                                    Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                                }
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
                                try {
                                } catch (NumberFormatException e) {
                                    Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                                }
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
                                try {
                                } catch (NumberFormatException e) {
                                    Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                                }
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
                        count.setVisibility(View.VISIBLE);
                        count.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                } catch (NumberFormatException e) {
                                    Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        break;
                    case 1:

                        txtNaz.setText(data3.get(1));
                        txta.setVisibility(View.VISIBLE);
                        txtb.setVisibility(View.VISIBLE);
                        count.setVisibility(View.VISIBLE);
                        count.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                } catch (NumberFormatException e) {
                                    Toast.makeText(getActivity(), getResources().getText(R.string.errenumsyscalc), Toast.LENGTH_SHORT).show();
                                }
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
    }
}
