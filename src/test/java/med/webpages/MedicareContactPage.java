package med.webpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class MedicareContactPage extends TestPageBase {
	
	@FindBy(how=How.XPATH, using="//a[text()='Contact']") WebElement contactLink;
	@FindBy(how=How.XPATH, using="//h1") WebElement contactHeading;
	@FindBy(how=How.XPATH, using="//p") WebElement contactPara;
	
	public MedicareContactPage(WebDriver driver){
		super(driver);
	}
	
	public void navigateContact() {
		contactLink.click();
	}
	
	public void validateContactHeading(String expHeadStr) {
		Assert.assertEquals(contactHeading.getText(), expHeadStr);
	}
	
    public void validateContactPara(String expParaStr) {
    	Assert.assertEquals(contactPara.getText(), expParaStr);
	}
}
