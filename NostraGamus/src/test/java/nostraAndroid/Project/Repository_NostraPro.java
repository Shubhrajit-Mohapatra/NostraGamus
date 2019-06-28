package nostraAndroid.Project;

import java.io.File;
import java.net.URL;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Repository_NostraPro {
	static AndroidDriver<MobileElement> driver;
	
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
    	
		driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
       
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}	
    public static void loginTo_Nostra() throws Exception
    {
    	driver.findElement(Locators_Nostra.Login).click();
    	
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	
    	driver.findElement(Locators_Nostra.UserId_Login).sendKeys(TestData_Nostra.UserId);
    	driver.findElement(Locators_Nostra.Pwd_Login).sendKeys(TestData_Nostra.Password);
    	
    	driver.findElement(Locators_Nostra.Login_BTN).click();
    }	
    
    public static void joinContets_Nostra() throws Exception {
    	
    	//swipeUP();
    	Thread.sleep(3000);
    	
    	swipeUP();
    	swipeUP();
    	swipeUP();
    	driver.findElement(Locators_Nostra.Match).click();
    	
    	
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	driver.findElement(Locators_Nostra.start_making_picks).click();
    	
    	//String activity = driver.currentActivity();
    	//System.out.println(activity);
    	
    	
    	Thread.sleep(3000);
    	
    	List<MobileElement> els1 = (List<MobileElement>) driver.findElementsByAccessibilityId("in.sportscafe.nostragamus.pro:id/prediction_audience_poll_layer_A_1");
    	List<MobileElement> els2 = (List<MobileElement>) driver.findElementsByAccessibilityId("in.sportscafe.nostragamus.pro:id/prediction_audience_poll_layer_A_1");
    	MobileElement el1 = (MobileElement) driver.findElementById("in.sportscafe.nostragamus.pro:id/prediction_audience_poll_layer_A_1");
		//el1.click();
    	 while(((List<MobileElement>) el1).size()>0) 
		 {
		      el1.click();
		 }
		  
		 
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static  void swipeUP()
   	{
   		Dimension up=driver.manage().window().getSize();
   		int startX=up.width/2;
   		int endX=up.width/2;
   		int startY=(int) (up.height*(0.4));
   		int endY=(int) (up.height*(0.1));
   		driver.swipe(startX, startY, endX, endY,500);
   	}
   	public static  void swipeDOWN()
   	{
   		Dimension down=driver.manage().window().getSize();
   		int startX=down.width/2;
   		int endX=down.width/2;
   		int startY=(int) (down.height*(0.5));
   		int endY=(int) (down.height*(0.2));
   		driver.swipe( endX, endY,startX, startY,500);
    }
   	public static void swipe_RL()
   	{
   		org.openqa.selenium.Dimension rl=driver.manage().window().getSize();
       	int startx = (int) (rl.width * (0.9));
   		int endx = (int)(rl.width*(0.2));
   		int starty =  rl.height /2 ;
   	    int endy = rl.height/2;
   	    driver.swipe(startx, starty, endx, endy,1000);
   	}
   	public static void swipe_LR()
   	{
   		org.openqa.selenium.Dimension lr=driver.manage().window().getSize();
       	int startx = (int) (lr.width * (0.9));
   		int endx = (int)(lr.width*(0.2));
   		int starty = lr.height /2 ;
   	    int endy = lr.height/2;
   	    
   	    //TouchAction action = new TouchAction(driver);
   	    //action.press(point(startx, starty)).waitAction().moveTo(point((endx - startx), (endy-starty))).release().perform();
   	    driver.swipe( endx, endy,startx, starty, 500);
   	}
	

}
