package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutUsPage {
    private static WebDriver driver;
    JavascriptExecutor js;
    private static By Ask_Franzi = By.xpath("//h3[contains(text(),'Frag Franzi')]");


    public AboutUsPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
    }


    public WebElement getTitle(){
        ScrollIntoView(Ask_Franzi);
        return  driver.findElement(Ask_Franzi);
    }


    public void ScrollIntoView(By element){
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }
}
