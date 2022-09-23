package test;

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

import pages.Loginpage0;
import pages.MessengerPage0;
import pages.RoomsPage0;
import setup.Base;

public class TestNgClass extends Base{

	private WebDriver driver;
	private SoftAssert soft;
	private Loginpage0 loginpage;
	private MessengerPage0 messengerpage;
	private RoomsPage0 roomspage;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browserName.equals("FireFox"))
		{
			driver = openFirefoxBrowser();
		}
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMObject()
	{	
		loginpage = new Loginpage0(driver);
		messengerpage = new MessengerPage0(driver);
		roomspage = new RoomsPage0(driver);
	}

	@BeforeMethod
	public void openApplication()
	{
	   driver.get("https:www.facebook.com/");
	 // loginpage = new Loginpage0(driver);
	  loginpage.openMessenger();
	 // messengerpage = new MessengerPage0(driver);
	  messengerpage.clickOnRooms();
	 // roomspage = new RoomsPage0(driver);
     soft = new SoftAssert();
	}
	@Test (priority=1)
	public void goBackToMessenger()
	{
		roomspage.gobackToMessenger();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		soft.assertEquals(url, "https://www.messenger.com/","goBackToMessengerpage is not verified");
		soft.assertEquals(title, "Messenger","title Messenger is not verified");
	    soft.assertAll();
	}	
	@Test (priority=2)
	public void contactToHelpCenter()
	{
		 //messengerpage.clickOnRooms();
	    roomspage.ContactToHelpCenter();
	    String url1 = driver.getCurrentUrl();
	    String title1 = driver.getTitle();
	    
	    System.out.println(url1);
	    System.out.println(title1);
	   
		soft.assertEquals(url1, "https://www.messenger.com/help","helpCenter page is not verified");
		soft.assertEquals(title1, "Messenger Help Centre","title helpCenter page is not verified");
	    soft.assertAll();
	}
	
	@AfterMethod
	public void logoutFromApplication()
	{
		System.out.println("AfterMethod");
		System.out.println("Logout");
	}
	
	
	@AfterClass
	public void cleanPOMObject()
	{
		System.out.println("AfterClass");
		loginpage = null;
		messengerpage = null;
		roomspage = null;
		
	}
	@AfterTest
	public void cleanBrowser()
	{	
		driver.close();
		driver = null;
		System.gc();  //delete the unused object
	}	
	
	
	
}
