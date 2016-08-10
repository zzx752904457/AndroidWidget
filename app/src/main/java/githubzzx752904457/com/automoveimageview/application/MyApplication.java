package githubzzx752904457.com.automoveimageview.application;

import android.app.Application;

/**
 * Created by admin on 2016/8/9.
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static synchronized MyApplication getInstance() {
        return instance;
    }
}
