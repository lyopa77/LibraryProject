package library2_main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".form-control.input-sm.input-xsmall.input-inline")
    WebElement dropDownClick;

    @FindBy(css = ".btn.btn-primary.btn-sm")
    List<WebElement> tableRows;


    public void clickRecord() {
        int count = 0;
        Select select = new Select(dropDownClick);
        select.selectByVisibleText("200");
        for (int i = 1; i < tableRows.size(); i++) {
            count++;
        }
        System.out.println("Amount of records: " + count);
    }



}
