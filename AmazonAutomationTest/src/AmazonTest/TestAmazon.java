package AmazonTest;

import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestAmazon {
	
	static WebDriver driver;
	static String URL = "https://www.amazon.in/";
	static String PATH = "C:\\Users\\userName\\Desktop\\\\Framework\\Drivers\\chromedriver.exe";
	//OTHER
	static String expectedString = "About this item";
	//LOCATORS
	static String firstLOCATOR = "//i[@class='hm-icon nav-sprite']";
	static String secondLOCATOR = "(//a[@class='hmenu-item'])[11]";
	static String thirdLOCATOR = "(//span[@class='a-size-base a-color-base'])[87]";
	static String fourthLOCATOR = "//span[@class='a-button a-button-dropdown a-button-small']";
	static String fifthLOCATOR = "(//a[@class='a-dropdown-link'])[2]";
	static String sixthLOCATOR = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]";
	static String linkTEXT = "Televisions";
	
	@Before
	public void start() {
		System.setProperty("webdriver.chrome.driver", PATH);
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestAmazon() throws InterruptedException {
		
		
		driver.findElement(By.xpath(firstLOCATOR)).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath(secondLOCATOR)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText(linkTEXT)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(thirdLOCATOR)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(fourthLOCATOR)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(fifthLOCATOR)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sixthLOCATOR)).click();
				
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String textString = driver.findElement(By.xpath("//h1[@class='a-size-base-plus a-text-bold']")).getText();	 
		System.out.println(textString);
		assertEquals(textString, expectedString);
		
	}
	@After
	public void close() {
				
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

