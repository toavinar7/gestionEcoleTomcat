package dao;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Config {
    private static final Properties prop = new Properties();
    
    private static final String nameconf = "/home/toavina/Documents/ecole/ecole/config.properties";
    static {
        try {
            prop.load(new FileInputStream(nameconf));
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }
}
