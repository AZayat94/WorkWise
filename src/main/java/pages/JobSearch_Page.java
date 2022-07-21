package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class JobSearch_Page {

    private static WebDriver driver;
    JavascriptExecutor js;
    private static By Search_Box = By.xpath("//input[@type='text']");
    private By Results = By.xpath("//div[contains(text(),'Quality Assurance Engineer (m/w/d) - Software Test')]");
    private static By JobTitle = By.tagName("h1");

    public JobSearch_Page(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public void SearchForAJob(String JobName){
        driver.findElement(Search_Box).sendKeys(JobName);
        driver.findElement(Results).click();
    }

    public String getJobTitle(){
      return driver.findElement(JobTitle).getText();

    }


}
