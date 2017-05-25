package in.bestpoint.commonlibrary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by sikanted on 5/25/2017.
 */
public class HtmlUtil {

    public static String GetFirstElementText(String html){
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("body").first().children();
        for (Element el : elements)
            return el.text();
        return StringUtils.EMPTY_STRING;
    }
}
