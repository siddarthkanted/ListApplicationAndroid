package in.bestpoint.commonlibrary;

import android.app.Activity;
import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Created by sikanted on 1/18/2017.
 */
public class StringUtils {

    public static String EMPTY_STRING = "";

    public static boolean isNullOrEmpty(String text){
        if (null == text || TextUtils.isEmpty(text)) {return true;}
        return false;
    }

    public static boolean regexMatch(String regex, String input){
        if(regex == null && input == null){
            return true;
        }
        if(regex != null && input != null){
            boolean isMatch = Pattern.matches(regex, input);
            return isMatch;
        }
        return false;
    }

    public static <T> String toStringIfNotNull(T t){
        return t == null ? null : t.toString();
    }

    public static boolean equalsIfNotNull(String x, String y){
        if(x == null && y == null){
            return true;
        }
        if(x != null && y != null){
            return x.equals(y);
        }
        return false;
    }

    public static String getStringAndFormat(Activity activity, int stringId, String... params){
        String text = activity.getString(stringId);
        return String.format(text, params);
    }

    public static String getStringIfNotNullElseDefault(String text, String defaultText){
        if(isNullOrEmpty(text)){
            return defaultText;
        }
        return text;
    }

    public static String getFirstNCharacters(String text, int numberOfCharacters){
        if(isNullOrEmpty(text)){
            return text;
        }
        numberOfCharacters = Math.min(text.length(), numberOfCharacters);
        return text.substring(0, numberOfCharacters);
    }


    public static String getLimitedString(String message, int numberOfCharactersToShow){
        if(null == message){
            return StringUtils.EMPTY_STRING;
        }
        if (message.length() <= numberOfCharactersToShow) {
            return message;
        } else {
            String text = StringUtils.getFirstNCharacters(message, numberOfCharactersToShow);
            text = text.concat(" ...");
            return text;
        }
    }
}
