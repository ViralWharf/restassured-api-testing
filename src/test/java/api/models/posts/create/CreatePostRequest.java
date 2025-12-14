package api.models.posts.create;

public class CreatePostRequest {

    private final int userId;
    private final String title;
    private final String body;

    public CreatePostRequest(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}

