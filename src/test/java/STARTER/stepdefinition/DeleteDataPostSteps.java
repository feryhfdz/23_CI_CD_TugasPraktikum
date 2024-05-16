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

}
