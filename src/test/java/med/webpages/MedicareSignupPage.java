package med.webpages;

import java.time.Duration;
import java.util.HashMap;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MedicareSignupPage extends TestPageBase {
	
	private final String signupBtnXpath = "//button[@type='submit']";
	private final String confirmAddrBtnXpath = "//button[@type='submit' and contains(@name,'confirm')]";
	private final String confirmBtnXpath = "//a[text()='Confirm']";
	private final String loginRdBtnXpath = "//a[text()='Login Here']";
	private final String loginBtnXpath = "//input[@type='submit']";
	private final String loginNameXpath = "//li[@id='userModel']/a";
	private final String waitProductMvBtn = "//div[@ng-repeat='product in pCtrl.mvProducts']/parent::div/div/a[text()='More Products']";
	private final String logoutBtnXpath = "//li[@id='logout']";
	private final String confirmCountryFldXpath = "//input[@id='country']";
		
	@FindBy(how=How.XPATH, using="//a[text()='Sign Up']") WebElement signUpLink;
	@FindBy(how=How.XPATH, using="//button[@type='submit']") WebElement signUpBtn;	
	@FindBy(how=How.XPATH, using="//input[@id='firstName']") WebElement firstName;
	@FindBy(how=How.XPATH, using="//input[@id='lastName']") WebElement lastName;
	@FindBy(how=How.XPATH, using="//input[@id='email']") WebElement email;
	@FindBy(how=How.XPATH, using="//input[@id='contactNumber']") WebElement contactNumber;
	@FindBy(how=How.XPATH, using="//input[@id='password']") WebElement passwd;
	@FindBy(how=How.XPATH, using="//input[@id='confirmPassword']") WebElement confPasswd;
	@FindBy(how=How.XPATH, using="//input[@type='radio'and@id='role1']") WebElement userRole;
	@FindBy(how=How.XPATH, using="//input[@type='radio'and@id='role2']") WebElement supplierRole;
	@FindBy(how=How.XPATH, using="//button[@type='submit' and contains(@name,'confirm')]") WebElement confirmAddrBtn;
	
	@FindBy(how=How.XPATH, using="//input[@id='addressLineOne']") WebElement addrOne;
	@FindBy(how=How.XPATH, using="//input[@id='addressLineTwo']") WebElement addrTwo;
	@FindBy(how=How.XPATH, using="//input[@id='city']") WebElement city;
	@FindBy(how=How.XPATH, using="//input[@id='postalCode']") WebElement posCode;
	@FindBy(how=How.XPATH, using="//input[@id='state']") WebElement state;
	@FindBy(how=How.XPATH, using="//input[@id='country']") WebElement country;
	@FindBy(how=How.XPATH, using="//a[text()='Confirm']") WebElement confirmBtn;
	@FindBy(how=How.XPATH, using="//h3[contains(text(),'Name')]/strong") WebElement expNameEl;
	@FindBy(how=How.XPATH, using="//h4[contains(text(),'Email')]/strong") WebElement expEmailEl;
	@FindBy(how=How.XPATH, using="//h4[contains(text(),'Contact')]/strong") WebElement expContactEl;
	@FindBy(how=How.XPATH, using="//h4[contains(text(),'Role')]/strong") WebElement expRoleEl;	
	@FindBy(how=How.XPATH, using="//h4[text()='Billing Address']/parent::div/following-sibling::div/div/p[1]") WebElement expAddr1El;
	@FindBy(how=How.XPATH, using="//h4[text()='Billing Address']/parent::div/following-sibling::div/div/p[2]") WebElement expAddr2El;
	@FindBy(how=How.XPATH, using="//h4[text()='Billing Address']/parent::div/following-sibling::div/div/p[3]") WebElement expCityZipEl;
	@FindBy(how=How.XPATH, using="//h4[text()='Billing Address']/parent::div/following-sibling::div/div/p[4]") WebElement expStateEl;
	@FindBy(how=How.XPATH, using="//h4[text()='Billing Address']/parent::div/following-sibling::div/div/p[5]") WebElement expCountryEl;
	@FindBy(how=How.XPATH, using="//a[text()='Login Here']") WebElement loginRdBtn;	
	@FindBy(how=How.XPATH, using="//h1") WebElement expHeadingEl;
	@FindBy(how=How.XPATH, using="//h3") WebElement expParaEl;
	@FindBy(how=How.XPATH, using="//h6") WebElement expDescEl;
	@FindBy(how=How.XPATH, using="//input[@type='submit']") WebElement loginBtn;
	@FindBy(how=How.XPATH, using="//input[@id='username']") WebElement userNameEl;
	@FindBy(how=How.XPATH, using="//input[@id='password']") WebElement passwordEl;
	@FindBy(how=How.XPATH, using="//li[@id='userModel']/a") WebElement expLoginNameEl;
	@FindBy(how=How.XPATH, using="//li[@id='logout']") WebElement logoutEl;
	@FindBy(how=How.XPATH, using="//li[@id='login']/a") WebElement loginLinkEl;
	

	public MedicareSignupPage(WebDriver driver){
		super(driver);
	}
	

	
	
	public void validateLoginExistingUser() throws InterruptedException {
		loginLinkEl.click();
		waitForPageToBeVisible(loginBtnXpath);
		userNameEl.sendKeys("kn@gmail.com");
		passwordEl.sendKeys("12345");
		loginBtn.click();
		waitForPageToBeVisible(waitProductMvBtn);
		Assert.assertEquals(expLoginNameEl.getText(),"Kavita Nigam");
		clickElementWithFluentWait(loginNameXpath);
		waitForElementToBeClickable(logoutBtnXpath);		
		logoutEl.click();
		waitForPageToBeVisible(loginBtnXpath);
		Assert.assertTrue(_driver.getCurrentUrl().contains("logout"));		
	}
	
	
	
    public void validateSignUpNewUser(HashMap<String,String> expHashMapVal) throws InterruptedException {
		
		signUpLink.click();
		waitForPageToBeVisible(signupBtnXpath);
		firstName.sendKeys(expHashMapVal.get("firstName"));
		lastName.sendKeys(expHashMapVal.get("lastName"));
		email.sendKeys(expHashMapVal.get("email"));
		contactNumber.sendKeys(expHashMapVal.get("contactNumber"));
		passwd.sendKeys(expHashMapVal.get("password"));
		confPasswd.sendKeys(expHashMapVal.get("confirmPassword"));
		selectRadio(expHashMapVal.get("selectRole"));
		waitForElementToBeClickable(signupBtnXpath);
		signUpBtn.click();
		waitForPageToBeVisible(confirmCountryFldXpath);
		addrOne.sendKeys(expHashMapVal.get("addrLine1"));
		addrTwo.sendKeys(expHashMapVal.get("addrLine2"));
		city.sendKeys(expHashMapVal.get("city"));
		posCode.sendKeys(expHashMapVal.get("postalCode"));
		state.sendKeys(expHashMapVal.get("state"));
		country.sendKeys(expHashMapVal.get("country"));
		waitForElementToBeClickable(confirmAddrBtnXpath);
		confirmAddrBtn.click();
		waitForPageToBeVisible(confirmBtnXpath);
		Assert.assertEquals(expNameEl.getText(),expHashMapVal.get("expName"));
		Assert.assertEquals(expEmailEl.getText(),expHashMapVal.get("expEmail"));
		Assert.assertEquals(expContactEl.getText(),expHashMapVal.get("expContact"));
		Assert.assertEquals(expRoleEl.getText(),expHashMapVal.get("expRole"));		
		Assert.assertTrue(expAddr1El.getText().contains(expHashMapVal.get("expAddr1")));
		Assert.assertTrue(expAddr2El.getText().contains(expHashMapVal.get("expAddr2")));
		/*System.out.println(expCityZipEl.getText());
		System.out.println(expHashMapVal.get("expCityZip"));*/
		Assert.assertTrue(expCityZipEl.getText().contains(expHashMapVal.get("expCityZip")));
		Assert.assertTrue(expStateEl.getText().contains(expHashMapVal.get("expState")));
		Assert.assertTrue(expCountryEl.getText().contains(expHashMapVal.get("expCountry")));
		waitForElementToBeClickable(confirmBtnXpath);
		confirmBtn.click();
		waitForPageToBeVisible(loginRdBtnXpath);
		Assert.assertTrue(expHeadingEl.getText().contains(expHashMapVal.get("expHeading")));
		Assert.assertTrue(expParaEl.getText().contains(expHashMapVal.get("expPara")));
		Assert.assertTrue(expDescEl.getText().contains(expHashMapVal.get("expDesc")));
		//waitForElementToBeClickable(loginRdBtnXpath);
		//loginRdBtn.click();
		clickElementWithFluentWait(loginRdBtnXpath);
		waitForPageToBeVisible(loginBtnXpath);
		userNameEl.sendKeys(expHashMapVal.get("email"));
		passwordEl.sendKeys(expHashMapVal.get("password"));
		waitForElementToBeClickable(loginBtnXpath);
		loginBtn.click();
		waitForPageToBeVisible(waitProductMvBtn);
		Assert.assertEquals(expLoginNameEl.getText(),expHashMapVal.get("expLoginName"));
		//waitForElementToBeClickable(loginNameXpath);
		//expLoginNameEl.click();
		clickElementWithFluentWait(loginNameXpath);
		waitForElementToBeClickable(logoutBtnXpath);		
		logoutEl.click();
		waitForPageToBeVisible(loginBtnXpath);
		Assert.assertTrue(_driver.getCurrentUrl().contains("logout"));		
				
	}	
    
    private void selectRadio(String role) {
		
		if(role.equals("User")) {
			if(!userRole.isSelected()) {
				userRole.click();
			}
		}
		
		if(role.equals("Supplier")) {
			if(!supplierRole.isSelected()) {
				supplierRole.click();
			}
		}
	}

}
