package com.example.poi;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.os.Environment.getExternalStorageDirectory;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.btn_export)
    Button btnExport;
    @ViewById(R.id.btn_include)
    Button btnInclude;
    @ViewById(R.id.btn_decode)
    Button btnDecode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click
    void btnExport(){
        exportData();
    }

    @Click
    void btnInclude(){
        readExcel();
    }

    @Click
    void btnDecode(){
        DecodeActivity_.intent(this).start();
        finish();
    }

    /**
     * 导出数据
     */
    public void exportData(){
        File path = new File(Environment.getExternalStorageDirectory().getPath()+"/F/F1/F2");
        Log.i("MainActivity======",Environment.getExternalStorageDirectory().getPath()+"/F/F1/F2");
        if(!path.exists()){
            path.mkdirs();
            //path.mkdirs();
            Toast.makeText(this,"创建文件夹目录成功",Toast.LENGTH_LONG).show();
        }
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this,"sd卡目录存在",Toast.LENGTH_LONG).show();
        }

        /**
         * 注意这只是07版本以前的做法对应的excel文件的后缀名为.xls
         * 07版本和07版本以后的做法excel文件的后缀名为.xlsx
         */
        //创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        //新建工作表
        HSSFSheet sheet = workbook.createSheet("hello");
        //创建行,行号作为参数传递给createRow()方法,第一行从0开始计算
        //HSSFRow row = sheet.createRow(0);
        //创建单元格,row已经确定了行号,列号作为参数传递给createCell(),第一列从0开始计算
        //HSSFCell cell = row.createCell(0);

        //cell.setCellValue("hello");//设置单元格的值，即0行0列


        FileOutputStream os =null;
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath()+"/F/F1/F2"+"/wirt.xls");
            if(!file.exists()){
                file.createNewFile();
            }
            os = new FileOutputStream(Environment.getExternalStorageDirectory().getPath()+"/F/F1/F2"+"/wirt.xls");
            for(int i = 0;i< 20;i++){
                HSSFRow row = sheet.createRow(i);
                for(int j =0 ;j < 20 ;j++){
                    HSSFCell cell = row.createCell(j);
                    cell.setCellValue("hello"+i+""+j);

                }
            }
            workbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(workbook!=null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null ){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 读如数据
     */
    public void readExcel(){
        StringBuilder builder = new StringBuilder();
        File file = new File(Environment.getExternalStorageDirectory().getPath()+"/F/F1/F2"+"/wirt.xls");

        if(file.exists() && file.canRead()){
            HSSFWorkbook workbook = null;
            try {
                InputStream inputStream = new FileInputStream(Environment.getExternalStorageDirectory().getPath()+"/F/F1/F2"+"/wirt.xls");
                workbook = new HSSFWorkbook(inputStream);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //循环工作表
            for(int sheetNum =0;sheetNum < workbook.getNumberOfSheets(); sheetNum++){
                HSSFSheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }

                //循环行和列
                for(int row = 0; row <= sheet.getLastRowNum(); row ++){
                    HSSFRow rowNum = sheet.getRow(row);
                    for(int col = 0; col < rowNum.getPhysicalNumberOfCells(); col ++){
                        HSSFCell cell = rowNum.getCell(col);
                        String value = cell.getStringCellValue();
                        builder.append(value).append("  ");
                    }
                }
            }
        }
        Log.i("builder======",builder.toString());
    }

}
