package TestRegisterPage;

import BasePack.BaseClass;
import RegisterUser.RegisterUserPage;
import RegisterUser.RegisterWithLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VerifyRegisterPage {

    WebDriver driver;
    BaseClass baseClass;
    RegisterUserPage registerUserPage;
    RegisterWithLoginPage registerWithLoginPage;

    @BeforeSuite
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

    @Test(priority = 4,dataProvider = "UserData")
    public void verifyUserSignUp(String userName, String UserEmail){
        registerUserPage.setUserSignUp(userName,UserEmail);

    }

    @DataProvider(name = "UserData")
    public Object[][] enterUserData(){
        return new Object[][] {
            {"abcd", "abcd.com"},
            {"xyz","zyz@...!!!"},
            {"Bhaai","adevara@gmail.com"}

        };
    }

    @Test(priority = 5)
    public void verifyCreatingAcc(){
        registerUserPage.setCreateAccount("Yogi@1213","yogi","reddy","RamchandraPuram","8378454452","Andhra Pradesh","Ongole","52347");

    }
    @Test(priority = 6)
    public void verifyAccountCreate(){
        assertEquals(registerUserPage.verifyThatAccountCreated(),"Congratulations! Your new account has been successfully created!");
    }
    @Test(priority = 7)
    public void navigateShoppingPage(){
        registerUserPage.directToShoppingPage();
    }
//    @Test(priority = 8)
//    public void loginIntoShopping(){
//        registerWithLoginPage.setUserLogin("pushpa2@gmail.com","Yogi@1213");
//        assertEquals(registerWithLoginPage.verifyShoppingPage(),"Bhaai");
//    }
//    @Test(priority = 9)
//    public void verifyLogout(){
//        registerUserPage.logoutFromCurrentACC();
//    }
    @Test(priority = 9,enabled = false)
    public void deleteAccount(){
       registerUserPage.deleteAccount();
       assertEquals(registerUserPage.verifyAccDeleteOrNot(),"Your account has been permanently deleted!");
    }

    @AfterSuite
    public void exit(){
        if(driver!=null){
            driver.close();
        }
    }
}
