package med.webtest;

import java.io.IOException;

import org.testng.annotations.Test;

import med.webproperties.MedicarePropertyConfig;
import med.webtestdata.MedicareHomeTestData;
import med.webutil.MedicareExcelUtil;

public class MedicareAccessTest {
	
	/*@Test(groups = { "test-group" }, dataProvider ="medicare-categorylist", dataProviderClass = MedicareHomeTestData.class)
	public void medicareTest(String categoryValue) throws IOException {
		System.out.println("SMOKE TESTING - Medicare Web Test Setup Success");
		System.out.println(categoryValue);
		//MedicareHomeTestData.readExcelDataTest();
		//MedicareHomeTestData.writeExcelDataTest();		
	} */
	
	@Test
	public void sampleDemo() {
		
		System.out.println("Automation Project Setup Test Sucess");
	}
}
