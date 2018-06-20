package com.qa.tests;


import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterPage;
import com.relevantcodes.extentreports.LogStatus;

public class loginPageTest extends TestBase {
	
	LoginPage loginObj;
	UserLogInPageTest userObj;
	RegisterPage register;
	
	loginPageTest() throws Exception
	{
		super();
		
		
	}
	@BeforeMethod
	public void setup(Method  method) throws IOException
	{
		initilization();
		test = extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()), method.getName());
		test.assignAuthor("Chetan");
		test.assignCategory("Sanity test");
		loginObj = new LoginPage();
		
	}
	@Test(priority=2)
	public void putVal()
	{
		String un = prop.getProperty("un");
		String pw = prop.getProperty("pw");
		loginObj.setValueUserName(un);
		loginObj.setValuePassword(pw);
		test.log(LogStatus.PASS, "username and password entered successfully");

	}
	@Test(priority=1)
	public void loginValidate()
	{
		String un = prop.getProperty("un");
		String pw = prop.getProperty("pw");
		loginObj.setValueUserName(un);
		loginObj.setValuePassword(pw);
		userObj= loginObj.login();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.PASS, "login successfully");
	
	}
	@Test(priority=0)
	public void navigateRegisterPage()
	{
		try {
			loginObj.validateSignUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	void tearDown()
	{
		driver.quit();
		extent.flush();
		extent.endTest(test);
		extent.close();
	}
	
}
