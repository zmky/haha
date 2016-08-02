/**
 * 
 */
/**
 * @author zm
 *
 */
package comment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browsers;
import base.BrowsersType;
import base.DateTimeUtil;
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
public class Comment {
	private WebDriver driver;
	private ParseProperties td;
	private HomePage homepage;
	private RegPage regpage;
	private LogPage logpage;
	private Wait wait;
	private Log log;
	private TalkPage talkpage;

	//@BeforeClass
	@BeforeMethod
	public void inialize(){
		Browsers brower = new Browsers(BrowsersType.chrome);
		driver = brower.driver; 
		td=new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
		//td=new ParseProperties(System.getProperty("user.dir")+da);
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
	public void commentNull(){
		homepage.comment();
		wait.waitFor(5000);
		homepage.commentPost();
		//wait.waitFor(1000);
		wait.waitForElementPresentByClass("comment-msg");
		Assert.assertEquals(homepage.commentNull(), true);
	}
	
	@Test 
	public void comment(){
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		String layout = "yyyyMMddHHmmss";
//		sdf.applyPattern(layout);//// 调用SimpleDateFormat的applyPattern(String pattern)方法用新创建的日期格式表达式替换其原有的   
//		
//		Calendar cl = Calendar.getInstance();//默认是当前日期
		
		String talktext =DateTimeUtil.getCurrentDateTime();
		int num1=homepage.commentNum();
		homepage.comment();
		wait.waitFor(5000);
		homepage.setComment(talktext);
		homepage.commentPost();
		wait.waitFor(8000);
		int num2=homepage.commentNum();
		Assert.assertEquals(homepage.commentText(), talktext);
		Assert.assertEquals(num1+1, num2);
	}
	
	@Test
	public void commentFace(){
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		String layout = "yyyyMMddHHmmss";
//		sdf.applyPattern(layout);//// 调用SimpleDateFormat的applyPattern(String pattern)方法用新创建的日期格式表达式替换其原有的   
//		
//		Calendar cl = Calendar.getInstance();//默认是当前日期
//		String talktext = sdf.format(cl.getTime());
		String talktext =DateTimeUtil.getCurrentDateTime();
		int num1=homepage.commentNum();
		homepage.comment();
		wait.waitFor(5000);
		homepage.setComment(talktext);
		homepage.setFace();
		homepage.commentPost();
		wait.waitFor(8000);
		int num2=homepage.commentNum();
		Assert.assertEquals(num1+1, num2);
		Assert.assertEquals(homepage.commentText(), talktext);
		Assert.assertEquals(homepage.commentFace(), td.getValue("facesrc"));
	}
	
	@Test 
	public void commentAsJoke(){
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		String layout = "yyyyMMddHHmmss";
//		sdf.applyPattern(layout);//// 调用SimpleDateFormat的applyPattern(String pattern)方法用新创建的日期格式表达式替换其原有的   
//		
//		Calendar cl = Calendar.getInstance();//默认是当前日期
//		
//		String talktext = sdf.format(cl.getTime());
		String talktext =DateTimeUtil.getCurrentDateTime();
		int num1=homepage.commentNum();
		homepage.comment();
		wait.waitFor(5000);
		homepage.setComment(talktext);
		homepage.setAsJoke();
		homepage.commentPost();
		wait.waitFor(8000);
		int num2=homepage.commentNum();
		Assert.assertEquals(num1+1, num2);
		Assert.assertEquals(homepage.commentText(), talktext);
		driver.get("http://www.haha.mx/new");
		wait.waitFor(5000);
		Assert.assertEquals(homepage.talkText(), talktext);

	}
	
	
	@Test 
	public void commentSensitive(){
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		String layout = "yyyyMMddHHmmss";
//		sdf.applyPattern(layout);//// 调用SimpleDateFormat的applyPattern(String pattern)方法用新创建的日期格式表达式替换其原有的   
//		
//		Calendar cl = Calendar.getInstance();//默认是当前日期
//		
//		String talktext = sdf.format(cl.getTime());
		String talktext=DateTimeUtil.getCurrentDateTime();
		int num1=homepage.commentNum();
		homepage.comment();
		wait.waitFor(5000);
		homepage.setComment(talktext+"kfc");
		homepage.commentPost();
		wait.waitFor(8000);
		int num2=homepage.commentNum();
		Assert.assertEquals(num1+1, num2);
		Assert.assertEquals(homepage.commentText(), talktext+"***");
	}
	
	@Test
	public void commentReply(){
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		String layout = "yyyyMMddHHmmss";
//		sdf.applyPattern(layout);//// 调用SimpleDateFormat的applyPattern(String pattern)方法用新创建的日期格式表达式替换其原有的   
//		
//		Calendar cl = Calendar.getInstance();//默认是当前日期
//		
//		String talktext = sdf.format(cl.getTime());
		String talktext =DateTimeUtil.getCurrentDateTime();
		int num1=homepage.commentNum();
		homepage.comment();
		wait.waitFor(5000);
		homepage.setReply();
		homepage.setComment(talktext);
		homepage.commentPost();
		wait.waitFor(8000);
		int num2=homepage.commentNum();
		Assert.assertEquals(num1+1, num2);
		Assert.assertEquals(homepage.commentReply(), true);
	}
	
	@Test
	public void commentLight(){

		homepage.comment();
		wait.waitFor(5000);
		int num1=homepage.lightNum();
		homepage.setLight();
		wait.waitFor(8000);
		int num2=homepage.lightNum();
		Assert.assertEquals(num1+1, num2);
	}
	
	@Test
	public void commentDel(){
		homepage.comment();
		wait.waitFor(5000);
		int num1=homepage.commentNum();
		homepage.setCommentDel();
		wait.waitFor(8000);
		int num2=homepage.commentNum();
		Assert.assertEquals(num1-1, num2);
	}
	@AfterMethod
	public void releaseBrowser(){
		driver.quit();
	}

}
