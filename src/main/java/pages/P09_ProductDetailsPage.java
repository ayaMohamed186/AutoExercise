package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P09_ProductDetailsPage {

    WebDriver driver;

    public P09_ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstProductName = By.xpath("//div[@class='product-information']/h2");
    private final By firstProductCategory = By.xpath("//div[@class='product-information']/p[1]");
    private final By productPrice = By.xpath("//div[@class='product-information']/span/span");
    private final By firstProductAvailability = By.xpath("//div[@class='product-information']/p[2]");

    private final By firstProductCondition = By.xpath("//div[@class='product-information']/p[3]");
    private final By firstProductBrand= By.xpath("//div[@class='product-information']/p[4]");
    private final By productQuantity = By.id("quantity");
    private final By addToCartBtn = By.xpath("//button[@type='button']");
    public boolean validateProductNameVisible(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductName));
        return driver.findElement(this.firstProductName).isDisplayed();
    }
    public boolean validateProductCategoryVisible(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductCategory));
        return driver.findElement(this.firstProductCategory).isDisplayed();
    }
    public boolean validateProductPriceVisible(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productPrice));
        return driver.findElement(this.productPrice).isDisplayed();
    }
    public boolean validateProductAvailabilityVisible(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductAvailability));
        return driver.findElement(this.firstProductAvailability).isDisplayed();
    }
    public boolean validateProductConditionVisible(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductCondition));
        return driver.findElement(this.firstProductCondition).isDisplayed();
    }
    public boolean validateProductBrandVisible(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductBrand));
        return driver.findElement(this.firstProductBrand).isDisplayed();
    }

    public String getFirstProductPrice(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productPrice));
        return driver.findElement(this.productPrice).getText().replaceAll("[^\\d\\.]", "");
    }
    public String getFirstProductQuantity() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productQuantity));
        return driver.findElement(this.productQuantity).getAttribute("value");
    }
    public P09_ProductDetailsPage increaseProductQuantityTo4(){
        WebElement firstItemQuantity = driver.findElement(this.productQuantity);
        firstItemQuantity.clear();
        firstItemQuantity.sendKeys("4");
        return this;
    }

    public P09_ProductDetailsPage clickOnContinueBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addToCartBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.addToCartBtn).click();
        return this;
    }
}
