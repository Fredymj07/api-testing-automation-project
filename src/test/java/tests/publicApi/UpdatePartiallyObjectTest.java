package tests.publicApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExtentReportGenerate;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdatePartiallyObjectTest {

    ExtentReportGenerate extentReportGenerate = new ExtentReportGenerate();

    @Test
    public void updatePartiallyObject() {
        extentReportGenerate.generateReport("UpdatePartiallyObjectTest");

        File patchBody = new File("src/main/resources/UpdatePartiallyObject.json");


        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects/")
                .header("Content-Type", "application/json")
                .body(patchBody);

        Response response = request
                .when()
                .patch("ff80818190a5a11e0190ac8999ba1345");

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
