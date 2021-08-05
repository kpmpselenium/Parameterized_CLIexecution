package parameterized_CLIExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameterized_CLI_Execution {
	
	WebDriver driver;
	
	@Parameters({"browser","urltotest"})
	@BeforeMethod
	public void setup(String browser,String urltotest) {
		
		
		  if(browser.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();		  
		  }
		 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(urltotest);
	
	}
	
	@Test
	public void test1() throws Throwable {
		System.out.println("Pagetitle before login: "+ driver.getTitle()); 
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kpmpss80@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ss9@freecrm");	
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		System.out.println("Pagetitle after login: "+ driver.getTitle()); 
		
		
		Thread.sleep(3000);
		
	}

	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
}
