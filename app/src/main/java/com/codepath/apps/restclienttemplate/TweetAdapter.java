package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by duongthoai on 10/29/16.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    private Context mContext;
    private List<Tweet> mTweets;

    public TweetAdapter(Context ctx, List<Tweet> list) {
        mContext = ctx;
        mTweets = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(mContext).inflate(R.layout.tweet_item, parent, false);
        return new ViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tweet item = mTweets.get(position);
        Glide.with(mContext).load(item.getUser().getProfile_image_url_https()).into(holder.imageView);
        holder.content.setText(item.getText());
        holder.name.setText(item.getUser().getName());
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.profile_image)
        CircleImageView imageView;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.time)
        TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
