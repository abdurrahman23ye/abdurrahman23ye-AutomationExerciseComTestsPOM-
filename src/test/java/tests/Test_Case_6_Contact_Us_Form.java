package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactUs;
import pages.RegistrationModule;
import pages.SignUpModule;
import utulities.ConfigReader;
import utulities.Driver;

public class Test_Case_6_Contact_Us_Form {
    @Test
    public static void registerExistingEmail() {
        RegistrationModule obj = new RegistrationModule();
        SignUpModule obje = new SignUpModule();
        SoftAssert sf = new SoftAssert();
        Actions action = new Actions(Driver.getDriver());
        ContactUs conUs=new ContactUs();

     /*   1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
       // 3. Verify that home page is visible successfully
       // 4. Click on 'Contact Us' button
       // 5. Verify 'GET IN TOUCH' is visible
       // 6. Enter name, email, subject and message
       // 7. Upload file
       // 8. Click 'Submit' button
       // 9. Click OK button
       // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
       // 11. Click 'Home' button and verify that landed to home page successfully

      */

        // 2. Navigate to url 'http://automationexercise.com'

        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));
        // 3. Verify that home page is visible successfully

        sf.assertTrue(obj.mainPage.isDisplayed(),"main page has not displayed");
        // 4. Click on 'Contact Us' button
        conUs.contactUsLink.click();

        // 5. Verify 'GET IN TOUCH' is visible
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0,250)");
        sf.assertTrue(conUs.getInTouch.isDisplayed());
        // 6. Enter name, email, subject and message
        conUs.name.sendKeys(ConfigReader.getProperty("dogruIsim"));

        action.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("dogruEmail")).perform();
        action.sendKeys(Keys.TAB).sendKeys("bir seyler").perform();
        action.sendKeys(Keys.TAB).sendKeys("falan filan").perform();
        // 7. Upload file

        conUs.file.sendKeys("C:\\Users\\asus\\Desktop\\290.txt");
        // 8. Click 'Submit' button

        conUs.submit.click();
        // 9. Click OK button
        Driver.getDriver().switchTo().alert().accept();

        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible

        sf.assertTrue(conUs.success.isDisplayed());

        // 11. Click 'Home' button and verify that landed to home page successfully

        conUs.home.click();
        sf.assertTrue(obj.mainPage.isDisplayed());

        sf.assertAll();

    }
}