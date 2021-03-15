package tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import listeners.ListenerTestNg;

@Listeners(ListenerTestNg.class)
public class HadlingMultipleWebElements extends TestBase{
	
	
	@Test(enabled = false)
	public void selectAllHobbies()
	{
		List<WebElement> list = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		
		Iterator<WebElement> itr = list.iterator();
		
		while(itr.hasNext())
		{
			itr.next().click();
		}
		
	}
	
	
	@Test
	public void getAllLinksFromFaceBook()
	{
		List<WebElement> list = driver.findElements(By.tagName("a"));
		
		System.out.println(list.size());
		
		for( WebElement li : list)
		{
			System.out.println(li.getText());
		}
	}
	

}
