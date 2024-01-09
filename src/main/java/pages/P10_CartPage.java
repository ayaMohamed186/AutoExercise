package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P10_CartPage {

    WebDriver driver;

    public P10_CartPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By firstProductAtCartName = By.xpath("//a[@href='/product_details/1']");
    private final By secondProductAtCartName = By.xpath("//a[@href='/product_details/2']");
    private final By firstProductAtCartPrice = By.xpath("//tr[@id='product-1']/td[3]/p");
    private final By secondProductAtCartPrice = By.xpath("//tr[@id='product-2']/td[3]/p");
    private final By firstProductAtCartQuantity = By.xpath("(//button[@class='disabled'])[1]");
    private final By secondProductAtCartQuantity = By.xpath("(//button[@class='disabled'])[2]");
    private final By shoppingCartMsg = By.xpath("//li[@class='active']");
    private final By processedToCheckoutBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By registerLoginBtn = By.xpath("(//a[@href='/login'])[2]");
    private final By deleteProductBtn = By.xpath("//a[@data-product-id='1']");

    public boolean validateProductDisplayAfterDelete(){
       longWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(firstProductAtCartName));
        WebElement DeletedProductName = driver.findElement(this.firstProductAtCartName);
        return DeletedProductName.isDisplayed();
    }
    public  boolean validateCartPageOpen(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.shoppingCartMsg));
        return driver.findElement(this.shoppingCartMsg).isDisplayed();
    }
    public String firstProductAtCartName (){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductAtCartName));
        return driver.findElement(this.firstProductAtCartName).getText();
    }

    public String firstProductAtCartPrice (){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductAtCartPrice));
        return driver.findElement(this.firstProductAtCartPrice).getText().replaceAll("[^\\d\\.]", "");
    }

    public String firstProductAtCartQuantity(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductAtCartQuantity));
        return driver.findElement(this.firstProductAtCartQuantity).getText();
    }

    public String secondProductAtCartName (){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.secondProductAtCartName));
        return driver.findElement(this.secondProductAtCartName).getText();
    }

    public String secondProductAtCartPrice (){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.secondProductAtCartPrice));
        return driver.findElement(this.secondProductAtCartPrice).getText().replaceAll("[^\\d\\.]", "");
    }

    public String secondProductAtCartQuantity(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.secondProductAtCartQuantity));
        return driver.findElement(this.secondProductAtCartQuantity).getText();
    }

    public P10_CartPage clickOnProcessedToCheckoutBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.processedToCheckoutBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.processedToCheckoutBtn).click();
        return this;
    }
    public P10_CartPage clickOnRegisterLoginBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.registerLoginBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.registerLoginBtn).click();
        return this;
    }
    public P10_CartPage clickOnDeleteProductBtn() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.deleteProductBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.deleteProductBtn).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }
}
