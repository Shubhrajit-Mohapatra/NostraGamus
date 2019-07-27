package nostraAndroid.Project;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


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
}
