package com.example.progressdialog;

import android.app.Activity;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

/**
 * Created by romg on 2017/9/25.
 */

@EActivity(R.layout.activity_ndk)
public class NDKActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //public native String getStringFormC();
}
