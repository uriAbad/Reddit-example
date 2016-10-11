package ctesting.cleancountries.view.adapter;

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
import ctesting.cleancountries.Model.UserModel;
import ctesting.cleancountries.R;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder>{

    private List<UserModel> usersCollection;
    private final LayoutInflater layoutInflater;


    @Inject
    public UsersAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.usersCollection = Collections.emptyList();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_post_reddit, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final UserModel userModel = this.usersCollection.get(position);
        holder.textViewTitle.setText(userModel.getUsername());
        holder.textViewSubtitle.setText(userModel.getEmail());
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
        return (this.usersCollection != null) ? this.usersCollection.size() : 0;
    }

    public void setUsersCollection(Collection<UserModel> usersCollection) {
        this.validateUsersCollection(usersCollection);
        this.usersCollection = (List<UserModel>) usersCollection;
        this.notifyDataSetChanged();
    }

    private void validateUsersCollection(Collection<UserModel> usersCollection) {
        if(usersCollection == null){
            throw new IllegalArgumentException("List cant be null");
        }
    }

    static class UserViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tvTitle) TextView textViewTitle;
        @BindView(R.id.tcSubtitle) TextView textViewSubtitle;


        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
