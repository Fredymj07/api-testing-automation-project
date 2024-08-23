package tests.publicApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExtentReportGenerate;
import java.io.File;
import static io.restassured.RestAssured.given;

public class CreateObjectTest {

    ExtentReportGenerate extentReportGenerate = new ExtentReportGenerate();

    @Test
    public void createObject() {
        extentReportGenerate.generateReport("CreateObjectTest");

        File postBody = new File("src/main/resources/CreateObject.json");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type", "application/json")
                .body(postBody);

        Response response = request
                .when()
                .post();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
