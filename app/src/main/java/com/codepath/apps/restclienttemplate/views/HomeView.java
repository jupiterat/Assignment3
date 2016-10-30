package com.codepath.apps.restclienttemplate.views;

import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

/**
 * Created by dtathoai on 26/10/2016.
 */

public interface HomeView {
    public void onLoadFinished(List<Tweet> list);
    public void onLoadFail();

    public void onPostTweetSuccess();
    public void onPostTweetFail();

    public void onLogoutSuccess();

}
