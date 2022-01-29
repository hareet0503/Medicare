package med.webtestdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareExcelUtil;

public class MedicareContactTestData extends TestDataBase {
	
	@DataProvider(name = "contact-heading")
	public static Object[][] tdContactHeading() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDCONF,
				            MedicarePropertyConfig.TDFSNONE);
		return arrObj;
	}
	
	@DataProvider(name = "contact-paragraph")
	public static Object[][] tdContactParagraph() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDCONF,
				            MedicarePropertyConfig.TDFSNTWO);
		return arrObj;
	}


}



/*
Object[][] arrViewProduct = new Object[arrObj.length][1];
System.out.println(arrObj.length);

for (int row = 0; row < arrObj.length; row++) {
	MedicareViewProductModel mvpModel = new MedicareViewProductModel();
	mvpModel.set_dropdownSelectValue(arrObj[row][0].toString());
	mvpModel.set_totalPages(arrObj[row][1].toString());
	arrViewProduct[row][0] = mvpModel;
	
}


/*	for (int row = 0; row < arrObj.length; row++) {
	
	for (int col = 0; col < arrObj[row].length; col++) {
		MedicareViewProductModel mvpModel = new MedicareViewProductModel();
		mvpModel.set_dropdownSelectValue(arrObj[row][col]);
		System.out.println(arrObj[row][col]);
	}
}*/
