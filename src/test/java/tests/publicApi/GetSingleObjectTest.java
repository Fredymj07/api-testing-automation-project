package tests.publicApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.ExtentReportGenerate;

import static io.restassured.RestAssured.given;

public class GetSingleObjectTest {

    ExtentReportGenerate extentReportGenerate = new ExtentReportGenerate();

    @Test
    @Parameters({"id", "expectedStatusCode"})
    public void getSingleObject(String id, int expectedStatusCode) {
        extentReportGenerate.generateReport("GetSingleObjectTest");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects/");

        Response response = request
                .when()
                .get(id);

        response.prettyPrint();

        int statusCode = response.getStatusCode();

        if (statusCode == 200) {
            Assert.assertEquals(statusCode, expectedStatusCode);

            JSONObject jsonResponse = new JSONObject(response.asString());
            String nameProduct = jsonResponse.getString("name");
            System.out.println("The name of product is -> " + nameProduct);

            JSONObject jsonData = jsonResponse.getJSONObject("data");
            String cpuModel = jsonData.getString("CPU model");
            System.out.println("The CPU Model is -> " + cpuModel);
        } else {
            Assert.assertEquals(statusCode, expectedStatusCode);
            System.out.println("The searched object does not exist!!!");
        }
    }
}
