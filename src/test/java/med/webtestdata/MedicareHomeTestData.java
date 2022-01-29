package med.webtestdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareExcelUtil;

public class MedicareHomeTestData extends TestDataBase {

	public static void readExcelDataTest() throws IOException {

		MedicareExcelUtil.readDataTest(get_resourcePath()+MedicarePropertyConfig.TDFDEMO1);

	}

	public static void writeExcelDataTest() throws IOException {

		MedicareExcelUtil.wrtieDataTest(get_resourcePath()+MedicarePropertyConfig.TDFDEMO1);
	}

	@DataProvider(name = "medicare-categorylist")
	public static Object[][] tdMedicareCaetgoryList() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDCATF,
				            MedicarePropertyConfig.TDFSNONE);
		return arrObj;
	}
	
	@DataProvider(name = "medicare-categorycount")
	public static Object[][] tdMedicareCaetgoryCount() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDCATF,
				            MedicarePropertyConfig.TDFSNTWO);
		return arrObj;
	}
	
	@DataProvider(name = "medicare-products-mostviewedcount")
	public static Object[][] tdMedicareProductsMostViewedCount() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDCATF,
				            MedicarePropertyConfig.TDFSNTHREE);
		return arrObj;
	}
	
	@DataProvider(name = "medicare-products-mostpurchasedcount")
	public static Object[][] tdMedicareProductsMostPurchasedCount() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDCATF,
				            MedicarePropertyConfig.TDFSNFOUR);
		return arrObj;
	}
	
	@DataProvider(name = "medicare-products-Moreproductscount")
	public static Object[][] tdMedicareProductsMoreProductsCount() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDCATF,
				            MedicarePropertyConfig.TDFSNFIVE);
		return arrObj;
	}

}
