
package useful.things;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class nav_backfeed extends Fragment {
    WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_feedback, container, false);
        webView = (WebView) root.findViewById(R.id.webview);
        webView.loadUrl("https://vk.com/leonid.spiri");
        return root;
    }
}
