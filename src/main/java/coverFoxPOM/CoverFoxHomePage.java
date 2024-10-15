package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage 
{
	//variable Declaration--> webElement
	//WebElement name= driver.findElement(By.x);
	@FindBy(xpath = "//div[text()='Female']") private WebElement gender;
	
	//Constructor--> variable initialize
	public CoverFoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//methods
	public void ClickOnGenderButton()
	{
		Reporter.log("Clicking on Gender Button", true);
		gender.click();
	}
}
