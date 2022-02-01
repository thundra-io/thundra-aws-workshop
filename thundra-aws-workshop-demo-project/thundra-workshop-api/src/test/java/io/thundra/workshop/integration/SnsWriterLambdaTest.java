package io.thundra.workshop.integration;

import io.thundra.workshop.common.Constants;
import io.thundra.workshop.model.RequestModel;
import io.thundra.workshop.model.ResponseModel;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SnsWriterLambdaTest extends IntegrationTestBase{

    @BeforeAll
    void initialize() throws RuntimeException {

        if( Constants.SNS_WRITER_URL == null || Constants.SNS_WRITER_URL.isEmpty()) {
            throw new RuntimeException("SNS WRITER URL is not set");
        }
        this.setBaseUrl(Constants.SNS_WRITER_URL);

        System.out.println(this.getBaseUrl());
    }

    @Test
    @DisplayName("Lambda Connection Test")
    @Order(1)
    void connectionTest() {
        ResponseModel response = this.postAction(new RequestModel());
        assertNotNull(response, "Cannot connected");
    }

    @Test
    @DisplayName("Send Empty UserName Test")
    @Order(2)
    void sendEmptyUserNameTest()  {

        RequestModel requestBody = new RequestModel();

        requestBody.setText("hello world");
        requestBody.setUserName(null);

        ResponseModel response = this.postAction(requestBody);

        assertNotNull(response, "Cannot connected to lambda");

        assertNull(response.getId());
        assertNotNull(response.getContent());

        assertTrue(response.getContent().contains("Missing username or text"));
    }

    @Test
    @DisplayName("Send Empty Text Test")
    @Order(3)
    void sendEmptyTextTest() {
        RequestModel requestBody = new RequestModel();

        requestBody.setText(null);
        requestBody.setUserName("user-test");

        ResponseModel response = this.postAction(requestBody);

        assertNotNull(response, "Cannot connected to lambda");

        assertNull(response.getId());
        assertNotNull(response.getContent());

        assertTrue(response.getContent().contains("Missing username or text"));
    }

    @Test
    @DisplayName("Send Valid Text Test")
    @Order(5)
    void sendValidTextTest(){

        RequestModel requestBody = new RequestModel();

        requestBody.setText("user test demo");
        requestBody.setUserName("user-test");

        ResponseModel response = this.postAction(requestBody);

        assertNotNull(response, "Cannot connected to lambda");

        assertNotNull(response.getId());
        assertNotNull(response.getContent());
    }

    @Test
    @DisplayName("JSON Example 1 Test")
    @Order(6)
    void jsonTestExample1() {

        RequestModel mockRequest = RequestModel.fromJsonFile("src/test/resources/json/example1-request.json");

        assertNotNull(mockRequest, "Cannot read json file");
        assertNotNull(mockRequest.getText(), "Cannot read text");

        ResponseModel response = this.postAction(mockRequest);

        assertNotNull(response, "Cannot connected to lambda");
        assertNotNull(response.getId(), "Runtime Exception on Lambda");

        ResponseModel expectedResponse = ResponseModel.fromJsonFile("src/test/resources/json/example1-response.json");

        assertNotNull(expectedResponse, "Cannot read json file");

        assertEquals(expectedResponse.getContent(), response.getContent());
        assertEquals(expectedResponse.getUserName(), response.getUserName());

        assertArrayEquals(expectedResponse.getBannedWord(), response.getBannedWord());
        assertArrayEquals(expectedResponse.getMostUsedWord(), response.getMostUsedWord());
        assertArrayEquals(expectedResponse.getLeastUsedWord(), response.getLeastUsedWord());
        assertArrayEquals(expectedResponse.getMaxLengthWord(), response.getMaxLengthWord());
        assertArrayEquals(expectedResponse.getMinLengthWord(), response.getMinLengthWord());
    }

    @Test
    @DisplayName("JSON Example 2 Test")
    @Order(7)
    void jsonTestExample2() {

        RequestModel mockRequest = RequestModel.fromJsonFile("src/test/resources/json/example2-request.json");

        assertNotNull(mockRequest, "Cannot read json file");
        assertNotNull(mockRequest.getText(), "Cannot read text");

        ResponseModel response = this.postAction(mockRequest);

        assertNotNull(response, "Cannot connected to lambda");
        assertNotNull(response.getId(), "Runtime Exception on Lambda");

        ResponseModel expectedResponse = ResponseModel.fromJsonFile("src/test/resources/json/example2-response.json");

        assertNotNull(expectedResponse, "Cannot read json file");

        assertEquals(expectedResponse.getContent(), response.getContent());
        assertEquals(expectedResponse.getUserName(), response.getUserName());

        assertArrayEquals(expectedResponse.getBannedWord(), response.getBannedWord());
        assertArrayEquals(expectedResponse.getMostUsedWord(), response.getMostUsedWord());
        assertArrayEquals(expectedResponse.getLeastUsedWord(), response.getLeastUsedWord());
        assertArrayEquals(expectedResponse.getMaxLengthWord(), response.getMaxLengthWord());
        assertArrayEquals(expectedResponse.getMinLengthWord(), response.getMinLengthWord());
    }



}
