package stepDefinitions;

import com.example.User.Entity.UserEntity;
import com.example.User.UserApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;


public class SaveUserSteps {
    private ResponseEntity<String> response;
    private RestTemplate restTemplate = new RestTemplate();

    @Given("I send a POST request to {string}")
    public void i_send_a_post_request_to(String url) {
        // Write code here that turns the phrase above into concrete actions
        Map<String, Object> user = Map.of(
                "name", "John Doe",
                "address", "pune",
                "itemId", 1
        );

        // Prepare the request body
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(user, headers);

        // Send POST request to API
        response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
    }
    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer expectedStatus) {
        Assert.assertEquals(response.getStatusCodeValue(), expectedStatus.intValue(),
                "Expected status code to be " + expectedStatus);
    }
    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String expectedString) {
        String responseBody = response.getBody();
        Assert.assertTrue(responseBody != null && responseBody.contains(expectedString),
                "Response body should contain: " + expectedString);
    }


    }






