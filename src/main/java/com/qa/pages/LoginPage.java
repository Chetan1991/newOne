package com.qa.pages;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;
import com.qa.tests.UserLogInPageTest;

public class LoginPage extends TestBase{
	//username
	@FindBy(xpath="//*[@name='username']")
	WebElement userName;
	
	//password
	@FindBy(xpath="//*[@name='password']")
	WebElement passWord;
	
	//Remember me
	@FindBy(id="remember-me")
	WebElement rememberMe;
	
	//SignUp
	@FindBy(xpath="//*[@class=\"btn btn-default btn-block form-group\"]")
	WebElement signUp;
	
	// Forgot password 
	@FindBy(xpath="//*[@class='btn btn-default btn-block']")
	WebElement forgotPassword;
	
	//login
	@FindBy(xpath="//*[@class=\"btn btn-action btn-lg btn-block loginbtn\"]")
	WebElement login;
	
	//Method-1 
	public LoginPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	//Method-2
	public void setValueUserName(String un)
	{
		userName.clear();
		userName.sendKeys(un);
	}
	//Method-3
	public void setValuePassword(String pw)
	{
		passWord.clear();
		passWord.sendKeys(pw);
	}
	//Method-4
	public UserLogInPageTest login()
	{
		if(rememberMe.isSelected())
		{
			login.click();
		}
		else
		{
			rememberMe.click();
			login.click();
		}
		
		return new UserLogInPageTest();
	}
	//Method-5
	public void validateSignUp() throws Exception
	{
		if(signUp.isEnabled())
		{
			signUp.click();
		}
		else
		{
			System.out.println("The sign is button is not available");
		}
		//return new RegisterPage();
	}
	
}
