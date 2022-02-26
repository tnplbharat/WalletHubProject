package utilityFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.BaseTest;

public class UtilityFunctions {
	
	public WebDriver driver;
	
	public UtilityFunctions(WebDriver driver)
	{
		this.driver = driver;
	}

	public void waiForElementToClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waiForElementToVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waiForElementToSelect(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void waiForElementTextToBePresentInElement(WebElement element, String strVal)
	{
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(element,strVal));
	}
	

}
