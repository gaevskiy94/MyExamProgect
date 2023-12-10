package utils;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

import static utils.DriverProvider.getCurrentDriver;

public class AssertionUtils {

    public static void assertContains(String inText, String words){
        Reporter.log("Contains the:"+inText+" this: "+words+".");
        Assert.assertTrue(inText.toLowerCase().contains(words.toLowerCase()));
    }

    public static void assertEquals(double price, double totalCost){
        Assert.assertEquals(price, totalCost);
    }

    public static void assertClickable(By locator){
        try {
            WebElement button = getCurrentDriver().findElement(locator);
            button.click();
            Assert.assertTrue(true);
        }catch (Exception e){
            Assert.assertTrue(false);
        }
    }

    public static void assertPriceRange(String minPrice, String maxPrice, List<Product> productList){
        double minPriceDouble = Double.parseDouble(minPrice);
        double maxPriceDouble = Double.parseDouble(maxPrice);

        boolean isPriceRange = true;

        for (Product product: productList){
            if (minPriceDouble > product.getPrice() || product.getPrice() > maxPriceDouble){
                isPriceRange = false;
                break;
            }
        }

        Assert.assertTrue(isPriceRange);
    }

    public static void assertTrue(boolean is){
        Assert.assertTrue(is);
    }

    public static void assertFalse(boolean is){
        Assert.assertFalse(is);
    }
}
