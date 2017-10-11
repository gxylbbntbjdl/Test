package com.example.annotationstest;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.btn_one)
    Button btnOne;

    @Click(R.id.btn_one)
    void btnOnClick(Button btn){
        Toast.makeText(this,"点击",Toast.LENGTH_LONG).show();
    }

    @AfterViews
    void init(){
        Toast.makeText(this,"此方法是做初始化操作的",Toast.LENGTH_LONG).show();
    }
}
