package HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import LoginPage.LoginPage;
import io.qameta.allure.Step;

public class ProductsTest {
	
	private ProductsPage productsPage;
	private LoginPage loginPage;
	
	@AfterEach
	public void afterEach() {
		this.productsPage.quit();
		this.loginPage = null;
		this.productsPage = null;
	}
	
	@Test
	@Step
	@org.testng.annotations.Test
	public void adicionarItemNoCarrinho() {
		this.loginPage = new LoginPage();
		this.productsPage = this.loginPage.login("standard_user", "secret_sauce");
		this.productsPage.addProductToCart();
		assertTrue(this.productsPage.cartHasItems());
	}
}
