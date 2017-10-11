package com.example.romg.myapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by romg on 2017/8/28.
 */

public class MyService extends Service{

    private MyBind myBind = new MyBind();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("sssssssssssMyService",String.valueOf(Thread.currentThread().getId()));
        //因为服务也是运行在主线程里面的，下面这段代码会导致ANR异常，其阻塞了主线程的运行
//        try {
//            Thread.sleep(50000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }



//        Notification notification = new Notification(R.mipmap.ic_launcher,"有通知的到来",1);
//        Intent intent = new Intent(this,MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
////        notification.setLatestEventInfo(this, "这是通知的标题", "这是通知的内容",
////                pendingIntent);
//        startForeground(1,notification);
    }
    @Override
    public IBinder onBind(Intent intent) {
        return myBind;
    }
    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //开始执行后台任务
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    class MyBind extends Binder {
        /**
         * 开始下载任务
         */
        public void startDownLoad(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //开始执行下载任务
                }
            }).start();
        }
    }
}
