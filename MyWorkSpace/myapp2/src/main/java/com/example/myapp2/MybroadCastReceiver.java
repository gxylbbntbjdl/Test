package com.example.myapp2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by romg on 2017/9/1.
 */

public class MybroadCastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals("android.intent.action.BOOT_COMPLETED")){
            Toast.makeText(context,"收到开机广播了",Toast.LENGTH_LONG).show();
        }
    }
}
