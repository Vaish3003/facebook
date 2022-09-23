package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage0 {

	private WebDriver driver;
	@FindBy (xpath= "//a[text() ='Messenger']")
	private WebElement messenger;
	
	public Loginpage0(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
		this.driver = driver;
	}
	
	public void openMessenger()
	{
		messenger.click();
	}
	
	
	
	
	
}
