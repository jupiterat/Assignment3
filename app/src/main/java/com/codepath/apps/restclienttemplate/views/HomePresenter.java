package com.codepath.apps.restclienttemplate.views;

import android.util.Log;

import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

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
                mHomeview.onLoadFinished();
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
}
