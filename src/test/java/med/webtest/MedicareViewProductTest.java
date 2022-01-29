package med.webtest;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import med.webpages.MedicareHomePage;
import med.webpages.MedicareViewProductsPage;
import med.webtestdata.MedicareHomeTestData;
import med.webtestdata.MedicareViewProductTestData;

public class MedicareViewProductTest extends TestBase {
	
	private MedicareViewProductsPage viewProductsPage;
		
	public MedicareViewProductTest(){
		
		//medicareHomePage = PageFactory.initElements(driver, MedicareHomePage.class);
	}
	
	@BeforeClass
	public void beforeMedicareHomeMethod() {
		setUpBrowser();
		viewProductsPage = PageFactory.initElements(driver, MedicareViewProductsPage.class);
		viewProductsPage.navigateMedicare();
		//viewProductsPage.navigateViewProductPage();
	}
	
	@AfterClass
	public void afterMedicareHomeMethod() {
		viewProductsPage.closeMeidcare();
	}

	
		
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="viewproduct-list", dataProviderClass = MedicareViewProductTestData.class)
	public void validateViewProductList(HashMap<String,String> hashMapViewProduct) throws InterruptedException {
		//Thread.sleep(3000);
		//viewProductsPage.validateCategory(categoryValue);
		/*System.out.println(hashMapViewProduct.get("dropdownSelectValue"));
		System.out.println(hashMapViewProduct.get("totalProducts"));
		System.out.println(hashMapViewProduct.get("totalPages"));
		System.out.println(hashMapViewProduct.get("pageNumber"));
		System.out.println(hashMapViewProduct.get("rowNumber"));
		System.out.println(hashMapViewProduct.get("productName"));
		System.out.println(hashMapViewProduct.get("productBrand"));
		System.out.println(hashMapViewProduct.get("productPrice"));
		System.out.println(hashMapViewProduct.get("productQty"));*/
		viewProductsPage.setUpFirstIterationProductListTest();
		viewProductsPage.validateViewProductTableList(hashMapViewProduct);
		
		//Select dropdown = new Select(driver.findElement(By.id("identifier")));
		//dropdown.selectByVisibleText("Programmer ");	
		//dropdown.selectByIndex(1);
		//dropdown.selectByValue("prog");
		
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="viewproduct-sort", dataProviderClass = MedicareViewProductTestData.class)
	public void validateViewProductSort(HashMap<String,String> hashMapViewProduct) throws InterruptedException {
		//Thread.sleep(3000);
		viewProductsPage.setUpFirstIterationSortTest();			
		viewProductsPage.validateViewProductTableSort(hashMapViewProduct);
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="viewproduct-search", dataProviderClass = MedicareViewProductTestData.class)
	public void validateViewProductSearch(HashMap<String,String> hashMapViewProduct) throws InterruptedException {
		//Thread.sleep(3000);
		//viewProductsPage.validateViewProductTableSearch(hashMapViewProduct);
		viewProductsPage.setUpFirstIterationSearchTest();			
		viewProductsPage.validateViewProductTableSearch(hashMapViewProduct);
	}
	
	@Test(enabled=true, groups = { "test-public" }, dataProvider ="viewproduct-category", dataProviderClass = MedicareViewProductTestData.class)
	public void validateViewProductCategory(HashMap<String,String> hashMapViewProduct) throws InterruptedException {
		//Thread.sleep(3000);
		//viewProductsPage.validateViewProductTableCategory(hashMapViewProduct);
		viewProductsPage.setUpFirstIterationCategoryTest();			
		viewProductsPage.validateViewProductTableCategory(hashMapViewProduct);
	}

}
