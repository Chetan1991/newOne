package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	public static ExtentTest test;
	public static ExtentReports extent;
	
	public TestBase() throws FileNotFoundException {
		log = Logger.getLogger("devpinoyLogger");
		prop = new Properties();
		FileInputStream ip  = new FileInputStream("C:\\Users\\CRC\\eclipse-workspace\\020591\\src\\main\\java\\com\\qa\\config\\config.properties");
		//log.debug("congiguration file loaded successfully");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void initilization()
{
	String browserName = prop.getProperty("browser");
	System.out.println("hi im here");
	System.out.println(browserName+"hi im here");
	/*if(browserName=="firefox") {
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium Material\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	     driver= new FirefoxDriver();
	     //log.debug("FireFox browser launched successfully");
	} else if(browserName=="chrome") {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Material\\chromedriver_win32 (2)\\chromedriver.exe");
		driver= new ChromeDriver();
		//log.debug("Google Chrome browser launched successfully");
	}*/
	extent = new ExtentReports ("C:\\Users\\CRC\\eclipse-workspace\\020591\\src\\main\\java\\com\\qa\\reports\\Php_travels_Reports.html", false);
	//extent.addSystemInfo("Environment","Environment Name")
	extent.addSystemInfo("Windows 10", "PHP travels Demo").addSystemInfo("Environment", "Automation Testing").addSystemInfo("User Name", "Chetan Chopade");
	//loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
	extent.loadConfig(new File("C:\\Users\\CRC\\eclipse-workspace\\020591\\extent-config.xml"));
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium Material\\chromedriver_win32 (2)\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get("https://www.phptravels.net/register");
	//driver.get("https://www.phptravels.net/login");
	//test.log(LogStatus.PASS, "Site launched successfully");
	log.debug("Site launched successfully");
	driver.manage().window().maximize();
	log.debug("Window get maximized");
	driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Timeout,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();	
	}
}
