package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P13_CategoryPage {

    WebDriver driver;

    public P13_CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By CategoryTextDisplayedEle = By.xpath("//h2[@class='title text-center']");
    private final By menCategory = By.xpath("//a[@href='#Men']");
    private final By tshirtSubCategory = By.xpath("//a[@href='/category_products/3']");

    public String categoryTextDisplayed() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.CategoryTextDisplayedEle));
        return driver.findElement(this.CategoryTextDisplayedEle).getText();
    }

    public P13_CategoryPage chooseMenCategory() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.menCategory));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.menCategory).click();
        return this;
    }

    public P13_CategoryPage chooseTShirtSubCategory() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.tshirtSubCategory));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.tshirtSubCategory).click();
        return this;
    }
}