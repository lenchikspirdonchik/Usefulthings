package useful.things.ui.numsyscalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import useful.things.R;

public class NumSysCalcFragment extends Fragment {

    private NumSysCalcViewModel navNumSysCalcViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        navNumSysCalcViewModel =
                ViewModelProviders.of(this).get(NumSysCalcViewModel.class);
        View root = inflater.inflate(R.layout.fragment_numsyscalc, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        navNumSysCalcViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}