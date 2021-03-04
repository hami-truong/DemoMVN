package day13_Testcase_eCom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import day13_Object_eCom.ObjectLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends Register{

	WebDriver driver;
	String url = "https://www.ecomdeveloper.com/designs/demoshop/index.php?route=common/home";
	ObjectLogin objLogin;

	@BeforeTest
	public void setUp() {
		System.out.println("Use Chrome driver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	//-----Let's an email field is empty------
	@Test
	public void TC001_loginUnSuccess() {
		driver.get(url);
		objLogin= new ObjectLogin(driver);
		objLogin.clickLoginbtn();
		objLogin.inputPass("truongha2201");
		objLogin.clickLogin();
		objLogin.verifyErrorEmptyEmail();
	}
	
	@Test
	public void TC002_loginSuccess() throws InterruptedException {
		
		objLogin= new ObjectLogin(driver);
		objLogin.clickLoginbtn();
		objLogin.inputEmail(mail);
		objLogin.inputPass(pass);
		objLogin.clickLogin();
		System.out.println(driver.getTitle());
		softass.assertEquals(driver.getTitle(), "My Account");
	}
	
}
