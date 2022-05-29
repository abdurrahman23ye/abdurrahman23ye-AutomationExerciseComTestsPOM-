package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationModule;
import pages.SignUpModule;
import utulities.ConfigReader;
import utulities.Driver;

public class Test_Case_3_Login_User_With_Incorrect_Email_and_Password {

   /* 1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible

    */

    @Test
    public static void ınCorrectLogin(){

   /* 1. Launch browser
2. Navigate to url 'http://automationexercise.com'

    */
        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));

      //  3. Verify that home page is visible successfully

        RegistrationModule obj=new RegistrationModule();
        SoftAssert sf=new SoftAssert();
        sf.assertTrue(obj.mainPage.isDisplayed());
     //   4. Click on 'Signup / Login' button

        obj.loginLinki.click();

        //5. Verify 'Login to your account' is visible

        SignUpModule obje=new SignUpModule();

        sf.assertTrue(obje.loginLabel.isDisplayed());

        //6. Enter incorrect email address and password

        obje.inputEmail.sendKeys(ConfigReader.getProperty("incorrectEmail"));

        Actions action=new Actions(Driver.getDriver());

        action.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("inCorrectPassword")).perform();


       // 7. Click 'login' button

        obje.login.click();

        // Verify error 'Your email or password is incorrect!' is visible

        sf.assertTrue(obje.loginerror.isDisplayed());

        sf.assertAll();



    }
}
