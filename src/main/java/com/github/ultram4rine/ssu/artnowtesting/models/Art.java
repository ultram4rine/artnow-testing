package com.github.ultram4rine.ssu.artnowtesting.models;

public class Art {
    private String name;
    private String author;
    private String price;

    public Art(String name, String author, String price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }
}