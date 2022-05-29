package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationModule;
import pages.SignUpModule;
import utulities.ConfigReader;
import utulities.Driver;

public class Test_Case_4_Logout_User {

    @Test
    public static void logout(){

        RegistrationModule obj=new RegistrationModule();
        SignUpModule obje=new SignUpModule();
        SoftAssert sf=new SoftAssert();
        Actions action=new Actions(Driver.getDriver());

      /*  1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter correct email address and password
        7. Click 'login' button
        8. Verify that 'Logged in as username' is visible
        9. Click 'Logout' button
        10. Verify that user is navigated to login page

       */

        /*  1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully

         */
        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));
        sf.assertTrue(obj.mainPage.isDisplayed());



       // 4. Click on 'Signup / Login' button

        obj.loginLinki.click();

      /*  5. Verify 'Login to your account' is visible
        6. Enter correct email address and password
        7. Click 'login' button

       */

        sf.assertTrue( obje.loginLabel.isDisplayed());

        String url= Driver.getDriver().getCurrentUrl();
        obje.inputEmail.sendKeys(ConfigReader.getProperty("dogruEmail"));

        action.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("signUpPassword")).perform();

        obje.login.click();



     //   8. Verify that 'Logged in as username' is visible

        sf.assertTrue(obj.loggedName.isDisplayed());

     //   9. Click 'Logout' button

        obj.logOut.click();
     //   10. Verify that user is navigated to login page

        sf.assertTrue(Driver.getDriver().getCurrentUrl().equals(url),"logout doesnt't navigated login page");

        sf.assertAll();


    }
}
