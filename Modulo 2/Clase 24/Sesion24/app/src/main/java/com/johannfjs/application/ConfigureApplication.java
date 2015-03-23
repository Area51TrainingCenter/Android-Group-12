package com.johannfjs.application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by johannfjs on 20/03/15.
 */
public class ConfigureApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "HTnxRdW9PMLtvcbkTkxXPhuh6kqlr4fvQ2bJ0a5O", "Bvil1QngpjXsxKo0qEdJpoM7DJaupi5BZ4iEUQEX");
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL=new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

    }
}
