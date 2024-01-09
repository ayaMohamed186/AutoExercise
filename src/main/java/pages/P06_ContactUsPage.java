package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P06_ContactUsPage {
    WebDriver driver;

    public P06_ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By contactUsMsg = By.xpath("//div[@class='contact-form']/h2");
    private final By nameInputField = By.xpath("//input[@name='name']");
    private final By emailInputField = By.xpath("(//input[@type='email'])[1]");
    private final By subjectInputField = By.xpath("//input[@name='subject']");
    private final By msgInputField = By.id("message");
    private final By uploadFileBtn = By.xpath("//input[@type='file']");
    private final By submitBtn = By.xpath("//input[@type='submit']");
    private final By successMsgForContactUs = By.xpath("//div[@class='status alert alert-success']");
    private final By homeBtn = By.xpath("//div[@id='form-section']/a");

    public boolean validateGetInTouchMsgDisplay() {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.contactUsMsg));
        return driver.findElement(this.contactUsMsg).isDisplayed();
    }

    public P06_ContactUsPage fillNameInputField(String name) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.nameInputField));
        driver.findElement(this.nameInputField).sendKeys(name);
        return this;
    }
    public P06_ContactUsPage fillEmailInputField(String email) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.emailInputField));
        driver.findElement(this.emailInputField).sendKeys(email);
        return this;
    }

    public P06_ContactUsPage fillSubjectInputField(String subject) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.subjectInputField));
        driver.findElement(this.subjectInputField).sendKeys(subject);
        return this;
    }

    public P06_ContactUsPage fillMsgInputField(String msg) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.msgInputField));
        driver.findElement(this.msgInputField).sendKeys(msg);
        return this;
    }

    public P06_ContactUsPage uploadFile() {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.uploadFileBtn));
        WebElement chooseFileElement = driver.findElement(this.uploadFileBtn);// click on " choose file " to upload one
        String filePath = System.getProperty("user.dir") + "/src/test/resources/download (1).png"; // path of file
        chooseFileElement.sendKeys(filePath);  // send path to choose file element
        return this;
    }

    public P06_ContactUsPage clickOnSubmitBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.submitBtn).click();
        return this;
    }

    public P06_ContactUsPage clickOnOKAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public boolean validateSuccessMsgDisplayed(){
        return driver.findElement(this.successMsgForContactUs).getText().equals("Success! Your details have been submitted successfully.");
    }

    public P06_ContactUsPage clickOnHomeBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.homeBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.homeBtn).click();
        return this;
    }
}
