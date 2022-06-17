package Tests;

import Config.ConfigProperties;
import base.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Tests extends BaseTests {
    List<String> MainSectionsTitles = Arrays.asList("General description", "Requirements", "Responsibilities", "What we offer");
    List<String> Locations = Arrays.asList("Sofia", "Skopje");
    String FilePath = System.getProperty("user.dir")+"/resources/Test.docx";
    ExtentTest test;
    ExtentReports reports;


    @Test(dataProvider="TestData")
    public void testCase1(String Data) throws IOException {
        homePage.clickContactUsButton();
        homePage.enterName("test");
        homePage.enterEmail(Data);
        homePage.enterMobile("010010010010");
        homePage.enterSubject("Test Automation");
        homePage.enterMessage("This message is automated");
        homePage.clickSendButton();
        assertTrue(homePage.ErrorMessageDisplayed().isDisplayed());
        assertEquals(homePage.getErrorMessageText(), "The e-mail address entered is invalid.");

    }

    @Test
    public void testCase2() throws InterruptedException {
        var Company = homePage.Open_Company_Tab();
        assertEquals(Company.getCurrentURL(), "https://www.musala.com/company/");
        assertTrue(Company.getLeadershipSections().isDisplayed());
        assertTrue(Company.getLeadershipSections().getText().contains("Leadership"));
        Company.ClickFacebookFooter();
        Company.Switch_Tabs();
        Company.WaitTitle("Musala Soft - Home | Facebook");
        assertEquals(Company.getCurrentURL(), "https://www.facebook.com/MusalaSoft?fref=ts");
        assertTrue(Company.getProfilePic().isDisplayed());
    }

    @Test
    public void testCase3() {
        var Careers = homePage.Open_Careers_Tab();
        Careers.clickCheckPosition();
        assertEquals(Careers.getCurrentURL(), "https://www.musala.com/careers//join-us/");
        Careers.selectFromDropDown("Anywhere");
        Careers.openPosition("Automation QA Engineer");
        Assert.assertEquals(Careers.getSections().size(), 4);
        for (int i = 0; i < Careers.getSections().size(); i++) {
            assertTrue(Careers.getSections().get(i).isDisplayed());
            assertTrue(Careers.getSections().get(i).getText().contains(MainSectionsTitles.get(i)));
        }
        assertTrue(Careers.getApplyBtn().isDisplayed());
        Careers.getApplyBtn().click();
        Careers.enterName("");
        Careers.enterMobile("");
        Careers.enterEmail("Test@Test");
        Careers.uploadFile(FilePath);
        Careers.CheckAgreeBox();
        Careers.ClickSend();
        assertTrue(Careers.getErrPopUp().isDisplayed());
        assertEquals(Careers.getErrPopUp().getText(), "One or more fields have an error. Please check and try again.");
        Careers.CloseErrPopUp();
        assertTrue(Careers.getNameErrorMessage().isDisplayed());
        assertTrue(Careers.getEmailErrorMessage().isDisplayed());
        assertTrue(Careers.getMobileErrorMessage().isDisplayed());
        assertTrue(Careers.getMessageErrorMessage().isDisplayed());
        assertEquals(Careers.getNameErrorMessage().getText(), "The field is required.");
        assertEquals(Careers.getEmailErrorMessage().getText(), "The e-mail address entered is invalid.");
        assertEquals(Careers.getMobileErrorMessage().getText(), "The field is required.");
        assertEquals(Careers.getMessageErrorMessage().getText(), "The field is required.");
    }

    @Test
    public void testCase4() {
        var Careers = homePage.Open_Careers_Tab();
        Careers.clickCheckPosition();
        for (int i = 0; i < Locations.size(); i++) {
            Careers.selectFromDropDown(Locations.get(i));
            System.out.println(Locations.get(i));
            for ( int x=1 ; x< Careers.getNumberOfCards() ; x++)
            {
                System.out.println("Position: "+Careers.getPositionTitles(x));
                System.out.println("More info: "+Careers.getPositionInfoLinks(x));
            }

        }
    }
}