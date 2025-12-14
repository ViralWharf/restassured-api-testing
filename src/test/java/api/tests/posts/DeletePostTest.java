package api.tests.posts;

import api.client.PostClient;
import api.utils.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeletePostTest extends BaseTest {

    PostClient postClient = new PostClient();

    @Test
    void deberiaEliminarPostSatisfactoriamente() {
        int postId = 15;

        // Act
        Response response = postClient.deletePost(request, postId);

        // Asserts
        response.then().statusCode(200);
        assertEquals("{}", response.getBody().asString());

        String prettyJson = response.getBody().asPrettyString();
        test.info("<details><summary><b>Response Body</b></summary><pre><code>"
                + prettyJson + "</code></pre></details>");
    }
}
