package Browser_Init;

import org.openqa.selenium.By;

public class PageObject {

	public By email_field= By.id("userEmail");
	public By password_field= By.id("userPassword");
	public By login_button= By.id("login");
	public By add_to_cart= By.xpath(".//button[contains(text(),' Add To Cart')]");
	public By toaster = By.cssSelector(".toast-container");
	public By cart_icon= By.xpath("//button[@routerlink='/dashboard/cart']");
	public By cart_container= By.xpath("//div[@class='cartSection']");
	public By checkout_button= By.xpath("//button[normalize-space()='Checkout']");
	public By country_dropdown= By.cssSelector("input[placeholder*='Country']");
	public By country_values= By.xpath("(//button[contains(@class, 'ta-item')][2])");
	public By placeorder_button = By.xpath("//a[normalize-space()='Place Order']");
	public By validation_message= By.cssSelector(".hero-primary");
	public By productlist_container= By.cssSelector(".mb-3");
	public By productlist_text= By.tagName("b");
	
	
}
