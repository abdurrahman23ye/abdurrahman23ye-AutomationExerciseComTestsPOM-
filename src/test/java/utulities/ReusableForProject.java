package utulities;

import org.testng.asserts.SoftAssert;
import pages.RegistrationModule;

public class ReusableForProject {

    public void loginAndVerify(){

        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));
        RegistrationModule obj=new RegistrationModule();
        SoftAssert sf=new SoftAssert();
        sf.assertTrue(obj.mainPage.isDisplayed());
        sf.assertAll();

    }
}
