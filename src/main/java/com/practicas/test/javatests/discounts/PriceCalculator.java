package com.practicas.test.javatests.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private List<Double> prices = new ArrayList<>();
    private double discount = 0;


    public double getTotal() {
        double result=0;

        for(Double price : prices) {
            result+=price;
        }
        if(discount!=0){
            return result - (result*this.discount)/100;
        }
        return result;
    }

    public void addPrice(double v) {
        this.prices.add(v);
    }


    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
