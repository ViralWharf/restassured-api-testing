package api.tests.posts;

import api.client.PostClient;
import api.models.posts.update.UpdatePostRequest;
import api.models.posts.update.UpdatePostResponse;
import api.utils.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdatePostTest extends BaseTest {

    PostClient postClient = new PostClient();

    @Test
    void deberiaActualizarPostSatisfactoriamente() {
        int userId = 1;
        int postId = 15;
        String title = "Prueba de Actualizacion de post";
        String bodyContent = "Contenido del post de prueba.";

        UpdatePostRequest body = new UpdatePostRequest(userId, title, bodyContent);

        // Act
        Response response = postClient.updatePost(request, body, postId);

        // Asserts
        response.then().statusCode(200);

        UpdatePostResponse post = response.as(UpdatePostResponse.class);

        assertEquals(userId, post.getUserId());
        assertEquals(title, post.getTitle());
        assertEquals(bodyContent, post.getBody());
        assertEquals(postId, post.getId());

        String prettyJson = response.getBody().asPrettyString();
        test.info("<details><summary><b>Response Body</b></summary><pre><code>"
                + prettyJson + "</code></pre></details>");
    }
}
