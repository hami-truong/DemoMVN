package day13_POM_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjectLogin {
	WebDriver driver;
	
	//------------------contructor----------------
	public ObjectLogin(WebDriver globalDriver) {
		driver = globalDriver;
	}
	
	//------------------element-------------------
	String xpathUserName = "//input[@name='uid']";
	String xpathPass = "//input[@name='password']";
	String btnLogin = "//input[@name='btnLogin']";
	String btnReset = "//input[@name='btnReset']";
	String lnkHere = "//a[contains(text(),'here')]";
	
	//------------------method-------------------
	public void inputUserId(String username) {
		driver.findElement(By.xpath(xpathUserName)).sendKeys(username);
	}
	
	public void inputPass(String passwd) {
		driver.findElement(By.xpath(xpathPass)).sendKeys(passwd);
	}
	
	public void clickLogin() {
		driver.findElement(By.xpath(btnLogin)).click();
	}
	
	public void clickHere() {
		driver.findElement(By.xpath(lnkHere)).click();
	}
}
