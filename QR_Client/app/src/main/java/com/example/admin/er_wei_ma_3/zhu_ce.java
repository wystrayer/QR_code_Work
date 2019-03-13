package com.example.admin.er_wei_ma_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Bmob_Been.MyUser;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class zhu_ce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Bmob.initialize(this, "61fb56a4c7d1359233041e050a94f9c3");
    }

    public void xiayibu(View v) {
        EditText yhm = (EditText) findViewById(R.id.yhm);
        EditText mm = (EditText) findViewById(R.id.mm);
        EditText xb = (EditText) findViewById(R.id.xb);
        EditText xq = (EditText) findViewById(R.id.xq);
        EditText zjhm = (EditText) findViewById(R.id.zzhm);
        EditText sjhm = (EditText) findViewById(R.id.sjhm);
        EditText dzyj = (EditText) findViewById(R.id.dzyj);

        if (yhm.getText().toString().equals("") || mm.getText().toString().equals("") || xb.getText().toString().equals("") || xq.getText().toString().equals("") || zjhm.getText().toString().equals("") || sjhm.getText().toString().equals("") || dzyj.getText().toString().equals("")
                || yhm.getText().length() < 6 || mm.getText().length() < 6  || sjhm.getText().length() != 11) {


            final AlertDialog.Builder normalDialog =
                    new AlertDialog.Builder(zhu_ce.this);
            // normalDialog.setIcon(R.drawable.icon_dialog);
            normalDialog.setTitle("温馨提示");
            normalDialog.setMessage("信息填写有误，请认真检查！");
            normalDialog.setPositiveButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //...To-do
                        }
                    });
            normalDialog.setNegativeButton("关闭",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //...To-do
                        }
                    });
            // 显示
            normalDialog.show();


        }
        else {
            MyUser save = new MyUser();

            save.setEmail(dzyj.getText().toString());
            save.setPassword(mm.getText().toString());
            save.setInterest(xq.getText().toString());
            save.setMobilePhoneNumber(sjhm.getText().toString());
            save.setSex(xb.getText().toString());
            save.setUsername(yhm.getText().toString());
            save.setQq(zjhm.getText().toString());
            save.setRank("n");


                save.signUp(new SaveListener<MyUser>() {
                    @Override
                    public void done(MyUser s, BmobException e) {
                        if (e == null ) {
                            final AlertDialog.Builder normalDialog =
                                    new AlertDialog.Builder(zhu_ce.this);
                            // normalDialog.setIcon(R.drawable.icon_dialog);
                            normalDialog.setTitle("温馨提示");
                            normalDialog.setMessage("注册成功！");
                            normalDialog.setPositiveButton("确定",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(zhu_ce.this, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    });
                            normalDialog.setNegativeButton("关闭",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(zhu_ce.this, deng_lu.class);
                                            startActivity(intent);
                                        }
                                    });
                            // 显示
                            normalDialog.show();


                        } else {


                            Log.d("bmob_zhuce", e.getMessage().toString());
                            if (e.getMessage().toString().equals("The network is not available,please check your network!(9016)"))
                                Toast.makeText(zhu_ce.this, "网络未连接，请检查！", Toast.LENGTH_SHORT).show();
                            if (e.getMessage().toString().equals("email Must be a valid email address"))
                                Toast.makeText(zhu_ce.this, "请输入正确的邮箱地址", Toast.LENGTH_SHORT).show();
                            if (e.getMessage().toString().equals("mobilePhoneNumber Must be valid mobile number"))
                                Toast.makeText(zhu_ce.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();

                            else
                                Toast.makeText(zhu_ce.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        }
    }

