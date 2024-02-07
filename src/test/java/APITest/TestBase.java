package APITest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.DataHandler;

import java.io.IOException;



public class TestBase {

    public DataBuild data =new DataBuild();

    /*
        Method which constructs a request component with common components which are used in all the requests
        This will increase reusability and remove duplicate code
        */
    public RequestSpecification createRequestSpecification() throws IOException {

        RequestSpecification requestSpecification =new RequestSpecBuilder().setBaseUri(DataHandler.getPropertyValue("baseUrl"))
                .setContentType(ContentType.JSON)


                .build();

        return requestSpecification;
    }



}
