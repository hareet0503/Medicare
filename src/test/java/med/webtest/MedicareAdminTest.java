package med.webtest;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import med.webpages.MedicareAdminPage;
import med.webpages.MedicareLoginPage;
import med.webpages.MedicareUserPage;
import med.webpages.MedicareViewProductsPage;
import med.webtestdata.MedicareAdminTestData;
import med.webtestdata.MedicareUserTestData;

public class MedicareAdminTest extends TestBase {
	
	private MedicareAdminPage medicareAdminPage;
	private MedicareLoginPage medicareLoginPage;
	private MedicareViewProductsPage medicareViewProductPage;
	
    public MedicareAdminTest(){
		
		//medicareHomePage = PageFactory.initElements(driver, MedicareHomePage.class);
	}
    
    @BeforeMethod
	public void beforeMedicareAdminMethod() {
		setUpBrowser();
		medicareAdminPage = PageFactory.initElements(driver, MedicareAdminPage.class);
		medicareLoginPage = PageFactory.initElements(driver, MedicareLoginPage.class);
		medicareViewProductPage = PageFactory.initElements(driver, MedicareViewProductsPage.class);
		medicareAdminPage.navigateMedicare();
		medicareLoginPage.loginUser("vk@gmail.com", "admin");
	}
	
	@AfterMethod
	public void afterMedicareAdminMethod() {
		medicareLoginPage.logoutUser();
		medicareAdminPage.closeMeidcare();
	}
	
	@Test(enabled=true, groups = { "test-admin" }, dataProvider ="admin-addcategory", dataProviderClass = MedicareAdminTestData.class)
	public void validateAddCategory(String category, String description) throws InterruptedException {
		//Thread.sleep(3000);
		medicareAdminPage.validateAddNewCategory(category, description,medicareViewProductPage);
		
	}
	
	@Test(enabled=true,dependsOnMethods = {"validateAddCategory"}, groups = { "test-admin" }, dataProvider ="admin-addproduct", dataProviderClass = MedicareAdminTestData.class)
	public void validateAddProduct(HashMap<String,String> hashMapNewProduct) throws InterruptedException {
		
		medicareAdminPage.validateAddNewProduct(hashMapNewProduct,medicareViewProductPage);
	}
	
	@Test(enabled=true, dependsOnMethods = {"validateAddCategory","validateAddProduct"}, groups = { "test-admin" }, dataProvider ="admin-editproduct", dataProviderClass = MedicareAdminTestData.class)
	public void validateEditProduct(HashMap<String,String> hashMapEditProduct) throws InterruptedException {
		
		medicareAdminPage.validateEditNewProduct(hashMapEditProduct,medicareViewProductPage);
	}	

}
