package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleDrive extends Page{

    @FindBy (xpath = "//div[@guidedhelpid=\"new_menu_button\"]")
    public WebElement createFolderBtn;

    @FindBy(xpath = "//div[@class='j-A j-A-Nj']")
    public WebElement menuWithFolderItem;

    @FindBy(xpath = "//div[@role='dialog']//input[@type='text']")
    public WebElement folderTitle;

    @FindBy(xpath = "//button[@name='ok']")
    public WebElement createBtn;

    @FindBy(xpath = "//div[@role='toolbar']//div[@aria-label='Remove']")
    public WebElement removeBtn;

    @FindBy(xpath = "//div[@role='option']/div[2]")
    public WebElement createdFolder;

    public void selectCreatedFolder(){
        this.createdFolder.click();
    }

    public String getFolderTitle() {
        return this.createdFolder.getText();
    }

    public void removeFolder() {
        this.selectCreatedFolder();
        this.removeBtn.click();
    }

    public void createNewFolder (String folderTitle) {
        this.createFolderBtn.click();
        this.sleep();
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(menuWithFolderItem.
                findElement(By.xpath("//div[@role='menuitem'][1]"))));
        this.menuWithFolderItem.findElement(By.xpath("//div[@role='menuitem'][1]")).click();
        this.folderTitle.clear();
        this.folderTitle.sendKeys(folderTitle);
        this.createBtn.click();
    }

    public void get() {
        this.driver.get("https://drive.google.com/");
    }

}
