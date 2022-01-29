package med.webtestdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareExcelUtil;

public class MedicareViewProductTestData extends TestDataBase {

	@DataProvider(name = "viewproduct-list")
	public static Object[][] tdViewProductList() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDVWPF,
				            MedicarePropertyConfig.TDFSNONE);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("dropdownSelectValue", arrObj[row][0].toString());
		    hashMapItems.put("totalProducts", arrObj[row][1].toString());
		    hashMapItems.put("totalPages", arrObj[row][2].toString());
		    hashMapItems.put("pageNumber", arrObj[row][3].toString());
		    hashMapItems.put("rowNumber", arrObj[row][4].toString());
		    hashMapItems.put("productName", arrObj[row][5].toString());
		    hashMapItems.put("productBrand", arrObj[row][6].toString());
		    hashMapItems.put("productPrice", arrObj[row][7].toString());
		    hashMapItems.put("productQty", arrObj[row][8].toString());
			arrViewProduct[row][0] = hashMapItems;
			
		}		
	
	    return arrViewProduct;
		//return arrObj;
	}
	
	@DataProvider(name = "viewproduct-sort")
	public static Object[][] tdViewProductSort() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDVWPF,
				            MedicarePropertyConfig.TDFSNTWO);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("sortOrder", arrObj[row][0].toString());
			hashMapItems.put("dropdownSelectValue", arrObj[row][1].toString());
		    hashMapItems.put("totalProducts", arrObj[row][2].toString());
		    hashMapItems.put("totalPages", arrObj[row][3].toString());
		    hashMapItems.put("pageNumber", arrObj[row][4].toString());
		    hashMapItems.put("rowNumber", arrObj[row][5].toString());
		    hashMapItems.put("productName", arrObj[row][6].toString());
		    hashMapItems.put("productBrand", arrObj[row][7].toString());
		    hashMapItems.put("productPrice", arrObj[row][8].toString());
		    hashMapItems.put("productQty", arrObj[row][9].toString());
			arrViewProduct[row][0] = hashMapItems;
			
		}		
	
	    return arrViewProduct;
		//return arrObj;
	}
	
	@DataProvider(name = "viewproduct-search")
	public static Object[][] tdViewProductSearch() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDVWPF,
				            MedicarePropertyConfig.TDFSNTHREE);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("searchText", arrObj[row][0].toString());
			hashMapItems.put("dropdownSelectValue", arrObj[row][1].toString());
		    hashMapItems.put("totalProducts", arrObj[row][2].toString());
		    hashMapItems.put("totalPages", arrObj[row][3].toString());
		    hashMapItems.put("pageNumber", arrObj[row][4].toString());
		    hashMapItems.put("rowNumber", arrObj[row][5].toString());
		    hashMapItems.put("productName", arrObj[row][6].toString());
		    hashMapItems.put("productBrand", arrObj[row][7].toString());
		    hashMapItems.put("productPrice", arrObj[row][8].toString());
		    hashMapItems.put("productQty", arrObj[row][9].toString());
			arrViewProduct[row][0] = hashMapItems;
			
		}		
	
	    return arrViewProduct;
		//return arrObj;
	}
	
	@DataProvider(name = "viewproduct-category")
	public static Object[][] tdViewProductCategory() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDVWPF,
				            MedicarePropertyConfig.TDFSNFOUR);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("category", arrObj[row][0].toString());
			hashMapItems.put("dropdownSelectValue", arrObj[row][1].toString());
		    hashMapItems.put("totalProducts", arrObj[row][2].toString());
		    hashMapItems.put("totalPages", arrObj[row][3].toString());
		    hashMapItems.put("pageNumber", arrObj[row][4].toString());
		    hashMapItems.put("rowNumber", arrObj[row][5].toString());
		    hashMapItems.put("productName", arrObj[row][6].toString());
		    hashMapItems.put("productBrand", arrObj[row][7].toString());
		    hashMapItems.put("productPrice", arrObj[row][8].toString());
		    hashMapItems.put("productQty", arrObj[row][9].toString());
			arrViewProduct[row][0] = hashMapItems;
			
		}		
	
	    return arrViewProduct;
		//return arrObj;
	}
}
