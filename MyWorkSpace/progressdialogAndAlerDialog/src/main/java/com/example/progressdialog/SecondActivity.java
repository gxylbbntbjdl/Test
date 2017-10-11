package com.example.progressdialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by romg on 2017/9/20.
 */

@EActivity(R.layout.activity_second)
public class SecondActivity  extends Activity{

    @ViewById
    ListView lv,lv1;
    @ViewById
    TextView xingming,xuehao,age,addr;

    private List<Map<String,String>> listMap = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();

    }

    @AfterViews
    void afterViews(){
        SimpleAdapter adapter = new SimpleAdapter(this,listMap,R.layout.lv_item_simperadapter,new String[]{"name","xuehao","age","addr"},new int[]{R.id.xingming,R.id.xuehao,R.id.age,R.id.addr});
        lv.setAdapter(adapter);
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listMap);
        lv1.setAdapter(adapter1);

    }
    void initData(){
        listMap.clear();;
        for(int i = 0;i < 20; i++){
            Map<String,String> map = new HashMap<>();
            map.put("name","name"+i);
            map.put("xuehao","xuehao"+i);
            map.put("age","age"+i);
            map.put("addr","addr"+i);
            listMap.add(map);
        }
    }

}
