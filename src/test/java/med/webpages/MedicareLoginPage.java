package med.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class MedicareLoginPage extends TestPageBase {
	
	private final String loginBtnXpath = "//input[@type='submit']";
	private final String loginNameXpath = "//li[@id='userModel']/a";
	private final String waitProductMvBtn = "//div[@ng-repeat='product in pCtrl.mvProducts']/parent::div/div/a[text()='More Products']";
	private final String logoutBtnXpath = "//li[@id='logout']";
	
	@FindBy(how=How.XPATH, using="//input[@type='submit']") WebElement loginBtn;
	@FindBy(how=How.XPATH, using="//input[@id='username']") WebElement userNameEl;
	@FindBy(how=How.XPATH, using="//input[@id='password']") WebElement passwordEl;
	@FindBy(how=How.XPATH, using="//li[@id='userModel']/a") WebElement expLoginNameEl;
	@FindBy(how=How.XPATH, using="//li[@id='logout']") WebElement logoutEl;
	@FindBy(how=How.XPATH, using="//li[@id='login']/a") WebElement loginLinkEl;
	
	
	public MedicareLoginPage(WebDriver driver){
		super(driver);
	}	
	
	
	public void validateLoginExistingUser(String userName,String passWord,String expDisplayName) throws InterruptedException {
		loginLinkEl.click();
		waitForPageToBeVisible(loginBtnXpath);
		userNameEl.sendKeys(userName);
		passwordEl.sendKeys(passWord);
		loginBtn.click();
		waitForPageToBeVisible(waitProductMvBtn);
		Assert.assertEquals(expLoginNameEl.getText(),expDisplayName);
		clickElementWithFluentWait(loginNameXpath);
		waitForElementToBeClickable(logoutBtnXpath);		
		logoutEl.click();
		waitForPageToBeVisible(loginBtnXpath);
		Assert.assertTrue(_driver.getCurrentUrl().contains("logout"));
		
	}
	
	public void loginUser(String userName,String passWord) {
		
		loginLinkEl.click();
		waitForPageToBeVisible(loginBtnXpath);
		userNameEl.sendKeys(userName);
		passwordEl.sendKeys(passWord);
		loginBtn.click();
		waitForPageToBeVisible(waitProductMvBtn);
		
	}
	
	public void logoutUser() {
		
		clickElementWithFluentWait(loginNameXpath);
		waitForElementToBeClickable(logoutBtnXpath);		
		logoutEl.click();
		waitForPageToBeVisible(loginBtnXpath);
		
	}
	
	public void clickLoginName() {
		
		clickElementWithFluentWait(loginNameXpath);		
	}
	

}
