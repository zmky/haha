package report;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import cn.xuexi.util.Browsers;
import cn.xuexi.util.BrowsersType;
import page.HomePage;
import page.LogPage;
import page.RegPage;
import page.TalkPage;
import base.ParseProperties;
import base.Wait;

public class Report {
	private WebDriver driver;
	private ParseProperties td;
	private HomePage homepage;
	private RegPage regpage;
	private LogPage logpage;
	private Wait wait;
	private TalkPage talkpage;
  
  @Test
  public void reportAd() {
	  wait.waitForElementPresentByClass("joke-main-misc-report");
	  homepage.setReport();
	  wait.waitFor(5000);
	  homepage.setAd();
	  homepage.submittedText();
  }
  
  @Test
  public void reportOneHundred() {
	  wait.waitForElementPresentByClass("joke-main-misc-report");
	  homepage.setReport();
	  wait.waitFor(5000);
	  homepage.setOneHundred();
	  homepage.submittedText();
  }
  @Test
  public void reportDiscord() {
	  wait.waitForElementPresentByClass("joke-main-misc-report");
	  homepage.setReport();
	  wait.waitFor(5000);
	  homepage.setDiscord();
	  homepage.submittedText();
  }
  @Test
  public void reportOtherReason() {
	  wait.waitForElementPresentByClass("joke-main-misc-report");
	  homepage.setReport();
	  wait.waitFor(5000);
	  homepage.setOtherReason();
	  homepage.submittedText();
  }
  @BeforeClass
  public void inialize() {
	  Browsers browsers=new Browsers(BrowsersType.firefox);
	  driver=browsers.driver;
	  DOMConfigurator.configure("log4j.xml");
	  td=new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
	  driver.manage().window().maximize();
	  homepage= new HomePage(driver);
	  regpage=new RegPage(driver);
	  logpage =new LogPage(driver);
	  wait=new Wait(driver);
	  talkpage=new TalkPage(driver);
	  homepage.openhaha(td.getValue("url"));
  }

  @AfterClass
  public void afterClass() {
  }

}
