package med.webpages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import med.webutil.MedicareFileUtil;

public class MedicareAdminPage extends TestPageBase {
	
	private final String saveBtnXpathBuilder = "//form[@id='product']//input[@type='submit']";
	private final String managePdtXpathBuilder = "//a[text()='Manage Product']";
	private final String addCatXpathBuilder = "//button[text()='Add New Category']";
	private final String orderPageScrollJsBuilder = "window.scrollBy(0,document.body.scrollHeight)";
	
	
	
	@FindBy(how=How.XPATH, using="//a[text()='Manage Product']") WebElement managePdtLinkEl;
	@FindBy(how=How.XPATH, using="//button[text()='Add New Category']") WebElement addCategoryEl;
	@FindBy(how=How.XPATH, using="//form[@id='categoryForm']//input[@id='name']") WebElement popNameEl;
	@FindBy(how=How.XPATH, using="//form[@id='categoryForm']//textarea[@id='description']") WebElement popDescEl;
	@FindBy(how=How.XPATH, using="//form[@id='categoryForm']//input[@type='submit']") WebElement popBtnSaveEl;
	@FindBy(how=How.XPATH, using="//select[@id='categoryId']/option") List<WebElement> drpdnBtnEl;
	
	
	@FindBy(how=How.XPATH, using="//form[@id='product']//input[@id='name']") WebElement addPdtNameEl;
	@FindBy(how=How.XPATH, using="//form[@id='product']//input[@id='brand']") WebElement addPdtBndEl;
	@FindBy(how=How.XPATH, using="//form[@id='product']//textarea[@id='description']") WebElement addPdtDescEl;
	@FindBy(how=How.XPATH, using="//form[@id='product']//input[@id='unitPrice']") WebElement addPdtUnitEl;
	@FindBy(how=How.XPATH, using="//form[@id='product']//input[@id='quantity']") WebElement addPdtQtyEl;
	@FindBy(how=How.XPATH, using="//form[@id='product']//input[@id='file']") WebElement addPdtFileEl;
	@FindBy(how=How.XPATH, using="//form[@id='product']//select[@id='categoryId']") WebElement drpdnPdtCatEl;
	@FindBy(how=How.XPATH, using="//form[@id='product']//input[@type='submit']") WebElement pdtBtnSaveEl;
		
	
	public MedicareAdminPage(WebDriver driver){
		super(driver);
	}	
	
	public void validateAddNewCategory(String cat, String desc,MedicareViewProductsPage viewProductPage) throws InterruptedException {
		
		clickElementWithFluentWait(managePdtXpathBuilder);
		waitForPageToBeVisible(saveBtnXpathBuilder);
		clickElementWithFluentWait(addCatXpathBuilder);
		popNameEl.sendKeys(cat);
		popDescEl.sendKeys(desc);
		popBtnSaveEl.click();
		viewProductPage.clickViewProductLink();
		viewProductPage.validateCategory(cat);
		clickElementWithFluentWait(managePdtXpathBuilder);
		Assert.assertTrue(validateCategoryDropdown(cat));
		
	}
	
	public void validateAddNewProduct(HashMap<String,String> hashMapProductVal,MedicareViewProductsPage viewProductPage) throws InterruptedException {
		
		clickElementWithFluentWait(managePdtXpathBuilder);
		waitForPageToBeVisible(saveBtnXpathBuilder);
		addPdtNameEl.sendKeys(hashMapProductVal.get("productName"));
		addPdtBndEl.sendKeys(hashMapProductVal.get("productBrand"));
		addPdtDescEl.sendKeys(hashMapProductVal.get("productDesc"));
		addPdtUnitEl.clear();
		addPdtUnitEl.sendKeys(hashMapProductVal.get("productPrice"));
		addPdtQtyEl.clear();
		addPdtQtyEl.sendKeys(hashMapProductVal.get("productQty"));
		addPdtFileEl.sendKeys(MedicareFileUtil.getMedicareTestImagesResourcePath()+hashMapProductVal.get("fileLocation"));
		Select dropdown = new Select(drpdnPdtCatEl);
  		dropdown.selectByVisibleText(hashMapProductVal.get("productCategory"));
  		pdtBtnSaveEl.click();
  		viewProductPage.clickViewProductLink();
  		viewProductPage.validateAdminProduct(hashMapProductVal);
  		//Thread.sleep(5000);
		
	}
	
	public void validateEditNewProduct(HashMap<String,String> hashMapPdtEditVal,MedicareViewProductsPage viewProductPage) throws InterruptedException {
		
		//clickElementWithFluentWait(managePdtXpathBuilder);
		viewProductPage.clickViewProductLink();
		execJsScript(orderPageScrollJsBuilder);
		viewProductPage.selectDropdownViewProduct(hashMapPdtEditVal.get("dropdownSelectValue"));
		viewProductPage.selectPageViewProduct(hashMapPdtEditVal.get("pageNumber"));
		viewProductPage.clickviewProductLast(hashMapPdtEditVal.get("rowNumber"));
		waitForPageToBeVisible(saveBtnXpathBuilder);		
		addPdtNameEl.clear();
		addPdtNameEl.sendKeys(hashMapPdtEditVal.get("expProductName"));
		addPdtBndEl.clear();
		addPdtBndEl.sendKeys(hashMapPdtEditVal.get("expProductBrand"));
		addPdtDescEl.clear();
		addPdtDescEl.sendKeys(hashMapPdtEditVal.get("expProductDesc"));
		addPdtUnitEl.clear();
		addPdtUnitEl.sendKeys(hashMapPdtEditVal.get("expUnitPrice"));
		addPdtQtyEl.clear();
		addPdtQtyEl.sendKeys(hashMapPdtEditVal.get("expProductQty"));
		addPdtFileEl.clear();
		addPdtFileEl.sendKeys(MedicareFileUtil.getMedicareTestImagesResourcePath()+hashMapPdtEditVal.get("fileLocation"));
		Select dropdown = new Select(drpdnPdtCatEl);
  		dropdown.selectByVisibleText(hashMapPdtEditVal.get("productCategory"));
		pdtBtnSaveEl.click();
  		viewProductPage.clickViewProductLink();
  		viewProductPage.validateAdminProduct(hashMapPdtEditVal);  		
		
		}	
	
	
	public Boolean validateCategoryDropdown(String catVal) {
		
	    for(WebElement e :drpdnBtnEl){  
			
	    	if(e.getText().equals(catVal))
	    		return true;
	    	
		}  
		
		return false;
	}

}
