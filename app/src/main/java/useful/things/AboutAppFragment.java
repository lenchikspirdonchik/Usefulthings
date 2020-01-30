package useful.things;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import useful.things.ui.mathformula.ShareViewModel;


public class AboutAppFragment extends Fragment {

    private ShareViewModel shareViewModel;
    ClipboardManager clipboardManager;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        shareViewModel = ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about_app, container, false);
        TextView txt = (TextView) root.findViewById(R.id.textView3);
        TextView txt1 = (TextView) root.findViewById(R.id.textView6);
        View.OnClickListener prerr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("TAG", "4274 3200 2700 0226");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getActivity(), getResources().getString(R.string.txt_copy), Toast.LENGTH_SHORT).show();
            }
        };
        txt.setOnClickListener(prerr);
        txt1.setOnClickListener(prerr);
        return root;
    }
}