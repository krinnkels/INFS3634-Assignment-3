package com.example.task3;


import java.io.Serializable;

public class CatType implements Serializable {


    private String id;
    private String breed;
    private String description;
    private String weight;
    private String temperament;
    private String origin;
    private String lifespan;
    private String wikilink;
    private int friendlinesslevel;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    public String getWikilink() {
        return wikilink;
    }

    public void setWikilink(String wikilink) {
        this.wikilink = wikilink;
    }

    public int getFriendlinesslevel() {
        return friendlinesslevel;
    }

    public void setFriendlinesslevel(int friendlinesslevel) {
        this.friendlinesslevel = friendlinesslevel;
    }
}