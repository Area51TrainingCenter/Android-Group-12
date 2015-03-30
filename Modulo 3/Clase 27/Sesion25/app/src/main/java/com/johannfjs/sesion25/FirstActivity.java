package com.johannfjs.sesion25;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.johannfjs.sliding.BaseActivity;

/**
 * Created by johannfjs on 30/03/15.
 */
public class FirstActivity extends BaseActivity {
    public FirstActivity(){
        super(R.string.app_name);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
}
