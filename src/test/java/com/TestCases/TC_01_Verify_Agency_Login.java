package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login;

public class TC_01_Verify_Agency_Login extends GenericFunctions
{
	
	@Test
	public static void Login()
	{
		//step1:
		launchApplication("firefox");
		//step2:
		Login lgn = PageFactory.initElements(driver, Login.class);
		lgn.Agent_Login();
		
	}
	

}
