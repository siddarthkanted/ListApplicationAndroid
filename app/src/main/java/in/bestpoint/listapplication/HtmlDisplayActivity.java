package in.bestpoint.listapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import in.bestpoint.commonlibrary.ActivityUtils;
import in.bestpoint.commonlibrary.Constants;

public class HtmlDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_display);
        ActivityUtils.setActionBarColor(this, R.color.green_00c1c1);
        ActivityUtils.setActionBarBackButton(this);
        Data data = (Data)ActivityUtils.getSerializableFromIntent(this, Constants.pass_Data);
        setTitle(data.getTitle());
        webView(data);
    }

    private void webView(Data data){
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.loadData(data.getText(), "text/html", null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
