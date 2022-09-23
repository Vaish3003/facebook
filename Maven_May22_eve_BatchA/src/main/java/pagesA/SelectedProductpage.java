package pagesA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedProductpage {

	private WebDriver driver;
	
	
	@FindBy (xpath="(//div[text()='Noise ColorFit Caliber Smart Watch with 15-day battery, 1.69\" display, 60 Sports Modes Smartwatch'])[1]")
	private WebElement RedWatch; 
	
	@FindBy (xpath="//button[text()='ADD TO CART']")
	private WebElement addToCart; 
	
	@FindBy (xpath="//button[text()='BUY NOW']")
	private WebElement buyNow; 
	public SelectedProductpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public void chooseRedWatchImg()
	{
		RedWatch.click();
	}
	
	public void clickOnaddToCart()
	{
		addToCart.click();
	}
	
	public void clickOnBuyNow()
	{
		buyNow.click();
	}
	
	
	
	
	
	
	
	
}
