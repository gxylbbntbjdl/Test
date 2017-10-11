package com.pemt.ypgt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by romg on 2017/9/22.
 */

@EActivity(R.layout.activity_include)
public class IncludeActivity extends Activity {

    @ViewById(R.id.tv_title)
    TextView tv_title;

    @ViewById(R.id.include_server_net_data)
    Button includeServerNetData;
    @ViewById(R.id.include_server_net_data)
    Button includeVoltagData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews(){
        tv_title.setText("导入");
    }

    @Click
    void includeServerNetData(){
        showAlerdialog("提示","导入服务网点数据");
    }

    @Click
    void includeVoltagData(){
        showAlerdialog("提示","导入高压用户数据");
    }

    public void showAlerdialog(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
