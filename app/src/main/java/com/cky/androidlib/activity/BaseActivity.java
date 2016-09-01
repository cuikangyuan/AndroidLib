package com.cky.androidlib.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cky.androidlib.net.RequestManager;

public abstract class BaseActivity extends AppCompatActivity {

    //请求管理器
    private RequestManager requestManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVariables();

        initViews(savedInstanceState);

        loadData();

    }

    @Override
    protected void onPause() {

        if (requestManager != null) {
            requestManager.cancelRequest();
        }

        super.onPause();
    }

    @Override
    protected void onDestroy() {

        if (requestManager != null) {
            requestManager.cancelRequest();
        }

        super.onDestroy();
    }

    protected abstract void initVariables();
    protected abstract void initViews(Bundle savedInstanceState);
    protected abstract void loadData();

    public RequestManager getRequestManager() {
        return requestManager;
    }
}
