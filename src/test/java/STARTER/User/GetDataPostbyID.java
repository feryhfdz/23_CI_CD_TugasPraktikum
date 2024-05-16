package STARTER.User;

import STARTER.utils.JsonSchema;
import STARTER.utils.JsonSchemaHelper;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetDataPostbyID {
    private static String url = "https://jsonplaceholder.typicode.com/posts/";

    @Step("I set API endpoint for get data with ID")
    public String setApiEndPoint(){
        return url + "6";
    }

    @Step("I send a GET request to the endpoint with a valid ID")
    public void sendDataPostRequestbyID(){
        SerenityRest.given()
                .get(setApiEndPoint());
    }

    @Step("I should receive the post data by ID")
    public void receivePostDatabyID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_DATA_POST_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("userId", equalTo(1)));
        restAssuredThat(response -> response.body("id", equalTo(6)));
        restAssuredThat(response -> response.body("title", equalTo("dolorem eum magni eos aperiam quia")));
        restAssuredThat(response -> response.body("body", equalTo("ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for post data with an invalid ID")
    public String setApiEndPointInvalidID(){
        return url + "1000";
    }

    @Step("I send a GET request to the endpoint with an invalid ID")
    public void sendRequestInvalidID(){
        SerenityRest.given()
                .get(setApiEndPointInvalidID());
    }


    @Step("I receive status code 404")
    public void receiveStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }


    @Step("I should receive a empty post data")
    public void receiveNullValue(){
        restAssuredThat(response -> response.body(equalTo("{}")));
    }
}
