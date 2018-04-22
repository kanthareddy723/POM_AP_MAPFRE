package com.GenericFunctions;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;



public class GenericFunctions extends TestNGListeners {
	
	
	public static  WebDriver driver;

	
	
	public static boolean launchApplication(String browser) {
		
		boolean status=true;
		
		
		switch (browser.toLowerCase()) {
		case "ie":
			
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			System.setProperty("webdriver.ie.driver",  "C:\\Users\\hp\\New folder (2)\\POM_AP_MAPFRE_FrameWork\\BrowserServers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			String url2=getCommontestdata("Url");
			System.out.println(url2);
			driver.get(url2);
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;

		case "firefox":
			
			driver= new FirefoxDriver();
			
			String url=getCommontestdata("Url");
			
			System.out.println(url);
			
			driver.get(url);
			
			driver.manage().window().maximize();
			
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			
			break;
			
		case "chrome":
			System. setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\New folder (2)\\POM_AP_MAPFRE_FrameWork\\BrowserServers\\chromedriver.exe");		
			
			driver =new ChromeDriver();
			String url1=getCommontestdata("Url");
			driver.get(url1);
			System.out.println(url1);
			driver.manage().window().maximize();

			break;
			
			
			
		default:
			break;
		}
		
	return status;	
		
	}

	
	
	
	public static String getCommontestdata(String data)
	{
		
		String strQuery="Select "+ data+" from CommonTestdata";
		
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(data));
				
				fetcheddata=recordset.getField(data);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	
	
	
	public static String getdata(String sheetname,String userdata,int itr)
	{
		
		String strQuery="Select "+ userdata+" from "+sheetname+ " where Tc_Name='"+crntclass+"' and Iteration="+itr;
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(userdata));
				
				fetcheddata=recordset.getField(userdata);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	public static String getsheetdata(String sheetname,String userdata)
	{
		
		String shtQuery="Select "+ userdata+" from "+sheetname+ " where Tc_Name='"+crntclass+"'";
		System.out.println(shtQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(shtQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(userdata));
				
				fetcheddata=recordset.getField(userdata);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	
	
	
	
	
	
	public static void waitForElement(WebElement element)
	{
	
		for(int i=1;i<=10;i++)
		{
		try
		{
			System.out.println("Wait is executing");
			Actions acc=new Actions(driver);
			acc.moveToElement(element).build().perform();
			
			System.out.println("Element Found");
			break;
			
		}
		catch(Exception e)
		{
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			
		}
		}	
		
	}
	
	
	public static boolean hoverAndClick(WebElement element)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Actions acc=new Actions(driver);
			acc.moveToElement(element).click().build().perform();
			
		}
		catch(Exception e)
		{
			
			status=false;
		
		}	
		
	
	
	return status;
	}	
	
	public static void forceClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
		
	}

	

	public static boolean setdata(WebElement element, String data)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			element.click();
			element.clear();
			element.sendKeys(data);
			System.out.println("Data Passed");
			
		}
		catch(Exception e)
		{
			
			status=false;
			System.out.println("Data Passed");
		}	
		
	
	
	return status;
	}	
	
	
	

	public static boolean selectdropdown(WebElement element, String data)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Select slct = new Select(element);
			slct.selectByVisibleText(data);
			System.out.println("List Option Selected");
		}
		catch(Exception e)
		{
			
			status=false;
			System.out.println("List Option not Selected");
		}	
		
	
	
	return status;
	}	
	
		
	

	public static boolean clickradioButton(WebElement element, String data)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			//element+ "[+data+]"+ .hoverAndClick(element);
			
			
			System.out.println("List Option Selected");
		}
		catch(Exception e)
		{
			
			status=false;
			System.out.println("List Option not Selected"+ data + "hii");
		}	
		
	
	
	return status;
	}	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


