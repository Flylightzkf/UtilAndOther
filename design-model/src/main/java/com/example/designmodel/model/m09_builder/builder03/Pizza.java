package com.example.designmodel.model.m09_builder.builder03;

import java.util.List;

/**
 * @author benjamin_5
 * @Description 产品
 * @date 2023/4/24
 */
public class Pizza {
    private String crust;
    private String sauce;
    private List<String> toppings;

    public static class Builder{
        private String crust;
        private String sauce;
        private List<String> toppings;

        public Builder(String crust, String sauce) {
            this.crust = crust;
            this.sauce = sauce;
        }

        public Builder addTopping(String topping) {
            toppings.add(topping);
            return this;
        }

        public Pizza build() {
            Pizza pizza = new Pizza();
            pizza.crust = crust;
            pizza.sauce = sauce;
            pizza.toppings = toppings;
            return pizza;
        }
    }
}

