package day13_Object_eCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ObjectLogin {
	WebDriver driver;
	SoftAssert softass = new SoftAssert();
	
	//========contructor=======
	public ObjectLogin(WebDriver globalDriver){
		driver = globalDriver;
	} 
	
	//============element==========
	//---------------Login--------------------
	String xpathloginbtn = "//div[@class='login pull-left']/a[contains(text(),'login')]";
	String xpathEmail = "//div[@class='content']/input[@name='email']";
	String xpathPass = "//div[@class='content']/input[@name='password']";
	String xpathLoginbtn = "//input[@class='button']";
	String xpathDisplayErrorEmail = "//div[contains(text(),'Warning: No match for E-Mail Address and/or Passwo')]";
	
	//============method===========
	//-------------------Login---------------
	public void clickLoginbtn() {
		driver.findElement(By.xpath(xpathloginbtn)).click();
	}
	
	public void inputEmail(String email) {
		driver.findElement(By.xpath(xpathEmail)).sendKeys(email);
	}
	
	public void inputPass(String pass) {
		driver.findElement(By.xpath(xpathPass)).sendKeys(pass);
	}
	
	public void clickLogin() {
		driver.findElement(By.xpath(xpathLoginbtn)).click();
	}
	
	//------------Login with an empty email-------------
	public void verifyErrorEmptyEmail() {
		String error = driver.findElement(By.xpath(xpathDisplayErrorEmail)).getText();
		System.out.println(error);
		softass.assertEquals(error, "Warning: No match for E-Mail Address and/or Password.");
	}
}
