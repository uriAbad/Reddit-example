package ctesting.redditexample.view;

import java.util.Collection;

import ctesting.redditexample.Model.PostModel;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface PostListView extends LoadDataView {

    void renderPostList(Collection<PostModel> postModelCollection);
}
