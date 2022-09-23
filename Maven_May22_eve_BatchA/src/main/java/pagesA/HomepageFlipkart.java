package pagesA;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageFlipkart {
	
private WebDriver driver;
private JavascriptExecutor js ;
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	private WebElement searchField;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement searchButton; 
	
	@FindBy (xpath="//div[text()='Noise ColorFit Caliber Smart Watch with 15-day battery, 1.69\" display, 60 Sports Modes Smartwatch']")
	private WebElement watch; 
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement close;
	
	public HomepageFlipkart(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver= driver;
	}
	public void cancelloginpage()
	{
		
		close.click();
	}
	
	public void SearchProduct()
	{
		searchField.sendKeys("Noise ColorFit Caliber ");
	}
	public void hitSearchButton()
	{
		searchButton.click();
	}
	 

	public void clickOnProduct()
	{
//		JavascriptExecutor js = new JavaScriptExecutor(driver);
//		js.executeScript(arguments[0].scrollIntoview;"watch");
		watch.click();
	}

	
	
	
	
	
	
}
