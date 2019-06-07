package nostraAndroid.Project;

import org.openqa.selenium.By;

public class Locators_Nostra {
	
	public static By Google_Login = By.id(TestData_Nostra.Package+":id/login_google_button");
	public static By Login = By.id(TestData_Nostra.Package+":id/login_signIn_button");
	public static By SignUp_PhNo = By.id(TestData_Nostra.Package+":id/login_Signup_button");
	
	//Login Screen
	public static By UserId_Login = By.id(TestData_Nostra.Package+":id/signin_phone_editText");
	public static By Pwd_Login = By.id(TestData_Nostra.Package+":id/signin_pass_editText");
	public static By Login_BTN = By.id(TestData_Nostra.Package+":id/signin_button");
	
	//Home,My contets,Quest,Activity,Profile
	public static By Home_BTN = By.id(TestData_Nostra.Package+":id/home_challenges_tab_layout");
	public static By MyContest_BTN = By.id(TestData_Nostra.Package+":id/home_inPlay_tab_layout");
	public static By Quest_BTN = By.id(TestData_Nostra.Package+":id/home_quest_tab_button");
	public static By Activity_BTN = By.id(TestData_Nostra.Package+":id/home_recent_activity_tab_layout");
	public static By Profile_BTN = By.id(TestData_Nostra.Package+":id/home_profile_tab_layout");

    public static By Match = By.xpath("(//*[@class='android.widget.LinearLayout'])[16]");
    
    
    //Strat Picks
    public static By start_making_picks = By.id(TestData_Nostra.Package+":id/new_challenge_matches_join_button");
    
    //Predict Your Answers
    public static By Select_Answer = By.id("in.sportscafe.nostragamus.pro:id/prediction_option_textView_A_1");
    




}

