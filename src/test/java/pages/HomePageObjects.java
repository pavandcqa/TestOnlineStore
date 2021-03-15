package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePageObjects{
	
	WebDriver driver;
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	@FindBy(how = How.XPATH, using ="//h3[text()='Already registered?']")
	WebElement alreadyRegistered;
	
	@FindBy(how = How.ID, using ="email")
	WebElement emailAddressForLogin;
	
	@FindBy(how = How.NAME, using = "passwd")
	WebElement password;
	
	@FindBy(how = How.NAME, using ="SubmitLogin")
	WebElement submitSignIn;
	
	@FindBy(how = How.XPATH, using ="//a[text()='Forgot your password?']")
	WebElement forgotYourPassword;
	
	@FindBy(how = How.XPATH, using ="//h3[text()='Create an account']")
	WebElement createAnAccountSection;
	
	@FindBy(how = How.ID, using ="email_create")
	WebElement emailCreate;
	
	@FindBy(how = How.ID, using ="SubmitCreate")
	WebElement submitCreate;
	
	public boolean verifySignInLink()
	{
		boolean status = signIn.isDisplayed();
		return status;
	}
	
	public void clickSignIn() {
		signIn.click();
	}
	
	public String getAlreadyRegisteredText()
	{
		String title = alreadyRegistered.getText();
		return title;
	}
	
	
	public void setEmail(String email)
	{
		emailAddressForLogin.clear();
		emailAddressForLogin.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickSubmitLogIn()
	{
		submitSignIn.click();
	}
	
	public boolean verifyForgottenPasswordLink()
	{
		boolean status = forgotYourPassword.isDisplayed();
		return status;
	}
	
	public void clickForgotPassword()
	{
		forgotYourPassword.click();
	}
	
	public String getCreateAccountText()
	{
		String title = createAnAccountSection.getText();
		return title;
	}
	
	
	public void setEmailCreate(String ec)
	{
		emailCreate.clear();
		emailCreate.sendKeys(ec);
	}
	
	public void clickSubmitCreate()
	{
		submitCreate.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
