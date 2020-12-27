package day13_POM_Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flow01_Login {

	WebDriver driver;
	String url = "http://demo.guru99.com/v4/";
	ObjectLogin objLogin;
	
	@BeforeTest
	public void setUp() {
		System.out.println("Use Chrome driver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	@Test
	public void TC001_loginvalid() {
		objLogin = new ObjectLogin(driver);
		objLogin.inputUserId("abcd");
		objLogin.inputPass("1234567890");
		objLogin.clickLogin();
	}
	
}