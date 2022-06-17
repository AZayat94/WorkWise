package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    public static Properties properties;
    private static String ConfigPath = "Configuration/ConfigSetting.properties";

    public static void InitializePropFile() throws IOException {

        properties  = new Properties();
        InputStream InputStream = new FileInputStream(ConfigPath);
        properties.load(InputStream);


    }

}
