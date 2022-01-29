package med.webtestdata;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareExcelUtil;

public class MedicareUserCheckoutTestData extends TestDataBase {
	
	@DataProvider(name = "user-addproduct-cart")
	public static Object[][] tdAddProductCart() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDUCHKF,
				            MedicarePropertyConfig.TDFSNONE);
		
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
		    arrViewProduct[row][0] = hashMapItems;			
		}			
	    return arrViewProduct;
		//return arrObj;
	}
	
	
	@DataProvider(name = "user-chkproduct-cart")
	public static Object[][] tdChkProductCart() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDUCHKF,
				            MedicarePropertyConfig.TDFSNTWO);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("rowNumber", arrObj[row][0].toString());
		    hashMapItems.put("expProductName", arrObj[row][1].toString());
		    hashMapItems.put("expProductBrand", arrObj[row][2].toString());
		    hashMapItems.put("expProductDesc", arrObj[row][3].toString());
		    hashMapItems.put("expProductPrice", arrObj[row][4].toString());
		    hashMapItems.put("expSubtotal", arrObj[row][5].toString());
		    hashMapItems.put("expTotal", arrObj[row][6].toString());		    
		    hashMapItems.put("expCartBdgQty", arrObj[row][7].toString());
		    hashMapItems.put("expCartBdgTot", arrObj[row][8].toString());
		    arrViewProduct[row][0] = hashMapItems; 
		   
		}			
	    return arrViewProduct;
		//return arrObj;
	}
	
	
	@DataProvider(name = "user-chkoutproduct-sumlst")
	public static Object[][] tdChkoutProductList() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDUCHKF,
				            MedicarePropertyConfig.TDFSNTHREE);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("rowNumber", arrObj[row][0].toString());
		    hashMapItems.put("expProductName", arrObj[row][1].toString());
		    hashMapItems.put("expProductQty", arrObj[row][2].toString());		    
		    hashMapItems.put("expPurchasePrice", arrObj[row][3].toString());
		    hashMapItems.put("expGrandtotal", arrObj[row][4].toString());
		    hashMapItems.put("expFinalTotal", arrObj[row][5].toString());		    
		 
		    arrViewProduct[row][0] = hashMapItems;  
			   
		}			
	    return arrViewProduct;
		//return arrObj;
	}
	
	@DataProvider(name = "user-orderlist-summary")
	public static Object[][] tdFinalOrderList() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDUCHKF,
				            MedicarePropertyConfig.TDFSNFOUR);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("rowNumber", arrObj[row][0].toString());
		    hashMapItems.put("expOrderItem", arrObj[row][1].toString());		    		    
		    hashMapItems.put("expOrderPrice", arrObj[row][2].toString());
		    hashMapItems.put("expOrderQty", arrObj[row][3].toString());
		    hashMapItems.put("expOrdertotal", arrObj[row][4].toString());   
		 
		    arrViewProduct[row][0] = hashMapItems;  
			   
		}			
	    return arrViewProduct;
		//return arrObj;
	}
	

}
