package med.webtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import med.webpages.MedicareHomePage;
import med.webpages.MedicareViewProductsPage;
import med.webproperties.MedicarePropertyConfig;
import med.webtestdata.MedicareHomeTestData;

public class MedicareHomeTest extends TestBase {
	
	
	private MedicareHomePage medicareHomePage;
	private MedicareViewProductsPage viewProductsPage;
	
	public MedicareHomeTest(){
		
		//medicareHomePage = PageFactory.initElements(driver, MedicareHomePage.class);
	}
	
	@BeforeClass
	public void beforeMedicareHomeMethod() {
		setUpBrowser();
		medicareHomePage = PageFactory.initElements(driver, MedicareHomePage.class);
		viewProductsPage = PageFactory.initElements(driver, MedicareViewProductsPage.class);
		medicareHomePage.navigateMedicare();
	}
	
	@AfterClass
	public void afterMedicareHomeMethod() {
		medicareHomePage.closeMeidcare();
	}
	
		
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="medicare-categorylist", dataProviderClass = MedicareHomeTestData.class)
	public void validateCategoryList(String categoryValue) throws InterruptedException {
		//Thread.sleep(3000);
		medicareHomePage.validateCategory(categoryValue,viewProductsPage);
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="medicare-categorycount", dataProviderClass = MedicareHomeTestData.class)
	public void validateCategoryCount(String categoryCount) {
		
		medicareHomePage.validateCategoryCount(categoryCount);		
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="medicare-products-mostviewedcount", dataProviderClass = MedicareHomeTestData.class)
	public void validateMostViewedProductCount(String categoryCount) {
		
		medicareHomePage.validateMostViewedProduct(categoryCount);
		medicareHomePage.navigateMedicare();
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="medicare-products-mostpurchasedcount", dataProviderClass = MedicareHomeTestData.class)
	public void validateMostPurchasedProductCount(String categoryCount) {
		
		medicareHomePage.validateMostPurchasedProduct(categoryCount);
		medicareHomePage.navigateMedicare();
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="medicare-products-Moreproductscount", dataProviderClass = MedicareHomeTestData.class)
	public void validateMoreProductsMvCount(String urlViewProduct, String pageTitle, String productCount) {
		viewProductsPage = PageFactory.initElements(driver, MedicareViewProductsPage.class);
		medicareHomePage.validateMvMoreProductBtn(urlViewProduct, pageTitle, productCount, viewProductsPage);
		medicareHomePage.navigateMedicare();
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="medicare-products-Moreproductscount", dataProviderClass = MedicareHomeTestData.class)
	public void validateMoreProductsMpCount(String urlViewProduct, String pageTitle, String productCount) {
		//viewProductsPage = PageFactory.initElements(driver, MedicareViewProductsPage.class);
		medicareHomePage.validateMpMoreProductBtn(urlViewProduct, pageTitle, productCount, viewProductsPage);
		medicareHomePage.navigateMedicare();
	}
	
	
		
	
	

}
