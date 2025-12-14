package api.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

public class BaseTest {

    protected ExtentTest test;
    protected RequestSpecification request;

    @BeforeAll
    static void initReport() {
        ExtentManager.getInstance();
    }

    @BeforeEach
    void setUp(TestInfo info) {
        test = ExtentManager.getInstance().createTest(info.getDisplayName());

        request = RestAssured.given()
                .baseUri(Config.get("base.url"))
                .contentType(ContentType.JSON);

        test.info("Request configurada con baseUri: " + Config.get("base.url"));
    }

    @AfterAll
    static void tearDown() {
        ExtentManager.getInstance().flush();
    }
}