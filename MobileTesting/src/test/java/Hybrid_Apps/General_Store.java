package Hybrid_Apps;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class General_Store extends HybridCapabilities {
	
AndroidDriver<AndroidElement> driver;
	
	
	@BeforeTest
	public  void bt() throws MalformedURLException {
		
		 driver = cap();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void login()
	{
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Angola\")")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("RUshikesh");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
		driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
	
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
	 String price = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println(price);
		
		
		
		
		
	}
	
	@Test
	public void price()
	{
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Angola\")")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rushikesh");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
		driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		String price1 =driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$160.97\")")).getText();
		String price2 =driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$120.0\")")).getText();
		String price = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println(price1);
		System.out.println(price2);
		System.out.println(price);
		
		String prod1 = price1.substring(1); //160.97
		System.out.println(prod1);
		String prod2 = price2.substring(1); //120.0
		System.out.println(prod2);
		String totalprice = price.substring(2); //280.97
		System.out.println(totalprice);
		
		Double p1 = Double.parseDouble(prod1);
		System.out.println(p1);
		
		Double p2 = Double.parseDouble(prod2);
		System.out.println(p2);
		
		Double total = Double.parseDouble(totalprice);
		System.out.println(total);
		
		Double TotalPrice = p1+p2;
		System.out.println(TotalPrice);
		
		if(TotalPrice.equals(total))
		{
			System.out.println("Cost Matching");
		}
		else
		{
			System.out.println("Cost not Matching");
		}
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		
	}

}
