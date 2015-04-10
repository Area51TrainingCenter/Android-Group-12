package com.johannfjs.application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by johannfjs on 10/04/15.
 */
public class ConfigureApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "qbqurqv23ToTNSQrKITlxlDje6F30ilyecJl1SPJ", "o54HgIaAUGFVHKqOKXzV8OXymzv9K2gN6EfAPXhd");
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}