package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Loginpage0;
import pages.MessengerPage0;
import pages.RoomsPage0;

public class TestclassFB0 {

	private Loginpage0 loginpage;
	 private MessengerPage0 messengerpage;
	   private RoomsPage0 roomspage;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\SELENIUM\\chromedriver_win32 (3)\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https:www.facebook.com/");
	    
	    Loginpage0 loginpage = new Loginpage0(driver);
	    loginpage.openMessenger();
	    //checkpoint
	    String url = driver.getCurrentUrl();
	   
	    if(url.equals("https://www.messenger.com/"))
	    {
	    	System.out.println("url of messengerpage is verified");
	    }
	    else
	    {
	    	System.out.println("url of messengerpage is not verified");
	    }
	    
	    MessengerPage0 messengerpage = new MessengerPage0(driver);
	    messengerpage.clickOnRooms();
	    //checkpoint
	    String url1 = driver.getCurrentUrl();
	   // System.out.println(url1);
	    if(url1.equals("https://www.messenger.com/rooms"))
	    {
	    	System.out.println("url of roomspage is verified");
	    }
	    else
	    {
	    	System.out.println("url of roomspage is not verified");
	    }
	    RoomsPage0 roomspage = new RoomsPage0(driver);
	    roomspage.gobackToMessenger();
	    
	    //checkpoint
	    String url2 = driver.getCurrentUrl();
	    //System.out.println(url2);
	    if(url.equals("https://www.messenger.com/"))
	    {
	    	System.out.println("url of gobackmessengerpage is verified");
	    }
	    else
	    {
	    	System.out.println("url of gobackmessengerpage is not verified");
	    }
	    
	    messengerpage.clickOnRooms();
	    String url3 = driver.getCurrentUrl();
		   // System.out.println(url3);
		    if(url3.equals("https://www.messenger.com/rooms"))
		    {
		    	System.out.println("url of roomspage is verified");
		    }
		    else
		    {
		    	System.out.println("url of roomspage is not verified");
		    }
		    
	    roomspage.ContactToHelpCenter();
	    //checkpoint
	    String url4 = driver.getCurrentUrl();
		   // System.out.println(url3);
		    if(url4.equals("https://www.messenger.com/help"))
		    {
		    	System.out.println("url of messenger/help is verified");
		    }
		    else
		    {
		    	System.out.println("url of messenger/help is not verified");
		    }
	  
	 
		   // System.out.println(url4);
		    driver.close();
	    
	    
		
		
	
	
	
	
	
	
	}
}
