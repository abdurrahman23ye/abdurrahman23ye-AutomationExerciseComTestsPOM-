package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class Subscription {

    public Subscription(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath ="//h2[text()='Subscription']")
    public WebElement subscription;

    @FindBy(xpath ="//input[@id='susbscribe_email']")
    public WebElement subscribe_email;

    @FindBy(xpath ="//i[@class='fa fa-arrow-circle-o-right']")
    public WebElement arrow;

    @FindBy(xpath ="//div[@class='alert-success alert']")
    public WebElement subscribeSuccess;




}
