package com.eylem.instaclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder> {

    private ArrayList<String> userEmailList;
    private ArrayList<String> userImageList;
    private ArrayList<String> userCommentList;

    public FeedRecyclerAdapter(ArrayList<String> userEmailList, ArrayList<String> userImageList, ArrayList<String> userCommentList) {
        this.userEmailList = userEmailList;
        this.userImageList = userImageList;
        this.userCommentList = userCommentList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.userEmailText.setText(userEmailList.get(position));
        Picasso.get().load(userImageList.get(position)).into(holder.imageView);
        holder.commentText.setText(userCommentList.get(position));
    }

    @Override
    public int getItemCount() {
        return userEmailList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView userEmailText,commentText;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            userEmailText=itemView.findViewById(R.id.recycler_row_userEmail_Text);
            imageView=itemView.findViewById(R.id.recycler_row_imageView);
            commentText=itemView.findViewById(R.id.recycler_row_comment_Text);
        }
    }
}
