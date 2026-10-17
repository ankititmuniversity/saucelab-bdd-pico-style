package base;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait eWait;
	protected Wait<WebDriver> fWait;
	protected Actions actions;

	public BasePage(WebDriver driver){
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	    this.eWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    this.fWait = new FluentWait<>(driver)
	                     .withTimeout(Duration.ofSeconds(30))
	                     .pollingEvery(Duration.ofSeconds(5))
	                     .ignoring(NoSuchElementException.class);
	    this.actions = new Actions(driver);
	}	
}
