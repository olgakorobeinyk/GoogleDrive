package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@id='Passwd']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@id='signIn']")
    public WebElement signInBtn;

    public boolean verifySignInBtnIsPresent() {
        boolean isTrue;
        if(this.signInBtn.isDisplayed()) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        return isTrue;
    }

    public void loginWithDefaultCredentials() {
        this.enterUsername(this.username)
                .enterPassword(this.password)
                .pressSignInBtn();
    }

    public void loginToTheGmail (String username, String password) {
        this.enterUsername(username)
                .enterPassword(password)
                .pressSignInBtn();
    }

    public LoginPage enterUsername (String username) {
        this.emailField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword (String password) {
        this.passwordField.sendKeys(password);
        return this;
    }

    public void pressSignInBtn() {
        this.signInBtn.click();
    }

    public LoginPage signInWithError() {
        this.pressSignInBtn();
        return this;
    }

    public void get() {
        this.driver.get("https://mail.google.com");
    }

}
