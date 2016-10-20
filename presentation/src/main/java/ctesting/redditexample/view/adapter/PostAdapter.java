package ctesting.redditexample.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ctesting.redditexample.Model.PostModel;
import ctesting.redditexample.R;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    private final Context context;
    private List<PostModel> postCollection;
    private final LayoutInflater layoutInflater;


    @Inject
    public PostAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.postCollection = Collections.emptyList();
        this.context = context;
    }

    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_post_reddit, parent, false);
        return new PostAdapter.PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostAdapter.PostViewHolder holder, int position) {
        final PostModel postModel = this.postCollection.get(position);
        holder.textViewTitle.setText(postModel.getTitle());
        holder.textViewAuthor.setText(postModel.getAuthor());
        holder.textViewDate.setText(String.format(context.getResources().getString(R.string.date),
                postModel.getDateString()));
        holder.textViewScore.setText(String.format(context.getResources().getString(R.string
                .score),postModel.getScore()));
        holder.textViewComments.setText(String.format(context.getResources().getString(R.string
                .comments),postModel.getNum_comments()));
//        holder.textViewSubtitle.setOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View v) {
//                if (UsersAdapter.this.onItemClickListener != null) {
//                    UsersAdapter.this.onItemClickListener.onUserItemClicked(userModel);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (this.postCollection != null) ? this.postCollection.size() : 0;
    }

    public void setPostCollection(Collection<PostModel> postCollection) {
        this.validatePostCollection(postCollection);
        this.postCollection = (List<PostModel>) postCollection;
        this.notifyDataSetChanged();
    }

    private void validatePostCollection(Collection<PostModel> postCollection) {
        if(postCollection == null){
            throw new IllegalArgumentException("List cant be null");
        }
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_author_reddit) TextView textViewAuthor;
        @BindView(R.id.tv_comments_reddit) TextView textViewComments;
        @BindView(R.id.tv_date_reddit) TextView textViewDate;
        @BindView(R.id.tv_score_reddit) TextView textViewScore;
        @BindView(R.id.tv_title_reddit) TextView textViewTitle;

        public PostViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
