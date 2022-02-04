package io.thundra.workshop.integration;

import io.thundra.workshop.model.RequestModel;
import io.thundra.workshop.model.ResponseModel;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class IntegrationTestBase {

    private final RestTemplate httpClient;
    protected String baseUrl;

    public IntegrationTestBase(){
        this.httpClient = new RestTemplate();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    public String getAction(String additionalUrl ) {
        try {
            return this.httpClient.getForObject(this.baseUrl.concat(additionalUrl), String.class);
        }
        catch (RestClientException e){

            if(Objects.requireNonNull(e.getMessage()).contains("<h1>Not Found</h1>"))
                return "Not Found";

            return null;
        }
    }

    public ResponseModel postAction(RequestModel requestBody) {
        try{
            String response =  this.httpClient.postForObject(this.baseUrl.concat("/"), requestBody, String.class);
            return ResponseModel.fromString(response);
        }
        catch (RestClientException e){


            if(Objects.isNull(e.getMessage()))
                return null;

            if(e.getMessage().contains("400"))
                return new ResponseModel() {{ setContent(e.getMessage()); }};
            else
                return null;
        }
    }
}
