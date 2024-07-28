package Com.naukari.Naukari.com;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Reports.ExtentReporting;
import utilities.Inputs;
import utilities.WaitingMethods;
import utilities.getTimeStampCurrent;

public class UpdateProfile {
	

	WebDriver driver= new ChromeDriver();
	WaitingMethods Wait= new WaitingMethods(driver);
	
  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	
	ExtentReports extent= ExtentReporting.getReportObject();
	ExtentTest test;
	String testMethodName;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	
	@Test(priority = 1)
	public void Login_naukariCom()
	{
		driver.get("https://www.naukri.com/");
		driver.findElement(By.id("login_Layer")).click();
		//impilcit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@placeholder='Enter your active Email ID / Username']"))));
		Wait.waituntilVisible(driver.findElement(By.xpath("//*[@placeholder='Enter your active Email ID / Username']")));
		
		driver.findElement(By.xpath("//*[@placeholder='Enter your active Email ID / Username']")).sendKeys(Inputs.getProperty("email"));
		
		driver.findElement(By.xpath("//*[@placeholder='Enter your password']")).sendKeys(Inputs.getProperty("password"));
		
		driver.findElement(By.className("loginButton")).click();
		Reporter.log("Login to Naukari.com is sucessfull.",true);
		
			
	}
	
	@Test(priority = 2)
	public void updateHeadline_in_Profile()
	{
		driver.findElement(By.xpath("//a[text()='View']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='card mt15']//div//span[@class='edit icon'][normalize-space()='editOneTheme']"))));
		driver.findElement(By.xpath("//div[@class='card mt15']//div//span[@class='edit icon'][normalize-space()='editOneTheme']")).click();
		Wait.waituntilVisible(driver.findElement(By.id("resumeHeadlineTxt")));
		driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).clear();
		driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).sendKeys(Inputs.getProperty("headerInfo") + getTimeStampCurrent.getCurrentTime());
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
		Reporter.log("Update headline of profile Naukari.com is sucessfull.",true);

		
	}
	
	@Test(priority = 3)
	public void LogoutFromNaukari()
	
	{
		driver.navigate().to("https://www.naukri.com/mnjuser/homepage");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@alt='naukri user profile img']"))));
		
		driver.findElement(By.xpath("//img[@alt='naukri user profile img']")).click();
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		Reporter.log("Logout from Naukari.com is sucessfull.",true);
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.close();
	}

}
