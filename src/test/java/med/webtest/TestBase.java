package med.webtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import med.webproperties.MedicarePropertyConfig;

public class TestBase {
	
	
	protected WebDriver driver = null;

	public TestBase(){
		System.setProperty(MedicarePropertyConfig.CHROMEDRIVER,MedicarePropertyConfig.CHROMEDRIVERURI);
		//driver = new ChromeDriver();		
	}
	
	protected void setUpBrowser() {
		
		driver = new ChromeDriver();
	}
	
   	
	
	
	
	 /*@BeforeSuite(alwaysRun = true)
	  public void beforeSuite(ITestContext context) {
		  String chromdriver = context.getCurrentXmlTest().getParameter("selenium.chromedriver");
		  String chromedriverurl = context.getCurrentXmlTest().getParameter("selenium.chromedriverurl");
		  System.setProperty(chromdriver,chromedriverurl);
		  //System.setProperty("webdriver.chrome.driver",
					//"C:\\Users\\DELL\\eclipse-workspace\\BrowserDrivers\\chromedriver.exe");
		  System.out.println("I am in beforeSuite Method" +" - "+"beforeSuite");
	  }*/

}
