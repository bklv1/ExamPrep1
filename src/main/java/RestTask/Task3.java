package RestTask;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;


public class Task3 {
    @BeforeEach
    public void Setup(){
    }

    @Test
    public void Task3() {
        Response response = given()
                .param("delay","3")
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .extract().response();

//        System.out.println(response.body().asPrettyString());
        Assertions.assertEquals("1", response.jsonPath().getString("page"));
        Assertions.assertEquals("6", response.jsonPath().getString("per_page"));
        Assertions.assertEquals("12", response.jsonPath().getString("total"));
        Assertions.assertEquals("2", response.jsonPath().getString("total_pages"));

        Gson gson = new Gson();
        Task3DTO dto = gson.fromJson(response.body().asString(), Task3DTO.class);
        for (var element : dto.data){
            System.out.println(element.first_name +" " +element.last_name);
        }
    }
}


