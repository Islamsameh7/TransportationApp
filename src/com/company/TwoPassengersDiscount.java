package com.company;

public class TwoPassengersDiscount extends DiscountDecorator{

    public TwoPassengersDiscount(Discount discount) {
        super(discount);
    }

    @Override
    public double makeDiscount(double originalPrice, double discountPrice) {
        System.out.println("5% discount applied on this trip.");
        return super.makeDiscount(originalPrice, discountPrice) - (super.makeDiscount(discountPrice, originalPrice) * 0.05);
    }
}
