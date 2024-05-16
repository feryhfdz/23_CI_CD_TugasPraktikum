package STARTER.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import STARTER.User.DeleteDataPost;

public class DeleteDataPostSteps {
    @Steps
    DeleteDataPost deleteDataPost;

    @Given("I set API endpoint for delete data with ID")
    public void setDeleteApiEndPoint(){
        deleteDataPost.setDeleteApiEndPoint();
    }

    @When("I send a DELETE request to the endpoint with a valid ID")
    public void sendDeletePostDataRequest(){
        deleteDataPost.sendDeletePostDataRequest();
    }

    @Then("I receive a successful response status code 200")
    public void verifyDeleteStatusCode(){
        deleteDataPost.verifyDeleteStatusCode();
    }

    @And("the post data is no longer retrievable using a GET request with the same ID")
    public void verifyPostDataDeleted() {
        deleteDataPost.verifyPostDataDeleted();
    }

    @When("I send a DELETE request to the endpoint with a non-existent ID")
    public void sendDeleteRequestWithNonExistentId() {
        deleteDataPost.sendDeleteRequestWithNonExistentId();
    }

    @Then("I receive a response with status code 404 Not Found")
    public void receiveStatusCode404(){
        deleteDataPost.receiveStatusCode404();
    }

    @And("the response body contains an error message Post not found")
    public void receiveErrorMessage(){
        deleteDataPost.receiveErrorMessage();
    }
}
