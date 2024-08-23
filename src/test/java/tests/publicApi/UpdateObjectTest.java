package tests.publicApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExtentReportGenerate;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdateObjectTest {

    ExtentReportGenerate extentReportGenerate = new ExtentReportGenerate();

    @Test
    public void updateObject() {
        extentReportGenerate.generateReport("UpdateObjectTest");

        File putBody = new File("src/main/resources/UpdateObject.json");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects/")
                .header("Content-Type", "application/json")
                .body(putBody);

        Response response = request
                .when()
                .put("ff8081819127333701912896670703fc");

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
