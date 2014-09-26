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
	
	@FindBy(linkText="½²Ò»¸ö")
	private WebElement talk;
	
	@FindBys(@FindBy(className="joke-item"))
	private List <WebElement> jokes;
	
	
	
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
		 String account2=td.getValue("nickname2");
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
}
