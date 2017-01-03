package praise;

import login.Login;


import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import page.HomePage;
import page.LogPage;
import page.RegPage;
import page.TalkPage;
import base.Browsers;
import base.BrowsersType;
import base.ParseProperties;
import base.Wait;
import cn.xuexi.util.*;

public class Praise {
	private WebDriver driver;
	private ParseProperties td;
	private HomePage homepage;
	private RegPage regpage;
	private LogPage logpage;
	private Wait wait;
	private TalkPage talkpage;
	//private Logger logger=Logger.getLogger(Despise.class);
	@BeforeClass
	public void inialize(){
	
		Browsers browser=new Browsers(BrowsersType.firefox);
		driver=browser.driver; 
		DOMConfigurator.configure("log4j.xml");
		td=new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
		driver.manage().window().maximize();
		homepage= new HomePage(driver);
		regpage=new RegPage(driver);
		logpage =new LogPage(driver);
		wait=new Wait(driver);
		talkpage=new TalkPage(driver);
		homepage.openhaha(td.getValue("url"));
		homepage.login();
		regpage.switchLogin();
		logpage.setAccount(td.getValue("accountexist"));
		logpage.setPwd(td.getValue("pwd"));
		logpage.submit();
		wait.waitFor(10);
		logpage.switchDefault();
		
	}


	@Test
	public void praise(){
		Log.startTestCase("praise");
		int num1=homepage.praiseNum();
		if(homepage.praiseStatus()==1){
			homepage.setPraise();
			wait.waitFor(5000);
			int num2=homepage.praiseNum();
			Assert.assertEquals(num1+1, num2);
		}else{
			homepage.setPraise();
			wait.waitFor(5000);
			int num2=homepage.praiseNum();
			Assert.assertEquals(num1, num2);
		}
		Log.endTestCase("praise");
		Log.info(DateTimeUtil.getCurrentDate());
		//logger.info("test1129");
		
	}
	
	@Test
	public void praiseOne(){
		homepage.getJokeRandom();
		wait.waitFor(6000);
		int num1=homepage.praiseNum();
		if(homepage.praiseStatus()==1){
			homepage.setPraise();
			wait.waitFor(5000);
			int num2=homepage.praiseNum();
			Assert.assertEquals(num1+1, num2);
		}else{
			homepage.setPraise();
			wait.waitFor(5000);
			int num2=homepage.praiseNum();
			Assert.assertEquals(num1, num2);
		}
	}
	@Test
	public void praisePic(){
		Log.startTestCase("praisePic");
		homepage.getPic();
		wait.waitFor(5000);
		int num1=homepage.praiseNum();
		if(homepage.praiseStatus()==1){
			homepage.setPraise();
			wait.waitFor(5000);
			int num2=homepage.praiseNum();
			Assert.assertEquals(num1+1, num2);
		}else{
			homepage.setPraise();
			wait.waitFor(5000);
			int num2=homepage.praiseNum();
			Assert.assertEquals(num1, num2);
		}
		Log.endTestCase("praisePic");		
	}
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
