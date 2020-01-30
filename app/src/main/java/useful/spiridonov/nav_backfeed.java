
package useful.spiridonov;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class nav_backfeed extends Fragment {
    WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_feedback, container, false);
        webView = root.findViewById(R.id.webview);
        TextView txt = root.findViewById(R.id.textView7);
        txt.setText(getResources().getString(R.string.txt_backfeed) + " https://forms.gle/Tb1NBAHQuSCboHocA\n" + getResources().getString(R.string.press_copy_txt));
        webView.loadUrl("https://forms.gle/Tb1NBAHQuSCboHocA");
        View.OnClickListener prerr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("backfeed||UsefulThings", "https://forms.gle/Tb1NBAHQuSCboHocA");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getActivity(), getResources().getString(R.string.txt_copy), Toast.LENGTH_SHORT).show();
            }
        };
        txt.setOnClickListener(prerr);
        return root;
    }
}
