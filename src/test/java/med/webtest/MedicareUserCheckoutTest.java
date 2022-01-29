package med.webtest;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import med.webpages.MedicareLoginPage;
import med.webpages.MedicareUserCheckoutPage;
import med.webpages.MedicareUserPage;
import med.webpages.MedicareViewProductsPage;
import med.webtestdata.MedicareUserCheckoutTestData;
import med.webtestdata.MedicareUserTestData;

public class MedicareUserCheckoutTest extends TestBase {
	
	private MedicareUserCheckoutPage medicareUserCheckoutPage;
	private MedicareLoginPage medicareLoginPage;
	private MedicareViewProductsPage medicareViewProductPage;
	private MedicareUserPage medicareUserPage;
	
    public MedicareUserCheckoutTest(){
		
		//medicareHomePage = PageFactory.initElements(driver, MedicareHomePage.class);
	}
    
    @BeforeMethod
	public void beforeMedicareUserCheckoutMethod() {
		setUpBrowser();
		medicareUserCheckoutPage = PageFactory.initElements(driver, MedicareUserCheckoutPage.class);
		medicareLoginPage = PageFactory.initElements(driver, MedicareLoginPage.class);
		medicareViewProductPage = PageFactory.initElements(driver, MedicareViewProductsPage.class);
		medicareUserPage = PageFactory.initElements(driver, MedicareUserPage.class);
		medicareUserCheckoutPage.navigateMedicare();
		medicareLoginPage.loginUser("kn@gmail.com", "12345");
	}
	
	@AfterMethod
	public void afterMedicareUserCheckoutMethod() {
		medicareLoginPage.logoutUser();
		medicareUserCheckoutPage.closeMeidcare();
	}
	
	@Test(enabled=true, groups = { "test-user" }, dataProvider ="user-addproduct-cart", dataProviderClass = MedicareUserCheckoutTestData.class)
	public void addProductCart(HashMap<String,String> hashMapProductDetail) throws InterruptedException {
		//Thread.sleep(3000);		
		medicareUserCheckoutPage.addProductToCart(hashMapProductDetail,medicareUserPage,medicareViewProductPage);
	}
	
	@Test(enabled=true,dependsOnMethods = {"addProductCart"}, groups = { "test-user" }, dataProvider ="user-chkproduct-cart", dataProviderClass = MedicareUserCheckoutTestData.class)
	public void validateProductCart(HashMap<String,String> hashMapProductDetail) throws InterruptedException {
		//Thread.sleep(3000);		
		medicareUserCheckoutPage.validateProductItemCart(hashMapProductDetail,medicareLoginPage, medicareUserPage,medicareViewProductPage);
	}
	
	//dependsOnMethods = {"addProductCart"},
	
	@Test(enabled=true, dependsOnMethods = {"addProductCart","validateProductCart"}, groups = { "test-user" }, dataProvider ="user-chkoutproduct-sumlst", dataProviderClass = MedicareUserCheckoutTestData.class)
	public void validateProductFinalConf(HashMap<String,String> hashMapProductDetail) throws InterruptedException {
		//Thread.sleep(3000);		
		medicareUserCheckoutPage.validateProductFinalItem(hashMapProductDetail,medicareLoginPage,medicareUserPage,medicareViewProductPage);
	}
	
	//dependsOnMethods = {"addProductCart","validateProductCart"},
	
	@Test(enabled=true,dependsOnMethods = {"addProductCart","validateProductCart","validateProductFinalConf"}, groups = { "test-user" })
	public void validateOrderPlacedInfo() throws InterruptedException {
		//Thread.sleep(3000);		
		medicareUserCheckoutPage.validateOrderItemInfo(medicareLoginPage,medicareUserPage,medicareViewProductPage);
	}
	
	//dependsOnMethods = {"addProductCart","validateProductCart","validateProductFinalConf"},

}
