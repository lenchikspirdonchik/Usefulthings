package useful.spiridonov;

import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import useful.spiridonov.ui.mathformula.ShareViewModel;


public class AboutAppFragment extends Fragment {

    private ShareViewModel shareViewModel;
    ClipboardManager clipboardManager;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        shareViewModel = ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about_app, container, false);
        return root;
    }
}