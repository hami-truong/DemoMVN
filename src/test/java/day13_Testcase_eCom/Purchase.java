package day13_Testcase_eCom;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import day13_Object_eCom.ObjectPurchase;
import day13_Object_eCom.ObjectRegister;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Purchase {

	WebDriver driver;

	String url = "https://www.ecomdeveloper.com/designs/demoshop/index.php?route=common/home";
	SoftAssert softass = new SoftAssert();
	ObjectPurchase objPurchase;
	ObjectRegister objRegister;
	Random ran = new Random();
	int x = ran.nextInt(6) + 5;
	String mail = "truonghami" + x + "@gmail.com";
	String pass = "truonghami2201";
	
	@BeforeTest
	public void setUp() {
		System.out.println("Use Chrome driver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void TC001_purchaseSuccess() throws InterruptedException {
		
		//----------register an account---------
		objRegister = new ObjectRegister(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
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
		//Thread.sleep(3000);
		objRegister.selectRegion("3780");
		objRegister.inputPass(pass);
		objRegister.inputPassConfirm(pass);
		objRegister.radioYes();
		objRegister.checkPolicy();
		objRegister.clickContinue();
		softass.assertEquals(driver.getTitle(), "Your Account Has Been Created!", "Register an account unsuccessfully");
		
		//------login successfully-------
		driver.get("https://www.ecomdeveloper.com/designs/demoshop/index.php?route=account/login");		
		objPurchase= new ObjectPurchase(driver);
		objPurchase.clickLoginbtn();
		objPurchase.inputEmail(mail);
		objPurchase.inputPass(pass);
		objPurchase.clickLogin();
		//Thread.sleep(1000);
		
		//---------purchase----------
		driver.get("https://www.ecomdeveloper.com/designs/demoshop/index.php?route=common/home");
		//	Thread.sleep(3000);
		objPurchase.selectFirstProduct();
		objPurchase.clickAddToCart();
		//	Thread.sleep(3000);
		objPurchase.clickItemsCart();
		//	Thread.sleep(3000);
		objPurchase.clickViewCart();
		objPurchase.clickCheckout();
		//	Thread.sleep(3000);
		objPurchase.clickContinueStep2();
		//	Thread.sleep(3000);
		objPurchase.clickContinueStep3();
		//	Thread.sleep(3000);
		objPurchase.clickContinueStep4();
		Thread.sleep(3000);
		objPurchase.clickAgreeTermsAndConditions();
		Thread.sleep(3000);
		objPurchase.clickContinueStep5();
		Thread.sleep(3000);
		objPurchase.clickConfirmOrder();
		objPurchase.verifyOrderProcess();
		
	}
}
