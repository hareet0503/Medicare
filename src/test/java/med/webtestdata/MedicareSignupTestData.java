package med.webtestdata;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareExcelUtil;

public class MedicareSignupTestData extends TestDataBase {
	
	@DataProvider(name = "signup-newuser")
	public static Object[][] tdSignUpNewUser() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = MedicareExcelUtil.getExcelDataWithoutHeader(
				            get_resourcePath() + MedicarePropertyConfig.TDMEDSNUPF,
				            MedicarePropertyConfig.TDFSNONE);
		
		//List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
	   // HashMap<String, String> hashMapItems = new HashMap<String, String>();
	    
		Object[][] arrViewProduct = new Object[arrObj.length][1];
		
		for (int row = 0; row < arrObj.length; row++) {
			HashMap<String, String> hashMapItems = new HashMap<String, String>();
			hashMapItems.put("firstName", arrObj[row][0].toString());
		    hashMapItems.put("lastName", arrObj[row][1].toString());
		    hashMapItems.put("email", arrObj[row][2].toString());
		    hashMapItems.put("contactNumber", arrObj[row][3].toString());
		    hashMapItems.put("password", arrObj[row][4].toString());
		    hashMapItems.put("confirmPassword", arrObj[row][5].toString());
		    hashMapItems.put("selectRole", arrObj[row][6].toString());
		    hashMapItems.put("addrLine1", arrObj[row][7].toString());
		    hashMapItems.put("addrLine2", arrObj[row][8].toString());
		    hashMapItems.put("city", arrObj[row][9].toString());
		    hashMapItems.put("postalCode", arrObj[row][10].toString());
		    hashMapItems.put("state", arrObj[row][11].toString());
		    hashMapItems.put("country", arrObj[row][12].toString());
		    hashMapItems.put("expName", arrObj[row][13].toString());
		    hashMapItems.put("expEmail", arrObj[row][14].toString());
		    hashMapItems.put("expContact", arrObj[row][15].toString());
		    hashMapItems.put("expRole", arrObj[row][16].toString());
		    hashMapItems.put("expAddr1", arrObj[row][17].toString());
		    hashMapItems.put("expAddr2", arrObj[row][18].toString());
		    hashMapItems.put("expCityZip", arrObj[row][19].toString());
		    hashMapItems.put("expState", arrObj[row][20].toString());
		    hashMapItems.put("expCountry", arrObj[row][21].toString());
		    hashMapItems.put("expHeading", arrObj[row][22].toString());
		    hashMapItems.put("expPara", arrObj[row][23].toString());
		    hashMapItems.put("expDesc", arrObj[row][24].toString());
		    hashMapItems.put("expLoginName", arrObj[row][25].toString());
		    hashMapItems.put("expLogoutUrl", arrObj[row][26].toString());
			arrViewProduct[row][0] = hashMapItems;
			
		}		
	
	    return arrViewProduct;
		//return arrObj;
	}
	

}


/*
First Name
Last Name
Email
Contact Number
Password
Confirm Password
Select Role
Address Line One
Address Line Two
City	
Postal Code
State
Country	
Exp Name
Exp Email	
Exp Contact
Exp Role
Exp Address1
Exp Address2	
Exp City Zip
Exp State	
Exp Country
Exp Heading
Exp Para	
Exp Desc
Exp Login Name*/

