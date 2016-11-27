package com.example.webviewsample;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        webView = (WebView) findViewById (R.id.webview);
        webView.getSettings ().setJavaScriptEnabled (true);
        webView.loadUrl ("http://www.ya.ru");

        webView.setWebViewClient (new WebViewClient ());
    }

    private class WebViewSampleClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading (WebView view, String url) {
            view.loadUrl (url);
            return true;
        }
    }

}
