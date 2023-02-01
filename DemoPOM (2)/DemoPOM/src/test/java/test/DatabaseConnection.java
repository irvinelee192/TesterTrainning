package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DatabaseConnection {

    public static final String connectionURL = "jdbc:mysql://localhost:3306/demo_tester";
    static int userId;
    static int id;
    static String title;
    static String body;
    static String sqlInsert;
    @Test
    public void getUser() throws SQLException, JsonProcessingException {

        Response response = given().
                headers("Content-Type", ContentType.JSON,"Accept",ContentType.JSON).
                when().
                get("https://jsonplaceholder.typicode.com/posts").
                then().extract().response();
        DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(connectionURL,"hoangtran","123456");
        Statement st = con.createStatement();

        JsonNode jsonNode = new ObjectMapper().readTree(response.asString());

        for (JsonNode titleNode : jsonNode) {
            userId = titleNode.path("userId").asInt();
            id = titleNode.path("id").asInt();
            title = titleNode.path("title").asText();
            body = titleNode.path("body").asText();
            sqlInsert = "Insert into customer (userId, id, title, body) Values ("+userId+","+id+",\""+title+"\",\""+body+"\");";
            st.execute(sqlInsert);
        }


//
//        Statement st = con.createStatement();
//        String sqlSelect = "Select * from customer;";
//        String sqlDelete = "DELETE FROM demotable WHERE idDemotable = 1;";
//        String sqlInsert = "Insert into customer (userID, id, title, body) Values (1,1,'title-A','body-A')";
//        st.execute(sqlSelect);
//        st.execute(sqlInsert);
        st.close();
        con.close();
    }

}
