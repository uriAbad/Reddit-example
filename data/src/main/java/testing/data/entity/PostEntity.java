package testing.data.entity;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class PostEntity extends RealmObject {

    private String thumbnail;
    @SerializedName("created")
    private long date;
    private String title;
    private String author;
    private String num_comments;
    private String score;
    private String postTypeDescription;

    public PostType getPostType() {
        return PostType.valueOf(postTypeDescription);
    }

    public void setPostType(PostType postType) {
        this.postTypeDescription = postType.toString();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNum_comments() {
        return num_comments;
    }

    public void setNum_comments(String num_comments) {
        this.num_comments = num_comments;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
