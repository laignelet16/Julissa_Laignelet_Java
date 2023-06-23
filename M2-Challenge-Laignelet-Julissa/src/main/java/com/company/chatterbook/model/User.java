package com.company.chatterbook.model;

import java.util.List;

//each user will have two instance variables name (string) and chatterposts (list of chattepost objects)
public class User {
    public String name;
    public List<ChatterPost> chatterPosts;

    public User(String name) {
        this.name = name;
    }

    //This is the setter and getter for the ChatterPosts
    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }

    //This is the setter and getter for the names of the users
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
