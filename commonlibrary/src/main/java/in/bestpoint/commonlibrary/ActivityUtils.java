package in.bestpoint.commonlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

/**
 * Created by sikanted on 5/25/2017.
 */
public class ActivityUtils {

    public static void setActionBarColor(AppCompatActivity appCompatActivity, int colorId){
        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(ColorUtils.getColor(appCompatActivity, colorId));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    public static void setActionBarBackButton(AppCompatActivity appCompatActivity){
        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    ///currently single argument is supported
    ///call the activity in single line
    public static <T> void callActivity(Activity sourceActivity, Class<?> destinationClass, String key, T value, Class<T> valueClass, Boolean finishOld, Boolean passOldData) {
        if (sourceActivity != null && destinationClass != null) {
            Intent intent = new Intent(sourceActivity, destinationClass);
            if (key != null) {
                if (valueClass == Float.class)
                    intent.putExtra(key, (Float) (value));
                else if (valueClass == String.class)
                    intent.putExtra(key, (String) value);
                else if (valueClass == Integer.class)
                    intent.putExtra(key, (Integer) value);
                else if (Serializable.class.isAssignableFrom(valueClass))
                    intent.putExtra(key, (Serializable) value);
                else if (valueClass == Boolean.class)
                    intent.putExtra(key, (Boolean) value);
            }
            if (passOldData) {
                setIntentDataFromActivity(intent, sourceActivity);
                setIntentExtrasFromActivity(intent, sourceActivity);
            }
            sourceActivity.startActivity(intent);
            if (finishOld)
                sourceActivity.finish();
        }
    }

    public static Object getSerializableFromIntent(Activity activity, String key) {
        if (null != activity && !StringUtils.isNullOrEmpty(key)) {
            Intent intent = activity.getIntent();
            if (null != intent) {
                return intent.getSerializableExtra(key);
            }

        }
        return null;
    }

    public static Intent setIntentDataFromActivity(Intent intent, Activity activity) {
        if (null != intent && null != activity && null != activity.getIntent() && null != activity.getIntent().getData()) {
            intent = intent.setData(activity.getIntent().getData());
        }
        return intent;
    }

    public static Intent setIntentExtrasFromActivity(Intent intent, Activity activity) {
        if (null != intent && null != activity && null != activity.getIntent() && null != activity.getIntent().getExtras()) {
            intent = intent.putExtras(activity.getIntent().getExtras());
        }
        return intent;
    }


}
