package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileUtils {
	
	public static String readLoginPropertiesFile(String key) throws IOException {
		File loginTestDataFile = new File(FileConstants.LOGIN_TEST_DATA_FILE_PATH);
		FileInputStream fis = new FileInputStream(loginTestDataFile);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	
	public static void main(String[] args) throws IOException {
//		File loginTestDataFile = new File("/Users/mithun/eclipse-workspace/SfdcAutomationFramework/src/test/java/test_data/login_data.properties");
//		FileInputStream fis = new FileInputStream(loginTestDataFile);
//		
//		Properties prop = new Properties();
//		prop.load(fis);
//		
//		System.out.println(prop.entrySet());
		
//		System.out.println(System.getProperty("user.dir"));
		File f = new File(FileConstants.LOGIN_OUTPUT_FILE_PATH);
		FileOutputStream fos = new FileOutputStream(f);
		
		Properties p = new Properties();
		p.setProperty("prod.username", "abcd@gmail.com");
		
		p.store(fos, "This will contain all file reatednvkfjdnvdkx");
		
		
		
		
		
		
	}
}
