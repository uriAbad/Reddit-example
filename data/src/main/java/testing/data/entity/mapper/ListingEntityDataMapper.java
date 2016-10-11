package testing.data.entity.mapper;

import com.domain.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import testing.data.entity.PostEntity;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Singleton
public class ListingEntityDataMapper {

    @Inject
    public ListingEntityDataMapper() {
    }

    public List<Post> transform(List<PostEntity> postEntities){
        List<Post> posts = new ArrayList<>();
        Post post;
        for(PostEntity postEntity : postEntities){
            post = transform(postEntity);
            if(post != null){
                posts.add(post);
            }
        }
        return posts;
    }

    public Post transform(PostEntity postEntity) {
        Post post = null;
        if(postEntity != null){
            post = new Post();
            post.setAuthor(postEntity.getAuthor());
            post.setDate(postEntity.getDate());
            post.setNum_comments(postEntity.getNum_comments());
            post.setScore(postEntity.getScore());
            post.setThumbnail(postEntity.getThumbnail());
            post.setTitle(postEntity.getTitle());
        }
        return post;
    }
}
