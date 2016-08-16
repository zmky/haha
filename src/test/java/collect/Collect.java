/**
 * 
 */
/**
 * @author zm
 *
 */
package collect;
import junit.framework.Assert;

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
public class Collect{
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
	
		Browsers brower = new Browsers(BrowsersType.ie);
		driver = brower.driver; 
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
		Assert.assertEquals(homepage.logsuccess(), true);
	}
	
	@Test
	public void collect(){
		String joketext1=homepage.talkText();
		Assert.assertEquals(homepage.setCollect(), true);
		homepage.myFav();
		String joketext2=homepage.talkText();
		Assert.assertEquals(joketext1, joketext2);	

	}
	
	
	@Test
	public void collectCancel(){
		//driver.get("http://www.haha.mx/my/fav/");
		homepage.myFav();
		String joketext1=homepage.talkText();
		wait.waitFor(5000);
		homepage.setCollectCancel();
		homepage.myFav();
		//homepage.openhaha(td.getValue("url"));
		wait.waitFor(6000);
		String joketext2=homepage.talkText();
		Assert.assertEquals(joketext1.equals(joketext2),false);
	}
	
	@AfterClass
	public void releaseBrowser(){
		driver.quit();
	}
	
	
	
}
