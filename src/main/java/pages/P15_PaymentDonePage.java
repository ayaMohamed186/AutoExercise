package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P15_PaymentDonePage {

    WebDriver driver;

    public P15_PaymentDonePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By downloadInvoiceBtn = By.xpath("//a[@class='btn btn-default check_out']");

    public P15_PaymentDonePage clickOnDownloadInvoiceBtn(){
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.downloadInvoiceBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.downloadInvoiceBtn).click();
        return this;
    }

    public boolean validateFileDownloaded(String downloadPath, String fileName){
        File downloadedFile = new File(downloadPath+ File.separator + fileName);
        boolean isFileDownloaded = downloadedFile.exists();
        return isFileDownloaded;
    }
}
