package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageObjects {
	
	public WebDriver driver;
	
	public RegistrationPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//h3[text()='Your personal information']")
	WebElement pageTitle;
	
	
	public String getPageTitle()
	{
		String title = pageTitle.getText();
		return title;
	}

}
