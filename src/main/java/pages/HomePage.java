package pages;

import org.openqa.selenium.*;

public class HomePage {
    private WebDriver driver;
    JavascriptExecutor js;

    private By loginButton = By.className("radius");
    private By ContactUs_btn = By.xpath("//span[contains(text(),'Contact us')]");
    private By NameField = By.id("cf-1");
    private By EmailField = By.id("cf-2");
    private By MobileField = By.id("cf-3");
    private By SubjectField = By.id("cf-4");
    private By YourMessageField = By.id("cf-5");
    private By Send_btn = By.xpath("//input[@value='Send']");
    private By Error_Message = By.xpath("//*[@id='cf-2']//following-sibling::span");
    private By Company_Tab = By.xpath("//*[@id='menu-main-nav-1']/li//a[contains(text(),'Company')]");
    private By Careers_Tab =By.xpath("//*[@id='menu-main-nav-1']/li//a[contains(text(),'Careers')]");


    public HomePage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
    }

    public void clickContactUsButton(){
        ScrollIntoView(ContactUs_btn);
       driver.findElement(ContactUs_btn).click();
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
    public void enterSubject(String Subject){
        driver.findElement(SubjectField).sendKeys(Subject);
    }
    public void enterMessage(String Message){
        driver.findElement(YourMessageField).sendKeys(Message);
    }

    public void clickSendButton(){
        driver.findElement(Send_btn).click();
    }

    public String getErrorMessageText(){
       return driver.findElement(Error_Message).getText();
    }
    public WebElement ErrorMessageDisplayed(){
       return driver.findElement(Error_Message) ;
    }
    public CompanyPage Open_Company_Tab() throws InterruptedException {
        driver.get("https://www.musala.com/company/");
       //driver.findElement(Company_Tab).click();
        return new CompanyPage(driver);
    }
    public CareersPage Open_Careers_Tab(){
        driver.get("https://www.musala.com/careers//");
        //driver.findElement(Careers_Tab).click();
        return new CareersPage(driver);
    }

    public void ScrollIntoView(By element){
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }

}

