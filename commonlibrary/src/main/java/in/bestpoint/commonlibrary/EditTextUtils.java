package in.bestpoint.commonlibrary;

import android.app.Activity;
import android.widget.EditText;

/**
 * Created by sikanted on 1/18/2017.
 */
public class EditTextUtils {

    public static String getString(Activity activity, int editTextId){
        EditText searchEditText = (EditText)activity.findViewById(editTextId);
        return searchEditText.getText().toString();
    }

    public static void setString(Activity activity, int editTextId, String text){
        EditText searchEditText = (EditText)activity.findViewById(editTextId);
        searchEditText.setText(text);
    }
}
