package Tests;

import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CampusJagerPage;

import java.util.Arrays;
import java.util.List;

public class Test2 extends BaseTests {
    List<String> Titles = Arrays.asList("1. Leg direkt los", "2. Erstelle dein Jobangebot","3. Stelle optimieren und von Experten prüfen lassen"
    ,"4. Stelle auf über 1.000 Kanälen schalten","5. Kandidaten verwalten und bewerten","6. Mit wenigen Klicks Termine vereinbaren"
    ,"7. Gespräche durchführen und Ergebnisse dokumentieren","8. Zusammen entscheiden und die besten Kandidaten einstellen"
    ,"9. Prämie nur bei Erfolg");

    @BeforeClass
    public void Login_to_WorkWise() {
        CampusJagerPage.OpenURL();
    }
    @Test
    public void Task3_2(){
        for (int i = 0; i < Titles.size(); i++) {
           String Title =  CampusJagerPage.Get_Title();
            CampusJagerPage.Click_on_Next_Button();
            System.out.println(Title);
            Assert.assertEquals(Title, Titles.get(i));

        }
    }
}
