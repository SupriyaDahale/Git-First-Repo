package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailPage;
import coverFoxPOM.CoverFoxResultPage;
import coverFoxUtility.Utility;


public class TC1234_CoverFox_ValidateBannerCount extends Base
{
	
  CoverFoxHomePage homePage;
  CoverFoxHealthPlanPage healthPlanPage;
  CoverFoxMemberDetailPage memberDetailPage;
  CoverFoxAddressDetailPage addressDetailPage;
  CoverFoxResultPage resultPage;
  String excelpath = System.getProperty("user.dir")+"\\DataSheets\\ExcelTest.xlsx";
  String sheetName = "Sheet5";
  public static org.apache.log4j.Logger logger;
  //open browser/open an application
  @BeforeClass
  public void openApplication() throws IOException
  {
	  launchBrowser();
	 logger= org.apache.log4j.Logger.getLogger("8th_june_coverfox");
	 PropertyConfigurator.configure("log4j.properties");
	 logger.info("opening Browser");
	  
  }
  
  @BeforeMethod
  //gender,next click,age selection,pinCode,mobile, Nextclick
  public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  homePage = new CoverFoxHomePage(driver);
	  healthPlanPage = new CoverFoxHealthPlanPage(driver);
	  memberDetailPage = new CoverFoxMemberDetailPage(driver);
	  addressDetailPage = new CoverFoxAddressDetailPage(driver);
	  resultPage = new CoverFoxResultPage(driver);
	  homePage.ClickOnGenderButton();
	  logger.info("Clicking on gender button");
	  Thread.sleep(2000);
	  healthPlanPage.clickOnNextButton();
	  logger.info("Clicking on next button");
	  Thread.sleep(2000);
	  memberDetailPage.handleAgeDropDown(Utility.readDataFromExcel(excelpath, sheetName, 0, 0));
	  logger.info("Handeling age dropdown");
	  memberDetailPage.clickOnNextButton();
	  logger.info("Clicking on next button");
	  Thread.sleep(2000);
	  logger.warn("enter valid pinCode");
	  addressDetailPage.enterPinCode(Utility.readDataFromExcel(excelpath, sheetName, 0, 1));
	  logger.info("Enter pinCode");
	  logger.warn("enter valid MobNum");
	  addressDetailPage.enterMobNum(Utility.readDataFromExcel(excelpath, sheetName, 0, 2));
	  logger.info("Enter MobNum");
	  addressDetailPage.clickOnContinueButton();
	  logger.info("Clicking on continue button");
	  logger.error("please check detail again");
	  Thread.sleep(4000);
	 
  }
  
  @Test
  public void validatePolicyCount() 
  {
	  int textCount = resultPage.getCountFromText();
	  int bannerCount= resultPage.getCountFromBanner();
	  Assert.assertEquals(textCount, bannerCount,"text count not matching with banner count, TC failed");
	  logger.info("Validating Result");
	  //Assert.fail();
  }
  
  //logout from Application
  //Close browser/Close an Application
  
  @AfterClass
  public void closeApplication()
  {
	  closeBrowser();
	  logger.info("Closing Browser");
  }
}
