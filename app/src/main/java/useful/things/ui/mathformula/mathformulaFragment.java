package useful.things.ui.mathformula;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import useful.things.R;

public class mathformulaFragment extends Fragment {

    private ShareViewModel shareViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calc, container, false);
        shareViewModel = ViewModelProviders.of(this).get(ShareViewModel.class);
        //View menuItemView = getView().findViewById(R.menu.activity_mathformula_drawer);
        PopupMenu popupMenu = new PopupMenu(getActivity(), root);
        popupMenu.getMenuInflater().inflate(R.menu.activity_mathformula_drawer, popupMenu.getMenu());


        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_mult_formulas:
                        Toast.makeText(getActivity(), "nav_mult_formulas", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_quad_equation:
                        Toast.makeText(getActivity(), "nav_quad_equation", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_triangles:
                        Toast.makeText(getActivity(), "nav_triangles", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_areaofshapes:
                        Toast.makeText(getActivity(), "nav_areaofshapes", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_trigonometry:
                        Toast.makeText(getActivity(), "nav_trigonometry", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        return root;
    }

   /* private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(getContext(), v);
        popupMenu.inflate(R.menu.activity_mathformula_drawer);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nav_mult_formulas:
                                Toast.makeText(getActivity(), "nav_mult_formulas", Toast.LENGTH_SHORT).show();
                                return true;

                                case R.id.nav_quad_equation:
                                    Toast.makeText(getActivity(), "nav_quad_equation", Toast.LENGTH_SHORT).show();
                                return true;

                                case R.id.nav_triangles:
                                    Toast.makeText(getActivity(), "nav_triangles", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.nav_areaofshapes:
                                Toast.makeText(getActivity(), "nav_areaofshapes", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.nav_trigonometry:
                                Toast.makeText(getActivity(), "nav_trigonometry", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });*/

    
}