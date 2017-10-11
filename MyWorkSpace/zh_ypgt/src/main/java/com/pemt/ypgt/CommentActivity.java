package com.pemt.ypgt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

/**
 * Created by romg on 2017/9/22.
 */
@EActivity(R.layout.activity_common)
public class CommentActivity extends Activity {

    @ViewById(R.id.tv_title)
    TextView tvTitle;
    @ViewById(R.id.common_lv)
    ListView commonLv;

    @ViewById(R.id.btn_find)
    Button btnFind;
    @ViewById(R.id.btn_new_add)
    Button btnNewAdd;
    @ViewById(R.id.btn_delete)
    Button btnDelete;
    @ViewById(R.id.btn_edit)
    Button btnEdit;
    @ViewById
    CheckBox iscb;


    @Extra
    int tpye;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews(){
        if(tpye == Constans.METERBOX){
            tvTitle.setText("计量箱组列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);
            btnEdit.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.TERMINAL){
            tvTitle.setText("终端设备列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.SERVERINTERNET){
            tvTitle.setText("服务网点列表");
            btnFind.setVisibility(View.VISIBLE);
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.HIGH_VOLTAGE_USER_POINT){
            tvTitle.setText("高压用户列表");
            btnFind.setVisibility(View.VISIBLE);
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.USER_BOX_TYPE_CHANGE){
            tvTitle.setText("用户箱式变列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.USER_SWITCH_STATION){
            tvTitle.setText("用户开关站列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.USER_DISTRIBUTION_ROOM){
            tvTitle.setText("用户配电房列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.METERING_THE_ROOM){
            tvTitle.setText("计量库房列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.DISTRIBUTED_POWER){
            tvTitle.setText("分布式电源列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.USER_TRANSFORMER){
            tvTitle.setText("用户变压器列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.USER_LINE){
            tvTitle.setText("用户专线列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.RECHARGEABLE_POWER_STATION){
            tvTitle.setText("充换电桩列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

        }else if(tpye == Constans.CHARGING_PILE){
            tvTitle.setText("充电桩列表");
            btnNewAdd.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);
        }
    }


    @Click
    void btnFind(){

    }

    @Click
    void btnNewAdd(){
        if(tpye == Constans.METERBOX){
            MeterBoxGroupActivity_.intent(this).start();
        }

    }

    @Click
    void btnEdit(){

    }

    @Click
    void btnDelete(){

    }
}
