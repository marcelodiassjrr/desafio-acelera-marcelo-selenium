package CartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	private WebDriver browser;

	public CartPage(WebDriver browser) {
		this.browser = browser;
	}
	
	public void quit() {
		this.browser.quit();
	}

	public void checkOut() {
		this.browser.findElement(By.id("checkout")).click();
	}
	
	public boolean isCheckOutPage() {
		return browser.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html");
	}

}
