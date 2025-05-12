package Browser_Init;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import junit.framework.Assert;


public class Placing_order extends Baseclass{
	PageObject pageelements = new PageObject();


	@Test(priority=1)
	public void goTo() throws IOException {
		System.out.println("Opening Application");
		driver.manage().window().maximize();
		driver.get(applicationURL);
	}

	@Test(priority=2)
	public void login() {
		driver.findElement(pageelements.email_field).sendKeys(Email);
		driver.findElement(pageelements.password_field).sendKeys(Password);
		driver.findElement(pageelements.login_button).click();
		System.out.println("------------------Login Successfully----------------------");
	}


	@Test(priority=3)
	public void productList() throws InterruptedException, IOException {

		String expectedProduct = prop.getProperty("actualproduct");
		Thread.sleep(3000);
		List<WebElement> listofProducts= driver.findElements(pageelements.productlist_container);
		for( WebElement container: listofProducts) {
			WebElement productName= container.findElement(pageelements.productlist_text);
			//lib.waitForElementToBeVisible(pageelements.productlist_text);
			String nameofProduct=	productName.getText();
			//	System.out.println("Selected product"+ nameofProduct);
			if(nameofProduct.equalsIgnoreCase(expectedProduct)) {
				WebElement allProducts= container.findElement(pageelements.add_to_cart);
				//lib.waitForElementToBeClickable(pageelements.add_to_cart);
				allProducts.click();
				break;
			}

		}
	}

	@Test(priority=4)
	public void cartPage() throws InterruptedException {
		Thread.sleep(4000);
		lib.invisiblityOfElementLocated(pageelements.toaster);
		lib.waitForElementToBeClickable(pageelements.cart_icon);
		lib.waitForElementToBeClickable(pageelements.checkout_button);
	}

	@Test(priority=5)
	public void paymentPage() throws InterruptedException {

		String countrySelection = prop.getProperty("country");
		lib.waitForElementToBeVisible(pageelements.country_dropdown);
		WebElement selectCountry = driver.findElement(pageelements.country_dropdown);
		selectCountry.sendKeys(countrySelection);		

		Thread.sleep(4000);
		lib.waitForElementToBeVisible(pageelements.country_values);	
		List <WebElement> countryLists= driver.findElements(pageelements.country_values);
		for(WebElement listsofCountry : countryLists) {
			String dropdownLists = listsofCountry.getText().trim();
			System.out.println(dropdownLists);
			if(dropdownLists.equalsIgnoreCase(countrySelection)) {	
				lib.scrollToElement(listsofCountry);
				Thread.sleep(3000);
				listsofCountry.click();
			}
		}
	}
	@Test(priority=6)
	public void orderpageValidation() {
		lib.waitForElementToBeClickable(pageelements.placeorder_button);
		String thankMessage=lib.getText(pageelements.validation_message);
		System.out.println(thankMessage);
		Assert.assertTrue(thankMessage.trim().equalsIgnoreCase("Thankyou for the order."));
	}

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










