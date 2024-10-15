package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultPage 
{
  // Variable declaration
	@FindBy(xpath = "//div[contains(text(),'matching Health')]") private WebElement resultText;
	@FindBy(className = "plan-card-container") private List<WebElement> planList;
	
	//constructor
	
	public CoverFoxResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public int getCountFromText()
	{
		Reporter.log("Getting policy count from text displayed",true);
		String resultInString = resultText.getText().substring(0, 2);
		int countFromText = Integer.parseInt(resultInString);
		return countFromText;
	}
	
	public int getCountFromBanner()
	{
		Reporter.log("Getting policy count from banners displayed",true);
		int countFromBanner = planList.size();
		return countFromBanner;
	}
	
	//Methods
	
//	public void validateResult()
//	{
//		String resultInString = resultText.getText().substring(0, 2);
//		int resultNumber = Integer.parseInt(resultInString);
//		int planListNumber = planList.size();
//		
//		System.out.println("Results number is: "+ resultNumber);
//		System.out.println("Plan List number is: "+ planListNumber);
//		
//		if(resultNumber==planListNumber)
//		{
//			System.out.println("Results are matching TC is passed");
//		}
//		else
//		{
//			System.out.println("Results are not matching TC is failed");
//		}
}
	