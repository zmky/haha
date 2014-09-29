/**
 * 
 */
/**
 * @author zm
 *
 */
package talk;
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
import base.LogLoc;
import page.HomePage;
import page.LogPage;
import page.RegPage;
import login.Log;
import page.TalkPage;




import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

public class Talk {
	private WebDriver driver;
	private ParseProperties td;
	private HomePage homepage;
	private RegPage regpage;
	private LogPage logpage;
	private Wait wait;
	private Log log;
	private TalkPage talkpage;
	
	@BeforeClass
	public void inialize(){
	
		Browsers brower = new Browsers(BrowsersType.chrome);
		driver = brower.driver; 
		td=new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
		driver.manage().window().maximize();
		homepage= new HomePage(driver);
		regpage=new RegPage(driver);
		logpage =new LogPage(driver);
		wait=new Wait(driver);
		talkpage=new TalkPage(driver);
	}
		
		
		@Test
		public void talkNull(){
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
			logpage.setAccount(td.getValue("accountexist"));
			logpage.setPwd(td.getValue("pwd"));
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			wait.waitFor(8000);
			homepage.talk();
			wait.waitFor(8000);
			talkpage.submit();
			Assert.assertEquals(talkpage.errorNull(), true);
		
		}
		
		@Test
		public void talk(){
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);//// 调用SimpleDateFormat的applyPattern(String pattern)方法用新创建的日期格式表达式替换其原有的   
			
			Calendar cl = Calendar.getInstance();//默认是当前日期
			
			String talktext = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
//			logpage.setAccount(td.getValue("accountexist"));
//			logpage.setPwd(td.getValue("pwd"));
			logpage.setAccount("zmm@520.com");
			logpage.setPwd("111111");
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			wait.waitFor(8000);
			homepage.talk();
			wait.waitFor(8000);
			talkpage.setText(talktext);
			talkpage.submit();
			Assert.assertEquals(homepage.talkText(), talktext);
		
		}
		
		@Test
		public void talkTopic(){
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			Calendar cl = Calendar.getInstance();
			
			String talktext = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
//			logpage.setAccount(td.getValue("accountexist"));
//			logpage.setPwd(td.getValue("pwd"));
			logpage.setAccount("zmm@520.com");
			logpage.setPwd("111111");
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			wait.waitFor(8000);
			homepage.talk();
			wait.waitFor(8000);
			talkpage.setText(talktext);
			talkpage.setTopic();
			talkpage.submit();
			Assert.assertEquals(homepage.talkText(), talktext);
			Assert.assertEquals(homepage.talkTopic(), td.getValue("topic"));
		
		}
		
		@Test
		public void talkTopicOther(){
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			Calendar cl = Calendar.getInstance();
			
			String talktext = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
//			logpage.setAccount(td.getValue("accountexist"));
//			logpage.setPwd(td.getValue("pwd"));
			logpage.setAccount("zmm@520.com");
			logpage.setPwd("111111");
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			wait.waitFor(8000);
			homepage.talk();
			wait.waitFor(8000);
			talkpage.setText(talktext);
			talkpage.setTopicOther(td.getValue("topicz"));
			talkpage.submit();
			Assert.assertEquals(homepage.talkText(), talktext);
			Assert.assertEquals(homepage.talkTopic(), td.getValue("topicz"));
		
		}
		
		
		@Test
		public void talkAnonymous(){
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			Calendar cl = Calendar.getInstance();
			
			String talktext = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
//			logpage.setAccount(td.getValue("accountexist"));
//			logpage.setPwd(td.getValue("pwd"));
			logpage.setAccount("zmm@520.com");
			logpage.setPwd("111111");
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			wait.waitFor(8000);
			homepage.talk();
			wait.waitFor(8000);
			talkpage.setText(talktext);
			talkpage.setTopicOther(td.getValue("topicz"));
			talkpage.submit();
			Assert.assertEquals(homepage.talkText(), talktext);
			Assert.assertEquals(homepage.talkAnonymous(), td.getValue("anonymous"));
				
		}
		
		@Test
		public void talkFace(){
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			Calendar cl = Calendar.getInstance();
			
			String talktext = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
//			logpage.setAccount(td.getValue("accountexist"));
//			logpage.setPwd(td.getValue("pwd"));
			logpage.setAccount("zmm@520.com");
			logpage.setPwd("111111");
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			wait.waitFor(8000);
			homepage.talk();
			wait.waitFor(8000);
			talkpage.setText(talktext);
			talkpage.setFace();
			talkpage.submit();
			Assert.assertEquals(homepage.talkText(), talktext);
			Assert.assertEquals(homepage.talkFace(),td.getValue("facesrc"));
				
		}
		
		@Test
		public void talkPic(){
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			Calendar cl = Calendar.getInstance();
			
			String talktext = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
//			logpage.setAccount(td.getValue("accountexist"));
//			logpage.setPwd(td.getValue("pwd"));
			logpage.setAccount("zmm@520.com");
			logpage.setPwd("111111");
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			wait.waitFor(8000);
			homepage.talk();
			wait.waitFor(8000);
			talkpage.setText(talktext);
			talkpage.setPic();
			talkpage.submit();
			Assert.assertEquals(homepage.talkText(), talktext);
			Assert.assertEquals(homepage.talkPic(),true);
				
		}
		
		@Test
		public void talkPicw(){
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			Calendar cl = Calendar.getInstance();
			
			String talktext = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
//			logpage.setAccount(td.getValue("accountexist"));
//			logpage.setPwd(td.getValue("pwd"));
			logpage.setAccount("zmm@520.com");
			logpage.setPwd("111111");
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			wait.waitFor(8000);
			homepage.talk();
			wait.waitFor(8000);
			talkpage.setText(talktext);
			talkpage.setPicw();
			talkpage.submit();
			Assert.assertEquals(homepage.talkText(), talktext);
			Assert.assertEquals(homepage.talkPic(),true);
				
		}
		
		@Test
		public void talkVideo(){
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			String layout = "yyyyMMddHHmmss";
			sdf.applyPattern(layout);
			Calendar cl = Calendar.getInstance();
			
			String talktext = sdf.format(cl.getTime());
			
			homepage.openhaha(td.getValue("url"));
			homepage.login();
			regpage.switchLogin();
//			logpage.setAccount(td.getValue("accountexist"));
//			logpage.setPwd(td.getValue("pwd"));
			logpage.setAccount("zmm@520.com");
			logpage.setPwd("111111");
			logpage.submit();
			Assert.assertEquals(homepage.logsuccess(), true);
			wait.waitFor(8000);
			homepage.talk();
			wait.waitFor(8000);
			talkpage.setText(talktext);
			talkpage.setVideo();
			talkpage.submit();
			Assert.assertEquals(homepage.talkText(), talktext);
			Assert.assertEquals(homepage.talkVideo(),true);
				
		}
		@AfterClass
		public void releaseBrowser(){
			//driver.quit();
		}
	}	

