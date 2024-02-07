package APITest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class APITest extends TestBase{

    String actualuserId="";

    @Test
    public void test01VerifyCreateUser() throws IOException {
        String responseCreateUser=given().log().all()
                .spec(createRequestSpecification())
                .body(data.createUserPojo())
                .when().post("/api/users")
                .then().log().all()

                .assertThat().statusCode(201)
                .extract().response().asString();

        /*
        Extract Response body
        */
        JsonPath js = new JsonPath(responseCreateUser);

         actualuserId=js.getString("userid");
        String expecteduserID="1234";

        Assert.assertEquals(actualuserId,expecteduserID);
        System.out.println("UserId: "+actualuserId);
    }


    @Test
    public void test02VerifyDeposit() throws IOException {

        String responseDeposit=given().log().all()
                .spec(createRequestSpecification())
                .body(data.depositPojo())
                .when().post("/api/deposit")
                .then().log().all()
                /*
                  Assert status code
                */
                .assertThat().statusCode(200)
                .extract().response().asString();

        /*
        Extract Response body
        */
        JsonPath js = new JsonPath(responseDeposit);

        float actualBalance=js.getFloat("new_balance");
        float expectedBalance=300;

        /*
                  Assert Response body
                */
        Assert.assertEquals(actualBalance,expectedBalance);
        System.out.println("Balance: "+actualBalance);

    }


    @Test
    public void test03VerifyWithdraw() throws IOException {

        String responseWithdraw=given().log().all()
                .spec(createRequestSpecification())
                .body(data.depositPojo())
                .when().post("/api/withdraw")
                .then().log().all()
                /*
                  Assert status code
                */
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(responseWithdraw);

        float actualBalance=js.getFloat("new_balance");
        float expectedBalance=250;
        /*
                  Assert Response body
                */
        Assert.assertEquals(actualBalance,expectedBalance);
        System.out.println("Balance: "+actualBalance);

    }

    @Test(priority =1 )
    public void test04VerifyGetBalance() throws IOException {

        String responseBalance=given().log().all()
                .spec(createRequestSpecification())
                .pathParam("userid",actualuserId)
                .when().get("/api/get_balance/{userid}")
                .then().log().all()
                /*
                  Assert status code
                */
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(responseBalance);

        float actualBalance=js.getFloat("balance");
        float expectedBalance=250;
        /*
                  Assert Response body
                */
        Assert.assertEquals(actualBalance,expectedBalance);
        System.out.println("Balance: "+actualBalance);

    }



    @Test
    public void test05VerifySend() throws IOException {

        String responseSend=given().log().all()
                .spec(createRequestSpecification())
                .body(data.sendPojo())
                .when().post("api/send")
                .then().log().all()
                /*
                  Assert status code
                */
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(responseSend);

        float actualBalance=js.getFloat("new_sender_balance");
        float expectedBalance=150;

        /*
                  Assert Response body
                */
        Assert.assertEquals(actualBalance,expectedBalance);
        System.out.println("New Sender Balance: "+actualBalance);

    }


    @Test
    public void test06VerifyCreateUserBadRequest() throws IOException {

                given().log().all()
                .spec(createRequestSpecification())
                .body(data.createUserPojo())
                .when().post("/api/invalidusers")
                .then().log().all()
                        /*
                  Assert status code
                */
                .assertThat().statusCode(404);



    }



}
