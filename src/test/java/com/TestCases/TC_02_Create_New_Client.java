package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Client_creation;
import com.ScreenFunctions.Login;

public class TC_02_Create_New_Client extends GenericFunctions
{
	@Test
	public static void Create_New_Client()
	{
		
		//step1:
		launchApplication("firefox");
		//step2:
		Login lgn = PageFactory.initElements(driver, Login.class);
		lgn.Agent_Login();
				
		Client_creation crtn = PageFactory.initElements(driver, Client_creation.class);
		crtn.new_client();
		crtn.Auto_vehicle();
		
		
	
	}
	
	
}
