import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Step;

public class LoginTest {

	LoginPage loginPage;

	@BeforeEach
	public void beforeEach() {
		this.loginPage = new LoginPage();
	}

	@AfterEach
	public void afterEach() {
		this.loginPage.quit();
	}

	@Test
	@Step
	@org.testng.annotations.Test
	public void realizaLogin() {
		this.loginPage.login("standard_user", "secret_sauce");
		assertTrue(this.loginPage.isSecretPage());
	}

	@Test
	@Step
	@org.testng.annotations.Test
	public void naoRealizaLoginComSenhaInválida() {
		this.loginPage.login("standard_user", "14289322");
		assertTrue(!this.loginPage.isSecretPage());
	}
}
