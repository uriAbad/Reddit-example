package testing.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class ListingEntity {

    @SerializedName("data")
    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public List<PostEntity> parseList(PostType postType){
        List<PostEntity> lists = Collections.emptyList();
        if(getData().getChildren()!= null){
            lists = new ArrayList<>();
            for(DataChildrenEntity dataChildrenEntity: getData().getChildren()){
                PostEntity post = dataChildrenEntity.getPost();
                post.setPostType(postType);
                if(post != null){
                    lists.add(post);
                }
            }
        }
        return lists;
    }
}
