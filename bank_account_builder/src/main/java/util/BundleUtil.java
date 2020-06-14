package util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public final class BundleUtil {

    private static final ResourceBundle RESOURCE_ACCOUNTS = ResourceBundle.getBundle("accounts_en");

    public static Map<String, String> getBundleProperties() {
        return convertResourceBundleToMap(RESOURCE_ACCOUNTS);
    }

    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, resource.getString(key));
        }
        return map;
    }

}