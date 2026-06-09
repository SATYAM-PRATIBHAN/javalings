package com.javalings.models;

public class Topic {
    private int id;
    private String slug;
    private String title;
    private String difficulty;

    public Topic() {};

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
}
