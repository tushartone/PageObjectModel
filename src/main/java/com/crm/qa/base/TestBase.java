package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utility.TestTimeUtil;

//base class is parent of all the child class
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("H:\\Tushar\\eclipse-workspace\\FreeCRMPOMTest\\src\\main\\java\\com\\crm\\qa\\configuration\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Intitlize method

	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "H:\\Tushar\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "H:\\Tushar\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestTimeUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestTimeUtil.implicit_Wait, TimeUnit.SECONDS);
	}
}
