package ShoppingUser;

import BasePack.BaseClass;
import RegisterUser.RegisterUserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingUserPage extends BaseClass {

    WebDriver driver;
    BaseClass baseClass;
    RegisterUserPage registerUserPage;

    public ShoppingUserPage(WebDriver driver){
        this.driver=driver;
        baseClass = new BaseClass();
        PageFactory.initElements(driver, this);
    }


}
