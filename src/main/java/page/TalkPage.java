package page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import base.Do;
import base.LogLoc;
import base.ParseProperties;
import base.RegLoc;
import base.TalkLoc;
import base.Wait; 

public class TalkPage {
	 private WebDriver driver;
	 private Wait wait;
	 private Do du;
	 private ParseProperties td;
	 
	 @FindBy(id="joke-add-sharing-text")
	 private WebElement talktext;
	 
	 @FindBy(linkText="表情")
	 private WebElement faces;
	 //所有的表情
	 @FindBys(@FindBy(className="face-pane-item"))
	 private List<WebElement> face;
	 
	 @FindBy(className="webuploader-pick")
	 private WebElement pic;
	 
	 @FindBy(className="images-add-web")
	 private WebElement picw;
	 
	 
	 @FindBy(className="images-add-url")
	 private WebElement filetext;
	 
	 @FindBy(linkText="确定")
	 private WebElement confirm;
	 //添加视频功能已取消
//	 @FindBy(id="add-video")
//	 private WebElement video;
	 
	 @FindBys(@FindBy(className="joke-add-sharing-topic-item"))
		private List<WebElement> topics;
	 
	 @FindBy(className="joke-add-sharing-topic-input")
	 private WebElement topictext;
	 
	 @FindBy(name="anonymous")
	 private WebElement anonymous;
	 
	 @FindBy(id="joke-add-sharing-submit")
	 private WebElement submit;
	
	 @FindBy(id="joke-add-sharing-error")
	 private WebElement error;
	 
	 public TalkPage(WebDriver driver){
		this.driver = driver;
		wait=new Wait(driver);
		du = new Do(driver);
		PageFactory.initElements(driver, this);
			
	}
	 
	 public void setText(String content){
		 talktext.sendKeys(content);
	 }
	 
	 public void setFace(){
		 faces.click();
		 wait.waitFor(3000);
		 face.get(0).click();
	 }
	 
	 public void setPic(){
		 pic.click();
		 try{
			 Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\tool\\flash.exe");
			 wait.waitFor(8000);
		 } catch (IOException e){
			// TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 
	 }
	public void setPicw(){
		picw.click();
		filetext.clear();
		filetext.sendKeys("http://p3.qqgexing.com/touxiang/20120901/1926/5041f0d047f70.jpg");
		confirm.click();
		wait.waitFor(8000);
	}
	
//	public void setVideo(){
//		video.click();
//		filetext.clear();
//		filetext.sendKeys("http://v.youku.com/v_show/id_XNzg4NDEyNDQw.html");
//		confirm.click();
//		wait.waitFor(8000);
//	}

	public void setAnonymous(){
		anonymous.click();
	}
	
	public void setTopic(){
		topics.get(0).click();
	}
	
	public void setTopicOther(String topic){
		topictext.sendKeys(topic);
	}
	
	public void submit(){
		submit.click();
		wait.waitFor(15000);
	}
	
	public boolean errorNull(){
		wait.waitForElementPresent(TalkLoc.error);
//		wait.waitFor(1000);
//		String errornull=error.getText();
//		System.out.println(errornull);
//		String errornull2="请输入内容正文";
//		System.out.println(errornull2);
		return error.isDisplayed();
	}
	
}
