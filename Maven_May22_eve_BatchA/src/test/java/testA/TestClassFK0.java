package testA;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pagesA.AddToCartPage;
import pagesA.HomepageFlipkart;
import pagesA.SelectedProductpage;



public class TestClassFK0 {
	
	//private HomepageFlipkart homepage;
	//private AddToCartPage addtocart;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\SELENIUM\\chromedriver_win32 (3)\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.flipkart.com/");
	    
	    HomepageFlipkart homepage = new HomepageFlipkart(driver);
	    homepage.cancelloginpage();
	    homepage.SearchProduct();
	    homepage.hitSearchButton();
	    homepage.clickOnProduct();
	    
	    AddToCartPage addtocart = new AddToCartPage(driver);	
	    ArrayList<String> listOfAddress = new  ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(listOfAddress.get(1));
	    addtocart.clickOnBuyNow();
	  
	    
	    String url = driver.getCurrentUrl();
	    System.out.println(url);
	   
	    if (url.equals("https://www.flipkart.com/checkout/init?otracker=search"))
	    {
	    	System.out.println("url is verified");
	    }
	    else
	    {
	    	System.out.println("url is not verified");

	    }
	    driver.close();
	    driver.switchTo().window(listOfAddress.get(0));
	    driver.close();
	    
	   
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
