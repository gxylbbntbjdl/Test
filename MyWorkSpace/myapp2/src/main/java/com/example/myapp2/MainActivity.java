package com.example.myapp2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnStartService;
    private Button btnStopService;
    private Button btnBindService;
    private Button btnUnbindService;
    private Button btn_huoqudata;
    private EditText et_input;
    private ProgressBar pb;
    private Button btn_start;
    private TextView tv_pb;
    private Button btn_shexiangji;
    private ImageView im_v;
    private Button btn_tosecond;


    private Intent intent;
    private TestService.MyBind myBind;
    private ServiceConnection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initListener();
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBind = (TestService.MyBind)service;
                myBind.downLoad();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    public void initUI() {
        btnStartService = (Button) this.findViewById(R.id.btn_startService);
        btnStopService = (Button) this.findViewById(R.id.btn_stopService);
        btnBindService = (Button) this.findViewById(R.id.btn_bindService);
        btnUnbindService = (Button) this.findViewById(R.id.btn_unbindService);
        et_input = (EditText)this.findViewById(R.id.et_input);
        btn_huoqudata = (Button)this.findViewById(R.id.btn_huoqudata);
        btn_start = (Button)this.findViewById(R.id.btn_start);
        pb = (ProgressBar) this.findViewById(R.id.pb);
        tv_pb = (TextView) this.findViewById(R.id.tv_pb);
        btn_shexiangji =(Button) this.findViewById(R.id.btn_shexiangji);
        im_v = (ImageView)this.findViewById(R.id.im_v);
        btn_tosecond = (Button)this.findViewById(R.id.btn_tosecond);
    }

    public void initListener() {
        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
        btnUnbindService.setOnClickListener(this);
        btn_huoqudata.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        btn_shexiangji.setOnClickListener(this);
        btn_tosecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_startService:
                intent = new Intent(this,TestService.class);
                startService(intent);
                //测试泛型
                MyFangXing<Integer> myFangXing = new MyFangXing<Integer>(100000);
                String type = myFangXing.showType();
                Toast.makeText(this,"T 的实际类型是： "+type,Toast.LENGTH_LONG).show();
                Integer t = myFangXing.getT();
                Toast.makeText(this,"t 的是值是： "+String.valueOf(t),Toast.LENGTH_LONG).show();
                Character[] char1 = {'h','e','l','l','o'};
                Integer[] ints = {1,2,3,4,5};
                printArray(ints);
                printArray(char1);
                break;
            case R.id.btn_stopService:
                intent = new Intent(this,TestService.class);
                stopService(intent);
                break;
            case R.id.btn_bindService:
                intent = new Intent(this,TestService.class);
                bindService(intent,conn,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbindService:
                unbindService(conn);
                break;
            case R.id.btn_huoqudata:
                String number = et_input.getText().toString().trim();
                if(number.equals("") || number.equals("0")){
                    Toast.makeText(this,"没有数据",Toast.LENGTH_LONG).show();
                }
                Toast.makeText(this,"有数据",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_start:
                startPb();
                break;
            case R.id.btn_shexiangji:
                startCarme();
                break;
            case R.id.btn_tosecond:
               Intent intent = new Intent(MainActivity.this,SecondActivity_.class);
                startActivity(intent);
                break;
        }
    }

    public <E> void printArray(E[] inputArray){
        for (E element:inputArray){
            Toast.makeText(MainActivity.this,element+"",Toast.LENGTH_LONG).show();
        }
    }
    public void startPb(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i <= pb.getMax();i++){
                    pb.setProgress(i);
                    tv_pb.setText(i+" ");
                }
            }
        };
        //new Thread(runnable).start();
      this.runOnUiThread(runnable);//这样写的话，就不能使用睡眠时间。
    }

    public void startCarme(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,Activity.DEFAULT_KEYS_DIALER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap)bundle.get("data");
            im_v.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
