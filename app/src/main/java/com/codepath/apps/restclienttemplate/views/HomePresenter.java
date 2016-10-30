package com.codepath.apps.restclienttemplate.views;

import android.util.Log;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by dtathoai on 26/10/2016.
 */

public class HomePresenter implements BasePresenter {
    private HomeView mHomeview;
    private static final String TAG = HomePresenter.class.getSimpleName();

    public HomePresenter(HomeView view) {
        mHomeview = view;
        subscribe();
    }


    @Override
    public void subscribe() {

        TwitterApplication.getRestClient().getHomeTimeline(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                Log.d(TAG, "onSuccess");

                Gson gson = new Gson();
                List<Tweet> list = gson.fromJson(response.toString(), new TypeToken<ArrayList<Tweet>>(){}.getType());

                mHomeview.onLoadFinished(list);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.d(TAG, "onFailure");
            }
        });
    }

    @Override
    public void unsubscribe() {

    }

    public void postTweet(String content) {

        TwitterApplication.getRestClient().postTweet(content, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                mHomeview.onPostTweetSuccess();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                mHomeview.onPostTweetFail();
            }
        });
    }

    public void logout() {
        TwitterApplication.getRestClient().clearAccessToken();
        mHomeview.onLogoutSuccess();
    }
}
