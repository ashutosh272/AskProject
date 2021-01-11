package com.Askuity.TestExecution;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
//import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.AskuityAutomation.pages.LandingPageAskuity;
import com.AskuityAutomation.utility.Setup;
import com.AskuityAutomation.utility.utility;


public class AskuityAutomationScenario {
	Logger logger=Logger.getLogger("AskuityAutomationScenario");
	
	@BeforeClass
	public void setUpBrowser(){
		
	PropertyConfigurator.configure("Log4j.properties");
	new Setup("chrome", "http://automationpractice.com/index.php",30);
	logger.info("website is opened successfully ");
	
	}
	
	@Test(priority=1)
	public void verifyPage()
	{
	LandingPageAskuity create = PageFactory.initElements(Setup.driver, LandingPageAskuity.class);
	create.verifyPage();
	logger.info("User is in Home page");
	create.moveToWomenOptionAndClickSummerDressesOption();
	logger.info("User is in Summer Dresses Page");
	create.moveToPrintedSummerDressAndClickQuickviewBbutton();
	logger.info("User Mouse Moved Printed Summer Dress' and click 'Quick view' button succesfully ");
	create.clickOnAddTocard();
	logger.info("User Select the S size and click on Add to card successfully ...");
	
	create.clickContinueShoppingButton();
	logger.info("User clicked on continue button successfully ..");
	create.overToCartSectionAndClickCheckOutButton();
	logger.info("user is mouse Over to Cart section and click Check Out' button successfully ");
	create.clickProceedToCheckoutButton();
	logger.info(" User is Clicked Proceed to checkout button successfully ");
	create.provideEmailIDAndClickCreateAccountButton();
	logger.info(" User is provide the mail Id and click create account ");
	
	}
	
	@Test(dataProvider="SingupData" , priority=2)
	public void signUp(String FName , String LName , String PWD , String Address , String City , String State , String Mob , String ALTMail)
	{
		LandingPageAskuity create2 = PageFactory.initElements(Setup.driver, LandingPageAskuity.class);
		create2.fillUpTheRequired(FName ,  LName ,  PWD , Address ,  City ,  State , Mob , ALTMail );
		logger.info(" User provided the data successfully . ");
	}
	
	@DataProvider(name="SingupData")
	public Object[][] signupData()
	{
		Object[][] arryObject= new utility().getExcelData(".\\Test Data\\Data.xlsx" , "Sheet1");
		return arryObject;
	}
	
	@Test(priority=3)
	
	public void proceedToPaymnetTab()
	{
		LandingPageAskuity create3 = PageFactory.initElements(Setup.driver, LandingPageAskuity.class);
		create3.clickPproccedToCheckoutButtonAndProceedToPaymnet();
		logger.info(" User is in Patymnet Tab.");
		
		create3.verifyProduct();
		logger.info(" correct product is selected in Payment tab.");
	}
	
	@AfterClass
	
	public void closeBwoser()
	{
		Setup.driver.close();
		logger.info(" Trear Down happened successfully .");
	}
	
	
}
