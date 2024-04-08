package WebApp;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebApp extends WebCapabilities {
WebDriver driver;
		 @BeforeTest
		public void bt() throws MalformedURLException {
			driver=cap();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	@Test
	public void webDemo() {
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Masai");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0; i<links.size(); i++)
		{
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		}
//		 for (WebElement link : links) {
//	            System.out.println(link.getAttribute("href"));
//	        }
		
	}

}
