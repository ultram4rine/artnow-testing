package com.github.ultram4rine.ssu.artnowtesting.models;

public class CatalogItem {
    private String name;
    private String author;

    public CatalogItem(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}