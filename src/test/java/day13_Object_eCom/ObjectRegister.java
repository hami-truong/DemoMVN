package day13_Object_eCom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class ObjectRegister {

	WebDriver driver;
	SoftAssert softass = new SoftAssert();
	
	//=============contructor-================
	public ObjectRegister(WebDriver driver) {
		//driver = globalDriver;
        this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	//====================element====================
	//-------------Create an account-----------
	/*String xpathCreateAccount = "//div[@class='login pull-left']/a[contains(text(),'create an account')]";*/
	@FindBy(xpath = "//div[@class='login pull-left']/a[contains(text(),'create an account')]")
	private WebElement xpathCreateAccount;
	
	//------------Your Personal Details-----------
	//String xpathFirstName = "//input[@name='firstname']";
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement xpathFirstName;
	
	//String xpathLastName = "//input[@name='lastname']";	
	@FindBy(xpath = "//td/input[@name='email']")
	private WebElement xpathLastName;
	
	//String xpathEmail = "//td/input[@name='email']";
	@FindBy(xpath = "//td/input[@name='email']")
	private WebElement xpathEmail;
	
	//String xpathTelephone = "//td/input[@name='telephone']";
	@FindBy(xpath = "//td/input[@name='telephone']")
	private WebElement xpathTelephone;
	
	//String xpathFax = "//td/input[@name='fax']";
	@FindBy(xpath = "//td/input[@name='fax']")
	private WebElement xpathFax;
	
	//------------Your Address-------------
	//String xpathCompany = "//input[@name='company']";
	@FindBy(xpath = "//input[@name='company']")
	private WebElement xpathCompany;
	
	//String xpathCompanyId = "//input[@name='company_id']";
	@FindBy(xpath = "//input[@name='company_id']")
	private WebElement xpathCompanyId;
	
	//String xpathAddress1 = "//input[@name='address_1']";
	@FindBy(xpath = "//input[@name='address_1']")
	private WebElement xpathAddress1;
	
	//String xpathAddress2 = "//input[@name='address_2']";
	@FindBy(xpath = "//input[@name='address_2']")
	private WebElement xpathAddress2;
	
	//String xpathCity = "//input[@name='city']";
	@FindBy(xpath = "//input[@name='city']")
	private WebElement xpathCity;
	
	//String xpathPostCode = "//input[@name='postcode']";
	@FindBy(xpath = "//input[@name='postcode']")
	private WebElement xpathPostCode;
	
	//String xpathCountry = "//select[@name='country_id']";
	@FindBy(xpath = "//select[@name='country_id']")
	private WebElement xpathCountry;
	
	//String xpathRegion = "//select[@name='zone_id']";
	@FindBy(xpath = "//select[@name='zone_id']")
	private WebElement xpathRegion;
	
	
	//-------------Your Password------------
	//String xpathPassword = "//input[@name='password']";
	@FindBy(xpath = "//input[@name='password']")
	private WebElement xpathPassword;
	
	//String xpathPasswordConfirm = "//input[@name='confirm']";
	@FindBy(xpath = "//input[@name='confirm']")
	private WebElement xpathPasswordConfirm;
	
	
	//------------Newsletter----------
	//String xpathYes = "//td[contains(text(),'Subscribe:')]/following-sibling::td/input[@value='1']";
	@FindBy(xpath = "//td[contains(text(),'Subscribe:')]/following-sibling::td/input[@value='1']")
	private WebElement xpathYes;
	
	//String xpathNo = "//td[contains(text(),'Subscribe:')]/following-sibling::td/input[@value='0']";
	@FindBy(xpath = "//td[contains(text(),'Subscribe:')]/following-sibling::td/input[@value='0']")
	private WebElement xpathNo;
	
	//String xpathCheckBox = "//input[@name='agree']";
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement xpathCheckBox;
	
	//String xpathContinuebtn = "//input[@class='button']";
	@FindBy(xpath = "//input[@class='button']")
	private WebElement xpathContinuebtn;
	
	
	//--------------Error Firstname------------
	//String xpathErrorFirstname = "//span[contains(text(),'First Name must be between 1 and 32 characters!')]";
	@FindBy(xpath = "//span[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement xpathErrorFirstname;
	
	
	//-------------Logout--------
	//String xpathLogout = "//a[contains(text(),'Logout')]";
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement xpathLogout;
	
	
	//=================method==================
	//------------login---------
	public void openLogin(String url) {
		driver.get(url);
	}
	//-------------Create an account----------
	public void clickCreateAccount() {
		xpathCreateAccount.click();
	}
	//----------Your Personal Details-------
	public void inputFirstname(String firstname) {
		xpathFirstName.sendKeys(firstname);
	}
	
	public void inputLastname(String lastname) {
		xpathLastName.sendKeys(lastname);
	}
	
	public void inputEmail(String email) {
		xpathEmail.sendKeys(email);
	}
	
	public void inputTelephone(String telephone) {
		xpathTelephone.sendKeys(telephone);
	}
	
	public void inputFax(String fax) {
		xpathFax.sendKeys(fax);
	}
	
	//----------Your Address-----
	public void inputCompany(String company) {
		xpathCompany.sendKeys(company);
	}
	
	public void inputCompanyId(String company_id) {
		xpathCompanyId.sendKeys(company_id);
	}
	
	
	public void inputAddress1(String address1) {
		xpathAddress1.sendKeys(address1);
	}
	
	public void inputAddress2(String address2) {
		xpathAddress2.sendKeys(address2);
	}
	
	
	public void inputPostCode(String postcode) {
		xpathPostCode.sendKeys(postcode);
	}
	
	public void inputCity(String city) {
		xpathCity.sendKeys(city);
	}
	
	public void selectCountry(String country) {
		WebElement selectCountry = xpathCountry;
		Select sl = new Select(selectCountry);
		sl.selectByVisibleText(country);
	}
	
	public void selectRegion(String region) {
		WebElement selectRegion =xpathRegion;
		Select sl = new Select(selectRegion);
		sl.selectByValue(region);
	}
	
	//-------------------Your Password-----------------
	public void inputPass(String pass) {
		xpathPassword.sendKeys(pass);
	}
	
	public void inputPassConfirm(String passConfirm) {
		xpathPasswordConfirm.sendKeys(passConfirm);
	}
	
	//-----------------Newsletter-------------
	public void radioYes() {
		xpathYes.click();
	}
	
	public void checkPolicy() {
		xpathCheckBox.click();
	}
	
	public void clickContinue() {
		xpathContinuebtn.click();
	}
	
	//----------------Error Firstname------------
	public void verifyErrorFirstname() {
		String errorfirstname = xpathErrorFirstname.getText();
		System.out.println(errorfirstname);
		softass.assertEquals(errorfirstname, "First Name must be between 1 and 32 characters!");
		softass.assertEquals(driver.getTitle(), "Register Account");
	}
	
	//---------------Logout----------
	public void logout() {
		xpathLogout.click();
	}

}