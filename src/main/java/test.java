import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class test {
	public static void main(String[] args) {
		
	
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium Material\\chromedriver_win32 (2)\\chromedriver.exe");
	
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.phptravels.net/register");
	

	WebElement FirstName =driver.findElement(By.xpath("//input[@name='firstname']"));
	FirstName.sendKeys("fsdf");
	WebElement LastName =driver.findElement(By.xpath("//input[@name='lastname']"));
	LastName.sendKeys("ffff");
	WebElement MobileNumber =driver.findElement(By.xpath("//input[@name='phone']"));
	MobileNumber.sendKeys("g");
	WebElement Email =driver.findElement(By.xpath("//input[@name='email']"));
	Email.sendKeys("fffggg@gmail.com");
	WebElement Password =driver.findElement(By.xpath("//input[@name='password']"));
	Password.sendKeys("asdasd");
	WebElement ConfirmPassword =driver.findElement(By.xpath("//input[@name='confirmpassword']"));
	
	ConfirmPassword.sendKeys("asdasd");
	WebElement signupRegister=driver.findElement(By.xpath("//*[@class=\"signupbtn btn_full btn btn-action btn-block btn-lg\"]"));
		
	signupRegister.click();
	}
	}
 