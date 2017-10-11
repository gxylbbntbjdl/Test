package com.pemt.ypgt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @ViewById
    ListView home_lv;

    @ViewById(R.id.tv_home)
    TextView tvHome;
    @ViewById(R.id.tv_include)
    TextView tvInclude;
    @ViewById(R.id.tv_export)
    TextView tvExport;
    @ViewById(R.id.tv_abot)
    TextView tvAbot;

    private List<Map<String,Object>> listMap = new ArrayList<>();
    private String[] titleStr = {"计量箱","终端设备","服务网点","高压用户点","用户箱式变","用户开关站","用户配电房","计量库房","分布式电源","用户变压器","用户专线","充换电站","充电桩"};
    private String[] descStr = {"采集计量箱空间及属性数据",
                                "采集终端设备空间及属性数据",
                                "采集银行、超市、营业厅等空间及属性数据",
                                "采集高压用户点空间及属性数据",
                                "采集用户箱式变空间及属性数据",
                                "采集用户开关站空间及属性数据",
                                "采集用户配电房空间及属性数据",
                                "采集计量库房空间及属性数据",
                                "采集分布式电源空间及属性数据",
                                "采集用户变压器空间及属性数据",
                                "采集用户专线空间及属性数据",
                                "采集充换电站空间及属性数据",
                                "采集计量箱空间及属性数据",};
    private int[] imgIDs ={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,};

    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();

    }

    public void initData(){
        for(int i = 0;i < imgIDs.length; i ++){
            Map<String,Object> map = new HashMap<>();
            map.put("iv",imgIDs[i]);
            map.put("tv_title",titleStr[i]);
            map.put("tv_desc",descStr[i]);
            listMap.add(map);
        }
    }

    @AfterViews
    void afterViews(){
        adapter = new SimpleAdapter(this,listMap,R.layout.item_home,new String[]{"iv","tv_title","tv_desc"},new int[]{R.id.iv,R.id.tv_title,R.id.tv_desc});
        home_lv.setAdapter(adapter);
    }

    @ItemClick(R.id.home_lv)
    void itemClick(int position){
        CommentActivity_.intent(this).extra("tpye",position).start();
    }

    @Click
    void tvHome(){
        MainActivity_.intent(this).start();
    }

    @Click
    void tvInclude(){
        IncludeActivity_.intent(this).start();
    }

    @Click
    void tvExport(){
        ExportActivity_.intent(this).start();
    }

    @Click
    void tvAbot(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View v = View.inflate(this,R.layout.abot_view,null);
        TextView title = (TextView) v.findViewById(R.id.tv_title);
        title.setText("关于");
        builder.setView(v);
        builder.create().show();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            AlertDialog dialog = null;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("是否退出应用程序");
            builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            });
            builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(dialog != null){
                        dialog.dismiss();
                    }
                }
            });
            dialog = builder.create();
            dialog.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
