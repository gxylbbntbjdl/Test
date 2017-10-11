package com.pemt.ypgt;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pemt.ypgt.bean.Student;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Created by romg on 2017/9/22.
 */

@EActivity(R.layout.activity_export)
public class ExportActivity extends Activity {

    @ViewById(R.id.tv_title)
    TextView tv_title;

    @ViewById
    ListView lv_export;

    @ViewById
    CheckBox iscb;


    private List<Student> list = new ArrayList<>();
    private String[] exportList = {"计量箱(柜)", "计量箱与电能表的关系", "终端设备", "服务网点", "高压用户点", "用户箱式变", "用户开关站", "用户配电室（房）", "计量库房", "分布式电源", "用户变压器", "用户专线", "充换电站", "充电桩"};
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews() {
        tv_title.setText("导出");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, exportList);
        lv_export.setAdapter(adapter);
        lv_export.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    @ItemClick
    void lv_export() {

    }

    @Click
    void iscb() {
        if (iscb.isChecked()) {
            for(int i = 0; i < lv_export.getCount();i++){
                lv_export.setItemChecked(i,true);
            }
        }else{
            for(int i = 0; i < lv_export.getCount();i++){
                lv_export.setItemChecked(i,false);
            }
        }
        exportExcel();
    }

    void exportExcel() {
        initData();
        final File Path = new File(Environment.getExternalStorageDirectory().getPath()+"/file/writ.xls") ;
        if(!Path.exists()){
            if(!Path.mkdirs()){
                Toast.makeText(this,"aaaa",Toast.LENGTH_LONG).show();
            }
        }
        try {
            WritableWorkbook writbook = Workbook.createWorkbook(Path);
            WritableSheet sheet = writbook.createSheet("sheet1",0);
            Label label1 = new Label(0, 0, "id"); // 第一列第一行
            Label label2 = new Label(0, 1, "name");
            Label label3 = new Label(0, 2, "age");
            Label label4 = new Label(0, 3, "phoneNumber");

            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);

            if(list.size()!=0){
                Iterator it = list.iterator();
                int i = 1;
                while (it != null && it.hasNext()){
                    Student  stu  = (Student)it.next();
                    Label l1 = new Label(0, i,stu.getId()+"");
                    Label l2 = new Label(0, i,stu.getName());
                    Label l3 = new Label(0, i,stu.getAge()+"");
                    Label l4 = new Label(0, i,stu.getPhoneNumber());

                    sheet.addCell(l1);
                    sheet.addCell(l2);
                    sheet.addCell(l3);
                    sheet.addCell(l4);
                    i++;
                }
                writbook.write();
                writbook.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData(){
        list.clear();
        for(int i =0;i < 10;i++){
            Student stu = new Student();
            stu.setId(i);
            stu.setAge(i+10);
            stu.setName("student"+i);
            stu.setPhoneNumber("1334567890"+i);
            list.add(stu);
        }
    }
}









































