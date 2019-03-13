package com.example.admin.er_wei_ma_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Bmob_Been.MyUser;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class deng_lu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng_lu);
        Bmob.initialize(this, "61fb56a4c7d1359233041e050a94f9c3");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Button bdl=(Button)findViewById(R.id.button4);
        CheckBox zddl=(CheckBox)findViewById(R.id.checkBox3);
        CheckBox jzmm=(CheckBox)findViewById(R.id.checkBox2);
        TextView wjmm=(TextView)findViewById(R.id.textView33);
        Button bzc=(Button)findViewById(R.id.button3);
        TextView yh=(TextView)findViewById(R.id.textView29);
        TextView mm=(TextView)findViewById(R.id.textView32);
        EditText eyh=(EditText) findViewById(R.id.yonghu);
        EditText emm=(EditText) findViewById(R.id.editText);

        Button tcdl=(Button)findViewById(R.id.tuichu);

        BmobUser bmobUser = BmobUser.getCurrentUser();
        if(bmobUser != null){
           //已经登录
            bdl.setVisibility(View.INVISIBLE);
            zddl.setVisibility(View.INVISIBLE);
            jzmm.setVisibility(View.INVISIBLE);
            wjmm.setVisibility(View.INVISIBLE);
            bzc.setVisibility(View.INVISIBLE);
            yh.setVisibility(View.INVISIBLE);
            mm.setVisibility(View.INVISIBLE);
            eyh.setVisibility(View.INVISIBLE);
            emm.setVisibility(View.INVISIBLE);

        }else{
            //未登录
            tcdl.setVisibility(View.INVISIBLE);
        }



    }

    public void tuichu(View view){
        BmobUser.logOut();
        Intent intent=new Intent(deng_lu.this,MainActivity.class);
        startActivity(intent);

    }
    public void huitui(View view){
        Intent intent=new Intent(deng_lu.this,MainActivity.class);
        startActivity(intent);
    }
    public void zhuce(View view){
        Intent intent=new Intent(deng_lu.this,zhu_ce.class);
        startActivity(intent);
    }
    public void denglv(View view){
        EditText yonghu=(EditText)findViewById(R.id.yonghu);
        EditText mima=(EditText)findViewById(R.id.editText);
        String mimas=mima.getText().toString();
        String yhms=yonghu.getText().toString();
        BmobUser.loginByAccount(yhms, mimas, new LogInListener<MyUser>() {

            @Override
            public void done(MyUser user, BmobException e) {
                if(user!=null){
                    Toast.makeText(deng_lu.this,"登录成功！",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(deng_lu.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(deng_lu.this,"用户名或者密码有错误！",Toast.LENGTH_LONG).show();
                }
            }
        });



    }


}
