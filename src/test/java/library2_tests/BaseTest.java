package library2_tests;

import library2_main.HomePage;
import library2_main.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import utility.WebDriverFactory;


public class BaseTest {

    protected static WebDriver driver;
    protected static LoginPage loginPage;
    protected static HomePage homePage;

    @BeforeClass
    public static void testBase() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://library2.cybertekschool.com/login.html");

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Login - Library";
        Assert.assertEquals(expectedTitle, actualTitle);

//
//        loginPage = new LoginPage(driver);
//        loginPage.emailAddressInput();
//        loginPage.passwordInput();
//        loginPage.buttonSighIn();

    }
}
