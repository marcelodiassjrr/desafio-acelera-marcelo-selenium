package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import CartPage.CartPage;

public class ProductsPage {
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
	
	public void removeProductsFromCart() {
		this.browser.findElement(By.xpath("//button[@data-test='remove-sauce-labs-backpack']")).click();
	}
	public boolean cartHasItems() {
		try {
			return this.browser.findElement(By.className("shopping_cart_badge")).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public CartPage openShoppingCart() {
		this.browser.findElement(By.className("shopping_cart_link")).click();
		return new CartPage(browser);
	}

}
