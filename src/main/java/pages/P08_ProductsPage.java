package pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P08_ProductsPage {

    WebDriver driver;

    public P08_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By allProductsMsg = By.xpath("//div[@class='features_items']/h2");
    private final By viewProductFirstItem = By.xpath("//a[@href='/product_details/1']");
    private final By viewProductSecondItem = By.xpath("//a[@href='/product_details/2']");
    private final By searchInputField = By.id("search_product");
    private final By submitSearchBtn = By.xpath("//button[@id='submit_search']");
    private final By searchedItemName = By.xpath("//div[@class='productinfo text-center']/p");
    private final By firstProductHover = By.xpath("(//div[@class='productinfo text-center'])[1]");
    private final By firstProductAddToCart = By.xpath("(//a[@data-product-id='1'])[2]");
    private final By firstProductName = By.xpath("(//div[@class='productinfo text-center']/p)[1]");
    private final By secondProductHover = By.xpath("(//div[@class='productinfo text-center'])[2]");
    private final By secondProductAddToCart = By.xpath("(//a[@data-product-id='2'])[2]");
    private final By secondProductName = By.xpath("(//div[@class='productinfo text-center']/p)[2]");
    private final By continueShoppingBtn = By.xpath("//button[@data-dismiss='modal']");
    private final By viewCartAtPopupMsg = By.xpath("(//a[@href='/view_cart'])[2]");
    private final By brandCategoryTextDisplayed = By.xpath("//div[@class='brands_products']/h2");
    private final By brandHMelement = By.xpath("//a[@href='/brand_products/H&M']");


    public List<WebElement> getProductElements() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='productinfo text-center']/p")));
        return driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
    }

    public boolean isProductDisplayed(String productName) {
        for (WebElement productElement : getProductElements()) {
            if (productElement.getText().toLowerCase().contains(productName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
        // List<WebElement> productElementsAddTCart = driver.findElements(By.xpath("//div[@class='overlay-content']/a"));

    public P08_ProductsPage chooseHMBrand(){
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.brandHMelement));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.brandHMelement).click();
        return this;
    }

    public boolean validateBrandCategoryDisplayed(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.brandCategoryTextDisplayed));
        return driver.findElement(this.brandCategoryTextDisplayed).isDisplayed();
    }

    public boolean validateProductsPageDisplay() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.allProductsMsg));
        return driver.findElement(this.allProductsMsg).isDisplayed();
    }

    public P08_ProductsPage clickOnViewProductFirstItem() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.viewProductFirstItem));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.viewProductFirstItem).click();
        return this;
    }
    public P08_ProductsPage clickOnViewProductSecondItem() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.viewProductSecondItem));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.viewProductSecondItem).click();
        return this;
    }
    public P08_ProductsPage fillSearchProduct(String productName) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.searchInputField));
        driver.findElement(this.searchInputField).sendKeys(productName);
        return this;
    }

    public P08_ProductsPage clickOnSubmitBtn() {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitSearchBtn));
        driver.findElement(this.submitSearchBtn).click();
        return this;
    }

    public String validateSearchedProductDisplay() {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.searchedItemName));
        return driver.findElement(this.searchedItemName).getText();
    }

    public P08_ProductsPage hoverOnFirstProduct() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductHover));
        WebElement firstProductElement = driver.findElement(this.firstProductHover);
        Actions hover = new Actions(driver);
        hover.moveToElement(firstProductElement).perform();
        return this;
    }

    public P08_ProductsPage clickOnAddToCartFirstProd() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.firstProductAddToCart));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.firstProductAddToCart).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }

    public P08_ProductsPage clickOnContinueShopping() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueShoppingBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueShoppingBtn).click();
        return this;
    }


    public P08_ProductsPage hoverOnSecondProduct() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.secondProductHover));
        WebElement secondProductElement = driver.findElement(this.secondProductHover);
        Actions hover = new Actions(driver);
        hover.moveToElement(secondProductElement).perform();
        return this;
    }

    public P08_ProductsPage clickOnAddToCartSecondProd() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.secondProductAddToCart));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.secondProductAddToCart).click();
        return this;
    }

    public P08_ProductsPage clickOnViewCartAtPopupMsg() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.viewCartAtPopupMsg));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.viewCartAtPopupMsg).click();
        return this;
    }

    public String firstProductNameAdded() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductName));
        return driver.findElement(this.firstProductName).getText();
    }

    public String secondProductNameAdded() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.secondProductName));
        return driver.findElement(this.secondProductName).getText();
    }


}
