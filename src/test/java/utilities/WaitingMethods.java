package utilities;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingMethods {

	private WebDriver driver;
	
	public WaitingMethods(WebDriver driver)
	{
		this.driver= driver;
		
	}
	public void waituntilVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
}
