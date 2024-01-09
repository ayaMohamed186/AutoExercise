package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P05_AccountDeletedPage {

    WebDriver driver;

    public P05_AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By deletedAccMsgDisplayed = By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/h2/b");
    private final By continueBtn = By.xpath("(//a[@href='/'])[3]");

    public boolean validateAccDeletedDisplay(){
        return driver.findElement(this.deletedAccMsgDisplayed).isDisplayed();
    }

    public P05_AccountDeletedPage clickOnContinueBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueBtn).click();
        return this;
    }
}
