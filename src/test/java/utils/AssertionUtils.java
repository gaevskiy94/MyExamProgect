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
    public static void assertIsDisplay(By locator){
        try {
            WebElement element = getCurrentDriver().findElement(locator);
            Assert.assertTrue(element.isDisplayed());
        }catch (Exception e){
            Assert.assertTrue( false );
        }
    }

    public static void assertIsNotDisplay(By locator){
        try {
            WebElement element = getCurrentDriver().findElement(locator);
            Assert.assertFalse(element.isDisplayed());
        }catch (Exception e){
            Assert.assertFalse( false );
        }
    }

    public static void assertEqualsProductsLists(List<Product> firstList, List<Product> secondList){
        boolean isEqualsLists = false;

        if (firstList.size() != 0 && secondList.size() != 0) {
            isEqualsLists = true;
            for (int i = 0; i < firstList.size(); i++) {
                for (int j = 0; j < secondList.size(); j++) {
                    if (firstList.get(i).getName().contains(secondList.get(j).getName())
                            && firstList.get(i).getPrice() == secondList.get(j).getPrice()) {
                        break;
                    } else if (j + 1 == secondList.size()) {
                        isEqualsLists = false;
                    }
                }
            }
        }
        Assert.assertTrue(isEqualsLists);
    }

    public static void assertEmptyList(List list){
        boolean isEmpty = false;

        if (list.size() == 0){
            isEmpty = true;
        }

        Assert.assertTrue(isEmpty);
    }
}
