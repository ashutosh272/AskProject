package com.AskuityAutomation.pages;


import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.AskuityAutomation.utility.Setup;
import com.AskuityAutomation.utility.utility;


public class LandingPageAskuity {
	WebDriver driver=null;
	
	
	
	public LandingPageAskuity()
	{
		driver =  Setup.driver;
	}

	
	
	@FindBy(how=How.XPATH , using ="(//a[@title='Summer Dresses'])[1]")
	public WebElement clickWomenSummerDress;
	
	@FindBy(how=How.XPATH , using ="//a[@title='Women']")
	public WebElement womenMouseOver;
	
	@FindBy(how=How.XPATH , using ="(//a[@class='product-name'])[2]")
	public WebElement womenMouseOverPrintedSummeDress1;
	
	@FindBy(how=How.XPATH , using ="//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[2]/span")
	public WebElement womenMouseOverPrintedSummeDressquickView1;
	
	@FindBy(how=How.XPATH , using ="//span[@class='cat-name']")
	public WebElement summerDressText;
	
	@FindBy(how=How.XPATH , using ="	//span[@class='editable' and text()='demo_5']")
	public WebElement ProductDetails;

	
	@FindBy(how=How.XPATH , using ="//button[@type='submit']/span[text()='Add to cart']")
	public WebElement addtoCard;
	
	@FindBy(how=How.XPATH , using ="//iframe[@class='fancybox-iframe']")
	public WebElement iFrame;
	
	@FindBy(how=How.XPATH , using ="(//*[@id='layer_cart']/div[1]/div[1]/h2/text())[2]")
	public WebElement successMssage;
	
	@FindBy(how=How.XPATH , using ="//span[@title='Continue shopping']/span")
	public WebElement continueShoppingButton ;
	
	@FindBy(how=How.XPATH , using ="//a[@title='View my shopping cart']")
	public WebElement moveHoverCardscetion ;
		
	@FindBy(how=How.XPATH , using ="	//a[@title='Check out']/span")
	public WebElement checkOut ;
    
	@FindBy(how=How.XPATH , using ="(//h1[@id='cart_title']/text())[1]")
	public WebElement shoppincartSummarypage ;
	
	@FindBy(how=How.XPATH , using ="(//a[@title='Proceed to checkout'])[2]")
	public WebElement proceedToCheckOutButton ;
	
	@FindBy(how=How.XPATH , using ="(//input[@class ='is_required validate account_input form-control'])[1]")
	public WebElement eMailIdFileld ;
	
	@FindBy(how=How.XPATH , using ="//button[@class ='btn btn-default button button-medium exclusive']")
	public WebElement createAccountbutton ;
	
	@FindBy(how=How.XPATH , using ="//input[@id='customer_firstname']")
	public WebElement persionalInfoFName ;
	
	@FindBy(how=How.XPATH , using ="//input[@id='customer_lastname']")
	public WebElement persionalInfoLName ;
	
	@FindBy(how=How.XPATH , using ="//input[@id='passwd']")
	public WebElement persionalInfoPwd ;
	
	@FindBy(how=How.XPATH , using ="//input[@id='firstname']")
	public WebElement addressInfoFNmame ;
	
	@FindBy(how=How.XPATH , using ="//input[@id='lastname']")
	public WebElement addressInfoLNmame ;
	
	@FindBy(how=How.XPATH , using ="//input[@id='address1']")
	public WebElement addressInfoAddress ;
	
	
	@FindBy(how=How.XPATH , using ="//input[@id='city']")
	public WebElement addressInfoCity ;
	
	@FindBy(how=How.XPATH , using ="//select[@id='id_state']")
	public WebElement addressInfoState ;
	
	@FindBy(how=How.XPATH , using ="//input[@id='phone_mobile']")
	public WebElement addressInfoMobile ;
	
	@FindBy(how=How.XPATH , using ="//input[@id='alias']")
	public WebElement addressInfoAlterEmail ;
	
	@FindBy(how=How.XPATH , using ="//input[@id='postcode']")
	public WebElement addressInfoZip ;
	
	@FindBy(how=How.XPATH , using ="//button[@id='submitAccount']")
	public WebElement RegisterButton ;
	
	@FindBy(how=How.XPATH , using ="//button[@class='button btn btn-default button-medium']")
	public WebElement proccedToCheckoutButton ;
	
	@FindBy(how=How.XPATH , using ="	//h1[text() ='Addresses']")
	public WebElement AddressPageTab ;

	
	@FindBy(how=How.XPATH , using ="//input[@type='checkbox']")
	public WebElement checkBox ;
	
	@FindBy(how=How.XPATH , using ="//button[@class='button btn btn-default standard-checkout button-medium']")
	public WebElement proccedToCheckoutButtonShippingTab ;
	
	@FindBy(how=How.XPATH , using ="//small[@class='cart_ref']")
	public WebElement PaymnetTabProductName ;
	
	
	
		
	public  void verifyPage()
	{
				
		String tile = Setup.driver.getTitle();
		
		if(tile.contains("My Store"))
		{
			System.out.println("User is in automationpractice.com home pge :"+Setup.driver.getCurrentUrl());
		}
	}
	
		
	public void moveToWomenOptionAndClickSummerDressesOption()
	{
		utility.moveToElemnet(womenMouseOver);
		utility.unContionalWait(2);
		utility.clickElement(clickWomenSummerDress);
		if(summerDressText.getText().contains("SUMMER DRESSES"))
	    {
	    	System.out.println("User is in Summer Dresses Page");
	    }
			
	}
    
	public void moveToPrintedSummerDressAndClickQuickviewBbutton()
	{
		utility.moveToElemnet(womenMouseOverPrintedSummeDress1);
		utility.unContionalWait(4);
		womenMouseOverPrintedSummeDressquickView1.click();
	    
	}
	
	public void clickOnAddTocard()
	{
		Setup.driver.switchTo().frame(iFrame);
		
		String prodName = ProductDetails.getText();
		
		new utility().setProduct(prodName);
		
		System.out.println("The product selected :"+new utility().getProduct());
		
		utility.clickElement(addtoCard);
		
		Setup.driver.switchTo().parentFrame();
		
		System.out.println("The product has been added to card success message displayed ");
				
	}
	
	
	
	public void clickContinueShoppingButton()
	{
		utility.unContionalWait(3);
		utility.clickElement(continueShoppingButton);
		
	}
	
	public void overToCartSectionAndClickCheckOutButton()
	{
		utility.moveToElemnet(moveHoverCardscetion);
		utility.unContionalWait(3);
		checkOut.click();
		
		String pgeName = Setup.driver.getTitle();	
		
		if(pgeName.contains("Order"))
		{
			System.out.println("User is in shopping cart summery page ");
		}
	}
	
	public void clickProceedToCheckoutButton()
	{
		utility.unContionalWait(3);
		utility.clickElement(proceedToCheckOutButton);
        String pgeName = Setup.driver.getTitle();	
		
		if(pgeName.contains("Login"))
		{
			System.out.println("User is in Login Page ");
		}
	}
	
	public void provideEmailIDAndClickCreateAccountButton()
	
	{
		eMailIdFileld.click();
		utility.unContionalWait(2);
		eMailIdFileld.sendKeys("aunhwwuuu11@gmail.com");
		utility.unContionalWait(2);
		createAccountbutton.click();
		
		
	}
	
	public void fillUpTheRequired(String FName , String LName , String PWD , String Address , String City , String State ,String Mob , String ALTMail )
	{
		persionalInfoFName.click();
		persionalInfoFName.sendKeys(FName);
		utility.unContionalWait(2);
		
		persionalInfoLName.click();
		persionalInfoLName.sendKeys(LName);
		utility.unContionalWait(2);
		
		persionalInfoPwd.click();
		persionalInfoPwd.sendKeys(PWD);
		utility.unContionalWait(2);
		
		addressInfoAddress.click();
		addressInfoAddress.sendKeys(Address);
		utility.unContionalWait(2);
		
		addressInfoCity.click();
		addressInfoCity .sendKeys(City);
		utility.unContionalWait(2);
		
		Select sel = new Select(addressInfoState );
		sel.selectByVisibleText(State);
		utility.unContionalWait(2);
		
		addressInfoZip.click();
		addressInfoZip.sendKeys("85202");
		utility.unContionalWait(2);
		
		addressInfoMobile.click();
		addressInfoMobile.sendKeys(Mob);
		utility.unContionalWait(2);
		
		addressInfoAlterEmail.click();
		addressInfoAlterEmail.clear();
		utility.unContionalWait(2);
		addressInfoAlterEmail.sendKeys(ALTMail);
		utility.unContionalWait(2);
		
		RegisterButton.click();
		
        String pageName = AddressPageTab.getText();
		
		if(pageName.contains("ADDRESSES"))
		{
			System.out.println("user is in Address Page ");
		}
	}	
		
	public void clickPproccedToCheckoutButtonAndProceedToPaymnet ()
	{
        
		utility.unContionalWait(2);
		proccedToCheckoutButton.click();
		
		utility.unContionalWait(2);
		checkBox.click();
		
		utility.unContionalWait(2);
		proccedToCheckoutButtonShippingTab.click();
				
	}
	
	public void verifyProduct()
	{
		String PaymentProdDetails = PaymnetTabProductName.getText();
		
		String FinalPaymentProdDetails = PaymentProdDetails.substring(6);
		
		if(FinalPaymentProdDetails.equalsIgnoreCase(new utility().getProduct()))
		{
			System.out.println("User is in paymet tab with the correct product :"+FinalPaymentProdDetails);
		}
		
		
	}
}
