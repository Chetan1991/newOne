package com.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(xpath="//input[@name='firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement MobileNumber;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@name='confirmpassword']")
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//*[@class=\"signupbtn btn_full btn btn-action btn-block btn-lg\"]")
	WebElement signupRegister;
	
	public RegisterPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void createuser(String firstName, String lastName, String mobileNumber, String email, String password, String confirmPassword)
	{
		System.out.println(firstName);
//		sysout
		FirstName.sendKeys(firstName);
		
	//	LastName.clear();
		LastName.sendKeys(lastName);
		
		//MobileNumber.clear();
		MobileNumber.sendKeys(mobileNumber);
		
		//Email.clear();
		Email.sendKeys(email);
		
		//Password.clear();
		Password.sendKeys(password);
		
		//ConfirmPassword.clear();
		ConfirmPassword.sendKeys(confirmPassword);
		
		signupRegister.submit();
		//return new AccountPage();
	}
}
