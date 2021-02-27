package day13_Object_eCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class ObjectRegister {

	WebDriver driver;
	SoftAssert softass = new SoftAssert();
	
	//=============contructor-================
	public ObjectRegister(WebDriver globalDriver) {
		driver = globalDriver;
	}
	
	//====================element====================
	//-------------Create an account-----------
	String xpathCreateAccount = "//div[@class='login pull-left']/a[contains(text(),'create an account')]";
	//------------Your Personal Details-----------
	String xpathFirstName = "//input[@name='firstname']";
	String xpathLastName = "//input[@name='lastname']";
	String xpathEmail = "//td/input[@name='email']";
	String xpathTelephone = "//td/input[@name='telephone']";
	String xpathFax = "//td/input[@name='fax']";
	
	//------------Your Address-------------
	String xpathCompany = "//input[@name='company']";
	String xpathCompanyId = "//input[@name='company_id']";
	String xpathAddress1 = "//input[@name='address_1']";
	String xpathAddress2 = "//input[@name='address_2']";
	String xpathCity = "//input[@name='city']";
	String xpathPostCode = "//input[@name='postcode']";
	String xpathCountry = "//select[@name='country_id']";
	String xpathRegion = "//select[@name='zone_id']";
	
	//-------------Your Password------------
	String xpathPassword = "//input[@name='password']";
	String xpathPasswordConfirm = "//input[@name='confirm']";
	
	//------------Newsletter----------
	String xpathYes = "//td[contains(text(),'Subscribe:')]/following-sibling::td/input[@value='1']";
	String xpathNo = "//td[contains(text(),'Subscribe:')]/following-sibling::td/input[@value='0']";
	String xpathCheckBox = "//input[@name='agree']";
	String xpathContinuebtn = "//input[@class='button']";
	
	//--------------Error Firstname------------
	String xpathErrorFirstname = "//span[contains(text(),'First Name must be between 1 and 32 characters!')]";
	
	//-------------Logout--------
	String xpathLogout = "//a[contains(text(),'Logout')]";
	
	//=================method==================
	//-------------Create an account----------
	public void clickCreateAccount() {
		driver.findElement(By.xpath(xpathCreateAccount)).click();
	}
	//----------Your Personal Details-------
	public void inputFirstname(String firstname) {
		driver.findElement(By.xpath(xpathFirstName)).sendKeys(firstname);
	}
	
	public void inputLastname(String lastname) {
		driver.findElement(By.xpath(xpathLastName)).sendKeys(lastname);
	}
	
	public void inputEmail(String email) {
		driver.findElement(By.xpath(xpathEmail)).sendKeys(email);
	}
	
	public void inputTelephone(String telephone) {
		driver.findElement(By.xpath(xpathTelephone)).sendKeys(telephone);
	}
	
	public void inputFax(String fax) {
		driver.findElement(By.xpath(xpathFax)).sendKeys(fax);
	}
	
	//----------Your Address-----
	public void inputCompany(String company) {
		driver.findElement(By.xpath(xpathCompany)).sendKeys(company);
	}
	
	public void inputCompanyId(String company_id) {
		driver.findElement(By.xpath(xpathCompanyId)).sendKeys(company_id);
	}
	
	
	public void inputAddress1(String address1) {
		driver.findElement(By.xpath(xpathAddress1)).sendKeys(address1);
	}
	
	public void inputAddress2(String address2) {
		driver.findElement(By.xpath(xpathAddress2)).sendKeys(address2);
	}
	
	
	public void inputPostCode(String postcode) {
		driver.findElement(By.xpath(xpathPostCode)).sendKeys(postcode);
	}
	
	public void inputCity(String city) {
		driver.findElement(By.xpath(xpathCity)).sendKeys(city);
	}
	
	public void selectCountry(String country) {
		WebElement selectCountry = driver.findElement(By.xpath(xpathCountry));
		Select sl = new Select(selectCountry);
		sl.selectByVisibleText(country);
	}
	
	public void selectRegion(String region) {
		WebElement selectRegion = driver.findElement(By.xpath(xpathRegion));
		Select sl = new Select(selectRegion);
		sl.selectByValue(region);
	}
	
	//-------------------Your Password-----------------
	public void inputPass(String pass) {
		driver.findElement(By.xpath(xpathPassword)).sendKeys(pass);
	}
	
	public void inputPassConfirm(String passConfirm) {
		driver.findElement(By.xpath(xpathPasswordConfirm)).sendKeys(passConfirm);
	}
	
	//-----------------Newsletter-------------
	public void radioYes() {
		driver.findElement(By.xpath(xpathYes)).click();
	}
	
	public void checkPolicy() {
		driver.findElement(By.xpath(xpathCheckBox)).click();
	}
	
	public void clickContinue() {
		driver.findElement(By.xpath(xpathContinuebtn)).click();
	}
	
	//----------------Error Firstname------------
	public void verifyErrorFirstname() {
		String errorfirstname = driver.findElement(By.xpath(xpathErrorFirstname)).getText();
		System.out.println(errorfirstname);
		softass.assertEquals(errorfirstname, "First Name must be between 1 and 32 characters!");
		softass.assertEquals(driver.getTitle(), "Register Account");
	}
	
	//---------------Logout----------
	public void logout() {
		driver.findElement(By.xpath(xpathLogout)).click();
	}

}