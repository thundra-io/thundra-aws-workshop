package io.thundra.workshop.e2e;

import io.thundra.workshop.common.Constants;
import io.thundra.workshop.integration.IntegrationTestBase;
import io.thundra.workshop.model.RequestModel;
import io.thundra.workshop.model.ResponseModel;
import io.thundra.workshop.selenium.SeleniumTestBase;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class E2ETest {

    private SeleniumTestBase selenium;
    private IntegrationTestBase integration;

    @BeforeAll
    void initialize(){
        selenium = new SeleniumTestBase();
        integration = new IntegrationTestBase();

        if(Objects.requireNonNull(Constants.WEB_CONTENT_RETRIEVER_URL).isEmpty()
                || Objects.requireNonNull(Constants.SNS_WRITER_URL).isEmpty()){
            throw new RuntimeException("SNS_WRITER_URL and WEB_CONTENT_RETRIEVER_URL must be set");
        }

        selenium.init(Constants.WEB_CONTENT_RETRIEVER_URL);
        integration.setBaseUrl(Constants.SNS_WRITER_URL);
    }

    private void waitUntilPageLoaded(){
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ignored) {
        }
    }

    @AfterEach
    void tearDown(){
        if(selenium != null){
            selenium.tearDown();
        }
    }

    private String[] clearEmptyArray(String[] array){
        if(array.length == 1 && array[0].isEmpty()){
            return new String[0];
        }
        return array;
    }

    private ResponseModel createResponseFromWebElements(WebDriver driver){
        String username = driver.findElement(By.tagName("h4")).getText();
        String content = driver.findElement(By.className("entity-content")).findElement(By.tagName("p")).getText();

        List<WebElement> attributes = driver.findElements(By.className("attribute"));

        int textLength = Integer.parseInt(attributes.get(0).findElement(By.tagName("span")).getText().trim());
        String[] mostUsedWord = attributes.get(1).findElement(By.tagName("p")).getText().trim().split(", ", -1);
        String[] leastUsedWord = attributes.get(2).findElement(By.tagName("p")).getText().trim().split(", ", -1);
        String[] bannedWord = attributes.get(3).findElement(By.tagName("p")).getText().trim().split(", ",-1);
        String[] maxLengthWord = attributes.get(4).findElement(By.tagName("p")).getText().trim().split(", ",-1);
        String[] minLengthWord = attributes.get(5).findElement(By.tagName("p")).getText().trim().split(", ",-1);


        selenium.getScreenShot();
        return new ResponseModel("<id>", username, content, textLength, clearEmptyArray(mostUsedWord), clearEmptyArray(leastUsedWord),
                clearEmptyArray(bannedWord), clearEmptyArray(maxLengthWord), clearEmptyArray(minLengthWord));

    }


    @Test
    @DisplayName("First E2E Test")
    void testLocalEntity() {

        final int expectedTextLength = 34;

        final String[] expectedMostUsedWord = new String[]{"hello"};
        final String[] expectedLeastUsedWord = new String[]{"world", "aws", "test", "example"};
        final String[] expectedBannedWords = new String[]{"aws","test"};
        final String[] expectedMaxLengthWords = new String[]{"example"};
        final String[] expectedMinLengthWords = new String[]{"aws"};


        RequestModel request = new RequestModel();

        request.setText("hello world aws test example hello");
        request.setUsername("test-user-1");

        ResponseModel response = integration.postAction(request);

        assertNotNull(response, "Response is null");
        assertNotNull(response.getId(), "Response id is null");


        assertEquals(request.getUsername(),response.getUsername());
        assertEquals(request.getText(),response.getContent());

        assertEquals(expectedTextLength, response.getTextLength());

        assertArrayEquals(expectedMostUsedWord, response.getMostUsedWord());
        assertArrayEquals(expectedLeastUsedWord, response.getLeastUsedWord());
        assertArrayEquals(expectedBannedWords, response.getBannedWord());
        assertArrayEquals(expectedMaxLengthWords, response.getMaxLengthWord());
        assertArrayEquals(expectedMinLengthWords, response.getMinLengthWord());

        waitUntilPageLoaded();

        selenium.setupDriver();

        WebDriver driver = selenium.getDriver();

        driver.get(selenium.getBaseUrl().concat("/text-analyzer/").concat(response.getId()));

        ResponseModel responseFromWeb = createResponseFromWebElements(driver);
        assertEquals(response, responseFromWeb);
    }

    @Test
    @DisplayName("Second E2E Test")
    void testFirstExample() {

        RequestModel request = RequestModel.fromJsonFile("src/test/resources/json/example1-request.json");
        assertNotNull(request, "Failed to read request from json file");

        ResponseModel response = integration.postAction(request);
        assertNotNull(response, "Response is null");

        ResponseModel expectedResponse = ResponseModel.fromJsonFile("src/test/resources/json/example1-response.json");
        assertNotNull(expectedResponse, "Failed to read response from json file");

        assertEquals(expectedResponse.getUsername(), response.getUsername());
        assertEquals(expectedResponse.getContent(), response.getContent());
        assertEquals(expectedResponse.getTextLength(), response.getTextLength());

        assertArrayEquals(expectedResponse.getMostUsedWord(), response.getMostUsedWord());
        assertArrayEquals(expectedResponse.getLeastUsedWord(), response.getLeastUsedWord());
        assertArrayEquals(expectedResponse.getBannedWord(), response.getBannedWord());
        assertArrayEquals(expectedResponse.getMaxLengthWord(), response.getMaxLengthWord());
        assertArrayEquals(expectedResponse.getMinLengthWord(), response.getMinLengthWord());


        waitUntilPageLoaded();
        selenium.setupDriver();

        WebDriver driver = selenium.getDriver();
        driver.get(selenium.getBaseUrl().concat("/text-analyzer/").concat(response.getId()));

        ResponseModel responseFromWeb = createResponseFromWebElements(driver);

        assertEquals(expectedResponse, responseFromWeb);

    }

    @Test
    @DisplayName("Third E2E Test")
    void testSecondExample() {

        RequestModel request = RequestModel.fromJsonFile("src/test/resources/json/example2-request.json");
        assertNotNull(request, "Failed to read request from json file");

        ResponseModel response = integration.postAction(request);
        assertNotNull(response, "Response is null");

        ResponseModel expectedResponse = ResponseModel.fromJsonFile("src/test/resources/json/example2-response.json");
        assertNotNull(expectedResponse, "Failed to read response from json file");

        assertEquals(expectedResponse.getUsername(), response.getUsername());
        assertEquals(expectedResponse.getContent(), response.getContent());
        assertEquals(expectedResponse.getTextLength(), response.getTextLength());

        assertArrayEquals(expectedResponse.getMostUsedWord(), response.getMostUsedWord());
        assertArrayEquals(expectedResponse.getLeastUsedWord(), response.getLeastUsedWord());
        assertArrayEquals(expectedResponse.getBannedWord(), response.getBannedWord());
        assertArrayEquals(expectedResponse.getMaxLengthWord(), response.getMaxLengthWord());
        assertArrayEquals(expectedResponse.getMinLengthWord(), response.getMinLengthWord());

        waitUntilPageLoaded();
        selenium.setupDriver();

        WebDriver driver = selenium.getDriver();
        driver.get(selenium.getBaseUrl().concat("/text-analyzer/").concat(response.getId()));

        ResponseModel responseFromWeb = createResponseFromWebElements(driver);

        assertEquals(expectedResponse, responseFromWeb);
    }
}
