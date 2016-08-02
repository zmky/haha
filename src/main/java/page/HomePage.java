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
	
	//����ע��
	@FindBy(id="header-account-register")
	private WebElement reg;
	//������¼
	@FindBy(id="header-account-login")
	private WebElement login;
	//�����ǳ�
	@FindBy(id="header-account-nickname")
	private WebElement nickname;
	
	@FindBy(linkText="��һ��")
	private WebElement talk;
	//��λЦ��
	@FindBys(@FindBy(className="joke-list-item"))
	private List <WebElement> jokes;
		
	//���е�����
	@FindBys(@FindBy(className="btn-icon-comment"))
	private List <WebElement> comments;
	
	@FindBys(@FindBy(className="joke-comment_header-buttons-delete"))
	private List <WebElement> commentsdel;
	//���۵�����
	@FindBys(@FindBy(className="joke-comment_header-buttons-light"))
	private List <WebElement> light;
	
	@FindBy(linkText="��������")
	private WebElement commentpost;
	
	@FindBy(linkText="����")
	private WebElement faces;
	
	//���������еı���
	@FindBys(@FindBy(className="face-pane-item"))
	private List<WebElement> face;
	//���۵�ͬʱת��
	@FindBy(className="joke-comment_input-post_as_new_joke")
	private WebElement asjoke;
	//���������
	@FindBy(className="joke-comment_input-inputbox")
	private WebElement commenttext;
	//����Ϊ�յȳ��ֵĴ�����ʾ	
	@FindBy(className="comment-msg")
	private WebElement commenterror;
	
	@FindBy(linkText="�ղ�")
	private WebElement collect;
	
	
	@FindBy(linkText="ȡ���ղ�")
	private WebElement collectcancel; 
	
	@FindBys(@FindBy(linkText="ȡ���ղ�"))
	private List <WebElement> collectcancels; 
	
	@FindBy(linkText="�ҵ��ղ�")
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
	//Ц���е�ͼƬ
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
	//�����������
	public void commentPost(){
		commentpost.click();
	}
	//��ӱ���
	 public void setFace(){
		 faces.click();
		 wait.waitFor(3000);
		 face.get(0).click();
	 }
	//�����������ʱ��ͬʱת��
	 public void setAsJoke(){
		 asjoke.click();
	 }
	 
	 public void setComment(String comment){
		 commenttext.sendKeys(comment);
	 }
	 
	public void setReply(){
		WebElement joke=jokes.get(0);
		WebElement reply=joke.findElements(By.linkText("�ظ�")).get(0);
		reply.click();
		}
	
	public void setCommentDel(){
		commentsdel.get(0).click();
	}
	
	public void setLight(){
		light.get(0).click();
	}
	//����Ϊ�մ�����ʾ�Ƿ���ȷ
	public boolean commentNull(){
		String commenterrornull=commenterror.getText();
		String commenterrornull2="�������ݲ���Ϊ�գ�����д���ݣ�";
		return commenterrornull.equals(commenterrornull2);
	}
	//��ȡЦ���ĵ�һ����������
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
	

	//��ȡЦ����������
	public int commentNum(){
		WebElement joke=jokes.get(0);
		String commentnumall=joke.findElement(By.className("btn-icon-comment")).getText();
		String commentnum=commentnumall.substring(4, (commentnumall.length()-1));
		System.out.println(commentnum);
		int num;
		num=Integer.parseInt(commentnum);
		return num;
		
	}
	//��ȡ���۵���������
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
	//����ղ�
	public boolean setCollect(){		
		collect.click();
		wait.waitFor(5000);
		return collectcancel.isDisplayed();
		
	}
	
	public void setCollectCancel(){
		collectcancels.get(0).click();
		wait.waitFor(5000);
		
	}
	//�����ղ�ҳ��
	public void myFav(){
		//Actions actions=new Actions(driver);
		//actions.moveToElement(nickname).build().perform();
		//wait.waitFor(8000);
		//fav.click();
		driver.get("http://www.haha.mx/my/fav/");
		wait.waitFor(20000);
				
	}
}
