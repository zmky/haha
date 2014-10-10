package page;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import base.ParseProperties;
import base.Wait;

public class HomePage {
	
	private WebDriver driver;
	Wait wait=new Wait(driver);
	private ParseProperties td;
	
	
	@FindBy(id="btn-regist")
	private WebElement reg;
	
	@FindBy(id="btn-login")
	private WebElement login;
	
	@FindBy(id="nickname")
	private WebElement nickname;
	
	@FindBy(linkText="讲一个")
	private WebElement talk;
	
	@FindBys(@FindBy(className="joke-item"))
	private List <WebElement> jokes;
	
	
	
	@FindBys(@FindBy(className="comment"))
	private List <WebElement> comments;
	
	@FindBys(@FindBy(className="btn-del"))
	private List <WebElement> commentsdel;
	
	@FindBys(@FindBy(className="light"))
	private List <WebElement> light;
	
	@FindBy(linkText="发布评论")
	private WebElement commentpost;
	
	@FindBy(linkText="表情")
	private WebElement faces;
	
	@FindBy(xpath="//ul[@id='face-content']/descendant::a[1]")
	private WebElement face;
	
	@FindBy(name="as_joke")
	private WebElement asjoke;
	
	@FindBy(name="comment-input")
	private WebElement commenttext;
		
	@FindBy(className="comment-msg")
	private WebElement commenterror;
	
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
		//System.out.println(joke.findElement(By.className("word-wrap")).getText());
		return	joke.findElement(By.className("word-wrap")).getText();
					
	}
	
	public String talkTopic(){
		WebElement joke=jokes.get(0);
		System.out.println(joke.findElement(By.className("btn-topic")).getText());
		return	joke.findElement(By.className("btn-topic")).getText();
					
	}
	
	public String talkAnonymous(){
		WebElement joke=jokes.get(0);
		System.out.println(joke.findElement(By.className("nickname")).getText());
		return	joke.findElement(By.className("nickname")).getText();
					
	}
	
	public String talkFace(){
		 WebElement joke=jokes.get(0);
		//System.out.println(joke.findElement(By.className("word-wrap")).findElement(By.tagName("img")).getAttribute("src"));
		return	joke.findElement(By.className("word-wrap")).findElement(By.tagName("img")).getAttribute("src");
					
	}
	
	public boolean talkPic(){
		WebElement joke=jokes.get(0);
		return joke.findElement(By.className("thumbnail")).isDisplayed();
	}
	
	public boolean talkVideo(){
		WebElement joke=jokes.get(0);
		return joke.findElement(By.className("video-thumbnail")).isDisplayed();
	}
	
	public void comment(){
		WebElement comment=comments.get(0);
		comment.click();
	}
	
	public void commentPost(){
		commentpost.click();
	}
	
	 public void setFace(){
		 faces.click();
		 wait.waitFor(3000);
		 face.click();
	 }
	
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
	public boolean commentNull(){
		String commenterrornull=commenterror.getText();
		String commenterrornull2="评论内容不能为空，请填写内容！";
		return commenterrornull.equals(commenterrornull2);
	}
	
	public String commentText(){
		WebElement joke=jokes.get(0);
		WebElement commentcontent=joke.findElements(By.className("word-wrap")).get(1);
		return commentcontent.getText();

	}
	
	public String commentFace(){
		WebElement joke=jokes.get(0);
		WebElement commentcontent=joke.findElements(By.className("word-wrap")).get(1);
		return commentcontent.findElement(By.tagName("img")).getAttribute("src");
	}
	


	public int commentNum(){
		WebElement joke=jokes.get(0);
		String commentnumall=joke.findElement(By.className("comment")).getText();
		String commentnum=commentnumall.substring(3, (commentnumall.length()-1));
		System.out.println(commentnum);
		int num;
		num=Integer.parseInt(commentnum);
		return num;
		
	}
	
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
		return joke.findElements(By.className("word-wrap")).get(1).findElement(By.className("quote")).isDisplayed();
	}

}
