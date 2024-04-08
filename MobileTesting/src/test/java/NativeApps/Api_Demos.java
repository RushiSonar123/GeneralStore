package NativeApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Native_Apps.Capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//Some static imports for touch actions
import static io.appium.java_client.touch.TapOptions.tapOptions;
//Some static imports for long press
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//static imports for elements.
import static io.appium.java_client.touch.offset.ElementOption.element;
//static imports for time.
import static java.time.Duration.ofSeconds;
public class Api_Demos extends Capabilities {
	
AndroidDriver<AndroidElement> driver;
	
	
	@BeforeTest
	public  void bt() throws MalformedURLException {
		
		 driver = cap();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void abc() throws InterruptedException {
		
		System.out.println("Rushikesh emulator opened");
		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();
		driver.findElement(MobileBy.AccessibilityId("Accessibility Node Provider")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	@Test
	public void xyz()
	{
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Rushikesh");
		driver.findElement(MobileBy.id("android:id/button2")).click();	
	}
	
	@Test
	public void notification() throws InterruptedException
	{
		driver.openNotifications();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(3).click();
		Thread.sleep(2000);
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		
	}
	
	
	@Test
	public void view()
	{
System.out.println("API demo is Opened");
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		//If we want to scroll then we need three things
				//1. AndroidUIAutomator
				//2. UiScrollable
				//3. UiSelector
		        //4.scrollIntoView
				//If you want to scroll to a particular element then you have to use scrollIntoView.
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
	}
	
	@Test
	public void view2()
	{
		//If we want to check that the elements are present or not then we use clickable & to check it is clcikable we use
		//UiSelector method & AndroidUIAutomator
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		AndroidElement Click = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)"));
		
		//Click.getSize();
		System.out.println(Click.getSize());
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	
	@Test
	public void swipe()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		AndroidElement date = driver.findElement(MobileBy.AccessibilityId("12"));
		AndroidElement date1 = driver.findElement(MobileBy.AccessibilityId("5"));
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(date)).withDuration(ofSeconds(5))).moveTo(element(date1)).release().perform();
		
		
	}
	
	@Test
	public void dragAndDrop()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		AndroidElement drag = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_3"));
		AndroidElement drop = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(drag)).withDuration(ofSeconds(5))).moveTo(element(drop)).release().perform();
		
		
	}
	
	@Test
	public void longPress()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		AndroidElement press = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fish Names\")"));
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(press)).withDuration(ofSeconds(5))).release().perform();
		
	}
	
	
	@Test
	public void messages() throws InterruptedException
	{
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Hello Rushikesh");
		driver.findElement(MobileBy.AccessibilityId("Send")).click();
		driver.activateApp("com.google.android.apps.messaging");
		String text = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		
		System.out.println(text);
		driver.activateApp("io.appium.android.apis");
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		
	}
	
	}


