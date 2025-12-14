package api.models.posts.update;

public class UpdatePostResponse {

    private String title;
    private String body;
    private int userId;
    private int id;

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }
}
