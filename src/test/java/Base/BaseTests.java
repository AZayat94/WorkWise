package Base;

import Config.ConfigProperties;
import Utils.ExcelUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.IOException;
import java.time.Duration;

public class BaseTests {
    ExcelUtils excelUtils = new ExcelUtils();
    private WebDriver driver;
    protected HomePage homePage;
    ExtentReports reports;
    ExtentSparkReporter SparkReporter;
    ExtentTest test;

    @DataProvider(name="TestData")
    public Object[][] getData() throws IOException {
        Object data[][] =excelUtils.DataProvider();
        return data;
    }

    @BeforeClass
    public  void setUp() throws IOException {
        reports = new ExtentReports();
        SparkReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentReport.html");
        reports.attachReporter(SparkReporter);
        ConfigProperties.InitializePropFile();
        if (ConfigProperties.properties.getProperty("BrowserType").equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (ConfigProperties.properties.getProperty("BrowserType").equalsIgnoreCase("FireFox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // implicit wait
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get(ConfigProperties.properties.getProperty("URL"));
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
        driver.quit();
    }
}