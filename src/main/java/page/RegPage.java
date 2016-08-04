package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Do;
import base.RegLoc;
import base.Wait; 

public class RegPage {
	 private WebDriver driver;
	 private Wait wait;
	 private Do du;
	 
	 
	 @FindBy(id="account")
	 private WebElement account;
	 
	 @FindBy(id="pwd")
	 private WebElement pwd;
	 
	 @FindBy(id="nickname")
	 private WebElement nickname;
	 
	 @FindBy(id="from-reg-submit")
	 private WebElement submit;
	 
	 @FindBy(id="goto-login")
	 private WebElement back;
	 
	 @FindBy(id="account_validationMessage")
	 private WebElement accounterror;
	 
	 @FindBy(id="pwd_validationMessage")
	 private WebElement pwderror;
	 
	 @FindBy(id="nickname_validationMessage")
	 private WebElement nicknameerror;
	 
	 @FindBy(id="login-dialog-iframe")
	 private WebElement loginiframe;
	 
	 String loginfr="//iframe[@id='login-dialog-iframe']";
	 
	 public RegPage(WebDriver driver){
		this.driver = driver;
		wait=new Wait(driver);
		du = new Do(driver);
		PageFactory.initElements(driver, this);
			
	}
	 public void switchLogin(){
		 wait.waitForElementPresent(loginfr);
		 driver.switchTo().frame(loginiframe);

		 
	 }
	 public void setAccount(String account){
		 wait.waitFor(5000);
		 this.account.sendKeys(account);
		 		 	
	 }
	 
	 public void setPwd(String pwd){
		 this.pwd.sendKeys(pwd);
	 }
	 
	 public void setNickname(String nickname){
		 this.nickname.sendKeys(nickname);
	 }
	 
	 public void submit(){
		 submit.click();
	 }
	 public void  back(){
		back.click(); 
	 }
	 public boolean  accountErrorExist(){
		 wait.waitForElementPresent(RegLoc.accounterror);
		 String accounterrorexist=accounterror.getText();
		 //System.out.println(accounterror.getText());
		 String accounterrorexist2="此邮箱地址已被占用";
		 //System.out.println(accounterrorexist2);
		 return accounterrorexist.equals(accounterrorexist2);
		 	 }
	 
	 
	 public boolean accountErrorFormat(){
		 wait.waitForElementPresent(RegLoc.accounterror);
		 String accounterrorformat=accounterror.getText();
		 //System.out.println(accounterrorformat);
		 String accounterrorformat2="邮箱格式不正确";
		 return accounterrorformat.equals(accounterrorformat2);
				 
	 }
	 
	 public boolean pwdError(){
		 wait.waitForElementPresent(RegLoc.pwderror);
		 String pwderrorfive=pwderror.getText();
		 System.out.println(pwderror);
		 String pwderrorfive2="密码长度不正确，应为6～20个字符";
		 return pwderrorfive.equals(pwderrorfive2);
				 
	 }
	 
	 public boolean nickErrorExist(){
		 wait.waitForElementPresent(RegLoc.nickerror);
		 String nicknameerrorexist=nicknameerror.getText();
		 //System.out.println(nicknameerrorexist);
		 String nicknameerrorexist2="该昵称已存在";
		 return nicknameerrorexist.equals(nicknameerrorexist2);
				
	 }
		public WebElement getWebElement(String wn,String accountname){
			   return  du.what(String.format(wn, accountname));	
	 
}
}

