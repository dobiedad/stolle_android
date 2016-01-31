package uk.stolle;
        import android.os.Bundle;
        import android.app.Activity;
        import android.graphics.Bitmap;
        import android.view.KeyEvent;
        import android.view.View;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.ImageView;
        import android.widget.ProgressBar;

public class MainActivity extends Activity {

    WebView web;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.webview1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        web.setBackgroundColor(0x372726);
        web.setWebViewClient(new myWebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://www.stolle.xyz/?app");


    }

    public class myWebClient extends WebViewClient
    {

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            ImageView imgView = (ImageView)findViewById(R.id.logoImageView);

            imgView.setVisibility(View.GONE);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }


    }
    @Override
    public void onResume() {
        super.onResume();
        web.reload();
        progressBar.setVisibility(View.VISIBLE);
        ImageView imgView = (ImageView)findViewById(R.id.logoImageView);
        imgView.setVisibility(View.VISIBLE);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack())
        {
            web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}

