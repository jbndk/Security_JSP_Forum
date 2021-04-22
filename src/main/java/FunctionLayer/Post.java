package FunctionLayer;

import java.sql.Timestamp;

public class Post {
    private int postID;
    private String category;
    private String content;
    private String author;
    private Timestamp created;

    public Post(int postID, String category, String content, String author, Timestamp created) {
        this.postID = postID;
        this.category = category;
        this.content = content;
        this.author = author;
        this.created = created;
    }

    public Post(String category, String content, String author) {
        this.category = category;
        this.content = content;
        this.author = author;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
