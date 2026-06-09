package com.javalings.engine;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javalings.models.Progress;
public class ProgressManager {
    private static final String FILE = ".progress.json";

    private final ObjectMapper mapper = new ObjectMapper();

    public Progress load() {
        File file = new File(FILE);
        if(!file.exists()) {
            Progress progress = new Progress();

            progress.setCurrentExercise(1);

            save(progress);

            return progress;
        }

        try {
            return mapper.readValue(
                file,
                Progress.class
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Progress progress) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                .writeValue(
                    new File(FILE),
                    progress
                );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
