package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.GenericFunctions.GenericFunctions;

public class Client_creation extends GenericFunctions
{

	@FindBy(xpath="//*[text()='Create New Client']")
	public static WebElement lnk_client_creation;
	
	@FindBy(xpath="//*[@id=\"InsuredOrPrincipal[InsuredOrPrincipalInfo.InsuredOrPrincipalRoleCd='Insured'].GeneralPartyInfo.NameInfo.PersonName.GivenName\"]")
	public static WebElement edi_client_firstname;
	
	@FindBy(xpath="//*[@id=\"InsuredOrPrincipal[InsuredOrPrincipalInfo.InsuredOrPrincipalRoleCd='Insured'].GeneralPartyInfo.NameInfo.PersonName.Surname\"]")
	public static WebElement edi_client_lastname;
	
	@FindBy(xpath="//*[@id=\"InsuredOrPrincipal[InsuredOrPrincipalInfo.InsuredOrPrincipalRoleCd='Insured'].GeneralPartyInfo.Addr[AddrTypeCd='StreetAddress'].DetailAddr.StreetNumber\"]")
	public static WebElement edi_client_strtnum;
	
	@FindBy(xpath="//*[@id=\"InsuredOrPrincipal[InsuredOrPrincipalInfo.InsuredOrPrincipalRoleCd='Insured'].GeneralPartyInfo.Addr[AddrTypeCd='StreetAddress'].DetailAddr.StreetName\"]")
	public static WebElement edi_client_strtname;
	
	@FindBy(xpath="//*[@id=\"InsuredOrPrincipal[InsuredOrPrincipalInfo.InsuredOrPrincipalRoleCd='Insured'].GeneralPartyInfo.Addr[AddrTypeCd='StreetAddress'].City\"]")
	public static WebElement edi_client_city;
	
	@FindBy(xpath="//*[@id=\"InsuredOrPrincipal[InsuredOrPrincipalInfo.InsuredOrPrincipalRoleCd='Insured'].GeneralPartyInfo.Addr[AddrTypeCd='StreetAddress'].StateProvCd\"]")
	public static WebElement lst_client_state;
	
	@FindBy(xpath="//*[contains(@name,'PostalCode')]")
	public static WebElement edi_client_zipcode;
	
	@FindBy(xpath="//*[@name='NEXT']")
	public static WebElement btn_client_clientcrtn;
	
	
	////////////**********auto**********//////////////
	

	@FindBy(xpath="//*[contains(text(),'Vehicle')]")
	public static WebElement lnk_client_auto;
	
	@FindBy(xpath="//*[contains(@name,'BirthDt')]")
	public static WebElement edi_client_bdate;
	
	@FindBy(xpath="//*[@name='continueButton']")
	public static WebElement btn_client_continue;
	
	@FindBy(xpath="//*[@id='PersPolicy.ContractTerm.DurationPeriod.NumUnits']")
	public static WebElement lst_client_pterm;
	
	@FindBy(xpath="//*[@id='policyType']")
	public static WebElement lst_client_ptype;
	
	@FindBy(xpath="//*[@id='PersPolicy.PersApplicationInfo.ResidenceTypeCd']")
	public static WebElement lst_client_residence;
//V_type
	@FindBy(xpath="//*[@id='PersAutoLineBusiness.PersVeh.ACIC_VehSubTypeCd']")
	public static WebElement lst_client_vhsubtype;
//Model year
	@FindBy(xpath="//*[@id='PersAutoLineBusiness.PersVeh.ModelYear']")
	public static WebElement edi_client_modelyear;

	@FindBy(xpath="//*[@id='PersAutoLineBusiness.PersVeh.Manufacturer']")
	public static WebElement lst_client_Manufacturer;
	
	@FindBy(xpath="//*[@id='PersAutoLineBusiness.PersVeh.Model']")
	public static WebElement lst_client_vhModel;
	
	@FindBy(xpath="//*[@id='assistedVehBodyTypeCd']")
	public static WebElement lst_client_vhbodyModel;

	@FindBy(xpath="//*[@id='costNew']")
	public static WebElement edi_client_vhnewcost;
	
	@FindBy(xpath="//*[@id='PersAutoLineBusiness.PersVeh.VehUseCd']")
	public static WebElement lst_client_vhusage;
	
	@FindBy(xpath="//*[@id='PersAutoLineBusiness.PersVeh.EstimatedAnnualDistance.NumUnits']")
	public static WebElement edi_client_vhannualmileage;
	
	@FindBy(xpath="//*[@id='PersAutoLineBusiness.PersVeh.OdometerReading']")
	public static WebElement edi_client_vhodmeter;
	
	@FindBy(xpath="//*[@name='continueButton2']")
	public static WebElement btn_client_continebtn2;
	
	
	public static boolean new_client()
	{
		boolean status = true;
		
		status = hoverAndClick(lnk_client_creation);
		
		String fname = getdata("client_data", "First_name", 1);
		status = setdata(edi_client_firstname, fname);
				
		String lname = getdata("client_data", "Last_name", 1);
		status = setdata(edi_client_lastname, lname);
		
		String stnum = getdata("client_data", "Street_number", 1);
		status = setdata(edi_client_strtnum, stnum);
		
		String stname = getdata("client_data", "Stree_name", 1);
		status = setdata(edi_client_strtname, stname);
		
		String city = getdata("client_data", "City", 1);
		status = setdata(edi_client_city, city);
		
		String state = getdata("client_data", "State", 1);
		status = selectdropdown(lst_client_state, state);
		
		String zipcode = getdata("client_data", "Zip_code", 1);
		status = setdata(edi_client_zipcode, zipcode);
		System.out.println(zipcode);
		
		status = hoverAndClick(btn_client_clientcrtn);
		
		
		return status;
		
	}
	
	/////***********************?????????????????*************************////
	
	public static boolean Auto_vehicle()
	{
		boolean status = true;
		status = hoverAndClick(lnk_client_auto);
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
		
		String Bdate = getdata("client_data", "DOB", 1);
		status = setdata(edi_client_bdate, Bdate);
		
		status = hoverAndClick(btn_client_continue);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		String pterm  = getdata("client_data", "Policy_Term", 1);
		status  = selectdropdown(lst_client_pterm, pterm);
		
		String ptype = getdata("client_data", "Policy_Type", 1);
		status  = selectdropdown(lst_client_ptype, ptype);
		
		String residence  = getdata("client_data", "Residence_Type", 1);
		status  = selectdropdown(lst_client_residence, residence);
		
		status = hoverAndClick(btn_client_continue);
		driver.switchTo().window(window);
		
		String vsubtype = getdata("client_data", "Vh_subtype", 1);
		status  = selectdropdown(lst_client_vhsubtype, vsubtype);
		
		String vhmyear = getdata("client_data", "Vh_modelyear", 1);
		status  = setdata(edi_client_modelyear, vhmyear);
		
		String vmnftr = getdata("client_data", "Manufacturer", 1);
		status  = selectdropdown(lst_client_Manufacturer, vmnftr);
		
		String VhModel = getdata("client_data", "Vh_Model", 1);
		status  = selectdropdown(lst_client_vhModel, VhModel);
		
		String vhbody = getdata("client_data", "Vh_Body", 1);
		status  = selectdropdown(lst_client_vhbodyModel, vhbody);
		
		String vcost = getdata("client_data", "Cost_new", 1);
		status  = selectdropdown(lst_client_vhsubtype, vcost);
		
		String vusage = getdata("client_data", "Vh_Usage", 1);
		status  = selectdropdown(lst_client_vhusage, vusage);
		
		String vamilege = getdata("client_data", "Annual_milege", 1);
		status  = selectdropdown(edi_client_vhannualmileage, vamilege);
		
		String vometer = getdata("client_data", "Odo_meter", 1);
		status  = selectdropdown(edi_client_vhodmeter, vometer);
		
		status = hoverAndClick(btn_client_continebtn2);
		return status;
	}
	
	
	
	
}
