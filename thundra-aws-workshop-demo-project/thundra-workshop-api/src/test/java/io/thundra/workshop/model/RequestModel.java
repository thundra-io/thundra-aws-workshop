package io.thundra.workshop.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;

@Getter
@Setter
public class RequestModel {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("text")
    private String text;

    @SneakyThrows
    @Override
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }


    public static RequestModel fromString(String json) {
        try {
            return new ObjectMapper().readValue(json, RequestModel.class);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static RequestModel fromJsonFile(String jsonFile) {
        try {
            return new ObjectMapper().readValue(new File(jsonFile), RequestModel.class);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
