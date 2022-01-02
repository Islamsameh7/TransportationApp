package com.company.App;

public class AdminAreaDiscount extends DiscountDecorator{

    public AdminAreaDiscount(Discount discount) {
        super(discount);
    }

    @Override
    public double makeDiscount(double originalPrice, double discountPrice) {
        System.out.println("10% discount applied on this trip.");
        return super.makeDiscount(originalPrice, discountPrice) - (super.makeDiscount(discountPrice, originalPrice) * 0.1);
    }
}
