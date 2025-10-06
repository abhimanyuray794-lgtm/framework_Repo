package abhi.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement mouseHover;
	
	@FindBy(linkText="Sign Out")
	WebElement signoutButton;
	public WebElement getMouseHover() {
		return mouseHover;
	}

	public WebElement getSignoutButton() {
		return signoutButton;
	}
	
	
}
