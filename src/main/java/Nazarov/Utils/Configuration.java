package Nazarov.Utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class Configuration {

    private static Configuration configuration;
    private Properties properties;

    private Configuration() {
    }

    public static Configuration getInstance() {
        if (configuration == null) {

            configuration = new Configuration();
            configuration.properties = new Properties();
            try {
                configuration.properties.load(Configuration.class.getResourceAsStream("/enviroment.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configuration;
    }

    private String base;

    public String getProperty(String name) {
        return getProperties().getProperty(name);
    }

    public Properties getProperties() {
        return properties;
    }

    public String getBase() {
        return base = properties.getProperty("url");
    }

}
