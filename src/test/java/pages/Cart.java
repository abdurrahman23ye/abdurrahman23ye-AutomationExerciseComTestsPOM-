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

    @FindBy(xpath ="(//p[contains(text(),'Rs.')])[1]")
    public WebElement addedFirstCartPrice;

    @FindBy(xpath ="(//p[contains(text(),'Rs.')])[2]")
    public WebElement addedfirstCartPriceTotal;

    @FindBy(xpath ="(//p[contains(text(),'Rs.')])[3]")
    public WebElement addedSecondCartPrice;

    @FindBy(xpath ="(//p[contains(text(),'Rs.')])[4]")
    public WebElement addedSecondCartPriceTotal;

    @FindBy(xpath = "(//button[@class='disabled'])[1]")
    public WebElement firstAddedProductQuantity;

    @FindBy(xpath = "(//button[@class='disabled'])[2]")
    public WebElement secondAddedProductQuantity;



}
