package med.webtestdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareExcelUtil;

public class MedicareLoginTestData extends TestDataBase {
	
	@DataProvider(name = "medicare-loginsucess")
	public static Object[][] tdMedicareLoginSuccess() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDLGSF,
				            MedicarePropertyConfig.TDFSNONE);
		return arrObj;
	}

}
