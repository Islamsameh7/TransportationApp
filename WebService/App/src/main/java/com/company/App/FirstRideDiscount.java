package com.company.App;

public class FirstRideDiscount extends DiscountDecorator{

    public FirstRideDiscount(Discount discount) {
        super(discount);
    }

    @Override
    public double makeDiscount(double originalPrice, double discountPrice) {
        System.out.println("10% discount applied on this trip.");
        return super.makeDiscount(originalPrice, discountPrice) - (super.makeDiscount(discountPrice, originalPrice) * 0.1);
    }
}
