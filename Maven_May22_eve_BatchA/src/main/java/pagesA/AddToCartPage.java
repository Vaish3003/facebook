package pagesA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	WebDriver driver;
	
	@FindBy (xpath="//button[text()='ADD TO CART']")
	private WebElement addToCart; 
	
	@FindBy (xpath="//button[text()='BUY NOW']")
	private WebElement buyNow; 
	
	
	 public AddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver= driver;
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
