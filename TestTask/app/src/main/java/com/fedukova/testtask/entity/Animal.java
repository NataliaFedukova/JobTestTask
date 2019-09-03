package com.fedukova.testtask.entity;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Animal implements Serializable {

    public static final String ANIMAL = "animal";
    public static final String URL = "url";
    public static final String TEXT = "text";

    @SerializedName(URL)
    private String url;

    @SerializedName(TEXT)
    private String text;

    public Animal(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }
}
