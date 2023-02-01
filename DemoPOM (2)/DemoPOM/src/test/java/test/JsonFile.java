package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lib.myWebElement;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.io.File;

import static io.restassured.RestAssured.given;

public class JsonFile extends BaseTest {
    String title;
    @Test
    public void getUser() throws JsonProcessingException {
        File file = new File("./src/resources/user.json");
        Response response = given().
                headers("Content-Type", ContentType.JSON,"Accept",ContentType.JSON).
                when().
                get("https://jsonplaceholder.typicode.com/posts").
                then().extract().response();

        JsonNode jsonNode = new ObjectMapper().readTree(response.asString());
        for (JsonNode titleNode : jsonNode) {
            long id = titleNode.path("id").asLong();
            if (id == 2) {
                title = titleNode.path("title").asText();
                System.out.println(title);
            }
        }
    }

    @Test
    public void demoSearching() {
        WebDriver driver = getDriver();
        driver.get("https://google.com");

        myWebElement searchBox = new myWebElement(driver,"//input[@name='q']");
        searchBox.withDuration(5).waitUntilClickAble().click();
        searchBox.sendKeys(title);

        myWebElement searchButton = new myWebElement(driver, "(//input[@class='gNO89b'])[1]");
        searchButton.withDuration(5).waitUntilClickAble().click();
    }

}
