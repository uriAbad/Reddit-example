package ctesting.redditexample.presenter;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import com.domain.interactor.UseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ctesting.redditexample.Mapper.PostModelDataMapper;
import ctesting.redditexample.view.PostListView;
import ctesting.redditexample.view.presenter.PostListPresenter;
import rx.Subscriber;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by Uri Abad on 18/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@RunWith(AndroidJUnit4.class)
public class PostListPresenterTest {

    private PostListPresenter postListPresenter;

    @Mock Context context;
    @Mock PostListView postListView;
    @Mock UseCase getPostNewUseCase;
    @Mock UseCase getPostHotUseCase;
    @Mock UseCase getPostControversialUseCase;
    @Mock PostModelDataMapper postModelDataMapper;

    @Before
    public void setUp(){

        try {
            MockitoAnnotations.initMocks(this);
        } catch (NullPointerException e) {
            //waiting for fix
        }

        postListPresenter = new PostListPresenter(
                getPostNewUseCase,
                getPostHotUseCase,
                getPostControversialUseCase,
                postModelDataMapper);
        postListPresenter.setView(postListView);
    }

    @Test
    public void testPostListPresenterGetPostNewAndInitialize(){
        given(postListView.context()).willReturn(context);

        postListPresenter.loadDataNew();

        verify(postListView).hideRetry();
        verify(postListView).showLoading();
        verify(getPostNewUseCase).execute(any(Subscriber.class));
    }
}
