package util;

import java.io.IOException;
import java.net.URL;

public class Properties {

    private static java.util.Properties properties;

    private Properties() {
    }

    static {
        properties = new java.util.Properties();
        URL props = ClassLoader.getSystemResource("common.properties");
        try {
            properties.load(props.openStream());
        }
        catch (IOException e) {
        }
    }

    public static String getProperty(String key) {
        if (System.getProperty(key) != null) {
            return System.getProperty(key);
        }
        return properties.getProperty(key);
    }
}
