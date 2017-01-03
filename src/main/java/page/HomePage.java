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
	private ParseProperties td=new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");;
	
	
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
	
	//第一个称赞
	@FindBy(xpath="//a[@title='称赞']")
	private WebElement praise;
	
	//第一个鄙视
	@FindBy(xpath="//a[@title='鄙视']")
	private WebElement despise;
	
	//第一个举报
	@FindBy(className="joke-main-misc-report")
	private WebElement report;
	
	//举报菜单中的广告
	@FindBy(xpath="//a[text()='广告']")
	private WebElement ad;
	//举报菜单中的看过100遍了
	@FindBy(xpath="//a[text()='看过100遍了']")
	private WebElement onehundred;
	//举报菜单中的内容不和谐
	@FindBy(xpath="//a[text()='内容不和谐']")
	private WebElement discord;
	//举报菜单中的其他原因
	@FindBy(xpath="//a[text()='其他原因']")
	private WebElement otherreason;
	//举报后弹窗的文字
	@FindBy(xpath="//h3[text()='已提交！']")
	private WebElement submitted;
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
	//driver.get到随机的单个笑话页面
	public void getJokeRandom(){
		System.out.println(jokes.size()-1);
		WebElement joke=jokes.get(RandomUtil.getRandomNumber(0, (jokes.size()-1)));
		String jid=joke.getAttribute("jid");
		String link="http://www.haha.mx/joke/"+jid;
		System.out.println(link);
		driver.get(link);
	}
	//进入到图片页面
	public void getPic(){
		driver.get(td.getValue("picUrl"));
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
	
	public void setPraise(){
		praise.click();
	}
	
	public void setDespise(){
		despise.click();
	}
	//鼠标移动到举报
	public void setReport(){
		Actions actions=new Actions(driver);
		actions.moveToElement(report).build().perform();
	}
	
	//点击广告
	public void setAd(){
		ad.click();
	}
	//点击看过100遍了
	public void setOneHundred(){
		onehundred.click();
	}
	//点击内容不和谐
	public void setDiscord(){
		discord.click();
	}
	//点击其他原因
	public void setOtherReason(){
		otherreason.click();
		
	}
	//判断是否存在文字已提交
	public boolean submittedText(){
		return submitted.isDisplayed();
	}
	//返回称赞数量
	public int praiseNum(){
		String praisenum=praise.getText();
		int num=Integer.parseInt(praisenum);
		System.out.println(num);
		return num;
	}
	
	//返回鄙视数量
	public int despiseNum(){
		String despisenum=despise.getText();
		int num=Integer.parseInt(despisenum);
		System.out.println(num);
		return num;
	}
	//判断称赞是否可点击
	public int praiseStatus(){
		System.out.println(praise.getAttribute("class"));
		System.out.println(td.getValue("good"));
		//在编程中，通常比较两个字符串是否相同的表达式是“==” ，但在 Java 中不能这么写。在 Java 中，如果要比较 a 字符串是否等于 b 字符串，需要这么写： if(a.equals(b)){ } 返回 true 或 false equals()方法 方法 String 的 equals()方法用于比较两个字符串是否相等。由于字符串是对象类型，所以不能 简单的用“==” （双等号）判断两个字符串是否相等，而使用 equals()方法比较两个对象的内 容。
		if(praise.getAttribute("class").equals(td.getValue("good"))){
			return 1;
		}else{
			return 0;
		}
	}
	
	//判断鄙视是否可点击
	public int despiseStatus(){
		System.out.println(despise.getAttribute("class"));
		System.out.println(td.getValue("bad"));
		//在编程中，通常比较两个字符串是否相同的表达式是“==” ，但在 Java 中不能这么写。在 Java 中，如果要比较 a 字符串是否等于 b 字符串，需要这么写： if(a.equals(b)){ } 返回 true 或 false equals()方法 方法 String 的 equals()方法用于比较两个字符串是否相等。由于字符串是对象类型，所以不能 简单的用“==” （双等号）判断两个字符串是否相等，而使用 equals()方法比较两个对象的内 容。
		if(despise.getAttribute("class").equals(td.getValue("bad"))){
			return 1;
		}else{
			return 0;
		}
	}
}
