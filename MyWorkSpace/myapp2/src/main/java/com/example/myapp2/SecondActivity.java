package com.example.myapp2;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by romg on 2017/9/11.
 */

@EActivity(R.layout.second_activity)
public class SecondActivity extends Activity {
    @ViewById
    Button hexbutton;

    @Click(R.id.hexbutton)
    void clickhebutton(){
        byte[] src = {0x01,0x10};
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
           Toast.makeText(this,"空",Toast.LENGTH_LONG).show();
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            Log.i("=====v===:",String.valueOf(v));
            String hv = Integer.toHexString(v);
            Log.i("=====hv===:",hv);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        Log.i("========:",stringBuilder.toString());
        Toast.makeText(this,stringBuilder.toString(),Toast.LENGTH_LONG).show();
    }

}
