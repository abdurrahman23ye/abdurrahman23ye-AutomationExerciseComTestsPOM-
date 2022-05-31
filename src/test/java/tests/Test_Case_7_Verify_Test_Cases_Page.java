package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationModule;
import pages.TestCases;
import utulities.ConfigReader;
import utulities.Driver;

public class Test_Case_7_Verify_Test_Cases_Page {

    @Test
    public void verifiedTestCases(){

      /*  1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Test Cases' button
        5. Verify user is navigated to test cases page successfully

       */

        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));

        SoftAssert sf=new SoftAssert();

        RegistrationModule obj=new RegistrationModule();
        TestCases obje=new TestCases();

        sf.assertTrue(obj.mainPage.isDisplayed());
        obje.TestCases.click();
        sf.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.automationexercise.com/test_cases"));
        sf.assertAll();


    }


}
