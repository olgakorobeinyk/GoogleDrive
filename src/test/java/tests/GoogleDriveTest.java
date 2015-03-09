package tests;

import page.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;

import static org.junit.Assert.*;


public class GoogleDriveTest {

    private FirefoxDriver driver;

    @Before
    public void openBrowser() {
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        HomePage homePage = PageFactory.initElements(this.driver, HomePage.class);
        homePage.get();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void verifyUserLogin() {
        LoginPage loginPage = PageFactory.initElements(this.driver, LoginPage.class);
        loginPage.loginToTheGmail("dcautotestuser@gmail.com", "dcautotestuser1");
        InboxPage inboxPage = PageFactory.initElements(this.driver, InboxPage.class);
        assertTrue(inboxPage.verifyUserIsLoggedIn());
    }

    @Test
    public void verifyAddingFolderOnDrive() {
        String folderTitle = "firstFolder";
        LoginPage loginPage = PageFactory.initElements(this.driver, LoginPage.class);
        loginPage.loginWithDefaultCredentials();
        InboxPage inboxPage = PageFactory.initElements(this.driver, InboxPage.class);
        Set<String> oldWindowHandles = inboxPage.getWindowHandles();

        inboxPage.openGoogleDrive();
        GoogleDrive googleDrive = PageFactory.initElements(this.driver, GoogleDrive.class);

        Set<String>  newWindowHandles = inboxPage.getWindowHandles();
        for (String windowHandler : newWindowHandles) {
            if(!oldWindowHandles.contains(windowHandler)){
                inboxPage.switchToWindow(windowHandler);
                break;
            }
        }
        googleDrive.createNewFolder(folderTitle);
        assertTrue(googleDrive.getFolderTitle().contains(folderTitle));

        googleDrive.removeFolder();
    }

    @Test
    public void verifyUserLogout() {
        LoginPage loginPage = PageFactory.initElements(this.driver, LoginPage.class);
        loginPage.loginWithDefaultCredentials();
        InboxPage inboxPage = PageFactory.initElements(this.driver, InboxPage.class);
        inboxPage.logOut();
        assertTrue(loginPage.verifySignInBtnIsPresent());

    }

}
