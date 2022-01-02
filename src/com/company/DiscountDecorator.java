package com.company;

public class DiscountDecorator implements Discount{
    Discount discount;

    public DiscountDecorator(Discount discount) {
        this.discount = discount;
    }

    @Override
    public double makeDiscount(double originalPrice, double discountPrice) {
        return this.discount.makeDiscount(originalPrice, discountPrice);
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

}
