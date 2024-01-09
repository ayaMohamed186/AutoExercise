package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt;

public class P03_EnterAccountInfoPage {
    WebDriver driver;

    public P03_EnterAccountInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By enterAccInfoP = By.xpath("//div[@class='login-form']/h2/b");
    private final By titleRadioBtn = By.xpath("//input[@type='radio']");
    private final By passwordInputField = By.id("password");
    public final By dayElement = By.id("days");
    public final By monthElement = By.id("months");
    public final By yearElement = By.id("years");
    private final By signUpForNewsletter = By.id("newsletter");
    private final By receiveSpecialOfferCheck = By.id("optin");
    private final By firstNameInputField = By.id("first_name");
    private final By lastNameInputField = By.id("last_name");
    private final By companyElement = By.id("company");
    private final By address1InputField = By.id("address1");
    private final By address2inputField = By.id("address2");
    private final By countryDropDown = By.id("country");
    private final By stateInputField = By.id("state");
    private final By cityInputField = By.id("city");
    private final By zipcodeInputField = By.id("zipcode");
    private final By mobileNumberInputField = By.id("mobile_number");
    private final By createAccBtn = By.xpath("(//button[@type='submit'])[1]");
    private final By accountCreatedMsgDisplayed = By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/h2/b");


    public String validateEnterAccInfoVisible(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.enterAccInfoP));
        String test = driver.findElement(this.enterAccInfoP).getText();
        return driver.findElement(this.enterAccInfoP).getText().toUpperCase();
    }

    public P03_EnterAccountInfoPage chooseTitle(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.titleRadioBtn));
        driver.findElement(By.xpath("(//input[@type='radio'])["+ generateRandomInt(2)+"]")).click();
        return this;
    }

    public P03_EnterAccountInfoPage fillPassword(String Password){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.passwordInputField));
        driver.findElement(this.passwordInputField).sendKeys(Password);
        return this;
    }

    public P03_EnterAccountInfoPage selectDay(int index){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.dayElement));
        WebElement dayElement = driver.findElement(this.dayElement);
        Select day=new Select(dayElement);
        day.selectByIndex(index);
        return this;
    }

    public P03_EnterAccountInfoPage selectMonth(int index)
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.monthElement));
        WebElement monthElement = driver.findElement(this.monthElement);
        Select month=new Select(monthElement);
        month.selectByIndex(index);
        return this;
    }

    public P03_EnterAccountInfoPage selectYear(int index){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.yearElement));
        WebElement yearElement = driver.findElement(this.yearElement);
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByIndex(index);
        return this;
    }

    public P03_EnterAccountInfoPage checkOnSignUForNewsletter(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.signUpForNewsletter));
        driver.findElement(this.signUpForNewsletter).click();
        return this;
    }

    public P03_EnterAccountInfoPage checkOnReceiveSpecialOfferCheck(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.receiveSpecialOfferCheck));
        driver.findElement(this.receiveSpecialOfferCheck).click();
        return this;
    }

    public P03_EnterAccountInfoPage fillFirstName(String firstName){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstNameInputField));
        driver.findElement(this.firstNameInputField).sendKeys(firstName);
        return this;
    }

    public P03_EnterAccountInfoPage fillLastName(String lastName){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.lastNameInputField));
        driver.findElement(this.lastNameInputField).sendKeys(lastName);
        return this;
    }

    public P03_EnterAccountInfoPage fillCompanyDetails(String company){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.companyElement));
        driver.findElement(this.companyElement).sendKeys(company);
        return this;
    }
    public P03_EnterAccountInfoPage fillAddress1(String address){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.address1InputField));
        driver.findElement(this.address1InputField).sendKeys(address);
        return this;
    }

    public P03_EnterAccountInfoPage fillAddress2(String address2){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.address2inputField));
        driver.findElement(this.address2inputField).sendKeys(address2);
        return this;
    }

    public P03_EnterAccountInfoPage selectCounty(int index)
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.countryDropDown));
        WebElement countryElement = driver.findElement(this.countryDropDown);
        Select month=new Select(countryElement);
        month.selectByIndex(index);
        return this;
    }

    public P03_EnterAccountInfoPage fillState(String state){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.stateInputField));
        driver.findElement(this.stateInputField).sendKeys(state);
        return this;
    }

    public P03_EnterAccountInfoPage fillCity(String city){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cityInputField));
        driver.findElement(this.cityInputField).sendKeys(city);
        return this;
    }

    public P03_EnterAccountInfoPage fillZipCodeInputField(String ZipCode) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.zipcodeInputField));
        driver.findElement(this.zipcodeInputField).sendKeys(ZipCode);
        return this;
    }
    public P03_EnterAccountInfoPage fillMobileNoInputField(String mobileNo) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.mobileNumberInputField));
        driver.findElement(this.mobileNumberInputField).sendKeys(mobileNo);
        return this;
    }

    public P03_EnterAccountInfoPage clickOnCreateAccBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.createAccBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.createAccBtn).click();
        return this;
    }

    public String validateAccountCreatedMsg(){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.accountCreatedMsgDisplayed));
        return driver.findElement(this.accountCreatedMsgDisplayed).getText();
    }

}
