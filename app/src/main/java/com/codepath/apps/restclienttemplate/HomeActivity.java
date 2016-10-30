package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.views.HomePresenter;
import com.codepath.apps.restclienttemplate.views.HomeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dtathoai on 26/10/2016.
 */

public class HomeActivity extends AppCompatActivity implements HomeView, TweetDialog.OnSubmitClickListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tweets)
    RecyclerView recyclerView;

    @BindView(R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    private HomePresenter mPresenter;

    TweetAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mPresenter = new HomePresenter(this);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.subscribe();
            }
        });

    }

    @Override
    public void onLoadFinished(List<Tweet> list) {
        adapter = new TweetAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }
    }

    @Override
    public void onLoadFail() {
        Toast.makeText(this, "get data fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostTweetSuccess() {
        mPresenter.subscribe();
    }

    @Override
    public void onPostTweetFail() {
        Toast.makeText(this, "post fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogoutSuccess() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                showEditDialog();
                return true;
            case R.id.action_logout:
                mPresenter.logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        TweetDialog dialog = TweetDialog.makeInstance();
        dialog.show(fm, "dialog");
    }

    @Override
    public void onSubmit(String content) {
        mPresenter.postTweet(content);
    }
}
