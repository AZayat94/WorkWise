package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    JavascriptExecutor js;

    private By AcepteCookies = By.xpath("//*[contains(text(),'Alle akzeptieren')]");
    private By LoginButton = By.xpath("//button[contains(text(),'Einloggen')]");
    private By EmailField = By.xpath("//input[@placeholder='E-Mail']");
    private By PasswordField = By.xpath("//input[@placeholder='Passwort']");
    private By Loginbtn = By.xpath("//*[@type='submit']");
    private  By AboutUs = By.xpath("//a[contains(text(),'Über uns')]");
    private  By JobSearch = By.xpath("//button[contains(text(),'Jobsuche')]");
    private By profileName = By.xpath("//span[contains(text(),'Ahmed')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public void Login(String Username , String Password){
        driver.get("https://www.workwise.io/");
        driver.findElement(AcepteCookies).click();
        driver.findElement(LoginButton).click();
        waitUntilClickabilityOf(LoginButton);
        driver.findElement(EmailField).sendKeys(Username);
        driver.findElement(PasswordField).sendKeys(Password);
        driver.findElement(Loginbtn).click();

    }

    public AboutUsPage Click_on_AboutUs(){
        waitUntilVisibilityOf(profileName);
        ScrollIntoView(AboutUs);
        driver.findElement(AboutUs).click();
        return new AboutUsPage(driver);
    }

    public JobSearch_Page Click_on_JobSearch(){
        waitUntilVisibilityOf(profileName);
        driver.findElement(JobSearch).click();
        return new JobSearch_Page(driver);
    }
    public void ScrollIntoView(By element){
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }

    public void waitUntilVisibilityOf(By Element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Element)));
    }

    public void waitUntilClickabilityOf(By Element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Element)));
    }

}

