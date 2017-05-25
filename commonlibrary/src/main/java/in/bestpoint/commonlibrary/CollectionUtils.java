package in.bestpoint.commonlibrary;

import java.util.Collection;

/**
 * Created by sikanted on 1/20/2017.
 */
public class CollectionUtils {

    public static <T> Boolean isNullOrEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
