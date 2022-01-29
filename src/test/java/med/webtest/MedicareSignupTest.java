package med.webtest;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import med.webpages.MedicareHomePage;
import med.webpages.MedicareSignupPage;
import med.webtestdata.MedicareSignupTestData;
import med.webtestdata.MedicareViewProductTestData;

public class MedicareSignupTest extends TestBase {
	
	private MedicareSignupPage medicareSignupPage;
	

	
	public MedicareSignupTest(){
		
		//medicareHomePage = PageFactory.initElements(driver, MedicareHomePage.class);
	}
	
	@BeforeClass
	public void beforeMedicareHomeMethod() {
		setUpBrowser();
		medicareSignupPage = PageFactory.initElements(driver, MedicareSignupPage.class);
		medicareSignupPage.navigateMedicare();
	}
	
	@AfterClass
	public void afterMedicareHomeMethod() {
		medicareSignupPage.closeMeidcare();
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="signup-newuser", dataProviderClass = MedicareSignupTestData.class)
	public void validateSignupNewUser(HashMap<String,String> hashMapViewProduct) throws InterruptedException {
		//Thread.sleep(3000);
		//viewProductsPage.setUpFirstIterationSortTest();			
		//viewProductsPage.validateViewProductTableSort(hashMapViewProduct);
		medicareSignupPage.validateSignUpNewUser(hashMapViewProduct);
	}
	
	@Test(enabled=false, groups = { "test-public" })
	public void validateExistingUserLogin() throws InterruptedException {
		medicareSignupPage.validateLoginExistingUser();
	}

}
