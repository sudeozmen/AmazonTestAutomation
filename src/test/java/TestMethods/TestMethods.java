package TestMethods;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Objects.LoginPage;
import Objects.SearchPage;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class TestMethods {

	
	WebDriver driver;
	SearchPage object;
	String signedInPageUrl;
	
	@Before
	public void beforeTest() throws Exception  {
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		driver.get("https://www.amazon.com.tr/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.tr%2F%3F%26tag%3Dtrtxtgoabkde-21%26ref%3Dnav_signin%26adgrpid%3D154611856018%26hvpone%3D%26hvptwo%3D%26hvadid%3D674177764078%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D1149421966730852694%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D1012786%26hvtargid%3Dkwd-10573980%26hydadcr%3D12932_2354400%26language%3Dtr_TR&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=trflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	    driver.manage().window().maximize();
	    object = new SearchPage(driver);
	    Thread.sleep(3000);
	}
	
	
	@Test	
	public void Test() {
		SignInOperation();
		SearchOperation();
		SortingOperation();
		AddToCartOperation();
	}
	public void SignInOperation() {
		LoginPage page= new LoginPage(driver);
		page.SignIn("username", "password");
	}

	public void SearchOperation() {
		object.Search("iphone 12");
	}

	public void SortingOperation(){
		object.Sorting();
	}

	public void AddToCartOperation() {
		object.Add();
	}
	
	@After
	public void afterTest(){
		driver.quit();
	}
	
}
