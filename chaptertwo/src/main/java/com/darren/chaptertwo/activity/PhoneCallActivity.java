package com.darren.chaptertwo.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.darren.chaptertwo.MainActivity;
import com.darren.chaptertwo.R;

/**
 * 运行时权限处理
 */
public class PhoneCallActivity extends AppCompatActivity {
    private Button btn_phone_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);
        initView();
    }

    private void initView() {
        btn_phone_call = (Button) findViewById(R.id.btn_phone_call);
        btn_phone_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //解决思路
                /**
                 * 判断用户是否已经给了权限
                 * */
                if (ContextCompat.checkSelfPermission(PhoneCallActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //如果没有个权限
                    ActivityCompat.requestPermissions(PhoneCallActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    //如果给了权限
                    call();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        /**
         * 调用requestPermissions（）方法之后，无论用户选择的是接受还是拒绝；
         * 统一在onRequestPermissionsResult（）方法中处理
         * */
        switch (requestCode) {
            case 1:
                //如果授权就执行拨打电话动作
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    //如果拒绝，就放弃操作
                    Toast.makeText(this, "You denied the permission ！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    private void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        } catch (SecurityException e) {
            //SecurityException 权限异常
            e.printStackTrace();
        }
    }
}
