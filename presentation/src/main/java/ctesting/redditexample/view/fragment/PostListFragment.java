package ctesting.redditexample.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ctesting.redditexample.Model.PostModel;
import ctesting.redditexample.R;
import ctesting.redditexample.internal.di.component.PostComponent;
import ctesting.redditexample.view.PostListView;
import ctesting.redditexample.view.adapter.PostAdapter;
import ctesting.redditexample.view.adapter.PostLayoutManager;
import ctesting.redditexample.view.presenter.PostListPresenter;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class PostListFragment extends BaseFragment implements PostListView {

    @Inject PostListPresenter postListPresenter;
    @Inject PostAdapter postAdapter;

    @BindView(R.id.rv_UserList) RecyclerView rv_users;
    @BindView(R.id.rl_ProgressBar) RelativeLayout rl_ProgressBar;
    @BindView(R.id.rl_retry) RelativeLayout rl_retry;
    @BindView(R.id.btn_retry) Button btn_retry;


    PostListListener postListListener;

    public PostListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PostListListener) {
            this.postListListener = (PostListListener) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(PostComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this,fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.postListPresenter.setView(this);
//        if(savedInstanceState == null){
//            this.loadUserList();
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.postListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.postListPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv_users.setAdapter(null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.postListPresenter.destroy();
    }

    private void loadUserList() {
        this.postListPresenter.initialize();
    }

    private void setupRecyclerView() {
        //TODO: on item click configure
//        this.rv_users.setLayoutManager(new UsersLayoutManager(context()));
//        this.rv_users.setAdapter(usersAdapter);

        this.rv_users.setLayoutManager(new PostLayoutManager(context()));
        this.rv_users.setAdapter(postAdapter);
    }

    @Override
    public void renderPostList(Collection<PostModel> postModelCollection) {
        if(postModelCollection != null){
            this.postAdapter.setPostCollection(postModelCollection);
        }
    }

    @Override
    public void hideLoading() {
        this.rl_ProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoading() {
        this.rl_ProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    public void loadDataNew() {
        this.postListPresenter.loadDataNew();
    }

    public void loadDataHot() {
        this.postListPresenter.loadDataHot();
    }

    public void loadDataControversial() {
        this.postListPresenter.loadDataControversial();
    }

    interface PostListListener {
        void onPostClicked(final PostModel postModel);
    }

}
