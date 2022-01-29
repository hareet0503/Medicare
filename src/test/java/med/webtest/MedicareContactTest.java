package med.webtest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import med.webpages.MedicareAboutPage;
import med.webpages.MedicareContactPage;
import med.webtestdata.MedicareAboutTestData;
import med.webtestdata.MedicareContactTestData;
import med.webtestdata.TestDataBase;


public class MedicareContactTest extends TestBase {
	
private MedicareContactPage medicareContactPage;
	
	public MedicareContactTest() {
		
	}
	
	@BeforeClass
	public void beforeContactMethod() {
		setUpBrowser();
		medicareContactPage = PageFactory.initElements(driver, MedicareContactPage.class);
		medicareContactPage.navigateMedicare();
		medicareContactPage.navigateContact();
	}
	
	@AfterClass
	public void afterContactMethod() {
		medicareContactPage.closeMeidcare();
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="contact-heading", dataProviderClass = MedicareContactTestData.class)
	public void validateHeading(String headingValue) throws InterruptedException {
		//Thread.sleep(3000);
		medicareContactPage.validateContactHeading(headingValue);
		
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="contact-paragraph", dataProviderClass = MedicareContactTestData.class)
	public void validateContent(String paraValue) throws InterruptedException {
		//Thread.sleep(3000);
		medicareContactPage.validateContactPara(paraValue);
		
	}
	

}
