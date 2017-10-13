package com.example.ewan.chapterone.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ewan.chapterone.MainActivity;
import com.example.ewan.chapterone.R;

public class SharedPreferencesActivity extends BaseActivity implements View.OnClickListener {
    private EditText et_name, et_password;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox cb_remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        initView();
        /**
         * 一定要在onCreate方法里面进行判断
         * */
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = sharedPreferences.getBoolean("isRemember", false);
        if (isRemember) {
            String account = sharedPreferences.getString("account", "");
            String password = sharedPreferences.getString("password", "");
            et_name.setText(account);
            et_password.setText(password);
            cb_remember.setChecked(true);
        }
    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        cb_remember = (CheckBox) findViewById(R.id.cb_remember);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "darren");
                editor.putInt("age", 20);
                editor.putBoolean("男", true);
                editor.apply();
                break;
            case R.id.btn_read:
                sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                String name = sharedPreferences.getString("name", "");
                int age = sharedPreferences.getInt("age", 0);
                boolean man = sharedPreferences.getBoolean("男", false);
                Toast.makeText(SharedPreferencesActivity.this,
                        "姓名：" + name + ",年龄：" + age + ",是否男性：" + man,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_login:
                check();
                break;
        }
    }

    private void check() {
        String name = et_name.getText().toString();
        String pwd = et_password.getText().toString();
        if(name.equals("admin")&&pwd.equals("123456")){
            editor=sharedPreferences.edit();
            if(cb_remember.isChecked()){
                editor.putBoolean("isRemember",true);
                editor.putString("account",name);
                editor.putString("password",pwd);
            }else {
                editor.clear();
            }
            editor.apply();
            startActivity(new Intent(SharedPreferencesActivity.this, TestActivity.class));
            finish();
        }else {
            Toast.makeText(this,"account or password is invalid",Toast.LENGTH_SHORT).show();
        }
    }
}
