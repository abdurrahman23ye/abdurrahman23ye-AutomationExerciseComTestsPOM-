package tests;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.Asserts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Cart;
import pages.Products;
import pages.RegistrationModule;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableForProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_Case_12_Add_Products_In_Cart {


    @Test(priority = -1)
    public void firstTask(){

          /*  1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully

         */

        ReusableForProject task=new ReusableForProject();
        task.loginAndVerify();

    }


    @Test
    public void addProduct() throws IOException {

       // 4. Click 'Products' button


        Products obj1=new Products();

        obj1.products.click();

        //5. Hover over first product and click 'Add to cart'

        Actions action=new Actions(Driver.getDriver());

        action.sendKeys(Keys.PAGE_DOWN).perform();


        action.moveToElement(obj1.listedFirstProducts).perform();
        obj1.listedFirstProductAddCart.click();

       // 6. Click 'Continue Shopping' button
        obj1.continueShoppingButton.click();

       // 7. Hover over second product and click 'Add to cart'

        action.moveToElement(obj1.listedSecondProducts).perform();
        obj1.listedSecondProductAddCart.click();

       // 8. Click 'View Cart' button

        obj1.viewCart.click();

        //9. Verify both products are added to Cart

        action.sendKeys(Keys.PAGE_DOWN).perform();

        TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();

        FileOutputStream chech=new FileOutputStream("target/screenShots/chech.jpg");

        File temp=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,chech);

        //10. Verify their prices, quantity and total price

        Cart obj2=new Cart();

        int inputAddedFirstCart= Integer.parseInt(obj2.addedFirstCartPrice.getText().replace("Rs. ",""));
        int inputAddedFirstQuan= Integer.parseInt(obj2.firstAddedProductQuantity.getText());
        int inputAddedFirstTotal= Integer.parseInt(obj2.addedfirstCartPriceTotal.getText().replace("Rs. ",""));

        int inputAddedSecondCart= Integer.parseInt(obj2.addedSecondCartPrice.getText().replace("Rs. ",""));
        int inputAddedSecondQuan= Integer.parseInt(obj2.secondAddedProductQuantity.getText());
        int inputAddedSecondTotal= Integer.parseInt(obj2.addedSecondCartPriceTotal.getText().replace("Rs. ",""));

        SoftAssert sf=new SoftAssert();

        sf.assertTrue(inputAddedFirstCart*inputAddedFirstQuan==inputAddedFirstTotal);
        sf.assertTrue(inputAddedSecondCart*inputAddedSecondQuan==inputAddedSecondTotal);
        sf.assertAll();
















    }

}
