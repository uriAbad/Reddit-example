package ctesting.redditexample.view.presenter;

import android.support.annotation.NonNull;

import com.domain.Post;
import com.domain.exception.DefaultErrorBundle;
import com.domain.interactor.DefaultSubscriber;
import com.domain.interactor.UseCase;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ctesting.redditexample.Mapper.PostModelDataMapper;
import ctesting.redditexample.Model.PostModel;
import ctesting.redditexample.internal.di.PerActivity;
import ctesting.redditexample.view.PostListView;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
@PerActivity
public class PostListPresenter implements Presenter {

    private PostListView postListView;
    private final PostModelDataMapper postModelDataMapper;
    private final UseCase getPostNewUseCase;
    private final UseCase getPostNewHotUseCase;
    private final UseCase getPostNewControversialUseCase;

    @Inject
    public PostListPresenter(@Named("postListNew") UseCase getPostNewUseCase,
                             @Named("postListHot") UseCase getPostHotUseCase,
                             @Named("postListControversial") UseCase getPostControversialUseCase,
                             PostModelDataMapper postModelDataMapper) {
        this.getPostNewUseCase = getPostNewUseCase;
        this.getPostNewHotUseCase = getPostHotUseCase;
        this.getPostNewControversialUseCase = getPostControversialUseCase;
        this.postModelDataMapper = postModelDataMapper;
    }

    public void setView(@NonNull PostListView postListView){
        this.postListView = postListView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getPostNewUseCase.unsubscribe();
        this.getPostNewHotUseCase.unsubscribe();
        this.getPostNewControversialUseCase.unsubscribe();
        this.postListView = null;
    }

    public void initialize(){
        this.prepareForloadPostList();
    }

    private void prepareForloadPostList(){
        this.hideViewRetry();
        this.showViewLoading();
    }

    private void showViewLoading() {
        this.postListView.showLoading();
    }

    private void hideViewLoading() {
        this.postListView.hideLoading();
    }

    private void showViewRetry() {
        this.postListView.showRetry();
    }

    private void hideViewRetry() {
        this.postListView.hideRetry();
    }

    private void showErrorMessage(DefaultErrorBundle defaultErrorBundle) {
        this.postListView.showError(defaultErrorBundle.getErrorMessage());
    }

    private void showPostCollectionInView(List<Post> posts){
        final Collection<PostModel> postModelCollection = this.postModelDataMapper.transform(posts);
        this.postListView.renderPostList(postModelCollection);
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
            PostListPresenter.this.hideViewLoading();
            System.out.println("COMPLETED");
        }

        @Override
        public void onError(Throwable e) {
            PostListPresenter.this.hideViewLoading();
            PostListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            PostListPresenter.this.showViewRetry();
            System.out.println("ERROR" + e.getMessage());

        }

        @Override
        public void onNext(List<Post> posts) {
            PostListPresenter.this.showPostCollectionInView(posts);
            System.out.println("ONNEXT");
        }
    }

}
