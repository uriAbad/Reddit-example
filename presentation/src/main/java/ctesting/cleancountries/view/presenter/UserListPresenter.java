package ctesting.cleancountries.view.presenter;

import android.support.annotation.NonNull;

import com.domain.Post;
import com.domain.User;
import com.domain.exception.DefaultErrorBundle;
import com.domain.interactor.DefaultSubscriber;
import com.domain.interactor.UseCase;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ctesting.cleancountries.Mapper.PostModelDataMapper;
import ctesting.cleancountries.Mapper.UserModelDataMapper;
import ctesting.cleancountries.Model.PostModel;
import ctesting.cleancountries.Model.UserModel;
import ctesting.cleancountries.internal.di.PerActivity;
import ctesting.cleancountries.view.UserListView;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
@PerActivity
public class UserListPresenter implements Presenter {

    private UserListView userListView;

    private final UseCase getUserListUseCase;
    private final UserModelDataMapper userModelDataMapper;
    private final PostModelDataMapper postModelDataMapper;
    private final UseCase getPostNewUseCase;
    private final UseCase getPostNewHotUseCase;
    private final UseCase getPostNewControversialUseCase;

    @Inject
    public UserListPresenter(@Named("userList") UseCase getUserListUseCase,
                             UserModelDataMapper userModelDataMapper,
                             @Named("postListNew") UseCase getPostNewUseCase,
                             @Named("postListHot") UseCase getPostHotUseCase,
                             @Named("postListControversial") UseCase getPostControversialUseCase,
                             PostModelDataMapper postModelDataMapper) {
        this.getUserListUseCase = getUserListUseCase;
        this.userModelDataMapper = userModelDataMapper;

        this.getPostNewUseCase = getPostNewUseCase;
        this.getPostNewHotUseCase = getPostHotUseCase;
        this.getPostNewControversialUseCase = getPostControversialUseCase;
        this.postModelDataMapper = postModelDataMapper;
    }

    public void setView(@NonNull UserListView userListView){
        this.userListView = userListView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getUserListUseCase.unsubscribe();
        this.userListView = null;
    }

    public void initialize(){
        this.loadUserList();
    }

    private void loadUserList(){
        this.hideViewRetry();
        this.showViewLoading();
//        this.getUserList();
//        this.getPostsList();
    }

    private void showViewLoading() {
        this.userListView.showLoading();
    }

    private void hideViewLoading() {
        this.userListView.hideLoading();
    }

    private void showViewRetry() {
        this.userListView.showRetry();
    }

    private void hideViewRetry() {
        this.userListView.hideRetry();
    }

    private void showErrorMessage(DefaultErrorBundle defaultErrorBundle) {
        this.userListView.showError(defaultErrorBundle.getErrorMessage());
    }

    private void showUsersCollectionInView(List<User> users) {
        final Collection<UserModel> userModelCollection = this.userModelDataMapper.transform(users);
        this.userListView.renderUserList(userModelCollection);
    }

    private void showPostCollectionInView(List<Post> posts){
        final Collection<PostModel> postModelCollection = this.postModelDataMapper.transform(posts);
        this.userListView.renderPostList(postModelCollection);
    }

    private void getPostsList(){
        this.getPostNewUseCase.execute(new PostListsSubscriber());
    }

    private void getPostsListHot(){
        this.getPostNewHotUseCase.execute(new PostListsSubscriber());
    }

    private void getPostsListControversial(){
        this.getPostNewControversialUseCase.execute(new PostListsSubscriber());
    }

    public void loadDataNew() {
        initialize();
        getPostsList();
    }

    public void loadDataHot() {
        initialize();
        getPostsListHot();
    }

    public void loadDataControversial() {
        initialize();
        getPostsListControversial();
    }

    private final class PostListsSubscriber extends DefaultSubscriber<List<Post>>{

        @Override
        public void onCompleted() {
            UserListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            UserListPresenter.this.hideViewLoading();
            UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            UserListPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<Post> posts) {
            UserListPresenter.this.showPostCollectionInView(posts);
        }
    }

    private void getUserList() {
        this.getUserListUseCase.execute(new UserListSubscriber());
    }

    private final class UserListSubscriber extends DefaultSubscriber<List<User>>{

        @Override
        public void onCompleted() {
            UserListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            UserListPresenter.this.hideViewLoading();
            UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            UserListPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<User> users) {
            UserListPresenter.this.showUsersCollectionInView(users);
        }
    }

}
