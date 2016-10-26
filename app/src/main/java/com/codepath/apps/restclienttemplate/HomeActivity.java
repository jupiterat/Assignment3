package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.codepath.apps.restclienttemplate.views.HomePresenter;
import com.codepath.apps.restclienttemplate.views.HomeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dtathoai on 26/10/2016.
 */

public class HomeActivity extends AppCompatActivity implements HomeView {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private HomePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mPresenter = new HomePresenter(this);
    }

    @Override
    public void onLoadFinished() {

    }

    @Override
    public void onLoadFail() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
