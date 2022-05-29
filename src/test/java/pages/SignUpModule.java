package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class SignUpModule {

    public SignUpModule(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//h2)[1]")
    public WebElement loginLabel;

    @FindBy(xpath = "(//input[@type='email'])[1]")
    public WebElement inputEmail;



    @FindBy(xpath = "(//button)[1]")
    public WebElement login;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement loginerror;




}
