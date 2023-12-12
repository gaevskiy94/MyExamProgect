package models;

public class RangePrice {
    String minPrice;
    String maxPrice;

    public RangePrice(String minPrice, String maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }
}
