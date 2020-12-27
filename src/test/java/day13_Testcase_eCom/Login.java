package day13_Testcase_eCom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import day13_Object_eCom.ObjectLogin;
import day13_Object_eCom.ObjectRegister;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends Register{

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
/*		register = new Register();
		register.TC001_registerSuccess();
		System.out.println("aaaaaaa");
		objlogin.clickLoginbtn();
		objlogin.inputEmail("truonghami2201@gmail.com");
		objlogin.inputPass("truongha2201");
		objlogin.clickLogin();  */
		
		objRegister = new ObjectRegister(driver);
		objRegister.clickCreateAccount();
		objRegister.inputFirstname("Mi");
		objRegister.inputLastname("Truong");
		objRegister.inputEmail(mail);
		objRegister.inputTelephone("1234567890");
		objRegister.inputFax("2244");
		objRegister.inputCompany("ABC");
		objRegister.inputCompanyId("123");
		objRegister.inputAddress1("110 Cong Hoa Tan Binh");
		objRegister.inputAddress2("220 To Hien Thanh, Quan 10");
		objRegister.inputCity("HCM");
		objRegister.inputPostCode("110001");
		objRegister.selectCountry("Viet Nam");
		Thread.sleep(3000);
		objRegister.selectRegion("3780");
		objRegister.inputPass(pass);
		objRegister.inputPassConfirm("truonghami2201");
		objRegister.radioYes();
		objRegister.checkPolicy();
		objRegister.clickContinue();
		softass.assertEquals(driver.getTitle(), "Your Account Has Been Created!", "Register an account unsuccessfully");
		
		//------login successfully-------
		driver.get("https://www.ecomdeveloper.com/designs/demoshop/index.php?route=account/login");
		objlogin= new ObjectLogin(driver);
		objlogin.clickLoginbtn();
		objlogin.inputEmail(mail);
		objlogin.inputPass(pass);
		objlogin.clickLogin();
		System.out.println(driver.getTitle());
		softass.assertEquals(driver.getTitle(), "My Account");
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
