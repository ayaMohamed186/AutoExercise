package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P07_TestCasesPage {
    WebDriver driver;

    public P07_TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By testCasesMsg = By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/h2/b");

    public boolean validateTestCasePageDisplay(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.testCasesMsg));
        return driver.findElement(this.testCasesMsg).isDisplayed();
    }
}
