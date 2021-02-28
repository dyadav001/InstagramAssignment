package com.codepath.rkpandey.instagramassignment.fragments;

import android.util.Log;

import com.codepath.rkpandey.instagramassignment.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostFragment {
    @Override
    protected void queryPosts(){
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.setLimit(20);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.addDescendingOrder(Post.KEY_CREATED_AT);

        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e!= null){
                    Log.e(TAG, "Issue with getting post", e);
                    e.printStackTrace();
                    return;

                }
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();

                for (int i=0; i<posts.size(); i++){
                    Post post= posts.get(i);
                    Log.i(TAG, "Post:" + post.getDescription() + ", username:" + post.getUser().getUsername());
                }

            }
        });
    }
}
