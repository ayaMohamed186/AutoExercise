package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P02_SignUpLoginPage {

    WebDriver driver;

    public P02_SignUpLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By NewUserSignupDisplay = By.xpath("//div[@class='signup-form']//h2");
    private final By emailInputFieldForSignUP = By.xpath("(//input[@type='email'])[2]");
    private final By nameInputField = By.xpath("//input[@type='text']");
    private final By signUpBtn = By.xpath("(//button[@type='submit'])[2]");
    private final By loginToAccMsgDisplay = By.xpath("//div[@class='col-sm-4 col-sm-offset-1']/div/h2");
    private final By emailInputFieldForLogin = By.xpath("(//input[@type='email'])[1]");
    private final By passwordInputFieldForLogin = By.xpath("//input[@type='password']");
    private final By loginBtn = By.xpath("(//button[@type='submit'])[1]");
    private final By validationOfInvalidLoginDisplay = By.xpath("//div[@class='login-form']/form/p");
    private final By validationOfEmailAlreadyRegistered = By.xpath("//div[@class='signup-form']/form/p");

    public boolean verifyValidationDisplay(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.validationOfInvalidLoginDisplay));
        return driver.findElement(this.validationOfInvalidLoginDisplay).isDisplayed();
    }

    public String validateSignUpHeaderDisplay() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.NewUserSignupDisplay));
        return driver.findElement(this.NewUserSignupDisplay).getText();
    }

    public P02_SignUpLoginPage fillNameInputFieldForSignUP(String Name) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.nameInputField));
        driver.findElement(this.nameInputField).sendKeys(Name);
        return this;
    }

    public P02_SignUpLoginPage fillEmailInputFieldForSignUP(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.emailInputFieldForSignUP));
        driver.findElement(this.emailInputFieldForSignUP).sendKeys(email);
        return this;
    }

    public P02_SignUpLoginPage clickOnSIgnUpBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.signUpBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.signUpBtn).click();
        return this;
    }

    public boolean validateLoginToAccMsgDisplay() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.loginToAccMsgDisplay));
        return driver.findElement(this.loginToAccMsgDisplay).isDisplayed();
    }

    public P02_SignUpLoginPage fillEmailFieldForLogin(String email) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.emailInputFieldForLogin));
        driver.findElement(this.emailInputFieldForLogin).sendKeys(email);
        return this;
    }

    public P02_SignUpLoginPage fillPasswordFieldForLogin(String password) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.passwordInputFieldForLogin));
        driver.findElement(this.passwordInputFieldForLogin).sendKeys(password);
        return this;
    }

    public P02_SignUpLoginPage clickOnLoginBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.loginBtn).click();
        return this;
    }

    public boolean verifyValidationSignUpDisplay(){
        return driver.findElement(this.validationOfEmailAlreadyRegistered).isDisplayed();
    }
}
