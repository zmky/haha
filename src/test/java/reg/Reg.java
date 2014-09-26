/**
 * 
 */
/**
 * @author zm
 *
 */
package reg;

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
import base.ParseProperties;
import base.Switch;
import base.Wait;
import base.RegLoc;
import page.HomePage;
import page.RegPage;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

public class Reg {
		private WebDriver driver;
		private ParseProperties td;
		private HomePage homepage;
		private RegPage regpage;
		private Wait wait;
		
		@BeforeClass
		public void inialize(){
		
			Browsers brower = new Browsers(BrowsersType.chrome);
			driver = brower.driver; 
			td=new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
			driver.manage().window().maximize();
			homepage= new HomePage(driver);
			regpage=new RegPage(driver);
			wait =new Wait(driver);
		}	
		
		@Test
		public void regAccountExist(){
			homepage.openhaha(td.getValue("url"));
			homepage.register();
			regpage.switchLogin();
			regpage.setAccount(td.getValue("accountexist"));
			regpage.submit();
			Assert.assertEquals(regpage.accountErrorExist(), true);
			
		}
		
		@Test
		public void regAccountFormat(){
			homepage.openhaha(td.getValue("url"));
			homepage.register();
			regpage.switchLogin();
			regpage.setAccount(td.getValue("accountformat"));
			regpage.submit();
			Assert.assertEquals(regpage.accountErrorFormat(), true);
			
		}
		
		@Test 
		public void regPwdError(){
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			
			Calendar cl = Calendar.getInstance();
			
			String accountname = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.register();
			regpage.switchLogin();
			regpage.setAccount(accountname+"@zm.cn");
			regpage.setPwd(td.getValue("pwdfive"));
			regpage.submit();
			Assert.assertEquals(regpage.pwdError(), true);
			
			
		}
		
		
		@Test 
		public void regNicknameError(){
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			
			Calendar cl = Calendar.getInstance();
			
			String accountname = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.register();
			regpage.switchLogin();
			regpage.setAccount(accountname+"@zm.cn");
			regpage.setPwd(td.getValue("pwd"));
			regpage.setNickname(td.getValue("nicknameexist"));
			regpage.submit();
			Assert.assertEquals(regpage.nickErrorExist(), true);
			
			
		}
		
		
		@Test 
		public void regSuccess(){
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			
			Calendar cl = Calendar.getInstance();
			
			String accountname = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.register();
			regpage.switchLogin();
			regpage.setAccount(accountname+"@zm.cn");
			regpage.setPwd(td.getValue("pwd"));
			regpage.setNickname(accountname);
			regpage.submit();
			wait.waitFor(8000);
			Assert.assertEquals(regpage.getWebElement(RegLoc.regsuc, accountname).isDisplayed(), true);
			
			
		}
		@AfterClass
		public void releaseBrowser(){
			//driver.quit();
		}
		
}

