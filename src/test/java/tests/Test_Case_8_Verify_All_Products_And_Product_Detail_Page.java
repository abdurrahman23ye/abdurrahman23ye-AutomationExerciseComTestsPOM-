package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Products;
import pages.RegistrationModule;
import utulities.ConfigReader;
import utulities.Driver;

public class Test_Case_8_Verify_All_Products_And_Product_Detail_Page {

    @Test
    public void products(){
        RegistrationModule obj=new RegistrationModule();
        Products pro=new Products();
        SoftAssert sf=new SoftAssert();
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

      /*  1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully

       */

        Driver.getDriver().get(ConfigReader.getProperty("mainPage"));
        sf.assertTrue(obj.mainPage.isDisplayed());

        //4. Click on 'Products' button

        pro.products.click();
        js.executeScript("window.scrollBy(0,600)");

       /* 5. Verify user is navigated to ALL PRODUCTS page successfully
        6. The products list is visible

        */

        sf.assertTrue(pro.allProductsLabel.isDisplayed());

       /* 7. Click on 'View Product' of first product
        8. User is landed to product detail page
        */

        pro.listedFirstProducts.click();

      //  9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

         sf.assertTrue(pro.listedFirstProductsCondition.isDisplayed());
         sf.assertTrue(pro.listedFirstProductsBrand.isDisplayed());
         sf.assertTrue(pro.listedFirstProductsName.isDisplayed());
         sf.assertTrue(pro.listedFirstProductsCategory.isDisplayed());
         sf.assertTrue(pro.listedFirstProductsPrice.isDisplayed());
         sf.assertTrue(pro.listedFirstProductsAvailability.isDisplayed());

         sf.assertAll();

    }
}
