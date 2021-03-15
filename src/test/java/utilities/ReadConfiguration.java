package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration {

	Properties prop;
	
	public ReadConfiguration() throws FileNotFoundException {
		File f = new File("./Configuration/config.properties");
		FileInputStream fis = new FileInputStream(f);
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String getChromePath()
	{
		String chromePath = prop.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath = prop.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getBrowserOption()
	{
		String browserOpt = prop.getProperty("browserOption");
		return browserOpt;
	}
	
	public String getUserEmail()
	{
		String userEmail = prop.getProperty("testUserEmail");
		return userEmail;
	}
	
	public String getPassword()
	{
		String pwd = prop.getProperty("password");
		return pwd;
	}
	
	public String getQAUrl()
	{
		String qaUrl = prop.getProperty("qa_env");
		return qaUrl;
	}
	
	public String getUATUrl()
	{
		String uatUrl = prop.getProperty("uat_env");
		return uatUrl;
	}
	
	
}
