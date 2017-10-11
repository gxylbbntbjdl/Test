package com.example.myapp2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by romg on 2017/8/31.
 */

public class TestService extends Service{
    private String Tag = TestService.class.getSimpleName();
    private MyBind myBind = new MyBind();
    @Override
    public IBinder onBind(Intent intent) {
        return myBind;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(Tag,":    onCreate()");
        System.out.println(":    onCreate()");
        Toast.makeText(TestService.this,"onCreate",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(Tag,":    onStartCommand()");
        Toast.makeText(TestService.this,"onStartCommand",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(Tag,":    onDestroy()");
        System.out.println(":    onDestroy()");
        Toast.makeText(TestService.this,"onDestroy",Toast.LENGTH_LONG).show();
    }
    class MyBind extends Binder{
        public void downLoad(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(TestService.this,"xxxxxxx",Toast.LENGTH_LONG).show();
                }
            }).start();
        }
    }
}
