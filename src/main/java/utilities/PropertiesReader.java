package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    Properties prop;
    public PropertiesReader(String filePath)throws Exception {
    	prop = new Properties();
        FileInputStream fis =new FileInputStream("src/main/resources/" + filePath);
        prop.load(fis);
    }
    public String getProperty(String key) {
    	return prop.getProperty(key);
    }
}