package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P04_AccountCreatedPage {
    WebDriver driver;

    public P04_AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By continueBtn = By.xpath("(//a[@href='/'])[3]");

    public P04_AccountCreatedPage clickOnContinueBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueBtn).click();
        return this;
    }

}
