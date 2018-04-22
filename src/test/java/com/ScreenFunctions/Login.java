package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Login extends GenericFunctions{
	
	// ****************************  Login Panel Section Object  *********************************
	
	
//User Name	
	@FindBy(xpath="//input[@id='j_username']")
	
		public static WebElement edi_Login_Agent_Username;
	
//Password	
	@FindBy(xpath="//input[@id='j_password']")
	
		public static WebElement edi_Login_Agent_password;
	
	
//Login Button
	@FindBy(xpath="//input[@id='NEXT']")
		
		public static WebElement btn_Login_agntsignin;	
	
	
	
	public static boolean Agent_Login()
	{
		boolean status = true;
		
		//enter Username
		String username = getCommontestdata("Agent_username");
		status = setdata(edi_Login_Agent_Username, username);
		
		//enter Password
		String password = getCommontestdata("Agent_password");
		status = setdata(edi_Login_Agent_password, password);
				
		//Login
		status = hoverAndClick(btn_Login_agntsignin);
		
		return status;		
	}


}
