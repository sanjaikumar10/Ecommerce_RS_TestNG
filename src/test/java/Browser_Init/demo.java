package Browser_Init;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

public class demo {
	@DataProvider
	public Object[][] getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Email", "sanjairajendran10@gmail.com");
		map.put("Password", "Sanjaikumar10*");
		map.put("productname","ADIDAS ORIGINAL");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map.put("Email", "sanjairajendran10@gmail.com");
		map.put("Password", "Sanjaikumar10*");
		map.put("productname","ZARA COAT 3");
		return new Object[][] {{},{}};
	}

}
