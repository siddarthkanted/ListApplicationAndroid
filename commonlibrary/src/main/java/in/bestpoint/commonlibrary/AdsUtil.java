package in.bestpoint.commonlibrary;

import android.app.Activity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * Created by sikanted on 5/26/2017.
 */
public class AdsUtil {

    public static void loadAd(Activity activity, int adId, String testDeviceId){
        AdView mAdMobAdView = (AdView) activity.findViewById(adId);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice(testDeviceId)// Add your real device id here
                .build();
        mAdMobAdView.loadAd(adRequest);
    }
}
