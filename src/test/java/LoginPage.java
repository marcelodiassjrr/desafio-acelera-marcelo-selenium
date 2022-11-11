import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginPage {
	private static final String URL_LOGIN = "https://www.saucedemo.com/";
	private WebDriver browser;

	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		this.browser = new ChromeDriver(options);
		this.browser.navigate().to(URL_LOGIN);
	}

	public void quit() {
		this.browser.quit();
	}

	public void login(String user, String password) {
		this.browser.findElement(By.id("user-name")).sendKeys(user);
		this.browser.findElement(By.id("password")).sendKeys(password);
		this.browser.findElement(By.id("login-button")).click();
	}

	public boolean isSecretPage() {
		return browser.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
	}
}
