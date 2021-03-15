package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import listeners.ListenerTestNg;

@Listeners(ListenerTestNg.class)
public class RegistrationTests extends TestBase{
	
	@Test
	public void verifyRegistration()
	{
		Assert.assertTrue(hp.verifySignInLink(), "SignIn link not available..");
		hp.clickSignIn();
		
		String expectedTitle = "CREATE AN ACCOUNT";
		String actualTitle = hp.getCreateAccountText();
		
		Assert.assertEquals(actualTitle, expectedTitle, "Create an account section not present..");
		hp.setEmailCreate("dcqadevops@gmail.com");
		hp.clickSubmitCreate();
		
		
		String expectedPageTitle ="YOUR PERSONAL INFORMATION";
		String actualPageTitle = rp.getPageTitle();
		
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "Registation Page not exists..");
	}

}
