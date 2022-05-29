package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationModule;
import utulities.ConfigReader;
import utulities.Driver;

public class Test_Case_1_Register_User {

    @Test
    public static void test01() throws InterruptedException {

        RegistrationModule obj=new RegistrationModule();

      //  1. Launch browser
      //  2. Navigate to url 'http://automationexercise.com'
     //   3. Verify that home page is visible successfully

         Driver.getDriver().get(ConfigReader.getProperty("mainPage"));

        SoftAssert sf=new SoftAssert();

        sf.assertTrue(obj.mainPage.isEnabled());

        //4. Click on 'Signup / Login' button

        obj.loginLinki.click();

        //5. Verify 'New User Signup!' is visible

        sf.assertTrue(obj.newUserSignUpLabel.isDisplayed(),"newUserSignUplabel is not displayed");

        //6. Enter name and email address

        obj.newUserSignUpName.sendKeys(ConfigReader.getProperty("dogruIsim"));

        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0,150)");
        obj.newUserSignUpEmail.sendKeys(ConfigReader.getProperty("dogruEmail"));

        js.executeScript("window.scrollBy(0,-150)");

       // 7. Click 'Signup' button

        obj.newUserSignUpButton.click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        sf.assertTrue(obj.enterAccountInformation.isDisplayed(),"enterAccountInformation is not displayed");

        //9. Fill details: Title, Name, Email, Password, Date of birth

        obj.inputTitle.click();

        Actions action=new Actions(Driver.getDriver());

        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(ConfigReader.getProperty("signUpPassword")).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(ConfigReader.getProperty("dayOfBirthday")).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(ConfigReader.getProperty("monthOfBirthday")).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(ConfigReader.getProperty("yearOfBirthday")).perform();

     /*   10. Select checkbox 'Sign up for our newsletter!'
        11. Select checkbox 'Receive special offers from our partners!'

      */
        action.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
        action.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();


      /*  12. Fill details: First name, Last name, Company, Address,
                Address2, Country, State, City, Zipcode, Mobile Number

       */
        Faker fk=new Faker();
        action.sendKeys(Keys.TAB).sendKeys(fk.name().name()).perform();
        action.sendKeys(Keys.TAB).sendKeys( fk.name().lastName()).perform();
        action.sendKeys(Keys.TAB).sendKeys( fk.company().name()).perform();
        action.sendKeys(Keys.TAB).sendKeys( fk.address().fullAddress()).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.address().country()).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.address().state()).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.address().city()).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.address().zipCode()).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.phoneNumber().cellPhone()).perform();

     //  13. Click 'Create Account button'
        obj.createAccount.click();

     //   14. Verify that 'ACCOUNT CREATED!' is visible

        sf.assertTrue(obj.accountCreated.isDisplayed());

        //15. Click 'Continue' button

        obj.accountCreatedContinue.click();

      //  16. Verify that 'Logged in as username' is visible

        sf.assertTrue(obj.loggedName.getText().equals(ConfigReader.getProperty("dogruIsim")),"logged name is not equal");

        //17. Click 'Delete Account' button
        obj.deleteAccount.click();

        sf.assertAll();






    }

}
