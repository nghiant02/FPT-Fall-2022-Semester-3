package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public Properties readFileProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("DealerData/Config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
