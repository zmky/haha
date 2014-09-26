/**
 * 
 */
/**
 * @author zm
 *
 */
package login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Browsers;
import base.BrowsersType;
import base.Do;
import base.ParseProperties;
import base.Switch;
import base.Wait;
import base.LogLoc;
import page.HomePage;
import page.LogPage;
import page.RegPage;




import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

public class Log {
	private WebDriver driver;
	private ParseProperties td;
	private HomePage homepage;
	private RegPage regpage;
	private LogPage logpage;
	private Wait wait;
	
	 public Log(WebDriver driver){
		this.driver = driver;
		wait=new Wait(driver);
		PageFactory.initElements(driver, this);
			
	}
	@BeforeClass
	public void inialize(){
	
		Browsers brower = new Browsers(BrowsersType.chrome);
		driver = brower.driver; 
		td=new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
		driver.manage().window().maximize();
		homepage= new HomePage(driver);
		regpage=new RegPage(driver);
		logpage =new LogPage(driver);
		wait =new Wait(driver);
	}
		
		
		@Test
		public void accountNull(){
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
			wait.waitFor(5000);
			logpage.submit();
			Assert.assertEquals(logpage.accountNull(), true);
		}
		
		@Test 
		public void pwdNull(){
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
			logpage.setAccount(td.getValue("accountexist"));
			logpage.submit();
			Assert.assertEquals(logpage.pwdNull(), true);
		}
		
		@Test
		public void pwdError(){
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
			logpage.setAccount(td.getValue("accountexist"));
			logpage.setPwd(td.getValue("pwdfive"));
			logpage.submit();
			Assert.assertEquals(logpage.pwdError(), true);
			
		}
		
		@Test
		public void logSuccess(){
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
			logpage.setAccount(td.getValue("accountexist"));
			logpage.setPwd(td.getValue("pwd"));
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			
			
		}
		

		@AfterClass
		public void releaseBrowser(){
			//driver.quit();
		}
	}	
