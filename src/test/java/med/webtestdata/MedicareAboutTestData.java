package med.webtestdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareExcelUtil;

public class MedicareAboutTestData extends TestDataBase {
	
	@DataProvider(name = "about-heading")
	public static Object[][] tdAboutHeading() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDABTF,
				            MedicarePropertyConfig.TDFSNONE);
		return arrObj;
	}
	
	@DataProvider(name = "about-paragraph")
	public static Object[][] tdAboutParagraph() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDABTF,
				            MedicarePropertyConfig.TDFSNTWO);
		return arrObj;
	}

}
