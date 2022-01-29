package med.webtest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import med.webpages.MedicareAboutPage;
import med.webpages.MedicareHomePage;
import med.webtestdata.MedicareAboutTestData;
import med.webtestdata.MedicareHomeTestData;


public class MedicareAboutTest extends TestBase {
	
	private MedicareAboutPage medicareAboutPage;
	
	public MedicareAboutTest() {
		
	}
	
	@BeforeClass
	public void beforeAboutMethod() {
		setUpBrowser();
		medicareAboutPage = PageFactory.initElements(driver, MedicareAboutPage.class);
		medicareAboutPage.navigateMedicare();
		medicareAboutPage.navigateAbout();
	}
	
	@AfterClass
	public void afterAboutMethod() {
		medicareAboutPage.closeMeidcare();
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="about-heading", dataProviderClass = MedicareAboutTestData.class)
	public void validateHeading(String headingValue) throws InterruptedException {
		//Thread.sleep(3000);
		medicareAboutPage.validateAboutHeading(headingValue);
		
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="about-paragraph", dataProviderClass = MedicareAboutTestData.class)
	public void validateContent(String paraValue) throws InterruptedException {
		//Thread.sleep(3000);
		medicareAboutPage.validateAboutPara(paraValue);
		
	}
	

}
