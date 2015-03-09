package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{

    @FindBy(id = "gmail-sign-in")
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

    public void pressSignInBtn() {
        this.signInBtn.click();
    }

    public void get() {
        this.driver.get("https://www.gmail.com/");
    }
}
