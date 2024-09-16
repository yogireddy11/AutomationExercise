package TestRegisterPage;

import BasePack.BaseClass;
import RegisterUser.RegisterUserPage;
import RegisterUser.RegisterWithLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VerifyLoginPage {
    WebDriver driver;
    BaseClass baseClass;
    RegisterUserPage registerUserPage;
    RegisterWithLoginPage registerWithLoginPage;
    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        baseClass = new BaseClass();
        baseClass.initialBaseSetup(browser);
        driver = baseClass.driver;
        registerUserPage = new RegisterUserPage(driver);
        registerWithLoginPage = new RegisterWithLoginPage(driver);
    }
    @Test(priority = 1)
    @Parameters("url")
    public void navigateToURL(@Optional("https://automationexercise.com") String url) {
        registerUserPage.openUrlPage(url);
        assertEquals(driver.getCurrentUrl(), url);  // Compare the current URL with the passed one
    }

    @Test(priority = 2)
    public void verifyHomePageVisible() {
        assertTrue(registerUserPage.verifyHomeVisible(), "Home page logo is not visible");
    }
    @Test(priority = 3)
    public void VerifyGoToLoginAndSignUpPage(){
         registerUserPage.setGotoLoginOrSignUp();
        assertTrue(registerUserPage.setGotoLoginOrSignUp());
    }
    @Test(priority = 4)
    public void loginIntoShopping(){
        registerWithLoginPage.setUserLogin("adevara@gmail.com","Yogi@1213");
        assertEquals(registerWithLoginPage.verifyShoppingPage(),"Bhaai");
    }
    @Test(priority = 5)
    public void verifyLogout(){
        registerUserPage.logoutFromCurrentACC();
    }
}
