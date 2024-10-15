package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailPage 
{
  // variable declaration
	@FindBy(id = "Age-You") private WebElement ageDropDown;
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	// constructor
	public CoverFoxMemberDetailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	// methods
	public void handleAgeDropDown(String age)
	{
		Reporter.log("Handeling Age dropdown", true);
		Select s= new Select(ageDropDown);
		s.selectByValue(age+"y");
	}
	
	public void clickOnNextButton()
	{
		Reporter.log("Clicking on Next Button", true);
		nextButton.click();
	}
}
