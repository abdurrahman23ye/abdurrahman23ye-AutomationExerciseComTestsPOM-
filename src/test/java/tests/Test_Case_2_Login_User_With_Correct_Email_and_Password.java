package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationModule;
import pages.SignUpModule;
import utulities.ConfigReader;
import utulities.Driver;

public class Test_Case_2_Login_User_With_Correct_Email_and_Password {

  @Test
    public  void signUp(){
        RegistrationModule obj=new RegistrationModule();
        SignUpModule obje=new SignUpModule();
        SoftAssert sf=new SoftAssert();
        Actions action=new Actions(Driver.getDriver());

         /* 1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button

    */

        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));

       sf.assertTrue( obj.mainPage.isDisplayed());

       obj.loginLinki.click();

      // 5. Verify 'Login to your account' is visible

       sf.assertTrue( obje.loginLabel.isDisplayed());

       // 6. Enter correct email address and password

        obje.inputEmail.sendKeys(ConfigReader.getProperty("dogruEmail"));

        action.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("signUpPassword")).perform();

       // 7. Click 'login' button

        obje.login.click();

        //8. Verify that 'Logged in as username' is visible

        sf.assertTrue(obj.loggedName.isDisplayed());

        //9. Click 'Delete Account' button

        obj.deleteAccount.click();

        sf.assertAll();



    }
}
