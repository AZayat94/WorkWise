package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.CampusJagerPage;
import pages.LoginPage;

import java.io.IOException;
import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected CampusJagerPage CampusJagerPage;
    ExtentReports reports;
    ExtentSparkReporter SparkReporter;
    ExtentTest test;



    @BeforeSuite
    public  void setUp() throws IOException {
        reports = new ExtentReports();
        SparkReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentReport.html");
        reports.attachReporter(SparkReporter);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // implicit wait
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        CampusJagerPage = new CampusJagerPage(driver);
    }


    @AfterMethod
    public void SetTestResults(ITestResult result){
        test = reports.createTest("Test Name : "+result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getName());
            test.log(Status.FAIL,result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Case : " + result.getName() + " has been skipped");
        }
        reports.flush();
    }

    @AfterClass
    public void tearDown(){
   //   driver.quit();
    }
}