package ctesting.redditexample.Model;

import android.text.format.DateFormat;

import java.util.Date;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class PostModel {

    private String thumbnail;
    private long date;
    private String title;
    private String author;
    private String num_comments;
    private String score;

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

    public String getDateString(){
        String dateString= DateFormat.format("MM/dd/yyyy", new Date(this.getDate())).toString();
        return dateString;
    }
}
