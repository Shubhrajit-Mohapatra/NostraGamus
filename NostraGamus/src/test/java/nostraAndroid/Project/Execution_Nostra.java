package nostraAndroid.Project;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Execution_Nostra extends Repository_NostraPro {
	
	@BeforeTest
	public void launchApp_Nostra() throws Exception {
		launchApp();
	}
	@Test
	public void login_Nostra() throws Exception {
		loginTo_Nostra();
	}
	@Test
	public void startPlay() {
		joinContets_Nostra();
	}
}
