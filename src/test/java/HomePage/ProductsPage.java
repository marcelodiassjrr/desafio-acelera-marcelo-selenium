package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsPage {
	//private static final String URL_INVENTORY = "https://www.saucedemo.com/inventory.html";
	private WebDriver browser;

	public ProductsPage(WebDriver browser2) {
		this.browser = browser2;
	}

	public void quit() {
		this.browser.quit();
	}

	public void addProductToCart() {
		this.browser.findElement(By.id("item_4_title_link")).click();
		this.browser.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

	}

	public boolean cartHasItems() {
		return this.browser.findElement(By.className("shopping_cart_badge")).isDisplayed();
	}

}
