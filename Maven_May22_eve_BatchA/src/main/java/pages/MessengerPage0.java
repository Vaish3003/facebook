package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage0 {

	private WebDriver driver;
	@FindBy (xpath="//a[text() = 'Rooms']")
	private WebElement rooms;
	
	@FindBy (xpath="//a[text() = 'Features']")
	private WebElement features;
	
	public MessengerPage0(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnRooms()
	{
		rooms.click();
	}
	
	public void clickOnfeatures()
	{
		features.click();
	}
}

