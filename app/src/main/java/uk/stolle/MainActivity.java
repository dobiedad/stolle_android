package uk.stolle;
        import android.os.Bundle;
        import android.app.Activity;
        import android.graphics.Bitmap;
        import android.view.KeyEvent;
        import android.view.Menu;
        import android.view.View;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.ImageView;
        import android.widget.ProgressBar;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;


/*
 * Demo of creating an application to open any URL inside the application and clicking on any link from that URl
should not open Native browser but  that URL should open in the same screen.

- Load WebView with progress bar
 */
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
        web.loadUrl("http://www.stolle.xyz.?app");


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
    // To handle "Back" key press event for WebView to go back to previous screen.
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

