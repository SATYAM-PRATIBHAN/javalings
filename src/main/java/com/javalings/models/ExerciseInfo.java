package com.javalings.models;

public class ExerciseInfo {
    private int globalId;
    private Topic topic;
    private String exerciseName;
    private String exercisePath;
    private String testPath;
    private String readmePath;
    private String topicPath;

    public int getGlobalId() { return globalId; }
    public void setGlobalId(int globalId) { this.globalId = globalId; }

    public Topic getTopic() { return topic; }
    public void setTopic(Topic topic) { this.topic = topic; }

    public String getExerciseName() { return exerciseName; }
    public void setExerciseName(String exerciseName) { this.exerciseName = exerciseName; }

    public String getExercisePath() { return exercisePath; }
    public void setExercisePath(String exercisePath) { this.exercisePath = exercisePath; }

    public String getTestPath() { return testPath; }
    public void setTestPath(String testPath) { this.testPath = testPath; }

    public String getReadmePath() { return readmePath; }
    public void setReadmePath(String readmePath) { this.readmePath = readmePath; }

    public String getTopicPath() { return topicPath; }
    public void setTopicPath(String topicPath) { this.topicPath = topicPath; }
}
