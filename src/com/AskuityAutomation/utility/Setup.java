package com.AskuityAutomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class Setup {

	public static WebDriver driver;
	private static int WaitTime = 0;

	public Setup(String Browser, String URL, int waitTime){
		initialiseSetup(Browser, URL);
		waitForElement(waitTime);

	}

	public Setup(String Browser, String URL){
		initialiseSetup(Browser, URL);
	}

	private static void initialiseSetup (String Browser, String URL){
		System.out.println("Default Class Initialised..!!");
		if(URL==null || URL.equalsIgnoreCase("null") || URL.equalsIgnoreCase("")){
			Assert.fail("Url Not Privided to Test Execution...");
		}

		if(Browser==null || Browser.equalsIgnoreCase("null") || Browser.equalsIgnoreCase("")){
			startBrowser("Chrome", URL);
			System.out.println("Browser not Specified, Selected Default Browser as Chrome...");
		}
		else if (Browser.equalsIgnoreCase("Chrome")){
			startBrowser("Chrome", URL);
			System.out.println("Assigning Default Browser as Chrome...");
		}
		else if (Browser.equalsIgnoreCase("firefox")){
			startBrowser("Firefox", URL);
			System.out.println("Assigning Default Browser as Chrome...");
		}
		else{
			//reserved for other Browsers
		}
			
		}
	
		private static WebDriver startBrowser(String browser , String URL){
			if(browser.equals("Firefox")){
				driver=new FirefoxDriver();

			}
			else if (browser.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
				driver=new ChromeDriver();
			}

			driver.manage().window().maximize();
			driver.get(URL);
			return driver;
		}

		
		public static void waitForElement(int newDefaultWaitTime){
			Setup.driver.manage().timeouts().implicitlyWait(newDefaultWaitTime , TimeUnit.SECONDS);
			WaitTime = newDefaultWaitTime;
		}

		public static void waitForElement(){
			Setup.driver.manage().timeouts().implicitlyWait(WaitTime , TimeUnit.SECONDS);
		}
		
		public static void quitDriver() {
			driver.quit();
		}
		
}
