package com.javalings.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javalings.models.Topic;

import java.io.File;
import java.io.IOException;

public class TopicLoader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public Topic load(String topicPath) {
        try {
            File metadata = new File(topicPath + "/topic.json");

            return mapper.readValue(
                metadata,
                Topic.class
            );
            
        } catch (IOException e) {
            throw new RuntimeException(
                "Failed to load topic",
                e
            );
        }
    }
}
