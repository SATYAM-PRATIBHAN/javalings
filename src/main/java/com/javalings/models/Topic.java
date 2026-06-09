package com.javalings.models;

public class Topic {
    private int id;
    private String slug;
    private String title;
    private String difficulty;
    private java.util.Map<String, String> hints;

    public Topic() {};

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public java.util.Map<String, String> getHints() { return hints; }
    public void setHints(java.util.Map<String, String> hints) { this.hints = hints; }
}
