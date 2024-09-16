package RegisterUser;

import BasePack.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegisterUserPage extends BaseClass{

    WebDriver driver;
    BaseClass baseClass;
    JavascriptExecutor executor;

    @FindBy(xpath = "//img[@src=\"/static/images/home/logo.png\"]") WebElement verifyHomePage;

    @FindBy(xpath = "//i[@class=\"fa fa-lock\"]") WebElement gotoLoginOrSignUp;
    @FindBy(xpath = "//h2[text()='New User Signup!']") WebElement verifyNewUserSignUpPage;
    @FindBy(xpath = "//input[@name=\"name\"]") WebElement userSignUP;
    @FindBy(xpath = "//input[@name=\"email\" and @data-qa=\"signup-email\"]") WebElement userSignUpMail;
    @FindBy(xpath = "//button[@class=\"btn btn-default\" and @data-qa=\"signup-button\"]") WebElement userSignButton;
    @FindBy(xpath = "//p[text()=\"Congratulations! Your new account has been successfully created!\"]") WebElement accountCreationSuccessfully;
    @FindBy(xpath = "//a[@data-qa=\"continue-button\"]") WebElement shoppingPageEra;
    @FindBy(id = "password") WebElement userPass;
    @FindBy(id = "first_name") WebElement firstName;
    @FindBy(id = "last_name") WebElement lastName;
    @FindBy(id = "address1") WebElement address;
    @FindBy(id = "country") WebElement selectCountry;
    @FindBy(id = "state") WebElement state;
    @FindBy(id = "city") WebElement city;
    @FindBy(id = "zipcode") WebElement zipCode;
    @FindBy(id = "mobile_number") WebElement mobileNum;
    @FindBy(xpath = "//button[@data-qa=\"create-account\"]") WebElement accountCreateBtn;

    @FindBy(xpath = "//a[@href=\"/delete_account\"]") WebElement deleteAcc;
    @FindBy(xpath = "//p[text()='Your account has been permanently deleted!']") WebElement deleteAccVerification;

    @FindBy(xpath = "//a[@href=\"/logout\"]") WebElement logout;


    public RegisterUserPage(WebDriver driver) {
        this.driver = driver;
        baseClass = new BaseClass();
        executor= ((JavascriptExecutor)driver);
        PageFactory.initElements(driver, this);
    }

    public String openUrlPage(String url) {
        driver.get(url);
        return driver.getCurrentUrl();
    }

    public boolean verifyHomeVisible(){
             //   driver.findElement(By.xpath(baseClass.properties.getProperty("verifyHomePage")));
        return verifyHomePage.isDisplayed();
    }

    public boolean setGotoLoginOrSignUp(){
        gotoLoginOrSignUp.click();
        return verifyNewUserSignUpPage.isDisplayed();
    }

    public void setUserSignUp(String userName, String userEmail){

        userSignUP.clear();
        userSignUP.sendKeys(userName);
        userSignUpMail.clear();
        userSignUpMail.sendKeys(userEmail);
        userSignButton.click();
    }
    public void setCreateAccount(String setPass, String fName, String lName,String setAddress1, String setMobileNum,String setState, String setCity, String setZipCode){

        userPass.sendKeys(setPass);
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        address.sendKeys(setAddress1);
        Select select = new Select(selectCountry);
        select.selectByValue("India");
       state.sendKeys(setState);
       city.sendKeys(setCity);
       zipCode.sendKeys(setZipCode);
        mobileNum.sendKeys(setMobileNum);
        accountCreateBtn.click();
    }
    public String verifyThatAccountCreated(){

        return accountCreationSuccessfully.getText();
    }
    public void directToShoppingPage(){
        shoppingPageEra.click();

    }
    public void deleteAccount(){
        deleteAcc.click();
    }
    public String verifyAccDeleteOrNot(){
        return deleteAccVerification.getText();
    }
    public void logoutFromCurrentACC(){
        logout.click();
    }
}
