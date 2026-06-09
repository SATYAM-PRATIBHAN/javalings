package com.javalings.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javalings.models.Topic;

import java.io.File;
import java.io.IOException;

public class TopicLoader {

    private static final ObjectMapper mapper = new ObjectMapper();
    private java.util.Map<String, Topic> topics;

    public TopicLoader() {
        try {
            File infoFile = new File("info.json");
            if (infoFile.exists()) {
                topics = mapper.readValue(
                    infoFile,
                    new com.fasterxml.jackson.core.type.TypeReference<java.util.Map<String, Topic>>() {}
                );
            } else {
                topics = new java.util.HashMap<>();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load info.json", e);
        }
    }

    public Topic load(String topicDirName) {
        Topic topic = topics.get(topicDirName);
        if (topic == null) {
            throw new RuntimeException("Topic not found in info.json: " + topicDirName);
        }
        return topic;
    }
}
