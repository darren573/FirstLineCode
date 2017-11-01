package com.example.ewan.chapterone;
/**
 * @param 数据持久化
 */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ewan.chapterone.activity.BaseActivity;
import com.example.ewan.chapterone.activity.FileStoreActivity;
import com.example.ewan.chapterone.activity.SharedPreferencesActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_file_store, btn_shared_preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_file_store = (Button) findViewById(R.id.btn_file_store);
        btn_shared_preferences = (Button) findViewById(R.id.btn_shared_preferences);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_file_store:
                startActivity(new Intent(MainActivity.this, FileStoreActivity.class));
                break;
            case R.id.btn_shared_preferences:
                startActivity(new Intent(MainActivity.this, SharedPreferencesActivity.class));
                break;
        }
    }
}
