package in.bestpoint.commonlibrary;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sikanted on 4/28/2017.
 */
public class FileUtil {

    public static InputStream loadInputStreamFromAssetFile(Context context, String fileName){
        AssetManager am = context.getAssets();
        try {
            InputStream is = am.open(fileName);
            return is;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String loadContentFromFile(Context context, String path){
        String content = null;
        try {
            InputStream is = loadInputStreamFromAssetFile(context, path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            content = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return content;
    }


    public static <T> T jsonDeserializeFromFile(Context context, String path){
        String partnersJson = FileUtil.loadContentFromFile(context, path);
        Type type = new TypeToken<T>(){}.getType();
        T t = new Gson().fromJson(partnersJson, type);
        return t;
    }

    public static <T> List<T> jsonListDeserializeFromFile(Context context, String path, Class<T[]> clazz){
        String partnersJson = FileUtil.loadContentFromFile(context, path);
        T[] t = new Gson().fromJson(partnersJson, clazz);
        return Arrays.asList(t);
    }
}
