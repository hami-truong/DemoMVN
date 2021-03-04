package day13_Testcase_eCom;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
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
	
	//data
	String Firstname = "Mi";
	String Lastname = "Truong";
	String Email = mail;
	String Telephone = "1234567890";
	String Fax = "2244";
	String Company = "ABC";
	String CompanyId = "123";
	String Address1 = "110 Cong Hoa Tan Binh";
	String Address2 = "220 To Hien Thanh, Quan 10";
	String City = "HCM";
	String PostCode = "110001";
	String Country = "Viet Nam";
	String Region = "3780";
	String PassConfirm = "truonghami2201";
	
	@BeforeTest
	public void setUp() {
		System.out.println("Use Chrome driver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();	

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	//----------register success + login success
	@Test
	public void TC001_registerSuccess() throws InterruptedException {
		
		driver.navigate().refresh();
		objRegister = new ObjectRegister(driver);
		objRegister.openLogin(url);

		objRegister.clickCreateAccount();
		objRegister.inputFirstname(Firstname);
		objRegister.inputLastname(Lastname);
		objRegister.inputEmail(mail);
		objRegister.inputTelephone(Telephone);
		objRegister.inputFax(Fax);
		objRegister.inputCompany(Company);
		objRegister.inputCompanyId(CompanyId);
		objRegister.inputAddress1(Address1);
		objRegister.inputAddress2(Address2);
		objRegister.inputCity(City);
		objRegister.inputPostCode(PostCode);
		objRegister.selectCountry(Country);
		Thread.sleep(3000);
		objRegister.selectRegion(Region);
		objRegister.inputPass(pass);
		objRegister.inputPassConfirm(PassConfirm);
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
	
	@Test
	public void TC002_registerUnSuccess() {
		objRegister = new ObjectRegister(driver);
		objRegister.openLogin(url);

		objRegister.logout();
		objRegister.clickCreateAccount();
		objRegister.clickContinue();
		objRegister.verifyErrorFirstname();
	}
	

}
