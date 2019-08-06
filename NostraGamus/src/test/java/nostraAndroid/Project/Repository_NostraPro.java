package nostraAndroid.Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class Repository_NostraPro {
	static AndroidDriver<MobileElement> driver;
	ExtentTest logger;
    public void launchApp() throws Exception  
    {
    	
    	
    	 File classpathRoot = new File(System.getProperty("user.dir"));
    	 File appDir = new File(classpathRoot, "App");
    	 File app = new File(appDir, "NostraStage.apk");   
    	 
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
    	 
    	 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
    	 capabilities.setCapability(CapabilityType.VERSION, "8.0.0");
    	 capabilities.setCapability("platformName", "Android");
    	 capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
         capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
    	 capabilities.setCapability("app", app.getAbsolutePath());
    	 //capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, EntryPoint_Locators.Package);
 		 //capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,EntryPoint_Locators.Package+".Activity.SplashScreenActivity");
    	try {
		driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
			System.out.println("Make sure appium server is up and running");
			System.exit(0);
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}	
    public static void loginTo_Nostra() throws Exception
    {
    	Thread.sleep(10000);
    	driver.findElement(Locators_Nostra.Login).click();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	driver.findElement(Locators_Nostra.UserId_Login).sendKeys(TestData_Nostra.UserId);
    	driver.findElement(Locators_Nostra.Pwd_Login).sendKeys(TestData_Nostra.Password);
    	driver.findElement(Locators_Nostra.Login_BTN).click();
    }	
    
    public void joinContets_Nostra() throws Exception {
    	
    	//scrollUp();
    	Thread.sleep(10000);   	
    	driver.findElement(Locators_Nostra.Match).click();    	
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	driver.findElement(Locators_Nostra.start_making_picks).click();    	
    	//String activity = driver.currentActivity();
    	//System.out.println(activity);    	
    	Thread.sleep(2000);
		TouchAction action1 = new TouchAction(driver);
		int xp= 367;
		int yp= 738;
     	action1.press(PointOption.point(xp,yp)).release().perform();
    	//(367,738)    	 
    	while(driver.findElements(By.id("in.sportscafe.nostragamus.pro:id/prediction_question_card_points_layout")).size()>0)  
		 {
    		Thread.sleep(2000);
    		TouchAction action = new TouchAction(driver);
         	action.press(PointOption.point(xp,yp)).release().perform();        	
		 }
    }
    
    public static void joinConfig() throws Exception
    {
    	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(Locators_Nostra.Join_a_contest_to_win_prizes).click();
    	   if(driver.findElements(Locators_Nostra.Cancel_Tooltip).size()>0) {
    	      driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	      driver.findElement(Locators_Nostra.Cancel_Tooltip).click();
    	   }else{
    		System.out.println("Tooltip doesn't apear");
     	   }
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(Locators_Nostra.Join_Con).click();
    	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	//driver.findElement(Locators_Nostra.Use_Pickset).click();
    	Thread.sleep(4000);
    	TouchAction action = new TouchAction(driver);
		int x1= 633;
		int y1= 479;
     	action.press(PointOption.point(x1,y1)).release().perform();    	    	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(Locators_Nostra.Pay_Join).click();
    }
    
    
    
    
 	public void scrollDownByElementLocation(MobileElement element) {   // scrolls by element coordinates
// 		System.out.println("scrolling by element location");
 		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		int startY=(int)(x*0.90);
 		int endY=(int)(y*0.20);
		new TouchAction(driver).press(PointOption.point(x, startY)).waitAction().moveTo(PointOption.point(x, endY)).release().perform();	

	}
 	
	
 	public void scrollDown() {  // scroll down by window coordinates
// 		System.out.println("scroll down by window");
 		Dimension dim=driver.manage().window().getSize();
		int height=dim.getHeight();
		int width=dim.getWidth();
		int x=width/2;
		int startY=(int)(height*0.80);
		int endY=(int)(height*0.50);
		new TouchAction(driver).press(PointOption.point(x, startY)).waitAction().moveTo(PointOption.point(x, endY)).release().perform();	

 	}
 	
 	public void scrollDownFast() { // scroll down by window coordinates
// 		System.out.println("scroll down by window");
 		Dimension dim=driver.manage().window().getSize();
		int height=dim.getHeight();
		int width=dim.getWidth();
		int x=width/2;
		int startY=(int)(height*0.80);
		int endY=(int)(height*0.20);
		new TouchAction(driver).press(PointOption.point(x, startY)).waitAction().moveTo(PointOption.point(x, endY)).release().perform();	

 	}
 	
 	
 	public void scrollUp() { // scroll up by window coordinates
		Dimension dim=driver.manage().window().getSize();
 		int height=dim.getHeight();
 		int width=dim.getWidth();
 		int x=width/2;
 		int startY=(int)(height*0.40);
 		int endY=(int)(height*0.80);
		new TouchAction(driver).press(PointOption.point(x, startY)).waitAction().moveTo(PointOption.point(x, endY)).release().perform();	
 
		
	}
 	
 	public static void printLine() {
		System.out.println("-------------------------------------");
	}
	public static String capture(AppiumDriver driver, String screenshotName) throws IOException { //to capture screenshot
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/screenshots/"+screenshotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
		
	}

	public static String fileName() { // generating file with current time
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY_hh:mm:ss");
		Date date= new Date();
		String file_name = sdf.format(date);		
		return file_name;
		
	}
	
	public static ArrayList<String> readDataFromFile(String path) throws FileNotFoundException {
		File file = new File(path);
		ArrayList<String> values = new ArrayList<String>();
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
			values.add(sc.nextLine());
		}
		return values;
	}
}
