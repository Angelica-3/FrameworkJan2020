package orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import orangeHRM.helper.Utility;

public class LoginPage {


	WebDriver driver;


	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}

	By user = By.id("txtUsername");
	/*
	 * @FindBy(id = "txtUsername") WebElement user;
	 */
	By password = By.name("txtPassword");
	By loginButton = By.xpath("//input[@value='LOGIN']");


	public void verifyUrlBeforeLogin()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login Page does not contain login url");
	}

	public void verifyUrlAfterLogin()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard does not contain dashboard keyword");
	}

	/*
	 * // public void verifyTitle() { driver.getTitle(); }
	 */
	public void typeUserName()
	{
		Utility.waitForWebElement(driver, user).sendKeys("Admin");
	}


	public void typePassword()
	{
		Utility.waitForWebElement(driver, password).sendKeys("admin123");
	}


	public void clickOnLoginButton()
	{
		Utility.waitForWebElement(driver, loginButton).click();
	}


	public void loginToApplication(String userName, String passWord)
	{
		Utility.waitForWebElement(driver, user).sendKeys(userName);
		Utility.waitForWebElement(driver, password).sendKeys(passWord);
		Utility.waitForWebElement(driver, loginButton).click();
	}
}
