package med.webpages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MedicareViewProductsPage extends TestPageBase {
	
	private Boolean _isFirstIterationProductListTest = true;
	private Boolean _isFirstIterationSortTest = true;
	private Boolean _isFirstIterationSearchTest = true;
	private Boolean _isFirstIterationCategoryTest = true;
	private final String productTableXpath = "//table[@id='productListTable']";
	//private final String categoryXpathBuilder = "//div[@class='list-group']/a[@id='a_";
	private final String pageLinkBuilder = "//div[@id='productListTable_paginate']/ul/li/a[text()='";
	private final String tableRowBuilder = "//table[@id='productListTable']/tbody/tr[";
	private final String catXpathBuilder = "//div[@class='list-group']/a[@id='a_";
	private final String viewPdtLinkXpathBuilder = "//a[text()='View Products']";
	private final String orderPageScrollJsBuilder = "window.scrollBy(0,document.body.scrollHeight)";
	
	@FindBy(how=How.XPATH, using="//table[@id='productListTable']") WebElement productTable;
	@FindBy(how=How.XPATH, using="//div[@id='productListTable_info']") WebElement productTableCount;
	@FindBy(how=How.XPATH, using="//a[text()='View Products']") WebElement viewProductLink;
	@FindBy(how=How.XPATH, using="//Select[@name='productListTable_length']") WebElement drpDownList;
	@FindBy(how=How.XPATH, using="//div[@id='productListTable_paginate']/ul/li/a") List<WebElement> pagingList;
	@FindBy(how=How.XPATH, using="//div[@id='productListTable_paginate']/ul/li/a[text()='1']") WebElement pageListOne;
	@FindBy(how=How.XPATH, using="//div[@id='productListTable_paginate']/ul/li/a[text()='1']/parent::li") WebElement pageListOneParent;
	@FindBy(how=How.XPATH, using="//table[@id='productListTable']/thead/tr/th[2]") WebElement sortByName;
	@FindBy(how=How.XPATH, using="//input[@type='search']") WebElement searchTxt;
	
	
	//input[@type='search']
	
	public MedicareViewProductsPage(WebDriver driver){
		super(driver);
	}
	
	
	public void validateProductTotalCount(String countStr) {
		waitForPageToBeVisible(productTableXpath);
		Assert.assertTrue(productTableCount.getText().contains(countStr));
	}
	
	public void clickViewProductLink() {
		
		//viewProductLink.click();
		clickElementWithFluentWait(viewPdtLinkXpathBuilder);
		waitForPageToBeVisible(productTableXpath);
	}
	
	public void clickViewProductDetail(String rowNum) {
	
		WebElement expProductEyeLink = _driver.findElement(By.xpath(tableRowBuilder+rowNum+"]/td[last()]/a"));
		expProductEyeLink.click();		
	}
	
	
	public void clickviewProductLast(String rowNum) {
		
		WebElement expProductCartLink = _driver.findElement(By.xpath(tableRowBuilder+rowNum+"]/td[last()]/a/following-sibling::a"));
		expProductCartLink.click();		
	}
	
	public void selectDropdownViewProduct(String drpVal) {
		
		Select dropdown = new Select(drpDownList);
  		dropdown.selectByValue(drpVal);
	}
	
	public void selectPageViewProduct(String pageNum) {
		
		WebElement expPageLink = _driver.findElement(By.xpath(pageLinkBuilder+pageNum+"']"));
		WebElement expPageLinkParent = _driver.findElement(By.xpath(pageLinkBuilder+pageNum+"']/parent::li"));
		if(!expPageLinkParent.getAttribute("class").contains("active")) {
			execJsScript(orderPageScrollJsBuilder);
			expPageLink.click();
		}
	}
	
	
    public void validateAdminProduct(HashMap<String,String> expHashMapVal) {
		
    	Select dropdown = new Select(drpDownList);
		dropdown.selectByValue(expHashMapVal.get("dropdownSelectValue"));
		WebElement expPageLink = _driver.findElement(By.xpath(pageLinkBuilder+expHashMapVal.get("pageNumber")+"']"));
		WebElement expPageLinkParent = _driver.findElement(By.xpath(pageLinkBuilder+expHashMapVal.get("pageNumber")+"']/parent::li"));
		if(!expPageLinkParent.getAttribute("class").contains("active")) {
		   execJsScript(orderPageScrollJsBuilder);	
		   expPageLink.click();
		}
		WebElement expProductName = _driver.findElement(By.xpath(tableRowBuilder+expHashMapVal.get("rowNumber")+"]/td[2]"));
		WebElement expProductBrand = _driver.findElement(By.xpath(tableRowBuilder+expHashMapVal.get("rowNumber")+"]/td[3]"));
		WebElement expProductPrice = _driver.findElement(By.xpath(tableRowBuilder+expHashMapVal.get("rowNumber")+"]/td[4]"));
		WebElement expProductQty = _driver.findElement(By.xpath(tableRowBuilder+expHashMapVal.get("rowNumber")+"]/td[5]"));
		Assert.assertEquals(expProductName.getText(),expHashMapVal.get("expProductName"));
		Assert.assertEquals(expProductBrand.getText(),expHashMapVal.get("expProductBrand"));
		Assert.assertTrue(expProductPrice.getText().contains(expHashMapVal.get("expProductPrice")));
		Assert.assertEquals(expProductQty.getText(),expHashMapVal.get("expProductQty"));
				
	}  
   		
	
	public void validateViewProductTableList(HashMap<String,String> expHashMapVal) throws InterruptedException {
		
		Select dropdown = new Select(drpDownList);
		dropdown.selectByValue(expHashMapVal.get("dropdownSelectValue"));
		validateProductListResult(expHashMapVal);		
				
	}	
	
     public void validateViewProductTableSort(HashMap<String,String> expHashMapVal) throws InterruptedException {
		
		Select dropdown = new Select(drpDownList);
		dropdown.selectByValue(expHashMapVal.get("dropdownSelectValue"));
		selectSortOrder(expHashMapVal.get("sortOrder"));		
		validateProductListResult(expHashMapVal);	
		//navigateViewProductPage();
				
	}
     
     public void validateViewProductTableSearch(HashMap<String,String> expHashMapVal) throws InterruptedException {
 		
 		Select dropdown = new Select(drpDownList);
 		dropdown.selectByValue(expHashMapVal.get("dropdownSelectValue"));
 		searchTxt.clear();
 		searchTxt.sendKeys(expHashMapVal.get("searchText")); 		
 		validateProductListResult(expHashMapVal);	
 				
 	}
     
     public void validateCategory(String expCategoryStr) {

   	  WebElement expCategoryEl = _driver.findElement(By.xpath(catXpathBuilder+expCategoryStr+"']"));
   	  Assert.assertEquals(expCategoryEl.getText(), expCategoryStr);	
   	} 
     
     public void validateViewProductTableCategory(HashMap<String,String> expHashMapVal) throws InterruptedException {
  		
  		Select dropdown = new Select(drpDownList);
  		dropdown.selectByValue(expHashMapVal.get("dropdownSelectValue"));
  		WebElement expCategoryEl = _driver.findElement(By.xpath(catXpathBuilder+expHashMapVal.get("category")+"']"));
  		if(!expCategoryEl.getAttribute("class").contains("active")) {
  			expCategoryEl.click();
  			waitForPageToBeVisible(productTableXpath);
  			
  		}
  		validateProductListResult(expHashMapVal);	
  				
  	}
     
     public void navigateViewProductPage() {
 		viewProductLink.click();
 		waitForPageToBeVisible(productTableXpath);
 	} 
     
     public void setUpFirstIterationProductListTest() {
 		if(_isFirstIterationProductListTest) {
 			navigateViewProductPage();
 			_isFirstIterationProductListTest = false;			
 		}			
 	}
 	
	
	public void setUpFirstIterationSortTest() {
		if(_isFirstIterationSortTest) {
			navigateViewProductPage();
			_isFirstIterationSortTest = false;			
		}			
	}	
	
	public void setUpFirstIterationSearchTest() {
		if(_isFirstIterationSearchTest) {
			navigateViewProductPage();
			_isFirstIterationSearchTest = false;			
		}			
	}
	
	public void setUpFirstIterationCategoryTest() {
		if(_isFirstIterationCategoryTest) {
			navigateViewProductPage();
			_isFirstIterationCategoryTest = false;			
		}			
	}
	
    private void validateProductListResult(HashMap<String,String> expHashMap) throws InterruptedException {
		
		WebElement expPageLink = _driver.findElement(By.xpath(pageLinkBuilder+expHashMap.get("pageNumber")+"']"));
		WebElement expPageLinkParent = _driver.findElement(By.xpath(pageLinkBuilder+expHashMap.get("pageNumber")+"']/parent::li"));
		if(!expPageLinkParent.getAttribute("class").contains("active")) {	
		  execJsScript(orderPageScrollJsBuilder);
		  expPageLink.click();
		}
		WebElement expProductName = _driver.findElement(By.xpath(tableRowBuilder+expHashMap.get("rowNumber")+"]/td[2]"));
		WebElement expProductBrand = _driver.findElement(By.xpath(tableRowBuilder+expHashMap.get("rowNumber")+"]/td[3]"));
		WebElement expProductPrice = _driver.findElement(By.xpath(tableRowBuilder+expHashMap.get("rowNumber")+"]/td[4]"));
		WebElement expProductQty = _driver.findElement(By.xpath(tableRowBuilder+expHashMap.get("rowNumber")+"]/td[5]"));
		Assert.assertTrue(productTableCount.getText().contains(expHashMap.get("totalProducts")));
		Assert.assertEquals(pagingList.size() - 2,Integer.parseInt(expHashMap.get("totalPages")));
		Assert.assertEquals(expProductName.getText(),expHashMap.get("productName"));
		Assert.assertEquals(expProductBrand.getText(),expHashMap.get("productBrand"));
		Assert.assertTrue(expProductPrice.getText().contains(expHashMap.get("productPrice")));
		Assert.assertEquals(expProductQty.getText(),expHashMap.get("productQty"));
		if(!pageListOneParent.getAttribute("class").contains("active")) {
			execJsScript(orderPageScrollJsBuilder);
			pageListOne.click();
		}
		//Thread.sleep(3000);	
		
	}
	
	private void selectSortOrder(String order) {
		
		if(order.equals("asc")) {
			if (!sortByName.getAttribute("class").contains("sorting_asc"))
			{
			    moveToElement(sortByName);
				sortByName.click();
			}
		}
		
		if(order.equals("desc")) {
			if(sortByName.getAttribute("class").contains("sorting_asc")) {
				moveToElement(sortByName);
				sortByName.click();
			}
			else if (sortByName.getAttribute("class").contains("sorting_desc")) {
			}
			else {
				moveToElement(sortByName);
				sortByName.click();
			    sortByName.click();
			}
		}
		
	}
			
		
	
	//div[@id='productListTable_info']   -- 1 to 5 of 7 entries
	//div[@id='productListTable']

}
