package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationModule;
import pages.SignUpModule;
import utulities.ConfigReader;
import utulities.Driver;

public class Test_Case_5_Register_User_With_Existing_Email {

    @Test
    public static void registerExistingEmail(){
        RegistrationModule obj=new RegistrationModule();
        SignUpModule obje=new SignUpModule();
        SoftAssert sf=new SoftAssert();
        Actions action=new Actions(Driver.getDriver());

        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
         */
      //  2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));
      //3. Verify that home page is visible successfully
        sf.assertTrue(obj.mainPage.isDisplayed());

        //4. Click on 'Signup / Login' button

        obj.loginLinki.click();

       // 5. Verify 'New User Signup!' is visible

       sf.assertTrue( obj.newUserSignUpLabel.isDisplayed(),"newUserSignUp");

       //6. Enter name and already registered email address

        obj.newUserSignUpName.sendKeys(ConfigReader.getProperty("dogruIsim"));
        obj.newUserSignUpEmail.sendKeys(ConfigReader.getProperty("dogruEmail"));
        //7. Click 'Signup' button

        obj.newUserSignUpButton.click();

     //   8. Verify error 'Email Address already exist!' is visible

        sf.assertTrue(obj.emailAlreadyExist.isDisplayed());

        sf.assertAll();


    }
}
