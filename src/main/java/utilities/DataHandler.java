package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataHandler {

    /*
        This method is used to read data from property file.
        Method is written to be platform independent, so that is support all operating systems.

 */
    public static String getPropertyValue(String key) throws IOException {

        /*
        Construct the file path
        */
        String path = System.getProperty("user.dir");
        String filePath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "global.properties";

        Properties p=new Properties();
        FileInputStream fis = new FileInputStream(filePath);

        /*
        Load the property file
        */

        p.load(fis);
        /*
        Read the key from the property file
        */
        return(p.getProperty(key));
    }
}
