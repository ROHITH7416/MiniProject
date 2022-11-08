package mytest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() 
	{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://www.amazon.in/");
	 driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
	}
	
	@Test
	public void verifyTitle() 
	{
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	@Test
	public void verifyLogo() throws InterruptedException
	{
		boolean logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
		
		Assert.assertTrue(logo);
		Thread.sleep(5000);
	}
	
	@Test
	public void searchBar() throws InterruptedException
	{
		WebElement bar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		bar.click();
		bar.sendKeys("mobiles");
		Thread.sleep(10000);
		
		WebElement search = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		search.click();
		Thread.sleep(10000);
			

	}
	
 
	

	
	
	@AfterMethod
	public void tearDown( ) {
		driver.close();
		driver.quit();
	}
	
	
	
	
}
