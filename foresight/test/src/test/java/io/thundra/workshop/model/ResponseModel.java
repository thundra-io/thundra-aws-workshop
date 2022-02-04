package io.thundra.workshop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

    @JsonProperty("id")
    private String id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("content")
    private String content;

    @JsonProperty("textLength")
    private int textLength;

    @JsonProperty("mostUsedWord")
    private String[] mostUsedWord;

    @JsonProperty("leastUsedWord")
    private String[] leastUsedWord;

    @JsonProperty("bannedWord")
    private String[] bannedWord;

    @JsonProperty("maxLengthWord")
    private String[] maxLengthWord;

    @JsonProperty("minLengthWord")
    private String[] minLengthWord;


    @SneakyThrows
    @Override
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);

    }

    @Override
    public boolean equals(Object o) {
        ResponseModel responseModel = (ResponseModel) o;

        return this.getUsername().equals(responseModel.getUsername()) &&
                this.getContent().equals(responseModel.getContent()) &&
                this.getTextLength() == responseModel.getTextLength() &&

                Arrays.equals(this.getMostUsedWord(), responseModel.getMostUsedWord()) &&
                Arrays.equals(this.getLeastUsedWord(), responseModel.getLeastUsedWord()) &&
                Arrays.equals(this.getBannedWord(), responseModel.getBannedWord()) &&
                Arrays.equals(this.getMaxLengthWord(), responseModel.getMaxLengthWord()) &&
                Arrays.equals(this.getMinLengthWord(), responseModel.getMinLengthWord());
    }

    public static ResponseModel fromString(String json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, ResponseModel.class);
        }
        catch (Exception e) {
            return null;

        }
    }

    public static ResponseModel fromJsonFile(String jsonFile) {
        try {
            return new ObjectMapper().readValue(new File(jsonFile), ResponseModel.class);

        } catch (IOException e) {
            return null;
        }
    }
}
