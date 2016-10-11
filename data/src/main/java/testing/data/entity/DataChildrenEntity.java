package testing.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class DataChildrenEntity {

    private String kind;
    @SerializedName("data")
    private PostEntity post;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }
}
