package in.bestpoint.commonlibrary;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.content.ContextCompat;

/**
 * Created by sikanted on 1/18/2017.
 */
public class PhoneUtils {

    public static boolean isInternetPresent(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager != null && ((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) ||
                (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED));
    }

    public static void goToUrl(Context context, String url){
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        launchBrowser.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(launchBrowser);
    }

    public static String UrlEncryption(String urlString)
    {
        if(StringUtils.isNullOrEmpty(urlString))
            return urlString;

        String encryptedString = urlString;

        encryptedString = encryptedString.replace("&", "-");
        encryptedString = encryptedString.replace("#", "-");
        encryptedString = encryptedString.replace(" ", "-");

        return encryptedString;
    }
}
