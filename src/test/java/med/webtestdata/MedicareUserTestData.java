package med.webtestdata;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareExcelUtil;

public class MedicareUserTestData extends TestDataBase {

	@DataProvider(name = "user-cartinfo")
	public static Object[][] tdMedicareCartInfoList() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDUF,
				            MedicarePropertyConfig.TDFSNONE);
		return arrObj;
	}
	
	
	@DataProvider(name = "user-productdetail")
	public static Object[][] tdViewUserProductDetail() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDUF,
				            MedicarePropertyConfig.TDFSNTWO);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("dropdownSelectValue", arrObj[row][0].toString());
		    hashMapItems.put("pageNumber", arrObj[row][1].toString());
		    hashMapItems.put("rowNumber", arrObj[row][2].toString());
		    hashMapItems.put("productName", arrObj[row][3].toString());
		    hashMapItems.put("productBrand", arrObj[row][4].toString());
		    hashMapItems.put("productPrice", arrObj[row][5].toString());
		    hashMapItems.put("productQty", arrObj[row][6].toString());
		    hashMapItems.put("expProductDesc", arrObj[row][7].toString());
		    hashMapItems.put("expProductPrice", arrObj[row][8].toString());
			arrViewProduct[row][0] = hashMapItems;
			
		}			
	    return arrViewProduct;
		//return arrObj;
	}
	
	
	@DataProvider(name = "user-cartammount")
	public static Object[][] tdUserCartNumberDetail() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDUF,
				            MedicarePropertyConfig.TDFSNTHREE);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("dropdownSelectValue", arrObj[row][0].toString());
		    hashMapItems.put("pageNumber", arrObj[row][1].toString());
		    hashMapItems.put("rowNumber", arrObj[row][2].toString());
		    hashMapItems.put("productName", arrObj[row][3].toString());
		    hashMapItems.put("productBrand", arrObj[row][4].toString());
		    hashMapItems.put("productPrice", arrObj[row][5].toString());
		    hashMapItems.put("productQty", arrObj[row][6].toString());		    
		    hashMapItems.put("pdtCheckoutQty", arrObj[row][7].toString());		    
		    hashMapItems.put("expProductName", arrObj[row][8].toString());
		    hashMapItems.put("expProductBrand", arrObj[row][9].toString());		    
		    hashMapItems.put("expProductDesc", arrObj[row][10].toString());
		    hashMapItems.put("expProductPrice", arrObj[row][11].toString());
		    hashMapItems.put("expSubtotal", arrObj[row][12].toString());
		    hashMapItems.put("expTotal", arrObj[row][13].toString());		    
		    hashMapItems.put("expCartBdgQty", arrObj[row][14].toString());
		    hashMapItems.put("expCartBdgTot", arrObj[row][15].toString());
		    hashMapItems.put("expDelPdtConf", arrObj[row][16].toString());
			arrViewProduct[row][0] = hashMapItems;		
			
		}			
	    return arrViewProduct;
		//return arrObj;
	}
	
	
	
	

	
	
	
}




