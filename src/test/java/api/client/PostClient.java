package api.client;

import api.models.posts.create.CreatePostRequest;
import api.models.posts.update.UpdatePostRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostClient {

    public Response getPosts(RequestSpecification request, int page) {
        return request
                .queryParam("page", page)
                .get("/posts");
    }

    public Response createPost(RequestSpecification request, CreatePostRequest body) {
        return request
                .contentType(ContentType.JSON)
                .body(body)
                .post("/posts");
    }

    public Response updatePost(RequestSpecification request, UpdatePostRequest body, int postId){
        return request
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/posts/" + postId)
                .then()
                .extract()
                .response();
    }

    public Response deletePost(RequestSpecification request,int postId){
        return request
                .contentType(ContentType.JSON)
                .when()
                .delete("/posts/" + postId)
                .then()
                .extract()
                .response();
    }
}
