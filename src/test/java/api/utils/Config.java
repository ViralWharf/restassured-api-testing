package api.utils;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     Config.class.getClassLoader()
                             .getResourceAsStream("application.properties")) {

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Error al cargar el archivo de application.properties");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
