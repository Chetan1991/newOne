package com.qa.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.base.TestBase;
import com.qa.pages.AccountPage;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterPage;
import com.qa.util.TestUtil;
import com.qa.util.getData;

public class RegisterPageTest extends TestBase{
	
	RegisterPage reg; 
	AccountPage account;
	String sheetName = "Sheet1";
	loginPageTest n;
	
	public RegisterPageTest() throws FileNotFoundException {
		super();
		reg = new RegisterPage();
		}
	@BeforeMethod
	public void setup(Method  method) throws IOException
	{
		initilization();
		test = extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()), method.getName());
		test.assignAuthor("Chetan");
		test.assignCategory("data pick test");
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider="getCRMTestData")
	public void createMultipleUser(String firstName, String lastName, String mobileNumber, String email, String password, String confirmPassword)
	{	
			
		//driver.get("https://www.phptravels.net/register");
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(mobileNumber);
		System.out.println(email);
		System.out.println(password);
		System.out.println(confirmPassword);
		//reg.createuser("firstName", "lastName", "mobileNumber", "email", "password", "password");
		reg.createuser(firstName, lastName, mobileNumber, email, password, confirmPassword);
	}
	/*@DataProvider
	public Iterator<Object[]> getDatafromExcel()
	{
		ArrayList<Object[]> mydata = getData.getdatexcel();
		return mydata.iterator();		
	}
	
	@Test(dataProvider="getDatafromExcel")
	public void createMultipleUser(String firstName, String lastName, String mobileNumber, String email, String password, String confirmPassword) throws Exception
	{	System.out.println("in the method");
		//n.navigateRegisterPage();
		loginObj.validateSignUp();
		
//	driver.get("https://www.phptravels.net/register");
	System.out.println("i ma onthe desired page");
	System.out.println(firstName);
	System.out.println(lastName);
	System.out.println(mobileNumber);
	System.out.println(email);
	System.out.println(password);
	System.out.println(confirmPassword);
	
	account = reg.createuser(firstName, lastName, mobileNumber, email, password, confirmPassword);
	System.out.println("Devak kalji ghe");
	}*/
	
	
	@AfterMethod
	void tearDown()
	{
		driver.quit();
		extent.flush();
		extent.endTest(test);
		extent.close();
	}
	
}

