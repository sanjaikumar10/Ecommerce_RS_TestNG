package Browser_Init;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Libraryclass {

	WebDriver driver;

	// Constructor to initialize WebDriver
	public Libraryclass(WebDriver driver) {
		this.driver = driver;
	}

	// Wait for element to be visible
	public void waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Wait for element to be clickable
	public void waitForElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();

	}

	// Click an element
	public void clickElement(By locator) {
		waitForElementToBeClickable(locator);
		driver.findElement(locator).click();
	}

	// Send text to an element
	public void sendKeysToElement(By locator, String text) {
		waitForElementToBeVisible(locator);
		driver.findElement(locator).sendKeys(text);
	}

	// Clear and send text to an input element
	public void clearAndSendKeys(By locator, String text) {
		waitForElementToBeVisible(locator);
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	// Get text from an element
	public String getText(By locator) {
		waitForElementToBeVisible(locator);
		return driver.findElement(locator).getText();
	}
	public void invisiblityOfElementLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated((locator)));
	}

	// Wait for list of elements to be visible
	public void waitForListOfElementsToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	 public void scrollToElement(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	 public void scrollToBottom() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(1000, document.body.scrollHeight)");
	    }


}



