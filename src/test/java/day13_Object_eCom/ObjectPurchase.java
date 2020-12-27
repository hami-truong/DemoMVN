package day13_Object_eCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ObjectPurchase {

	WebDriver driver;
	SoftAssert softass = new SoftAssert();
	
	//==========contructor=========
	public ObjectPurchase(WebDriver globalDriver) {
		driver = globalDriver;
	}
	
	//==========element============
	String xpathloginbtn = "//div[@class='login pull-left']/a[contains(text(),'login')]";
	String xpathEmail = "//div[@class='content']/input[@name='email']";
	String xpathPass = "//div[@class='content']/input[@name='password']";
	String xpathLoginbtn = "//input[@class='button']";
	String xpathFirstProduct ="//a[contains(text(),'SareeShop Embroidered Multi-Coloured Half And Half Geor..')]";
	String xpathAddCart = "//input[@id='button-cart']";
	String xpathItems = "//span[@id='cart-total']";
	String xpathViewCart = "//a[contains(text(),'View Cart')]";
	String xpathCheckout = "//div[@class='right']/a[contains(text(),'Checkout')]";
	String xpathContinueStep2 = "//input[@id='button-payment-address']";
	String xpathContinueStep3 = "//input[@id='button-shipping-address']";
	String xpathContinueStep4 = "//input[@id='button-shipping-method']";
	String xpathContinueStep5 = "//input[@id='button-payment-method']";
	String xpathCheckTermsConditions = "//input[@name='agree']";
	String xpathConfirmOrder = "//input[@id='button-confirm']";
	
	//==========method============
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
	
	public void selectFirstProduct() {
		driver.findElement(By.xpath(xpathFirstProduct)).click();
	}
	
	public void clickAddToCart() {
		driver.findElement(By.xpath(xpathAddCart)).click();
	}
	
	public void clickItemsCart() {
		driver.findElement(By.xpath(xpathItems)).click();
	}
	
	public void clickViewCart() {
		driver.findElement(By.xpath(xpathViewCart)).click();
	}
	
	public void clickCheckout() {
		driver.findElement(By.xpath(xpathCheckout)).click();
	}
	
	public void clickContinueStep2() {
		driver.findElement(By.xpath(xpathContinueStep2)).click();
	}
	
	public void clickContinueStep3() {
		driver.findElement(By.xpath(xpathContinueStep3)).click();
	}
	
	public void clickContinueStep4() {
		driver.findElement(By.xpath(xpathContinueStep4)).click();
	}
	
	public void clickAgreeTermsAndConditions() {
		driver.findElement(By.xpath(xpathCheckTermsConditions)).click();
	}
	
	public void clickContinueStep5() {
		driver.findElement(By.xpath(xpathContinueStep5)).click();
	}

	public void clickConfirmOrder(){
		driver.findElement(By.xpath(xpathConfirmOrder)).click();
	}
	
	public void verifyOrderProcess() {
		String title = driver.getTitle();
		System.out.println(title);
		softass.assertEquals(title, "Your Order Has Been Processed!");
	}
}
