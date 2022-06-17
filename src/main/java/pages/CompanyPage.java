package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class CompanyPage {

    private static WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    private static By Facebook_Icon =By.xpath("//*[@class='links-buttons']/a[4]/span");
    private static By LeadershipSection = By.xpath("//section[@class='company-members']");
    private static By AcceptCookies = By.id("wt-cli-accept-all-btn");
    private static By ProfilePhoto = By.xpath("//*[@aria-label='Musala Soft profile photo']");
    public CompanyPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    }

    public void ClickFacebookFooter(){
        ScrollIntoView(Facebook_Icon);
        driver.findElement(AcceptCookies).click();
        driver.findElement(Facebook_Icon).click();
    }

    public WebElement getLeadershipSections(){
        ScrollIntoView(LeadershipSection);
        return driver.findElement(LeadershipSection);
   }

    public String getCurrentURL(){
       return driver.getCurrentUrl();
    }

    public WebElement getProfilePic(){
        return driver.findElement(ProfilePhoto);
    }
    public void Switch_Tabs(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    public void WaitTitle(String TabTitle){
        wait.until(titleIs(TabTitle));

    }
    public void ScrollIntoView(By element){
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }
}

