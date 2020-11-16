package library2_tests;


import library2_main.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;
import java.util.concurrent.TimeUnit;

public class UserStoriesDemo extends BaseTest {
    //********USER STORIES********
    //US 1. As a student I should be able to login "Library" application
    //US 2. As a student I should be able to borrow a book from "Library" application

    @BeforeMethod
    public void setUp_Method() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open the url
        driver.get("http://library2.cybertekschool.com/login.html");
}

    //US 1. As a student I should be able to log into "Library" application
    //AC1. 	Student should be able to login with valid credentials

    @Test
    public void Login_Valid_Credentials () throws InterruptedException {
        //link
        driver.get("http://library2.cybertekschool.com/login.html");
        //email
        driver.findElement(By.id("inputEmail")).sendKeys("student63@library");
        //password
        driver.findElement(By.id("inputPassword")).sendKeys("Jg2orVoF");
        //click to the button "Sign in"
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        //this line gives me actual title of the page
        String actualTitle = driver.getTitle();
        //System.out.println (actualTitle);
        String expectedTitle = "library";
        //Assert
        Assert.assertEquals(expectedTitle.toLowerCase(),actualTitle.toLowerCase());
    }


    //US 1. As a student I should be able to log in "Library" application
    //AC2  Student should not be able to log in with invalid credentials

    @Test
    public void loginAttempt() throws InterruptedException {
        //  WebElement email = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/label"));
        WebElement email = driver.findElement(By.id("inputEmail"));
        // WebElement password = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/label"));
        WebElement password = driver.findElement(By.id("inputPassword"));
        WebElement signinButton = driver.findElement(By.cssSelector("#login-form > button"));
        Thread.sleep(2000);
        email.sendKeys("student63@library");
        password.sendKeys("Cybertek");
        Thread.sleep(2000);
        signinButton.click();
        Thread.sleep(2000);
        WebElement ActualInvalidLoginMessage = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div"));
        String AIM = ActualInvalidLoginMessage.getText();
        String ExpectedInvalidLoginMessage = "Sorry, Wrong Email or Password";
        Assert.assertEquals(AIM, ExpectedInvalidLoginMessage);
        System.out.println("Expected message: " + ExpectedInvalidLoginMessage);
        System.out.println("Actual message: " + AIM);
    }

    //US 2. As a student I should be able to borrow a book from "Library" application
    //AC2  User should be able to choose number of shown  records

    @Test
    public void show_records() throws InterruptedException {

        driver.findElement(By.id("inputEmail")).sendKeys("student64@library");
        driver.findElement(By.id("inputPassword")).sendKeys("pbdQAvkN");
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
        Thread.sleep(3000);
        homePage = new HomePage(driver);
        homePage.clickRecord();

    }


    //US 2. As a student I should be able to borrow a book from "Library" application
    //AC1	User should be able to choose any category

    @Test
    public void book_categories() throws InterruptedException {

        driver.findElement(By.id("inputEmail")).sendKeys("student64@library");
        driver.findElement(By.id("inputPassword")).sendKeys("pbdQAvkN");
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click "Book Categories"
        driver.findElement(By.id("book_categories")).click();
        Thread.sleep(3000);

        // choose a category
        driver.findElement(By.xpath("//option[@value='14']")).click();
        Thread.sleep(2000);

    }



    @AfterMethod
    public void close(){
        driver.quit();
    }
}
