package com.example.admin.er_wei_ma_3;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Bmob_Been.MyUser;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Bmob.initialize(this, "61fb56a4c7d1359233041e050a94f9c3");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        TextView tusername=(TextView)findViewById(R.id.yhm);
        TextView tsfz=(TextView)findViewById(R.id.sfz);
        TextView txm=(TextView)findViewById(R.id.xm);
        TextView tsjhm=(TextView)findViewById(R.id.sjhm);
        TextView tyx=(TextView)findViewById(R.id.yx);
        MyUser userInfo = MyUser.getCurrentUser(MyUser.class);
        if(userInfo != null){
            String username = (String) BmobUser.getObjectByKey("username");
            String sjh = (String) BmobUser.getObjectByKey("mobilePhoneNumber");
            String xm = (String) BmobUser.getObjectByKey("interest");
            String sfz = (String) BmobUser.getObjectByKey("qq");
            String yx = (String) BmobUser.getObjectByKey("email");
            tsfz.setText(sfz);
            tsjhm.setText(sjh);
            tusername.setText(username);
            txm.setText(xm);
            tyx.setText(yx);


            // 允许用户使用应用
        }else{
            //缓存用户对象为空时， 可打开用户注册界面…
        }
    }

    public void huitui(View v){
        Intent intent=new Intent(message.this,MainActivity.class);
        startActivity(intent);
    }
}
