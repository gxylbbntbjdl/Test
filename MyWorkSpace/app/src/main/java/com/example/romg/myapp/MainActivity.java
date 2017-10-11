package com.example.romg.myapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyService.MyBind myBind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("sssssssssssMainActivity",String.valueOf(Thread.currentThread().getId()));
        setContentView(R.layout.activity_main);
        initView();
        initService();

        //实例化Class类对象
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        class1 = MyClass.class;
        try {
            class2 = Class.forName("com.example.romg.myapp.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
       }
        class3 = new MyClass().getClass();
        /*class1.getName()获取类名的全路径
        * MainActivity.class.getSimpleName()获取类名，以字符串的形式*/
        Log.i(MainActivity.class.getSimpleName()+"class1:",class1.getName());
        Log.i(MainActivity.class.getSimpleName()+"class2:",class2.getName());
        Log.i(MainActivity.class.getSimpleName()+"class3:",class3.getName());
        Class<?> parentClass = class1.getSuperclass();
        parentClass.getName();//获取父类

        //获取类实现的所有接口
        Class<?> interfaces[] = class1.getInterfaces();
        for (int i = 0;i < interfaces.length; i ++){
            Log.i(MainActivity.class.getSimpleName()+"interface",interfaces[i].getName());
        }

        }
        public void initView(){
        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Toast.makeText(MainActivity.this,"aaa",Toast.LENGTH_LONG).show();
        }
        });
        }

    public void initService(){
        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBind = (MyService.MyBind)service;
                myBind.startDownLoad();
                Toast.makeText(MainActivity.this,"开始下载任务",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        Intent intent = new Intent(this,MyService.class);
        bindService(intent,conn,BIND_AUTO_CREATE);
    }
}
