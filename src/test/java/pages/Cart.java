package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class Cart {

    public Cart() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="(//a[@href='/view_cart'])[1]")
    public WebElement cartButton;
}
