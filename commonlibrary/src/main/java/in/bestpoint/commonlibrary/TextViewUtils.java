package in.bestpoint.commonlibrary;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sikanted on 1/18/2017.
 */
public class TextViewUtils {

    public static void setTextInTextViewIfNotNull(Activity activity, int textViewId, int textId, int visibility) {
        if (activity != null) {
            TextView textView = (TextView) activity.findViewById(textViewId);
            if (textView != null) {
                textView.setText(textId);
                textView.setVisibility(visibility);
            }
        }
    }

    public static void setTextInTextViewIfNotNull(View view, int textViewId, String message) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(textViewId);
            if (textView != null) {
                textView.setText(message);
            }
        }
    }

    public static void setTextInTextViewIfNotNull(Activity activity, int textViewId, String message, int visibility) {
        if (activity != null) {
            TextView textView = (TextView) activity.findViewById(textViewId);
            if (textView != null) {
                textView.setText(message);
                textView.setVisibility(visibility);
            }
        }
    }
}
