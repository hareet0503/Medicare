package med.webutil;

import java.nio.file.Path;
import java.nio.file.Paths;

import med.webproperties.MedicarePropertyConfig;

public class MedicareFileUtil {
	
public static String getMedicareTestDataResourcePath() {
		
	    String resourcePath = "";
		Path resourceDirectory = Paths.get(MedicarePropertyConfig.SRCPATHSTR,MedicarePropertyConfig.TESTPATHSTR,
				                           MedicarePropertyConfig.RESOURCESPATHSTR,MedicarePropertyConfig.MEDICARETESTDATASTR);
		resourcePath = resourceDirectory.toFile().getAbsolutePath();
		return resourcePath;		
	
	}

public static String getMedicareTestImagesResourcePath() {
	
    String resourcePath = "";
	Path resourceDirectory = Paths.get(MedicarePropertyConfig.SRCPATHSTR,MedicarePropertyConfig.TESTPATHSTR,
			                           MedicarePropertyConfig.RESOURCESPATHSTR,MedicarePropertyConfig.MEDICARETESTIMAGESSTR);
	resourcePath = resourceDirectory.toFile().getAbsolutePath();
	return resourcePath;		

}

}
