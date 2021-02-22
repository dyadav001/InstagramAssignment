package com.codepath.rkpandey.instagramassignment;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("cgqUJLT4Ba8sxJGkraCscmk6oaJWXghz3Vk8sNZc")
                .clientKey("D5HiXSTvIaHGLgc9ki0SfIjVgGr1ZXzXAJOCyZu9")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
