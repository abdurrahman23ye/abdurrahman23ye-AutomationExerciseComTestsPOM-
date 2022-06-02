package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Products;
import pages.RegistrationModule;
import utulities.ConfigReader;
import utulities.Driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_Case_9_Search_Product {


    @Test
    public void search() throws InterruptedException, IOException {


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'

   */
        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));
        RegistrationModule obj= new RegistrationModule();
        SoftAssert sf=new SoftAssert();

        sf.assertTrue(obj.mainPage.isDisplayed());


    /*
4. Click on 'Products' button

     */
        Products obj1=new Products();
        obj1.products.click();


    /*

5. Verify user is navigated to ALL PRODUCTS page successfully
     */
        sf.assertTrue(obj1.allProductsLabel.isDisplayed());

        //6. Enter product name in search input and click search button

        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,600)");

        obj1.searchBox.sendKeys("input");
        obj1.searchButton.click();


       // 7. Verify 'SEARCHED PRODUCTS' is visible

        sf.assertTrue(obj1.searchedProducts.isDisplayed());

      //  8. Verify all the products related to search are visible

        TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();

        FileOutputStream chech=new FileOutputStream("target/screenShots/chech.jpg");

        File temp=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,chech);

        sf.assertAll();

        js.executeScript("window.scrollBy(0,500)");

        //There is no listed item







    }

}
