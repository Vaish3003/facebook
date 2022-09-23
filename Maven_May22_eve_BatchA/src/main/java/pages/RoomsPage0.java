package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomsPage0 {

	private WebDriver driver;
	@FindBy (xpath="//a[text() = ' Return to messenger.com ']")
	private WebElement returntomessenger;
	
	@FindBy (xpath="//a[text() = ' Visit our help center ']")
	private WebElement visithelpcenter;
	
	public  RoomsPage0(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void gobackToMessenger()
	{
		returntomessenger.click();
	}
	public void ContactToHelpCenter()
	{
		visithelpcenter.click();
	}
	
	
}
