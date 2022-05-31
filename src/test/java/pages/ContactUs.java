package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class ContactUs {
    public ContactUs() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/contact_us']")
    public WebElement contactUsLink;


    @FindBy(xpath = "(//h2)[2]")
    public WebElement getInTouch;



    @FindBy(xpath = "//input[@type='text']")
    public WebElement name;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement file;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement success;

    @FindBy(xpath = "//span")
    public WebElement home;



}
