package med.webtestdata;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareExcelUtil;

public class MedicareAdminTestData extends TestDataBase {
	
	@DataProvider(name = "admin-addcategory")
	public static Object[][] tdMedicareAddCategory() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDAF,
				            MedicarePropertyConfig.TDFSNONE);
		return arrObj;
	}
	
	@DataProvider(name = "admin-addproduct")
	public static Object[][] tdMedicareAddProduct() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDAF,
				            MedicarePropertyConfig.TDFSNTWO);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("productName", arrObj[row][0].toString());
		    hashMapItems.put("productBrand", arrObj[row][1].toString());
		    hashMapItems.put("productDesc", arrObj[row][2].toString());
		    hashMapItems.put("productPrice", arrObj[row][3].toString());
		    hashMapItems.put("productQty", arrObj[row][4].toString());
		    hashMapItems.put("fileLocation", arrObj[row][5].toString());
		    hashMapItems.put("productCategory", arrObj[row][6].toString());		    
		    hashMapItems.put("dropdownSelectValue", arrObj[row][7].toString());
		    hashMapItems.put("pageNumber", arrObj[row][8].toString());
		    hashMapItems.put("rowNumber", arrObj[row][9].toString());
		    hashMapItems.put("expProductName", arrObj[row][10].toString());
		    hashMapItems.put("expProductBrand", arrObj[row][11].toString());
		    hashMapItems.put("expProductPrice", arrObj[row][12].toString());
		    hashMapItems.put("expProductQty", arrObj[row][13].toString());
			arrViewProduct[row][0] = hashMapItems;
			
		}			
	    return arrViewProduct;
		//return arrObj;
	}
	
	
	@DataProvider(name = "admin-editproduct")
	public static Object[][] tdMedicareEditProduct() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDAF,
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
			 hashMapItems.put("expProductName", arrObj[row][7].toString());
			 hashMapItems.put("expProductBrand", arrObj[row][8].toString());
			 hashMapItems.put("expProductDesc", arrObj[row][9].toString());
			 hashMapItems.put("expProductPrice", arrObj[row][10].toString());
			 hashMapItems.put("expProductQty", arrObj[row][11].toString());
			 hashMapItems.put("fileLocation", arrObj[row][12].toString());
			 hashMapItems.put("productCategory", arrObj[row][13].toString());		
			 hashMapItems.put("expUnitPrice", arrObj[row][14].toString());		 

			arrViewProduct[row][0] = hashMapItems;
			
		}			
	    return arrViewProduct;
		//return arrObj;
	}	

}
