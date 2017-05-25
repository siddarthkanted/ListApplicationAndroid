package in.bestpoint.listapplication;

import java.io.Serializable;

/**
 * Created by sikanted on 5/25/2017.
 */
public class Data implements Serializable {
    private String Title;
    private String Text;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
