package com.example.progressdialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Button cylcre;
    @ViewById
    Button tiaoxing_nodongtai;
    @ViewById
    Button tiaoxing_and_dongtai;
    @ViewById
    Button putong_AlerDialog;
    @ViewById
    Button putong_AlerDialogList;
    @ViewById
    Button AlerDialog_singlechoice_List;
    @ViewById
    Button AlerDialog_multichoice_List;
    @ViewById
    Button next_activity,btn_ndk;


    private ProgressDialog progressDialog;

    int add = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @AfterViews
    void AfterViews(){

    }

    @Click
    void cylcre(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("加载资源");
        progressDialog.setMessage("资源加载中...");
        progressDialog.setCancelable(false);//不可以通过按钮来取消关闭对话框
        progressDialog.show();
    }

    @Click
    void tiaoxing_nodongtai(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("软件更新中");
        progressDialog.setMessage("软件正在更新...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Click
    void tiaoxing_and_dongtai(){
        final int Max = 100;
        int progressStart = 0;
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("文件读取中");
        progressDialog.setMessage("文件正在读取...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);
        progressDialog.setMax(Max);
        progressDialog.show();

    }

    @Click
    void putong_AlerDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog  aler = null;
        builder.setTitle("系统提示");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("这是一个最普通的AlertDialog,\n带有三个按钮，分别是取消，中立和确定");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了取消按钮~", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了确定按钮~", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("中立", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了中立按钮~", Toast.LENGTH_SHORT).show();
            }
        });
        aler = builder.create();
        aler.show();
    }
    @Click
    void putong_AlerDialogList(){
        AlertDialog aler = null;
        final String[] lesson = new String[]{"语文", "数学", "英语", "化学", "生物", "物理", "体育"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("选择你喜欢的课程");
        builder.setItems(lesson, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,lesson[which]+"",Toast.LENGTH_LONG).show();
            }
        });
        aler = builder.create();
        aler.show();
    }
    @Click
    void AlerDialog_singlechoice_List(){
        final String[] fruits = new String[]{"苹果", "雪梨", "香蕉", "葡萄", "西瓜"};
        AlertDialog aler = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("选择喜欢的水果");
        builder.setSingleChoiceItems(fruits, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,fruits[which]+"",Toast.LENGTH_LONG).show();
            }
        });
        aler = builder.create();
        aler.show();
    }
    @Click
    void AlerDialog_multichoice_List(){
        final String[] menu = new String[]{"水煮豆腐", "萝卜牛腩", "酱油鸡", "胡椒猪肚鸡"};
        //定义一个用来记录个列表项状态的boolean数组
        final boolean[] checkItems = new boolean[]{false, false, false, false};
        AlertDialog aler = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("选择喜欢的食物");
        builder.setMultiChoiceItems(menu, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkItems[which] = isChecked;
                Toast.makeText(MainActivity.this,menu[which]+"",Toast.LENGTH_LONG).show();
            }
        });
        aler = builder.create();
        aler.show();
    }

    @Click
    void next_activity(){
        Intent intent = new Intent(MainActivity.this,SecondActivity_.class);
        startActivity(intent);
    }

    @Click
    void btn_ndk(){
        NDKActivity_.intent(this).start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        progressDialog.dismiss();
    }
}
