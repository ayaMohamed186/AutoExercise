package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P01_HomePage {
    WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By homeBtn = By.xpath("(//a[@href='/'])[2]");
    private final By signUpLoginBtn = By.xpath("//a[@href='/login']");
    private final By loggedAsBtn = By.xpath("//li[10]/a");
    private final By deleteAccBtn = By.xpath("//a[@href='/delete_account']");
    private final By logoutBtn = By.xpath("//a[@href='/logout']");
    private final By contactUsBtn = By.xpath("//a[@href='/contact_us']");
    private final By testCasesBtn = By.xpath("(//a[@href='/test_cases'])[1]");
    private final By productsBtn = By.xpath("//a[@href='/products']");
    private final By subscriptionText = By.xpath("//div[@class='single-widget']/h2");
    private final By subscriptionMail = By.id("susbscribe_email");
    private final By submitSubscription = By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
    private final By subscriptionSubmitAlert = By.xpath("//div[@class='alert-success alert']");
    private final By cartBtn = By.xpath("(//a[@href='/view_cart'])[1]");
    private final By categoryText = By.xpath("//div[@class='left-sidebar']/h2");
    private final By womenCategory = By.xpath("//a[@href='#Women']");
    private final By dressWomenCategory = By.xpath("//a[@href='/category_products/1']");
    private final By recommendationItemsMsgSection = By.xpath("(//h2[@class='title text-center'])[2]");
    private final By recommendProductAddToCart = By.xpath("(//a[@data-product-id='1'])[3]");
    private final By recommendProductName = By.xpath("");


    public boolean validateCategoryDisplayed(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.categoryText));
        return driver.findElement(this.categoryText).isDisplayed();
    }

    public boolean validateHomePageIsVisible(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.homeBtn));
        return driver.findElement(this.homeBtn).isDisplayed();
    }

    public P01_HomePage clickSingUpLoginButton() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.signUpLoginBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.signUpLoginBtn).click();
        return this;
    }

    public P01_HomePage clickHomeBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.homeBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.homeBtn).click();
        return this;
    }
    public boolean validateLoggedAsUserNameDisplay(){
        longWait(driver).until(ExpectedConditions.elementToBeClickable(this.loggedAsBtn));
        return driver.findElement(this.loggedAsBtn).isDisplayed();
    }

    public P01_HomePage clickDeleteAccBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.deleteAccBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.deleteAccBtn).click();
        return this;
    }

    public P01_HomePage clickLogOutBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.logoutBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.logoutBtn).click();
        return this;
    }
    public P01_HomePage clickContactUsBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.contactUsBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.contactUsBtn).click();
        return this;
    }

    public P01_HomePage clickTestCaseBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.testCasesBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.testCasesBtn).click();
        return this;
    }

    public P01_HomePage clickProductsBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.productsBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.productsBtn).click();
        return this;
    }

    public P01_HomePage scrollToFooter(){
        WebElement footerElement = driver.findElement(By.id("susbscribe_email"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerElement);
        return this;
    }
    public boolean validateSubscriptionDisplay(){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.subscriptionText));
        return driver.findElement(this.subscriptionText).isDisplayed();
    }

    public P01_HomePage fillSubscriptionMail(String mail){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.subscriptionMail));
        driver.findElement(this.subscriptionMail).sendKeys(mail);
        return this;
    }

    public P01_HomePage clickOnSubmitSubscription(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitSubscription));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.submitSubscription).click();
        return this;
    }

    public boolean validateSubmitSubscription(){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.subscriptionSubmitAlert));
        return driver.findElement(this.subscriptionSubmitAlert).isDisplayed();
    }
    public P01_HomePage clickOnCartBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.cartBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.cartBtn).click();
        return this;
    }

    public P01_HomePage chooseWomenCategory(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.womenCategory));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.womenCategory).click();
        return this;
    }
    public P01_HomePage chooseWomenDressCategory(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.dressWomenCategory));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.dressWomenCategory).click();
        return this;
    }

    public boolean validateRecommendationSecVisible(){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.recommendationItemsMsgSection));
        return driver.findElement(this.recommendationItemsMsgSection).isDisplayed();
    }

    public P01_HomePage clickOnAddToCartForRecommendation(){
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.recommendProductAddToCart));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.recommendProductAddToCart).click();
        return this;
    }


}
