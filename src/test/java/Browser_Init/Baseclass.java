package Browser_Init;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;
	String applicationURL="https://rahulshettyacademy.com/client";
	String Email= "sanjairajendran10@gmail.com";
	String Password="Sanjaikumar10*";
	Libraryclass lib ;
	Properties prop ;


	@BeforeClass
	public void browserInitialize() throws IOException {
		prop = new  Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Browser_Init\\browsersetup.properties");
		prop.load(file);
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			lib = new Libraryclass(driver);
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

		}else {
			System.out.println("Browser not valid");

		}}

	//@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.close();
		}}

}