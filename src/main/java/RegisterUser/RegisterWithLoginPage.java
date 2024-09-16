package RegisterUser;

import BasePack.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterWithLoginPage extends BaseClass {

    WebDriver driver;
    BaseClass baseClass;
    @FindBy(xpath = "//input[@data-qa=\"login-email\"]")
    WebElement loginEmailId;
    @FindBy(xpath = "//input[@data-qa=\"login-password\"]") WebElement loginPassword;
    @FindBy(xpath = "//button[@data-qa=\"login-button\"]") WebElement loginBtn;

    @FindBy(xpath = "//b[text()='raghuGreen']") WebElement verifyShopPage;
    public RegisterWithLoginPage(WebDriver driver){
        this.driver=driver;
        baseClass = new BaseClass();
        PageFactory.initElements(driver,this);

    }

    public void setUserLogin(String email, String password){
        loginEmailId.sendKeys(email);
        loginPassword.sendKeys(password);
        loginBtn.click();
    }
    public String verifyShoppingPage(){
        return verifyShopPage.getText();
    }
}
