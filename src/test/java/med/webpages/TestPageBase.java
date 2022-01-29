package med.webpages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import med.webproperties.MedicarePropertyConfig;

public class TestPageBase {
	
    protected WebDriver _driver;
    private String fluentClickXpathStr = "";
    private String fluentFindXpathStr = "";
    	

	public TestPageBase(WebDriver driver){
		this._driver=driver;
	}
	
	
	public void navigateMedicare() {
		_driver.get(MedicarePropertyConfig.MEDICARETESTURL);
		_driver.manage().window().maximize();
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void closeMeidcare() {
		_driver.quit();
	}
	
	protected void waitForPageToBeVisible(String xpathStr) {
		WebDriverWait wait = new WebDriverWait(_driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathStr)));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitProductMvBtn)));
	}	
		
	protected void waitForElementToBeClickable(String xpathStr) {
		WebDriverWait wait = new WebDriverWait(_driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathStr)));
		
	}
	
	protected void clickElementWithFluentWait(String xpathStr) {		
		  
		  fluentClickXpathStr = xpathStr;
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofMillis(600))
			       .ignoring(ElementClickInterceptedException.class);
		  
		  wait.until(new Function<WebDriver, Boolean>() {
			     public Boolean apply(WebDriver _driver) {
			    	 _driver.findElement(By.xpath(fluentClickXpathStr)).click();	 
			       //_driver.findElement(By.xpath(loginNameXpath)).click();	 	 
			       return true;
			     }
			   });  
			 	
	}
	
	protected void findElementWithFluentWait(String xpathStr) {		
		  
		 fluentFindXpathStr = xpathStr;
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofMillis(600))
			       .ignoring(NoSuchElementException.class);
		  
		  wait.until(new Function<WebDriver, Boolean>() {
			     public Boolean apply(WebDriver _driver) {
			    	 _driver.findElement(By.xpath(fluentFindXpathStr));	 
			       //_driver.findElement(By.xpath(loginNameXpath)).click();	 	 
			       return true;
			     }
			   });  
			 	
	}
	
	
	
	protected String executeJsScript(String strJs) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) _driver;  
		String txtVal = (String) jsExecutor.executeScript(strJs);  
		return txtVal;
	}
	
	protected void execJsScript(String strJs) {
		
		JavascriptExecutor js = (JavascriptExecutor) _driver;
	 	   js.executeScript(strJs);
		
	}
	
	
	//document.querySelector("input[type='number']").value = 2
	
	
	protected void moveToElement(WebElement el) {
    	
   	 Actions actions = new Actions(_driver);
   		actions.moveToElement(el);
   		actions.perform();    	
   }
	
	
}
