package com.company.chatterbook.model;

//this will create a model object that has a one string instance variable named text
//text represents a post from user
public class ChatterPost {
    public String text;

    public ChatterPost (String text) {
        this.text = text;
    }

    //This is the getter and setter of the posts that the users do
    public String getText() {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }
}
