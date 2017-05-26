package in.bestpoint.commonlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sikanted on 5/25/2017.
 */
public class ColorUtils {

    private static final Map<Integer, Integer> colorMap;

    static {
        Map<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
        hashMap.put(0, Color.parseColor("#FF0000"));
        hashMap.put(1, Color.parseColor("#FF00FF"));
        hashMap.put(2,Color.parseColor("#BA55D3"));
        hashMap.put(3,Color.parseColor("#FFDD00"));
        hashMap.put(4,Color.parseColor("#4876FF"));
        colorMap = Collections.unmodifiableMap(hashMap);
    }


    public static final int getColor(Context context, int id) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            return ContextCompat.getColor(context, id);
        } else {
            return context.getResources().getColor(id);
        }
    }

    public static int getColorFromColorMap(int c){
        int colorIndex = c % colorMap.size();
        return colorMap.get(colorIndex);
    }

    public static void setCharacterAsImage(String title, ImageView imageView, int colorMapPosition) {
        if (imageView != null) {
            String c = StringUtils.getFirstNCharacters(title, 2);
            imageView.setImageDrawable(null);
            imageView.setBackground(TextDrawable.builder().buildRound(c, getColorFromColorMap(colorMapPosition)));
        }
    }

    public static void setByteInImageView(byte[] byteArrayString, ImageView imageView){
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArrayString, 0, byteArrayString.length);
        imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, imageView.getWidth(),
                imageView.getHeight(), false));
    }




}
