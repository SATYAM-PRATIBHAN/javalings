package com.javalings.engine;

import com.javalings.models.ExerciseInfo;
import com.javalings.models.Topic;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerciseRegistry {

    public List<ExerciseInfo> getAllExercises() {
        List<ExerciseInfo> exercises = new ArrayList<>();
        TopicLoader loader = new TopicLoader();
        
        File exercisesDir = new File("exercises");
        if (!exercisesDir.exists()) return exercises;
        
        File[] topicDirs = exercisesDir.listFiles(File::isDirectory);
        if (topicDirs == null) return exercises;
        
        Arrays.sort(topicDirs, (a, b) -> a.getName().compareTo(b.getName()));
        
        int globalIdCounter = 1;
        
        for (File topicDir : topicDirs) {
            Topic topic;
            try {
                topic = loader.load(topicDir.getPath());
            } catch (Exception e) {
                continue; // Skip if no topic.json
            }
            
            File[] javaFiles = topicDir.listFiles((d, name) -> name.endsWith(".java"));
            if (javaFiles == null) continue;
            
            Arrays.sort(javaFiles, (a, b) -> a.getName().compareTo(b.getName()));
            
            for (File javaFile : javaFiles) {
                String exerciseName = javaFile.getName().replace(".java", "");
                
                ExerciseInfo info = new ExerciseInfo();
                info.setGlobalId(globalIdCounter++);
                info.setTopic(topic);
                info.setExerciseName(exerciseName);
                info.setTopicPath(topicDir.getPath());
                info.setExercisePath(javaFile.getPath());
                info.setTestPath("tests/" + topicDir.getName() + "/" + exerciseName + "Test.java");
                info.setReadmePath(topicDir.getPath() + "/README.md");
                
                exercises.add(info);
            }
        }
        
        return exercises;
    }

    public ExerciseInfo getExercise(int globalId) {
        return getAllExercises().stream()
                .filter(e -> e.getGlobalId() == globalId)
                .findFirst()
                .orElse(null);
    }
}
