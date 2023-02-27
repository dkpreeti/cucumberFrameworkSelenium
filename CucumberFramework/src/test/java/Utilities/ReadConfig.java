package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public Properties properties;
	
	String path="config.properties";
	
	public ReadConfig() throws IOException {
		properties=new Properties();		
		FileInputStream fis=new FileInputStream(path);
		properties.load(fis);
	}

	public String getBrowser() {
		String browser=properties.getProperty("browser");
		if(browser!=null) 
			return browser;
		else
			throw new RuntimeException("url not specified in config file");
				
	}
}
