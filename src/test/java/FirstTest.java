import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.example.ExampleDto;
import org.example.LoginDto;
import org.example.VersionDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FirstTest {
    @BeforeAll
    public static void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void thirdTest() {
        var payload = LoginDto.builder()
                .withUsername("me")
                .withPassword("xxx")
                .build();

        var token = RestAssured
                .given()
                .port(8081)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(201)
                .extract().body().asString();
        Assertions.assertThat("s").isEqualTo("s");
    }

    @Test
    public void secondTest() {
        var expected = VersionDto.builder().withVersion("3.5").build();
        var actual = RestAssured
                .given()
                .port(8081)
                .header("Authorization", "Bearer bWV4eHg=")
                .contentType(ContentType.JSON)
                .when()
                .get("/version")
                .then()
                .statusCode(200)
                .extract()
                .as(VersionDto.class);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void firstTest() {
        var t = ExampleDto.builder().withFirst("xxx").build();
        System.out.println(t);
        Assertions.assertThat("s").isEqualTo("s");
    }
}
