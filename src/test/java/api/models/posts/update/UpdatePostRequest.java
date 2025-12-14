package api.models.posts.update;

public class UpdatePostRequest {

    private final int userId;
    private final String title;
    private final String body;

    public UpdatePostRequest(int userId, String title, String body) {
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

