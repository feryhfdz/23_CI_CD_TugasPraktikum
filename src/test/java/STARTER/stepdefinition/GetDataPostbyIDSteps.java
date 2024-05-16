package STARTER.stepdefinition;

import STARTER.User.GetDataPostbyID;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class GetDataPostbyIDSteps {
    @Steps
    GetDataPostbyID getDataPostbyID;

    @Given("I set API endpoint for get data with ID")
    public void setApiEndPoint(){
        getDataPostbyID.setApiEndPoint();
    }

    @When("I send a GET request to the endpoint with a valid ID")
    public void sendDataPostRequestbyID(){
        getDataPostbyID.sendDataPostRequestbyID();
    }

    @Then("I should receive the post data by ID")
    public void receivePostDatabyID(){
        getDataPostbyID.receivePostDatabyID();
    }

    @When("I send a GET request to the endpoint with an invalid ID")
    public void sendRequestInvalidID(){
        getDataPostbyID.sendRequestInvalidID();
    }

    @Then("I receive status code 404")
    public void receiveStatusCode404(){
        getDataPostbyID.receiveStatusCode404();
    }

    @And("I should receive a empty post data")
    public void receiveNullValue(){
        getDataPostbyID.receiveNullValue();
    }
}
