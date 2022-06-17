package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CareersPage {
    private static WebDriver driver;
    JavascriptExecutor js;
     WebDriverWait wait;
    private static By CheckPositionsBtn = By.xpath("//span[contains(text(),'Check our open positions')]");
    private static By DropDownMenu = By.id("get_location");
    private static By MainSections = By.xpath("//*[@class='entry-content']/div/div");
    private static By NameField = By.id("cf-1");
    private static By EmailField = By.id("cf-2");
    private static By MobileField = By.id("cf-3");
    private static By ApplyBtn = By.xpath("//input[@value='Apply']");
    private static By AgreeCheckBox = By.id("adConsentChx");
    private static By PopUpErrMessage = By.xpath("//*[@class='message-form-content']/div");
    private static By PopUpCloseBtn = By.className("close-form");
    private static By uploadFileInput = By.id("uploadtextfield");
    private static By NameErrMessage = By.xpath("//*[@id='cf-1']//following-sibling::span");
    private static By EmailErrMessage = By.xpath("//*[@id='cf-2']//following-sibling::span");
    private static By MobileErrMessage = By.xpath("//*[@id='cf-3']//following-sibling::span");
    private static By MessageErrMessage = By.xpath("//*[@id='cf-6']//following-sibling::span");
    private static By SendBtn = By.xpath("//input[@value='Send']");
    private static By PositionTitle = By.className("card-jobsHot__title");
    private static By PositionMoreInfoLink = By.className("card-jobsHot__link");
    private static By PositionCards = By.className("card");

    public CareersPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    public void clickCheckPosition(){
        driver.findElement(CheckPositionsBtn).click();
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }
    public void openPosition(String Position){
        ScrollIntoView(By.xpath("//h2[contains(text(),'"+Position+"')]"));
        driver.findElement(By.xpath("//h2[contains(text(),'"+Position+"')]")).click();
    }
    private Select findDropDownElement(){
        WaitUntilElementVisible(DropDownMenu);
        return new Select(driver.findElement(DropDownMenu));
    }
    public List<WebElement> getSections(){
      return driver.findElements(MainSections);
    }
    public WebElement getApplyBtn(){
        ScrollIntoView(ApplyBtn);
      return driver.findElement(ApplyBtn);
    }

    public void enterName(String Name){

        driver.findElement(NameField).sendKeys(Name);
    }
    public void enterEmail(String Email){

        driver.findElement(EmailField).sendKeys(Email);
    }
    public void enterMobile(String Mobile){

        driver.findElement(MobileField).sendKeys(Mobile);
    }
    public void uploadFile(String absPathOfFile){
        driver.findElement(uploadFileInput).sendKeys(absPathOfFile);
    }

    public void CheckAgreeBox(){
        driver.findElement(AgreeCheckBox).click();
    }
    public void ClickSend(){
        driver.findElement(SendBtn).click();
    }
    public WebElement getErrPopUp(){
        WaitUntilElementVisible(PopUpErrMessage);
        return driver.findElement(PopUpErrMessage);
    }
    public void CloseErrPopUp(){
        WaitUntilElementVisible(PopUpCloseBtn);
        driver.findElement(PopUpCloseBtn).click();
    }

    public WebElement getNameErrorMessage(){
        return driver.findElement(NameErrMessage);
    }
    public WebElement getMobileErrorMessage(){
        return driver.findElement(MobileErrMessage);
    }
    public WebElement getEmailErrorMessage(){
        return driver.findElement(EmailErrMessage);
    }
    public WebElement getMessageErrorMessage(){
        return driver.findElement(MessageErrMessage);
    }

    public void WaitUntilElementVisible(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void WaitUntilElementClickable(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getPositionTitles(int CardNumber){
        return driver.findElement(By.xpath("//article["+CardNumber+"]//h2")).getText();
    }

    public String getPositionInfoLinks(int CardNumber) {
        return driver.findElement(By.xpath("//article[" +CardNumber+ "]//a")).getAttribute("href");
    }
    public int getNumberOfCards(){
        WaitUntilElementVisible(PositionCards);
        return driver.findElements(PositionCards).size();
    }
    public void ScrollIntoView(By element){
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }
}
