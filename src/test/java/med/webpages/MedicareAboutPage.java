package med.webpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import med.webproperties.MedicarePropertyConfig;

public class MedicareAboutPage extends TestPageBase {
	
	@FindBy(how=How.XPATH, using="//a[text()='About']") WebElement aboutLink;
	@FindBy(how=How.XPATH, using="//h1") WebElement aboutHeading;
	@FindBy(how=How.XPATH, using="//p") WebElement aboutPara;
	
	public MedicareAboutPage(WebDriver driver){
		super(driver);
	}	
	
	public void navigateAbout() {
		aboutLink.click();
	}
	
	public void validateAboutHeading(String expHeadStr) {
		Assert.assertEquals(aboutHeading.getText(), expHeadStr);
	}
	
    public void validateAboutPara(String expParaStr) {
    	Assert.assertEquals(aboutPara.getText(), expParaStr);
	}

}
