package page;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import base.ParseProperties;
import base.Wait;
import cn.xuexi.util.*;
public class HomePage {
	
	private WebDriver driver;
	Wait wait=new Wait(driver);
	private ParseProperties td;
	
	//顶部注册
	@FindBy(id="header-account-register")
	private WebElement reg;
	//顶部登录
	@FindBy(id="header-account-login")
	private WebElement login;
	//顶部昵称
	@FindBy(id="header-account-nickname")
	private WebElement nickname;
	
	@FindBy(linkText="讲一个")
	private WebElement talk;
	//定位笑话
	@FindBys(@FindBy(className="joke-list-item"))
	private List <WebElement> jokes;
		
	//所有的评论
	@FindBys(@FindBy(className="btn-icon-comment"))
	private List <WebElement> comments;
	
	@FindBys(@FindBy(className="joke-comment_header-buttons-delete"))
	private List <WebElement> commentsdel;
	//评论的亮了
	@FindBys(@FindBy(className="joke-comment_header-buttons-light"))
	private List <WebElement> light;
	
	@FindBy(linkText="发布评论")
	private WebElement commentpost;
	
	@FindBy(linkText="表情")
	private WebElement faces;
	
	//评论中所有的表情
	@FindBys(@FindBy(className="face-pane-item"))
	private List<WebElement> face;
	//评论的同时转发
	@FindBy(className="joke-comment_input-post_as_new_joke")
	private WebElement asjoke;
	//评论输入框
	@FindBy(className="joke-comment_input-inputbox")
	private WebElement commenttext;
	//评论为空等出现的错误提示	
	@FindBy(className="comment-msg")
	private WebElement commenterror;
	
	@FindBy(linkText="收藏")
	private WebElement collect;
	
	
	@FindBy(linkText="取消收藏")
	private WebElement collectcancel; 
	
	@FindBys(@FindBy(linkText="取消收藏"))
	private List <WebElement> collectcancels; 
	
	@FindBy(linkText="我的收藏")
	private WebElement fav;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void register(){
		wait.waitFor(5000);
		reg.click();
		
	}
	
	public void login(){
		wait.waitFor(5000);
		login.click();
	}
	public void openhaha(String url){
		driver.get(url);
		
	}
	
	
	 public boolean logsuccess(){
		 td=new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
		 wait.waitFor(8000);
		 String account=nickname.getText();
		 String account2=td.getValue("nickname");
		 return account.equals(account2);
	 }
	 
	 public void talk(){
		 talk.click();
	 }
	
	public String talkText(){
		WebElement joke=jokes.get(0);
		System.out.println(joke.findElement(By.className("joke-main-content-text")).getText());
		return	joke.findElement(By.className("joke-main-content-text")).getText();
					
	}
	
	public String talkTopic(){
		WebElement joke=jokes.get(0);
		System.out.println(joke.findElement(By.className("joke-list-item-topic")).getText());
		return	joke.findElement(By.className("joke-list-item-topic")).getText();
					
	}
	
	public String talkAnonymous(){
		WebElement joke=jokes.get(0);
		System.out.println(joke.findElement(By.className("joke-user-info-nickname")).getText());
		return	joke.findElement(By.className("joke-user-info-nickname")).getText();
					
	}
	
	public String talkFace(){
		 WebElement joke=jokes.get(0);
		//System.out.println(joke.findElement(By.className("word-wrap")).findElement(By.tagName("img")).getAttribute("src"));
		return	joke.findElement(By.className("joke-main-content-text")).findElement(By.tagName("img")).getAttribute("src");
					
	}
	//笑话中的图片
	public boolean talkPic(){
		WebElement joke=jokes.get(0);
		return joke.findElement(By.className("joke-main-img")).isDisplayed();
	}
	
	public boolean talkVideo(){
		WebElement joke=jokes.get(0);
		return joke.findElement(By.className("video-thumbnail")).isDisplayed();
	}
	
	public void comment(){
		WebElement comment=comments.get(0);
		comment.click();
	}
	//点击发布评论
	public void commentPost(){
		commentpost.click();
	}
	//添加表情
	 public void setFace(){
		 faces.click();
		 wait.waitFor(3000);
		 face.get(0).click();
	 }
	//点击发布评论时的同时转发
	 public void setAsJoke(){
		 asjoke.click();
	 }
	 
	 public void setComment(String comment){
		 commenttext.sendKeys(comment);
	 }
	 
	public void setReply(){
		WebElement joke=jokes.get(0);
		WebElement reply=joke.findElements(By.linkText("回复")).get(0);
		reply.click();
		}
	
	public void setCommentDel(){
		commentsdel.get(0).click();
	}
	
	public void setLight(){
		light.get(0).click();
	}
	//评论为空错误提示是否正确
	public boolean commentNull(){
		String commenterrornull=commenterror.getText();
		String commenterrornull2="评论内容不能为空，请填写内容！";
		return commenterrornull.equals(commenterrornull2);
	}
	//获取笑话的第一条评论内容
	public String commentText(){
		WebElement joke=jokes.get(0);
		WebElement commentcontent=joke.findElements(By.className("joke-comment_content")).get(0);
		System.out.println(commentcontent.getText());
		return commentcontent.getText();

	}
	
	public String commentFace(){
		WebElement joke=jokes.get(0);
		WebElement commentcontent=joke.findElements(By.className("joke-comment_content")).get(0);
		System.out.println(commentcontent.findElement(By.tagName("img")).getAttribute("src"));
		return commentcontent.findElement(By.tagName("img")).getAttribute("src");
		
	}
	

	//获取笑话的评论数
	public int commentNum(){
		WebElement joke=jokes.get(0);
		String commentnumall=joke.findElement(By.className("btn-icon-comment")).getText();
		String commentnum=commentnumall.substring(4, (commentnumall.length()-1));
		System.out.println(commentnum);
		int num;
		num=Integer.parseInt(commentnum);
		return num;
		
	}
	//获取评论的亮了数量
	public int lightNum(){
		String lightnumall=light.get(0).getText();
		String lightnum=lightnumall.substring(3, (lightnumall.length()-1));
		System.out.println(lightnum);
		int num;
		num=Integer.parseInt(lightnum);
		return num;
		
	}
	public boolean commentReply(){
		WebElement joke=jokes.get(0);
		return joke.findElement(By.className("joke-comment_header-buttons-reply")).isDisplayed();
	}
	//点击收藏
	public boolean setCollect(){		
		collect.click();
		wait.waitFor(5000);
		return collectcancel.isDisplayed();
		
	}
	
	public void setCollectCancel(){
		collectcancels.get(0).click();
		wait.waitFor(5000);
		
	}
	//进入收藏页面
	public void myFav(){
		//Actions actions=new Actions(driver);
		//actions.moveToElement(nickname).build().perform();
		//wait.waitFor(8000);
		//fav.click();
		driver.get("http://www.haha.mx/my/fav/");
		wait.waitFor(20000);
				
	}
}
