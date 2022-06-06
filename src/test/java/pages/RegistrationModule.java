package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.CrossDriver;
import utulities.Driver;

public class RegistrationModule {

   public RegistrationModule(){

       PageFactory.initElements(CrossDriver.getDriver("browser"),this);

   }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginLinki;

   @FindBy(xpath ="//html")
   public WebElement mainPage;

    @FindBy(xpath ="(//h2)[2]")
    public WebElement newUserSignUpLabel;


    @FindBy(xpath ="//input[@data-qa='signup-name']")
    public WebElement newUserSignUpName;

    @FindBy(xpath ="//input[@data-qa='signup-email']")
    public WebElement newUserSignUpEmail;


    @FindBy(xpath ="//button[@data-qa='signup-button']")
    public WebElement newUserSignUpButton;


    @FindBy(xpath ="//b[text()='Enter Account Information']")
    public WebElement enterAccountInformation;



    @FindBy(xpath ="(//input[@name='title'])[1]")
    public WebElement inputTitle;

    @FindBy(xpath = "(//button)[1]")
    public WebElement createAccount;

    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreated;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement accountCreatedContinue;

    @FindBy(xpath = "//b")
    public WebElement loggedName;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logOut;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    public WebElement emailAlreadyExist;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccount;



}
