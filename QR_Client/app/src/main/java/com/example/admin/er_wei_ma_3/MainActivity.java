package com.example.admin.er_wei_ma_3;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.View;
import android.widget.Toast;

import com.example.qrcode.Constant;
import com.example.qrcode.ScannerActivity;

import Bmob_Been.MyUser;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "61fb56a4c7d1359233041e050a94f9c3");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
    public void denglu(View view){
        Intent intent=new Intent(this,deng_lu.class);
        startActivity(intent);

    }
    public void zhuce(View view){
        Intent intent=new Intent(this,zhu_ce.class);
        startActivity(intent);

    }
    public void zhizuo(View view){
        MyUser userInfo = MyUser.getCurrentUser(MyUser.class);
        if(userInfo != null){
            String rank = (String) BmobUser.getObjectByKey("rank");
            if(rank.equals("n")){
                Toast.makeText(MainActivity.this,"非管理员无权限制作二维码！",Toast.LENGTH_LONG).show();
            }
            else{
                Intent intent=new Intent(this,er_wei_ma_zhi_zuo.class);
                startActivity(intent);
            }




            // 允许用户使用应用
        }else{
            Toast.makeText(MainActivity.this,"请先登录管理员帐号！",Toast.LENGTH_LONG).show();
        }


    }
    public void er(View view){
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if(bmobUser != null){
            // 允许用户使用二维码扫描
            Intent intent = new Intent(this, ScannerActivity.class);
            //这里可以用intent传递一些参数，比如扫码聚焦框尺寸大小，支持的扫码类型。
//        //设置扫码框的宽
//        intent.putExtra(Constant.EXTRA_SCANNER_FRAME_WIDTH, 400);
//        //设置扫码框的高
//        intent.putExtra(Constant.EXTRA_SCANNER_FRAME_HEIGHT, 400);
//        //设置扫码框距顶部的位置
//        intent.putExtra(Constant.EXTRA_SCANNER_FRAME_TOP_PADDING, 100);
//        //设置是否启用从相册获取二维码(默认为FALSE，不启用)。
//        intent.putExtra(Constant.EXTRA_IS_ENABLE_SCAN_FROM_PIC,true);
//        Bundle bundle = new Bundle();
//        //设置支持的扫码类型
//        bundle.putSerializable(Constant.EXTRA_SCAN_CODE_TYPE, mHashMap);
//        intent.putExtras(bundle);
            startActivityForResult(intent, 1);

        }else{
            Toast.makeText(this,"请先登录！",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this,deng_lu.class);
            startActivity(intent);
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    if (data == null) return;
                    String type = data.getStringExtra(Constant.EXTRA_RESULT_CODE_TYPE);
                    String content = data.getStringExtra(Constant.EXTRA_RESULT_CONTENT);
                    Toast.makeText(MainActivity.this,"codeType:" + type
                            + "-----content:" + content,Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(this,message.class);
                    startActivity(intent);
                    break;
                default:
                    break;

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
