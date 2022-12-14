package LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import HomePage.ProductsPage;
import utils.WebDriverUtil;

public class LoginPage {
	private static final String URL_LOGIN = "https://www.saucedemo.com/";
	private WebDriver browser;
	private WebDriverUtil driver;

	public LoginPage() {
		driver = new WebDriverUtil();
		this.browser = this.driver.setUp();
		this.browser.navigate().to(URL_LOGIN);
	}

	public void quit() {
		this.driver.quit();
	}

	public ProductsPage login(String user, String password) {
		this.browser.findElement(By.id("user-name")).sendKeys(user);
		this.browser.findElement(By.id("password")).sendKeys(password);
		this.browser.findElement(By.id("login-button")).click();
		return new ProductsPage(browser);
	}

	public boolean isSecretPage() {
		return browser.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
	}
	
	public boolean isPasswordEmpty() {
		return browser.findElement(By.xpath("//h3[@data-test='error']")).getText().contains("Epic sadface: Password is required");
	}
	
	public boolean isInvalidUser() {
		return browser.findElement(By.xpath("//h3[@data-test='error']")).getText().contains("Epic sadface: Username and password do not match any user in this service");
	}
}

