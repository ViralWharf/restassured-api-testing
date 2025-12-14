package api.tests.posts;

import api.client.PostClient;
import api.models.posts.get.GetPostResponse;
import api.utils.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetPostTest extends BaseTest {

    PostClient postClient = new PostClient();

    @Test
    void deberiaObtenerPostsSatisfactoriamente() {

        // Act
        Response response = postClient.getPosts(request, 1);
        String prettyResponse = response.prettyPrint();

        GetPostResponse[] posts = response.as(GetPostResponse[].class);

        // Acceder al primer post
        GetPostResponse firstPost = posts[0];

        // Asserts
        response.then().statusCode(200);
        assertEquals(1, firstPost.getId());
        assertEquals(1, firstPost.getUserId());
        assertNotNull(firstPost.getTitle());
        assertNotNull(firstPost.getBody());

        String prettyJson = response.getBody().asPrettyString();
        test.info("<details><summary><b>Response Body</b></summary><pre><code>"
                + prettyJson + "</code></pre></details>");

    }

}
