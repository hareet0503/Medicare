package med.webtestdata;

import java.nio.file.Path;
import java.nio.file.Paths;

import med.webproperties.MedicarePropertyConfig;
import med.webutil.MedicareFileUtil;

public class TestDataBase {
	
	private static String _resourcePath;
		
	protected static String get_resourcePath() {
		
		_resourcePath = MedicareFileUtil.getMedicareTestDataResourcePath();
		return _resourcePath;		
	
	}	
	

}
