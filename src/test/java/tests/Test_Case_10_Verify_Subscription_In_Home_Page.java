package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationModule;
import pages.Subscription;
import utulities.ConfigReader;
import utulities.Driver;

import java.time.Duration;
import java.util.function.Function;

public class Test_Case_10_Verify_Subscription_In_Home_Page {

    @Test
    public void subscription() throws InterruptedException {

     /*   1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Scroll down to footer
        5. Verify text 'SUBSCRIPTION'
        6. Enter email address in input and click arrow button
        7. Verify success message 'You have been successfully subscribed!' is visible

      */

       /* 1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully

        */

        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));

        RegistrationModule obj=new RegistrationModule();
        SoftAssert sf=new SoftAssert();
        sf.assertTrue(obj.mainPage.isDisplayed());

        //4. Scroll down to footer
        //5. Verify text 'SUBSCRIPTION'

        Actions action=new Actions(Driver.getDriver());

        int input=18;
        int sayac=0;
        while(sayac<input){
        action.sendKeys(Keys.PAGE_DOWN).perform();

        sayac++;}

        Subscription obj1=new Subscription();

        sf.assertTrue(obj1.subscription.isDisplayed());

      //  6. Enter email address in input and click arrow button

        obj1.subscribe_email.sendKeys(ConfigReader.getProperty("dogruEmail"));

        obj1.arrow.click();

      //  7. Verify success message 'You have been successfully subscribed!' is visible

        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOf(obj1.subscribeSuccess));

        sf.assertTrue(obj1.subscribeSuccess.isDisplayed());

        sf.assertAll();



    }


}
