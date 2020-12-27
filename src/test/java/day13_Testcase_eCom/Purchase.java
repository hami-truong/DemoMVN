package day13_Testcase_eCom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	
	@BeforeTest
	public void setUp() {
		System.out.println("Use Chrome driver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	@Test
	public void TC001_purchaseSuccess() throws InterruptedException {
		
		//----------register an account---------
		objRegister = new ObjectRegister(driver);
		objRegister.clickCreateAccount();
		objRegister.inputFirstname("Mi");
		objRegister.inputLastname("Truong");
		objRegister.inputEmail("truonghami2201@gmail.com");
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
		objRegister.inputPass("truonghami2201");
		objRegister.inputPassConfirm("truonghami2201");
		objRegister.radioYes();
		objRegister.checkPolicy();
		objRegister.clickContinue();
		softass.assertEquals(driver.getTitle(), "Your Account Has Been Created!", "Register an account unsuccessfully");
		
		//------login successfully-------
		driver.get("https://www.ecomdeveloper.com/designs/demoshop/index.php?route=account/login");
		
		objPurchase= new ObjectPurchase(driver);
		objPurchase.clickLoginbtn();
		objPurchase.inputEmail("truonghami2201@gmail.com");
		objPurchase.inputPass("truongha2201");
		objPurchase.clickLogin();
		
		//---------purchase----------
		driver.get("https://www.ecomdeveloper.com/designs/demoshop/index.php?route=common/home");
		objPurchase.selectFirstProduct();
		objPurchase.clickAddToCart();
		objPurchase.clickItemsCart();
		Thread.sleep(3000);
		objPurchase.clickCheckout();
		objPurchase.clickContinueStep2();
		objPurchase.clickContinueStep3();
		objPurchase.clickContinueStep4();
		objPurchase.clickAgreeTermsAndConditions();
		objPurchase.clickContinueStep5();
		objPurchase.clickConfirmOrder();
		objPurchase.verifyOrderProcess();
		
	}
}
