package demo.DemoMVN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo_Action {
	WebDriver driver;
	
	//@Test
	public void demoSendKey() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
		
		//action sendkey
		WebElement inputSearch = driver.findElement(By.xpath("//input[@name='q']"));
		inputSearch.sendKeys("");
		
		Actions act = new Actions(driver);
		act.moveToElement(inputSearch)
		.click(inputSearch)
		.sendKeys("ac")
		.build()
		.perform();
	}
	
	@Test
	public void clickAndHold() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		WebElement from = driver.findElement(By.xpath("//li[contains(text(),'10')]"));
		WebElement to = driver.findElement(By.xpath("//li[contains(text(),'11')]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(from)
		.clickAndHold(from)
		.moveToElement(to)
		.release(to)
		.build()
		.perform();
	}
}