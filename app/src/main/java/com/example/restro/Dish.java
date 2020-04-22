package com.example.restro;

public class Dish {
    String dish_name,dish_price,dish_description,dish_image_link;

    public Dish() {
    }

    public Dish(String dish_name, String dish_price, String dish_description, String dish_image_link) {
        this.dish_name = dish_name;
        this.dish_price = dish_price;
        this.dish_description = dish_description;
        this.dish_image_link = dish_image_link;
    }


    public String getDish_image_link() {
        return dish_image_link;
    }

    public void setDish_image_link(String dish_image_link) {
        this.dish_image_link = dish_image_link;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getDish_price() {
        return dish_price;
    }

    public void setDish_price(String dish_price) {
        this.dish_price = dish_price;
    }

    public String getDish_description() {
        return dish_description;
    }

    public void setDish_description(String dish_description) {
        this.dish_description = dish_description;
    }
}
