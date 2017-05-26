package in.bestpoint.listapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import com.google.android.gms.ads.AdSize;

import in.bestpoint.commonlibrary.ActivityUtils;
import in.bestpoint.commonlibrary.AdsUtil;
import in.bestpoint.commonlibrary.Constants;
import in.bestpoint.commonlibrary.FileUtil;

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
        AdsUtil.loadAd(this, R.id.admob_adview, getString(R.string.TestDeviceId));
    }


    private void webView(Data data){
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.loadData(data.getText(), "text/html; charset=UTF-8", null);
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
