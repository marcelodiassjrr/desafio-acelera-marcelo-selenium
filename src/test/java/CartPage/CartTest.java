package CartPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import HomePage.ProductsPage;
import LoginPage.LoginPage;
import io.qameta.allure.Step;

public class CartTest {
	private CartPage cartPage;
	private ProductsPage productsPage;
	private LoginPage loginPage;
	
	@AfterEach
	public void afterEach() {
		//this.productsPage.quit();
		this.cartPage = null;
		this.productsPage = null;
	}
	
	@Test
	@Step
	@org.testng.annotations.Test
	public void realizarCheckOut() {
		this.loginPage = new LoginPage();
		this.productsPage = this.loginPage.login("standard_user", "secret_sauce");
		this.productsPage.addProductToCart();
		this.cartPage = this.productsPage.openShoppingCart();
		this.cartPage.checkOut();
		assertTrue(this.cartPage.isCheckOutPage());
	}
}
