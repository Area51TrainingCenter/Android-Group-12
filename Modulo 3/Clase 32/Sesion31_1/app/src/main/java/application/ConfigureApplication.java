package application;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by johannfjs on 10/04/15.
 */
public class ConfigureApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
