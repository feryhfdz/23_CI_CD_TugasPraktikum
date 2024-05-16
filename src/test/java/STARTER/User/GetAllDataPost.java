package STARTER.User;

import STARTER.utils.JsonSchema;
import STARTER.utils.JsonSchemaHelper;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllDataPost {
    private static String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set API endpoint for get all post data")
    public String setApiEndPoint(){
        return url + "posts";
    }

    @Step("I send a request to get all post data")
    public void sendGetAllPostData(){
        SerenityRest.given()
                .get(setApiEndPoint());
    }

    @Step("I receive status code 200")
    public void receiveStatusCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }


    @Step("I receive valid data for all post data")
    public void receiveValidAllPostData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_DATA_POST_SCHEMA);

        restAssuredThat(response -> response.body("'id'", notNullValue() ));
        restAssuredThat(response -> response.body("'title'", notNullValue() ));
        restAssuredThat(response -> response.body("'body'", notNullValue() ));
        restAssuredThat(response -> response.body("'userId'", notNullValue() ));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive null data for all post data")
    public void receiveNullData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_DATA_POST_SCHEMA);

        restAssuredThat(response -> response.body("'id'", notNullValue() ));
        restAssuredThat(response -> response.body("'title'", notNullValue() ));
        restAssuredThat(response -> response.body("'body'", notNullValue() ));
        restAssuredThat(response -> response.body("'userId'", notNullValue() ));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
