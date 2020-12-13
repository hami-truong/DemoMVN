package demo.DemoMVN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMVN {
	WebDriver driver;
	
	@Test
	public void demo() {
		
		WebDriverManager.chromedriver().setup(); //khai bao dung chrome: System.SetProperty()
		driver = new ChromeDriver();
		driver.get("https://google.com");

	}
}