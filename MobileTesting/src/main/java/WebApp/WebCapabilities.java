package WebApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebCapabilities {

	
public static AndroidDriver<AndroidElement> cap() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi K20_Pro");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C://Users//CTSS//OneDrive//Documents//Selenium Grid//chromedriver.exe");
		
	
	dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c",false));
		
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		return driver;
}
}
