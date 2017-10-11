package com.pemt.ypgt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by romg on 2017/9/22.
 */

@EActivity(R.layout.activity_meterbox_group)
public class MeterBoxGroupActivity extends Activity{

    @ViewById(R.id.tv_title)
    TextView tvTitle;

    @ViewById(R.id.btn_save)
    Button btnSave;
    @ViewById
    CheckBox iscb;

    @ViewById
    EditText et_group_name,install_addr,tv_mount_terminal_name;


    @ViewById
    TextView tv_terminal_type,tv_box_type,tv_row,tv_col,tv_Material,tv_asset_nature,tv_city_type,tv_voltag_grad,tv_mount_terminal_type;

    @ViewById
    Button btnGps,select;


    private String[] terminalType = {"计量箱","计量柜"};
    private static int curterminalTypeChecknumber = 0;

    private String[] boxTpye = {"单体表箱","合体表箱","虚拟表箱"};
    private static int curboxTpyeChecknumber = 0;

    private String[] col = {"1","2","3","4","5","6","7","8","9","10"};
    private static int curRowChecknumber = 0;

    private String[] row = {"1","2","3","4","5","6","7","8","9","10"};
    private static int curColChecknumber = 0;

    private String[] termial = {"铁","不锈钢","合金","塑料"};
    private static int curTermialChecknumber = 0;

    private String[] assetNature = {"供电企业资产","客户资产","发电企业资产"};
    private static int curAssetNatureChecknumber = 0;

    private String[] city = {"城市","农村","特殊边远山区"};
    private static int curCityChecknumber = 0;

    private String[] voltagGrad = {"交流220v","交流380v"};
    private static int curVoltagGradChecknumber = 0;

    private String[] mountTpye = {"低压杆塔","低压分支箱","变压器","低压电缆（头）"};
    private static int curMountTypeCheckNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews(){
        tvTitle.setText("计量箱组");
        iscb.setVisibility(View.GONE);
        btnSave.setVisibility(View.VISIBLE);
    }

    @Click
    void btnGps(){

    }

    void select(){

    }

    @Click
    void tv_terminal_type(){
        initAdapter(tv_terminal_type,curterminalTypeChecknumber,terminalType);
    }

    @Click
    void tv_box_type(){
        initAdapter(tv_box_type,curboxTpyeChecknumber,boxTpye);
    }
    @Click
    void tv_row(){
        initAdapter(tv_row,curRowChecknumber,row);
    }
    @Click
    void tv_col(){
        initAdapter(tv_col,curColChecknumber,col);
    }
    @Click
    void tv_asset_nature(){
        initAdapter(tv_asset_nature,curAssetNatureChecknumber,assetNature);
    }
    @Click
    void tv_Material(){
        initAdapter(tv_Material,curTermialChecknumber,termial);
    }
    @Click
    void tv_city_type(){
        initAdapter(tv_city_type,curCityChecknumber,city);
    }
    @Click
    void tv_voltag_grad(){
        initAdapter(tv_voltag_grad,curVoltagGradChecknumber,voltagGrad);
    }
    @Click
    void tv_mount_terminal_type(){
        initAdapter(tv_mount_terminal_type,curMountTypeCheckNumber,mountTpye);
    }


    public void initAdapter(final TextView v, int curChecknumber, final String[] str){
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.select_dialog_singlechoice,str);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(adapter, curChecknumber, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                v.setText(adapter.getItem(which).toString());
                if(v == tv_terminal_type){
                    MeterBoxGroupActivity.curterminalTypeChecknumber = which;
                }else if(v == tv_box_type){
                    MeterBoxGroupActivity.curboxTpyeChecknumber = which;
                }else if(v == tv_row){
                    MeterBoxGroupActivity.curRowChecknumber = which;
                }else if(v == tv_col){
                    MeterBoxGroupActivity.curColChecknumber = which;
                }else if(v == tv_Material){
                    MeterBoxGroupActivity.curTermialChecknumber = which;
                }else if(v == tv_asset_nature){
                    MeterBoxGroupActivity.curAssetNatureChecknumber = which;
                }else if(v == tv_city_type){
                    MeterBoxGroupActivity.curCityChecknumber = which;
                }else if(v == tv_voltag_grad){
                    MeterBoxGroupActivity.curVoltagGradChecknumber = which;
                }else if(v == tv_mount_terminal_type){
                    MeterBoxGroupActivity.curMountTypeCheckNumber  = which;
                }
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
