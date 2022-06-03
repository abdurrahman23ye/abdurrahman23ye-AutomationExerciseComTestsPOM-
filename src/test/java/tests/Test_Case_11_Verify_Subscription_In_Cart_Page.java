package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Cart;
import pages.RegistrationModule;
import pages.Subscription;
import utulities.ConfigReader;
import utulities.Driver;

import java.time.Duration;

public class Test_Case_11_Verify_Subscription_In_Cart_Page {

    @Test
    public void cartPage(){






        //1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
       // 3. Verify that home page is visible successfully

        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));
        RegistrationModule obj=new RegistrationModule();
        SoftAssert sf=new SoftAssert();
        sf.assertTrue(obj.mainPage.isDisplayed());

        //4. Click 'Cart' button

        Cart crt=new Cart();

        crt.cartButton.click();

       // 5. Scroll down to footer

        Actions action=new Actions(Driver.getDriver());

        int input=3;
        int sayac=0;
        while(sayac<input){
            action.sendKeys(Keys.PAGE_DOWN).perform();

            sayac++;}
        //6. Verify text 'SUBSCRIPTION'
        Subscription sbr=new Subscription();

        sf.assertTrue(sbr.subscription.isDisplayed());

        /*  7. Enter email address in input and click arrow button
        8. Verify success message 'You have been successfully subscribed!' is visible

         */
        sbr.subscribe_email.sendKeys(ConfigReader.getProperty("dogruEmail"));

        sbr.arrow.click();

        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOf(sbr.subscribeSuccess));

        sf.assertTrue(sbr.subscribeSuccess.isDisplayed());

        sf.assertAll();

        Driver.closeDriver();



    }
}
