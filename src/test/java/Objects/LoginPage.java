package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	

	public void SignIn(String mail,String password) {
		WebElement mailBox=driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		WebElement mailcontinue=driver.findElement(By.xpath("//*[@id=\"continue\"]/span"));
		   try {
	            Thread.sleep(2000); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		   
		mailBox.sendKeys(mail);
		mailcontinue.click();
		WebElement passwordBox=driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		WebElement signIn=driver.findElement(By.xpath("//*[@id=\"auth-signin-button\"]/span"));
		
		passwordBox.sendKeys(password);
		signIn.click();
	}
	
}
