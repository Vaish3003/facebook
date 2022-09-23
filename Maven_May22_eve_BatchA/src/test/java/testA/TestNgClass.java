package testA;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pagesA.AddToCartPage;
import pagesA.HomepageFlipkart;
import setup.Base;

public class TestNgClass extends Base {

	private WebDriver driver;
	private HomepageFlipkart homepage;
	private AddToCartPage addtocart;
	private SoftAssert soft;
	private ArrayList<String> listOfAddress ;
	
	@Parameters ("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName )
	{
		if (browserName.equals("Chrome"))
		{
			
		    driver =openChromeBrowser();
		}
		if (browserName.equals("FireFox"))
		{
			
		    driver = openFirefoxBrowser();
		}
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	}
	@BeforeClass
	public void createPOMObject()
	{	
		homepage = new HomepageFlipkart(driver);
	    addtocart = new AddToCartPage(driver);	
	    
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException 
	{
		driver.get("https://www.flipkart.com");
	   // homepage = new HomepageFlipkart(driver);
	   Thread.sleep(3000);
	    homepage.cancelloginpage();
	    homepage.SearchProduct();
	    Thread.sleep(3000);
	    homepage.hitSearchButton();
	    Thread.sleep(3000);
	    homepage.clickOnProduct();
//	   // addtocart = new AddToCartPage(driver);	
//	   // listOfAddress = new  ArrayList<String>(driver.getWindowHandles());
	    
	    soft = new SoftAssert();
		
	}
	@Test
	public void test1() 
	{
		listOfAddress = new  ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(listOfAddress.get(1));
		 addtocart.clickOnBuyNow();
		 String url = driver.getCurrentUrl();
		 String title = driver.getTitle();
		 System.out.println(url);
		 System.out.println(title);

//		 soft.assertEquals(url, "https://www.flipkart.com/noise-colorfit-caliber-smart-watch-15-day-battery-1-69-display-60-sports-modes-smartwatch/p/itm21dca40c77bbe?pid=SMWG9UKPHDH47DWK&lid=LSTSMWG9UKPHDH47DWKCFOSD0&marketplace=FLIPKART&q=Noise+ColorFit+Caliber+&store=ajy%2Fbuh&spotlightTagId=BestsellerId_ajy%2Fbuh&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=b71aa065-1c16-4989-a942-a81c1b6d07f8.SMWG9UKPHDH47DWK.SEARCH&ppt=sp&ppn=sp&ssid=1bfy61wa1mi2dgqo1663570110663&qH=1dbc6b89364e8f18\r\n"
//		 		+ "");

//		 soft.assertEquals(title, "Noise ColorFit Caliber Smart Watch with 15-day battery, 1.69\" display, 60 Sports Modes Smartwatch Price in India - Buy Noise ColorFit Caliber Smart Watch with 15-day battery, 1.69\" display, 60 Sports Modes Smartwatch online at Flipkart.com");
		 soft.assertAll();
		 
	}
	
	@AfterMethod
	public void logoutFromapplication() throws InterruptedException
	{
		System.out.println("AfterMethod");
		System.out.println("Logout");
		driver.switchTo().window(listOfAddress.get(1));
		//driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.close();
	}
	
	@AfterClass
	public void cleanPOMObject()
	{
		System.out.println("AfterClass");
		driver.switchTo().window(listOfAddress.get(0));
		homepage =null;
		addtocart =null;
		listOfAddress =null;
		
	}
	@AfterTest
	public void cleanBrowser() throws InterruptedException
	{
		System.out.println("AfterTest");
		Thread.sleep(2000);
		 driver.close();
		 driver= null;
		 System.gc();
	}	
	
	
}
