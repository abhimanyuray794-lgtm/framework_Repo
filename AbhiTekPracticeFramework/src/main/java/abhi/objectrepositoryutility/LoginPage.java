package abhi.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhi.generic.webdriverutility.WebdriverUtility;

public class LoginPage {
	WebdriverUtility wu;
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	WebElement userNameEdit;
	
	@FindBy(name="user_password")
	WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	WebElement loginButton;
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(String url, String username, String password) {
		wu=new WebdriverUtility();
		wu.maximizeWindow(driver);
		wu.implicitWait(driver);
		driver.get(url);
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginButton.click();
	}
	
	
}
