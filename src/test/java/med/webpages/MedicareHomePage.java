package med.webpages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import med.webproperties.MedicarePropertyConfig;

public class MedicareHomePage extends TestPageBase {
	
	//private final String categoryXpathBuilder = "//div[@class='list-group']/a[@id='a_"; 
	private final String waitProductMpBtn = "//div[@ng-repeat='product in pCtrl.mpProducts']/parent::div/div/a[text()='More Products']";
	private final String waitProductMvBtn = "//div[@ng-repeat='product in pCtrl.mvProducts']/parent::div/div/a[text()='More Products']";
	
	@FindBy(how=How.XPATH, using="//div[@class='list-group']/a") List<WebElement> categoryList;
	@FindBy(how=How.XPATH, using="//div[@ng-repeat='product in pCtrl.mvProducts']") List<WebElement> mvProductList;
	@FindBy(how=How.XPATH, using="//div[@ng-repeat='product in pCtrl.mpProducts']") List<WebElement> mpProductList;
	@FindBy(how=How.XPATH, using="//div[@ng-repeat='product in pCtrl.mpProducts']/parent::div/div/a[text()='More Products']") WebElement mvMoreProductBtn;
	@FindBy(how=How.XPATH, using="//div[@ng-repeat='product in pCtrl.mvProducts']/parent::div/div/a[text()='More Products']") WebElement mpMoreProductBtn;
	
	//http://localhost:8080/medicare/show/all/products
	//Medicare - All Products
	//div[@ng-repeat='product in pCtrl.mpProducts']/parent::div/div/a[text()='More Products']
	//div[@ng-repeat='product in pCtrl.mvProducts']/parent::div/div/a[text()='More Products']
	
	//div[@ng-repeat='product in pCtrl.mvProducts']   -- 5
	//div[@ng-repeat='product in pCtrl.mpProducts']
	
	public MedicareHomePage(WebDriver driver){
		super(driver);
	}			
	
	@Override
	public void navigateMedicare() {
		_driver.get(MedicarePropertyConfig.MEDICARETESTURL);
		_driver.manage().window().maximize();
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitForPageToBeVisible(waitProductMpBtn);
	}
	
	public void validateCategory(String expCategoryStr,MedicareViewProductsPage viewProductsPage) {

	   viewProductsPage.validateCategory(expCategoryStr);
	}
	
	public void validateCategoryCount(String countStr) {
		int actCount = Integer.parseInt(countStr);
		Assert.assertEquals(categoryList.size(),actCount);
	}
	
	public void validateMostViewedProduct(String countStr) {
		int actCount = Integer.parseInt(countStr);
		Assert.assertEquals(mvProductList.size(),actCount);		
	}
	
	public void validateMostPurchasedProduct(String countStr) {
		int actCount = Integer.parseInt(countStr);
		Assert.assertEquals(mpProductList.size(),actCount);		
	}
	
	public void validateMvMoreProductBtn(String expUrlSub,String expTitle,String expTotPdtCount, MedicareViewProductsPage viewProductsPage) {
		waitForElementToBeClickable(waitProductMvBtn);		
		mvMoreProductBtn.click();
		viewProductsPage.validateProductTotalCount(expTotPdtCount);
		Assert.assertTrue(_driver.getCurrentUrl().contains(expUrlSub));
		Assert.assertEquals(_driver.getTitle(), expTitle);
	}
	
	public void validateMpMoreProductBtn(String expUrlSub,String expTitle,String expTotPdtCount, MedicareViewProductsPage viewProductsPage) {
		waitForElementToBeClickable(waitProductMpBtn);
		mpMoreProductBtn.click();
		viewProductsPage.validateProductTotalCount(expTotPdtCount);
		Assert.assertTrue(_driver.getCurrentUrl().contains(expUrlSub));
		Assert.assertEquals(_driver.getTitle(), expTitle);
	}
	
	
	//WebElement productDescription = _driver.findElement(By.xpath("//*[@id=\"search\"]//span[@data-component-type='s-search-results']/div[2]/div[@data-asin='"+tempattr+"']//h2/a/span"));
	
	
	//div[@class='list-group']/a  --count
	//div[@class='list-group']/a[@id='a_Analgesics']
	
	
	/*
	@FindBy(how=How.ID, using="searchDropdownBox") WebElement searchCategoryDropdown;
	@FindBy(how=How.ID, using="twotabsearchtextbox") WebElement searchTextbox;
	@FindBy(how=How.XPATH, using="//*[@id=\"nav-search-submit-text\"]/input") WebElement searchSubmitButton;
	@FindBy(how=How.XPATH, using="//*[@id=\"search\"]//span[@data-component-type='s-search-results']/div[2]/div") List<WebElement> productResultsList;
*/
}
