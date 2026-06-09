package com.javalings.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javalings.models.Exercise;

import java.io.File;
import java.io.IOException;

public class ExerciseLoader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public Exercise load(String exercisePath) {
        try {
            File metadata = new File(exercisePath + "/exercise.json");

            return mapper.readValue(
                metadata,
                Exercise.class
            );
            
        } catch (IOException e) {
            throw new RuntimeException(
                "Failed to load exercise",
                e
            );
        }
    }
}
