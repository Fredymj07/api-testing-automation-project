package tests.publicApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExtentReportGenerate;

import static io.restassured.RestAssured.given;

public class DeleteObjectTest {

    ExtentReportGenerate extentReportGenerate = new ExtentReportGenerate();

    @Test
    public void deleteObject() {
        extentReportGenerate.generateReport("DeleteObjectTest");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects/");

        Response response = request
                .when()
                .delete("ff808181912733370191287c2feb03cf");

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
