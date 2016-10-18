package ctesting.cleancountries.mapper;

import com.domain.Post;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ctesting.cleancountries.Mapper.PostModelDataMapper;
import ctesting.cleancountries.Model.PostModel;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by Uri Abad on 17/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class PostModelDataMapperTest extends TestCase {


    private static final String FAKE_AUTHOR = "PACO POTTER";
    private static final String FAKE_TITLE = "SURUNDERE";

    private PostModelDataMapper postModelDataMapper;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        postModelDataMapper = new PostModelDataMapper();
    }

    public void testTransformPost(){
        Post post = createFakePost();
        PostModel postModel = postModelDataMapper.transform(post);

        assertThat(postModel,is(instanceOf(PostModel.class)));
        assertThat(postModel.getAuthor(),is(FAKE_AUTHOR));
        assertThat(postModel.getTitle(),is(FAKE_TITLE));
    }

    public void testTransformPostCollection(){
        Post mockPostOne = mock(Post.class);
        Post mockPostTwo = mock(Post.class);

        List<Post> postList = new ArrayList<>(5);
        postList.add(mockPostOne);
        postList.add(mockPostTwo);

        Collection<PostModel> postModelList = postModelDataMapper.transform(postList);

        assertThat(postModelList.toArray()[0],is(instanceOf(PostModel.class)));
        assertThat(postModelList.toArray()[1],is(instanceOf(PostModel.class)));
        assertThat(postModelList.size(),is(2));
    }

    private Post createFakePost() {
        Post post = new Post();
        post.setAuthor(FAKE_AUTHOR);
        post.setTitle(FAKE_TITLE);

        return post;
    }
}
