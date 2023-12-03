package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

    String totalCostTextXpath = "//strong[@class='notranslate float_right c-price h-price--large']";
    String nextButtonXpath = "//button[@class='c-btn--primary h-btn-intent--atc h-btn--full-width  ']";

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public double totalCost(){
        WebElement totalCostText = driver.findElement(By.xpath(totalCostTextXpath));
        return Double.parseDouble(totalCostText.
                getText().replaceAll("\n",".").replace(" ", "").
                substring(0, totalCostText.getText().length()-3));
    }

    public boolean isClickableButtonNext(){
        try {
            WebElement nextButton = driver.findElement(By.xpath(nextButtonXpath));
            nextButton.click();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
