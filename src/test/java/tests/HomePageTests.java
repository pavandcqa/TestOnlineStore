package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import listeners.ListenerTestNg;

@Listeners(ListenerTestNg.class)
public class HomePageTests extends TestBase{
	
	@Test(priority = 1)
	public void verifyLogin()
	{
		Assert.assertTrue(hp.verifySignInLink(), "SignIn link not available..");
		hp.clickSignIn();
		
		String expectedSubheading = "Already registered?";
		String actualSubHeading = hp.getAlreadyRegisteredText();
		
		Assert.assertEquals(actualSubHeading, expectedSubheading, "Already Registered Section not present..");
		hp.setEmail(readConfig.getUserEmail());
		hp.setPassword(readConfig.getPassword());
		hp.clickSubmitLogIn();	
	}
	
	@Test(priority = 2)
	public void resetPassword()
	{
	
		Assert.assertTrue(hp.verifySignInLink(), "SignIn link not available..");
		hp.clickSignIn();
		
		Assert.assertTrue(hp.verifyForgottenPasswordLink(), "Forgottn Password link not present");
		hp.clickForgotPassword();
		
		String expectedTitle = "Forgot your password?";		
		
		
	}
	
}
