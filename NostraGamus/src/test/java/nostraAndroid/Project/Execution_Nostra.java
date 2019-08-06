package nostraAndroid.Project;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


public class Execution_Nostra extends Repository_NostraPro {
	
	@BeforeTest
	public void launchApp_Nostra() throws Exception {
		launchApp();
		Thread.sleep(3000);
	}

	
	  @Test(priority = 1) public void login_Nostra() throws Exception {
	  loginTo_Nostra(); }
	 
	 
	@Test(priority = 2)
	public void startPlay() throws Exception {
		joinContets_Nostra();
	}
	@Test(priority = 3)
	public void join() throws Exception {
		joinConfig();
	}
	//Crash Handle
    private void hasAppCrashed() {
        By alertTitle = By.id("android:id/alertTitle"); // taking id which unique for alert to check app crash text
        Boolean crashTextAppeared = driver.findElements(alertTitle).size() > 0;
        if (crashTextAppeared) {
            if (driver.findElement(alertTitle).getAttribute("text").contains("has stopped")) {
                System.out.println("app crashed");
                logger.log(LogStatus.FAIL, "App crashed");
            }
        }
    }
}
