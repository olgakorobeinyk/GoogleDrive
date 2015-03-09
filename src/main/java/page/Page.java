package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page implements PageI{

    protected String username = "dcautotestuser@gmail.com";
    protected String password = "dcautotestuser1";
    protected String firstName = "Autotest";
    protected String lastName = "User";

    protected WebDriver driver;
    public String URL;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){

        }
    }
}