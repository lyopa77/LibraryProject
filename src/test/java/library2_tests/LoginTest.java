package library2_tests;

import library2_main.HomePage;
import library2_main.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  LoginPage loginPage =  new LoginPage(driver);

  @Test
  public void testLogin() throws InterruptedException {

      loginPage = new LoginPage(driver);
      loginPage.emailAddressInput();
      Thread.sleep(3000);
      loginPage.passwordInput();
      Thread.sleep(3000);
      loginPage.buttonSighIn();
      Thread.sleep(3000);

     homePage = new HomePage(driver);
     homePage.clickRecord();



  }
}
