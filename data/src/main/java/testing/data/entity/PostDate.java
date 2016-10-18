package testing.data.entity;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by Uri Abad on 13/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class PostDate extends RealmObject {

    private Date expirationDate;
    private String postType;

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public PostType getPostType() {
        return PostType.valueOf(postType);
    }

    public void setPostType(PostType postType) {
        this.postType = postType.toString();
    }
}
