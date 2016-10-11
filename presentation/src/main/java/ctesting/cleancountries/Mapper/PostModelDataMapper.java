package ctesting.cleancountries.Mapper;

import com.domain.Post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import ctesting.cleancountries.Model.PostModel;
import ctesting.cleancountries.internal.di.PerActivity;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@PerActivity
public class PostModelDataMapper {

    @Inject
    public PostModelDataMapper() {
    }

    public PostModel transform(Post post){
        if(post == null){
            throw new IllegalArgumentException();
        }
        PostModel postModel = new PostModel();
        postModel.setAuthor(post.getAuthor());
        postModel.setTitle(post.getTitle());
        postModel.setThumbnail(post.getThumbnail());
        postModel.setScore(post.getScore());
        postModel.setNum_comments(post.getNum_comments());
        postModel.setDate(post.getDate());
        return postModel;
    }

    public Collection<PostModel> transform(Collection<Post> posts){
        Collection<PostModel> postModelCollection;
        if(posts != null && !posts.isEmpty()){
            postModelCollection = new ArrayList<>();
            for(Post post: posts){
                postModelCollection.add(transform(post));
            }
        }else{
            postModelCollection = Collections.emptyList();
        }

        return postModelCollection;
    }
}
