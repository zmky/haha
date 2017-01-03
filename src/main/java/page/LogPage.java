package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Do;
import base.LogLoc;
import base.Wait; 

public class LogPage {
	 private WebDriver driver;
	 private Wait wait;
	 private Do du;
	 
	 @FindBy(id="account")
	 private WebElement account;
	 
	 @FindBy(id="password")
	 private WebElement pwd;
	 
	 @FindBy(id="basic-submit")
	 private WebElement submit;
	 
	 @FindBy(id="login_validationMessage")
	 private WebElement loginerror;
	 
	 
	 public LogPage(WebDriver driver){
		this.driver = driver;
		wait=new Wait(driver);
		du = new Do(driver);
		PageFactory.initElements(driver, this);
			
	}
	 

	 public void setAccount(String account){
		 wait.waitFor(5000);
		 this.account.sendKeys(account);
		 		 	
	 }
	 
	 public void setPwd(String pwd){
		 this.pwd.sendKeys(pwd);
		 		 	
	 }
	
	 public void submit(){
		 submit.click();
	 }
	 public void switchDefault(){
		 driver.switchTo().defaultContent();
	 }
	 public boolean  accountNull(){
		 wait.waitForElementPresent(LogLoc.error);
		 String accountnull=loginerror.getText();
		 //System.out.println(accounterror.getText());
		 String accountnull2="«Î ‰»Î’À∫≈";
		 //System.out.println(accounterrorexist2);
		 return accountnull.equals(accountnull2);
		 	 }

	 public boolean  pwdNull(){
		 wait.waitForElementPresent(LogLoc.error);
		 String accountnull=loginerror.getText();
		 //System.out.println(accounterror.getText());
		 String accountnull2="«Î ‰»Î√‹¬Î";
		 //System.out.println(accounterrorexist2);
		 return accountnull.equals(accountnull2);
		 	 }
	 
	 public boolean  pwdError(){
		 wait.waitForElementPresent(LogLoc.error);
		 String accountnull=loginerror.getText();
		 //System.out.println(accounterror.getText());
		 String accountnull2="’À∫≈ªÚ√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ ‰»Î";
		 //System.out.println(accounterrorexist2);
		 return accountnull.equals(accountnull2);
		 	 }

}