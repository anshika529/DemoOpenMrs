package com.atmecs.openmrs.testsuit;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.atmecs.openmrs.constants.Constants;
import com.atmecs.openmrs.utils.PropertiesUtil;




public class TestBase {
	public static WebDriver driver;

	public static PropertiesUtil props=PropertiesUtil.getInstance();
	


	@BeforeTest
	public void openBrowser() 
	{ 

	if (props.getValue("browser").equalsIgnoreCase("chrome")) 
	{
		System.setProperty("webdriver.chrome.driver",Constants.Chrome_path);
		driver = new ChromeDriver();
	} 
	else if (props.getValue("browser").equalsIgnoreCase("firefox")) 
	{
		System.setProperty("webdriver.gecko.driver",Constants.firefox_path);
		driver = new FirefoxDriver();
	}

	else if (props.getValue("browser").equalsIgnoreCase("internetexplorer")) 
	{
		System.setProperty("webdriver.ie.driver",Constants.IE_path);
		driver = new InternetExplorerDriver();
	}
	driver.get(props.getValue("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LODE_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	@AfterTest
	public void quitBrowser()  {

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS); 
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.quit();
	}
}
