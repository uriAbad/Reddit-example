package ctesting.cleancountries.presenter;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import com.domain.interactor.UseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ctesting.cleancountries.Mapper.PostModelDataMapper;
import ctesting.cleancountries.Mapper.UserModelDataMapper;
import ctesting.cleancountries.view.UserListView;
import ctesting.cleancountries.view.presenter.UserListPresenter;
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
public class UserListPresenterTest {

    private UserListPresenter userListPresenter;

    @Mock Context context;
    @Mock UserListView userListView;
    @Mock UseCase getUserListUseCase;
    @Mock UseCase getPostNewUseCase;
    @Mock UseCase getPostHotUseCase;
    @Mock UseCase getPostControversialUseCase;
    @Mock UserModelDataMapper userModelDataMapper;
    @Mock PostModelDataMapper postModelDataMapper;

    @Before
    public void setUp(){

        try {
            MockitoAnnotations.initMocks(this);
        } catch (NullPointerException e) {
            //waiting for fix
        }

        userListPresenter = new UserListPresenter(getUserListUseCase,
                userModelDataMapper,
                getPostNewUseCase,
                getPostHotUseCase,
                getPostControversialUseCase,
                postModelDataMapper);
        userListPresenter.setView(userListView);
    }

    @Test
    public void testUserListPresenterGetPostNewAndInitialize(){
        given(userListView.context()).willReturn(context);

        userListPresenter.loadDataNew();

        verify(userListView).hideRetry();
        verify(userListView).showLoading();
        verify(getPostNewUseCase).execute(any(Subscriber.class));
    }
}
