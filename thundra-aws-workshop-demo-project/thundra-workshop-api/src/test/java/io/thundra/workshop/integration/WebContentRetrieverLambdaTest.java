package io.thundra.workshop.integration;

import io.thundra.workshop.common.Constants;
import io.thundra.workshop.model.RequestModel;
import io.thundra.workshop.model.ResponseModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WebContentRetrieverLambdaTest extends IntegrationTestBase{

    @BeforeAll
    void initialize() throws RuntimeException {

        if(Constants.WEB_CONTENT_RETRIEVER_URL == null || Constants.WEB_CONTENT_RETRIEVER_URL.isEmpty()) {
            throw new RuntimeException("Thundra Workshop WEB CONTENT RETRIEVER URL is not set");
        }
        this.setBaseUrl(Constants.WEB_CONTENT_RETRIEVER_URL);
    }

    @Test
    @DisplayName("Connect Lambda Test")
    void connectLambdaTest()  {
        String response = this.getAction("/");

        assertNotNull(response, "Cannot connected to Lambda");
        assertEquals("Not Found", response);
    }

    @Test
    @DisplayName("Get Todo App Test")
    void getTodoAppTest() {
        String response = this.getAction("/todo-app");

        assertNotNull(response, "Cannot connected to Lambda");

        assertNotEquals("Not Found", response);
        assertTrue(response.startsWith("<!DOCTYPE html>"));
    }


    @Test
    @DisplayName("Get Text Analyzer Test")
    void getTextAnalyzerTest()  {
        String response = this.getAction("/text-analyzer");

        assertNotNull(response, "Cannot connected to Lambda");
        assertEquals("Not Found", response);
    }

}
