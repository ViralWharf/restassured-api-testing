package api.tests.posts;

import api.client.PostClient;
import api.models.posts.create.CreatePostRequest;
import api.models.posts.create.CreatePostResponse;
import api.utils.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreatePostTest extends BaseTest {

    PostClient postClient = new PostClient();

    @Test
    void deberiaCrearPostSatisfactoriamente() {
        int userId = 1;
        String title = "Prueba de Creación de post";
        String bodyContent = "Contenido del post de prueba.";

        CreatePostRequest body = new CreatePostRequest(userId, title, bodyContent);

        // Act
        Response response = postClient.createPost(request, body);

        // Asserts
        response.then().statusCode(201);

        CreatePostResponse post = response.as(CreatePostResponse.class);

        assertEquals(userId, post.getUserId());
        assertEquals(title, post.getTitle());
        assertEquals(bodyContent, post.getBody());

        String prettyJson = response.getBody().asPrettyString();
        test.info("<details><summary><b>Response Body</b></summary><pre><code>"
                + prettyJson + "</code></pre></details>");
    }
}
