package testing.data.entity;

import io.realm.RealmObject;

/**
 * Created by Uri Abad on 13/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class PostDate extends RealmObject {

    private long expirationDate;
    private String postType;

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public PostType getPostType() {
        return PostType.valueOf(postType);
    }

    public void setPostType(PostType postType) {
        this.postType = postType.toString();
    }
}
