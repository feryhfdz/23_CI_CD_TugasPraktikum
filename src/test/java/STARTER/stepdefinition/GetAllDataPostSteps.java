package STARTER.stepdefinition;

import STARTER.User.GetAllDataPost;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class GetAllDataPostSteps {
    @Steps
    GetAllDataPost getAllDataPost;

    @Given("I set API endpoint for get all post data")
    public void setApiEndPoint(){
        getAllDataPost.setApiEndPoint();
    }

    @When("I send a request to get all post data")
    public void sendGetAllPostData(){
        getAllDataPost.sendGetAllPostData();
    }

    @Then("I receive status code 200")
    public void receiveStatusCode200() {getAllDataPost.receiveStatusCode200();}

    @Then("I receive valid data for all post data")
    public void receiveValidAllPostData(){
        getAllDataPost.receiveValidAllPostData();
    }

    @Then("I receive null data for all post data")
    public void receiveNullData(){
        getAllDataPost.receiveNullData();
    }
}
