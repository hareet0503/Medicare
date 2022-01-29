package med.webtest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import med.webpages.MedicareLoginPage;
import med.webpages.MedicareSignupPage;
import med.webtestdata.MedicareLoginTestData;
import med.webtestdata.MedicareSignupTestData;

public class MedicareLoginTest extends TestBase {
	
private MedicareLoginPage medicareLoginPage;
	
	
	public MedicareLoginTest(){
		
		//medicareHomePage = PageFactory.initElements(driver, MedicareHomePage.class);
	}
	
	@BeforeMethod
	public void beforeMedicareLoginMethod() {
		setUpBrowser();
		medicareLoginPage = PageFactory.initElements(driver, MedicareLoginPage.class);
		medicareLoginPage.navigateMedicare();
	}
	
	@AfterMethod
	public void afterMedicareLoginMethod() {
		medicareLoginPage.closeMeidcare();
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="medicare-loginsucess", dataProviderClass = MedicareLoginTestData.class)
	public void validateUserLoginSucess(String userName, String passWord, String displayName) throws InterruptedException {
		medicareLoginPage.validateLoginExistingUser(userName, passWord, displayName);
	}

}
