package day13_Testcase_eCom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import day13_Object_eCom.ObjectLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login{

	WebDriver driver;
	String url = "https://www.ecomdeveloper.com/designs/demoshop/index.php?route=common/home";
	ObjectLogin objlogin;
	Register register;
	SoftAssert softass = new SoftAssert();

	@BeforeTest
	public void setUp() {
		System.out.println("Use Chrome driver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	@Test
	public void TC001_loginSuccess() throws InterruptedException {
		objlogin= new ObjectLogin(driver);
		register = new Register();
		register.TC001_registerSuccess();
		/*objlogin.clickLoginbtn();
		objlogin.inputEmail("truonghami2201@gmail.com");
		objlogin.inputPass("truongha2201");
		objlogin.clickLogin();*/
	}
	
	//-----Let's an email field is empty------
	//@Test
	public void TC002_loginUnSuccess() {
		objlogin= new ObjectLogin(driver);
		objlogin.clickLoginbtn();
		objlogin.inputPass("truongha2201");
		objlogin.clickLogin();
		objlogin.verifyErrorEmptyEmail();
	}
}
