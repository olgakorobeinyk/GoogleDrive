package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class InboxPage extends Page {

    @FindBy(xpath = "//a[contains(@title,'Account')]")
    public WebElement accountName;

    @FindBy(xpath = "//div[@id='gbwa']//a[@title='Apps']")
    public WebElement appsIcon;

    @FindBy(id = "gb49")
    public WebElement driveIcon;

    @FindBy(id = "gb_71")
    public WebElement signOutBtn;

    public void openGoogleDrive() {
        this.sleep();
        this.clickOnAppsIcon();
        this.driveIcon.click();
    }

    public Set<String> getWindowHandles() {
        return this.driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return this.driver.getWindowHandle();
    }

    public WebDriver switchToWindow(String windowName) {
        return this.driver.switchTo().window(windowName);
    }

    public void clickOnAppsIcon() {
        this.appsIcon.click();
    }

    public void logOut() {
        this.accountName.click();
        this.signOutBtn.click();
        try{
            this.driver.switchTo().alert().accept();
        } catch (Exception e){

        }
    }

    public boolean verifyUserIsLoggedIn() {
        boolean isTrue;

        if(this.getAccountName().compareTo(this.username) == 0) {
            isTrue = true;
        } else {
            isTrue = false;
        }

        return isTrue;
    }

    public String getAccountName() {
        return this.accountName.getText();
    }

    public void get() {
        this.driver.get("https://mail.google.com/mail/u/0/#inbox");
    }

}
