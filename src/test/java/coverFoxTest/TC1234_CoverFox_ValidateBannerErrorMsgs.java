package coverFoxTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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


public class TC1234_CoverFox_ValidateBannerErrorMsgs extends Base
{
	
  CoverFoxHomePage homePage;
  CoverFoxHealthPlanPage healthPlanPage;
  CoverFoxMemberDetailPage memberDetailPage;
  CoverFoxAddressDetailPage addressDetailPage;
  CoverFoxResultPage resultPage;
  String excelpath = System.getProperty("user.dir")+"\\DataSheets\\ExcelTest.xlsx";
  String sheetName = "Sheet5";
  public static org.apache.log4j.Logger logger;
  
  
  @BeforeMethod
  //gender,next click,age selection,pinCode,mobile, Nextclick
  public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException
  {
	     launchBrowser();
		 logger= org.apache.log4j.Logger.getLogger("8th_june_coverfox");
		 PropertyConfigurator.configure("log4j.properties");
		 logger.info("opening Browser");
		  
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
//	  logger.warn("enter valid pinCode");
//	  addressDetailPage.enterPinCode(Utility.readDataFromExcel(excelpath, sheetName, 0, 1));
//	  logger.info("Enter pinCode");
//	  logger.warn("enter valid MobNum");
//	  addressDetailPage.enterMobNum(Utility.readDataFromExcel(excelpath, sheetName, 0, 2));
//	  logger.info("Enter MobNum");
//	  addressDetailPage.clickOnContinueButton();
//	  logger.info("Clicking on continue button");
//	  logger.error("please check detail again");
//	  Thread.sleep(4000);
	 
  }
  
  @Test
  public void validatePinCodeErrorMsg() throws InterruptedException, EncryptedDocumentException, IOException 
  {
	  logger.warn("enter valid MobNum");
	  addressDetailPage.enterMobNum(Utility.readDataFromExcel(excelpath, sheetName, 0, 2));
	  logger.info("Enter MobNum");
	  addressDetailPage.clickOnContinueButton();
	  logger.info("Clicking on continue button");
	  logger.error("please check detail again");
	  String actualPinErrorMsg = addressDetailPage.pinErrMsg();
	  String expectedPinErrorMsg = Utility.readDataFromExcel(excelpath,sheetName, 0, 3);
	  Thread.sleep(4000);
	  Assert.assertEquals(actualPinErrorMsg, expectedPinErrorMsg,"Error msg not matching,TC failed");
  }
  
  @Test(priority = -1)
  public void validateMobileNumErrorMg() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  logger.warn("enter valid pinCode");
	  addressDetailPage.enterPinCode(Utility.readDataFromExcel(excelpath, sheetName, 0, 1));
	  logger.info("Enter pinCode");
	  addressDetailPage.clickOnContinueButton();
	  logger.info("Clicking on continue button");
	  logger.error("please check detail again");
	  Thread.sleep(4000);
	  String actualMobErrorMsg = addressDetailPage.mobErrMsg();
	  String expectedMobErrorMsg = Utility.readDataFromExcel(excelpath,sheetName,0, 4);
	  Assert.assertEquals(actualMobErrorMsg,expectedMobErrorMsg,"Error msg not matching,TC failed");
	  Reporter.log("My Name is supriya",true);
	  Reporter.log("Hi This is Amruta",true);
	  Reporter.log("Hi This is Supriya Dahale",true);
	  Reporter.log("new brach has been created",true);
	  
  }
  //logout from Application
  //Close browser/Close an Application
  
  @AfterMethod
  public void closeApplication()
  {
	  closeBrowser();
	  logger.info("Closing Browser");
  }
}
