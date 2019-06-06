package nostraAndroid.Project;

import org.openqa.selenium.By;

public class Locators_Nostra {
	public static By Google_Login = By.id("in.sportscafe.nostragamus.pro:id/login_google_button");
	public static By Login = By.id("in.sportscafe.nostragamus.pro:id/login_signIn_button");
	public static By SignUp_PhNo = By.id("in.sportscafe.nostragamus.pro:id/login_Signup_button");
	
	//Login Screen
	public static By UserId_Login = By.id("in.sportscafe.nostragamus.pro:id/signin_phone_editText");
	public static By Pwd_Login = By.id("in.sportscafe.nostragamus.pro:id/signin_pass_editText");
	public static By Login_BTN = By.id("in.sportscafe.nostragamus.pro:id/signin_button");
	
	//Home,My contets,Quest,Activity,Profile
	public static By Home_BTN = By.id("in.sportscafe.nostragamus.pro:id/home_challenges_tab_layout");
	public static By MyContest_BTN = By.id("in.sportscafe.nostragamus.pro:id/home_inPlay_tab_layout");
	public static By Quest_BTN = By.id("in.sportscafe.nostragamus.pro:id/home_quest_tab_button");
	public static By Activity_BTN = By.id("in.sportscafe.nostragamus.pro:id/home_recent_activity_tab_layout");
	public static By Profile_BTN = By.id("in.sportscafe.nostragamus.pro:id/home_profile_tab_layout");

    public static By Match = By.xpath("(//*[@class='android.widget.LinearLayout'])[3]");
}
