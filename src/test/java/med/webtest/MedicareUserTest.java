package med.webtest;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import med.webpages.MedicareHomePage;
import med.webpages.MedicareLoginPage;
import med.webpages.MedicareUserPage;
import med.webpages.MedicareViewProductsPage;
import med.webtestdata.MedicareHomeTestData;
import med.webtestdata.MedicareUserTestData;
import med.webtestdata.MedicareViewProductTestData;

public class MedicareUserTest extends TestBase{
	
	private MedicareUserPage medicareUserPage;
	private MedicareLoginPage medicareLoginPage;
	private MedicareViewProductsPage medicareViewProductPage;
	
    public MedicareUserTest(){
		
		//medicareHomePage = PageFactory.initElements(driver, MedicareHomePage.class);
	}
    
    @BeforeMethod
	public void beforeMedicareUserMethod() {
		setUpBrowser();
		medicareUserPage = PageFactory.initElements(driver, MedicareUserPage.class);
		medicareLoginPage = PageFactory.initElements(driver, MedicareLoginPage.class);
		medicareViewProductPage = PageFactory.initElements(driver, MedicareViewProductsPage.class);
		medicareUserPage.navigateMedicare();
		medicareLoginPage.loginUser("kn@gmail.com", "12345");
	}
	
	@AfterMethod
	public void afterMedicareUserMethod() {
		medicareLoginPage.logoutUser();
		medicareUserPage.closeMeidcare();
	}	
	
	@Test(enabled=true, groups = { "test-user" }, dataProvider ="user-cartinfo", dataProviderClass = MedicareUserTestData.class)
	public void validateCartInformation(String cartTotalItems, String cartTotalAmt, String cartEmptyDesc, String cartEmptyUrl) throws InterruptedException {
		//Thread.sleep(3000);		
		medicareUserPage.validateCartInfo(cartTotalItems, cartTotalAmt, cartEmptyDesc, cartEmptyUrl,medicareLoginPage);
	}
	
	
	@Test(enabled=true, groups = { "test-user" }, dataProvider ="user-productdetail", dataProviderClass = MedicareUserTestData.class)
	public void validateProductDetail(HashMap<String,String> hashMapProductDetail) {
		
		medicareUserPage.validateUserProductDetail(hashMapProductDetail,medicareViewProductPage);
	}
	
	
	@Test(enabled=true, groups = { "test-user" }, dataProvider ="user-cartammount", dataProviderClass = MedicareUserTestData.class)
	public void validateCartNumbers(HashMap<String,String> hashMapProductDetail) {
		
		medicareUserPage.validateCartNumberDetail(hashMapProductDetail,medicareViewProductPage);
	}

	
	


}
