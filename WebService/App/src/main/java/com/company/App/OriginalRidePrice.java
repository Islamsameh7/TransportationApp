package com.company.App;

public class OriginalRidePrice implements Discount {

    public OriginalRidePrice() {
    }

    @Override
    public double makeDiscount(double originalPrice, double discountPrice) {
        return discountPrice;
    }
}
