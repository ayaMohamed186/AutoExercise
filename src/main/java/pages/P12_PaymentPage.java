package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.shortWait;

public class P12_PaymentPage {

    WebDriver driver;

    public P12_PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By cardHolderName = By.xpath("(//input[@type='text'])[1]");
    private final By cardNumberEle = By.xpath("(//input[@type='text'])[2]");
    private final By cardCVCEle = By.xpath("(//input[@type='text'])[3]");
    private final By cardExpireMonth = By.xpath("//input[@name='expiry_month']");
    private final By cardExpireYear = By.xpath("//input[@name='expiry_year']");
    private final By payAndConfirmOrder = By.id("submit");
    private final By orderPlacedMSuccessMsg = By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/p");

    public P12_PaymentPage fillCardHolderName(String holderName){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardHolderName));
        driver.findElement(this.cardHolderName).sendKeys(holderName);
        return this;
    }


    public P12_PaymentPage fillCreditCardNumberField(String creditNumber){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardNumberEle));
        driver.findElement(this.cardNumberEle).sendKeys(creditNumber);
        return this;
    }
    public P12_PaymentPage fillCardCVC(String cardCode){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardCVCEle));
        driver.findElement(this.cardCVCEle).sendKeys(cardCode);
        return this;
    }

    public P12_PaymentPage selectExpireYear(String year){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardExpireYear));
        driver.findElement(this.cardExpireYear).sendKeys(year);
        return this;
    }
    public P12_PaymentPage selectExpireMonth(String month){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardExpireMonth));
        driver.findElement(this.cardExpireMonth).sendKeys(month);
        return this;
    }

    public P12_PaymentPage clickOnPayBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.payAndConfirmOrder));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.payAndConfirmOrder).click();
        return this;
    }

    public boolean validateOrderCreatedSuccess(){
        return driver.findElement(this.orderPlacedMSuccessMsg).getText().equals("Congratulations! Your order has been confirmed!");
    }

}
