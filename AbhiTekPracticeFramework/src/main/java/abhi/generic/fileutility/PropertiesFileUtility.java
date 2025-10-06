package abhi.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {
	public String readDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configCommonData/commonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String data = pro.getProperty(key);
		return data;
	}
}
