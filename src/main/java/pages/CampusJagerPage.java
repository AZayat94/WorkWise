package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CampusJagerPage {

    private static WebDriver driver;
    JavascriptExecutor js;

    private By NextButton = By.xpath("//*[contains(text(),'Nächster Schritt')]");
    private By Header = By.xpath("//*[@id=\"processSection\"]/div/div/div[1]/div/h2");
    private By Title = By.xpath("//*[@id=\"processSection\"]//div[1]/h3");
    private By AcepteCookies = By.xpath("//*[contains(text(),'Alle akzeptieren')]");

    public CampusJagerPage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public WebElement Get_Next_button(){
        ScrollIntoView(Header);
      return  driver.findElement(NextButton);
    }

    public void OpenURL(){
        driver.get(" https://arbeitgeber.campusjaeger.de/");
        driver.findElement(AcepteCookies).click();

    }

    public List<WebElement> GetNextbutton(){
        List<WebElement> NextBtn = driver.findElements(NextButton);
        return NextBtn;
    }
    public void Click_on_Next_Button(){
        ScrollIntoView(Header);
        driver.findElement(NextButton).click();
    }

    public String Get_Title(){
        ScrollIntoView(Header);
        return driver.findElement(Title).getText();
    }
    public void ScrollIntoView(By element){
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }
}
