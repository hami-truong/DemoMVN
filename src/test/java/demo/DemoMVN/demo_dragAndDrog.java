package demo.DemoMVN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo_dragAndDrog {
	WebDriver driver;
	
	@Test
	public void demo() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step 1. Go to the demo page");
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		Thread.sleep(5000);
		
		System.out.println("Step 2. Drap item Draggable 1 to \'Drop here\'");
		WebElement spanDrag1 = driver.findElement(By.xpath("//span[contains(text(),'Draggable 1')]"));
		WebElement dropHere = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(spanDrag1)
		.clickAndHold(spanDrag1)
		.moveToElement(dropHere)
		.release(dropHere)
		.build()
		.perform();
		
		System.out.println("Step 3. Verify drap and drop success");
		
	}
}