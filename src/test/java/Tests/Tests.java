package Tests;
import Base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Tests extends BaseTests {
    String Username = "1amzayat@gmail.com";
    String Password = "P@ssw0rdWorkWisee";
    String JobName = "Quality Assurance Engineer (m/w/d) - Software Testing Frontend/Backend";

    @BeforeClass
    public void Login_to_WorkWise() {
      loginPage.Login(Username, Password);
    }

    @Test
    public void Task3_1() {
        loginPage.Click_on_AboutUs();
        var AboutUs = loginPage.Click_on_AboutUs();
        assertTrue(AboutUs.getTitle().isDisplayed());
    }
    @Test
    public void Task3_3(){
       var JobSearch= loginPage.Click_on_JobSearch();
        JobSearch.SearchForAJob(JobName);
        String JobTitle = JobSearch.getJobTitle();
        assertEquals(JobTitle,JobName);
    }


}
