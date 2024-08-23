package tests.publicApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.ExtentReportGenerate;

import static io.restassured.RestAssured.given;

public class GetMultipleObjectsTest {

    ExtentReportGenerate extentReportGenerate = new ExtentReportGenerate();

    @Test
    @Parameters({"id"})
    public void getMultipleObjects(String id) {
        extentReportGenerate.generateReport("GetMultipleObjectsTest");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParam("id", id);

        Response response = request
                .when()
                .get();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
