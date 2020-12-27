package day13_Testcase_eCom;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import day13_Object_eCom.ObjectLogin;
import day13_Object_eCom.ObjectRegister;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {
	WebDriver driver;
	String url = "https://www.ecomdeveloper.com/designs/demoshop/index.php?route=common/home";
	ObjectRegister objRegister;
	Random random = new Random();
	int x = random.nextInt(6) + 5;
	String mail = "truonghami" + x + "@gmail.com";
	String pass = "truonghami2201";
	SoftAssert softass = new SoftAssert();
	
	ObjectLogin objlogin;
	
	@BeforeTest
	public void setUp() {
		System.out.println("Use Chrome driver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	//----------register success + login success
	@Test
	public void TC001_registerSuccess() throws InterruptedException {
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
	
	//@Test
	public void TC002_registerUnSuccess() {
		objRegister = new ObjectRegister(driver);
		objRegister.clickCreateAccount();
		objRegister.clickContinue();
		objRegister.verifyErrorFirstname();
	}
}
