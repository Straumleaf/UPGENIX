package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    // create the object of Properties
    private static Properties properties = new Properties();

    static{
        try {

            // opening configuration file
            FileInputStream file = new FileInputStream("configuration.properties");

            // loading values from file to Properties object
            properties.load(file);

            // close the configuration file
            file.close();

        } catch (IOException e) {

            System.err.println("Something wrong with the configuration or file not found!");
            e.printStackTrace();

        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
