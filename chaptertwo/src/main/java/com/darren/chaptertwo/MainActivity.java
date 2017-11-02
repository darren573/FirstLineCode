package com.darren.chaptertwo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.darren.chaptertwo.activity.BaseActivity;
import com.darren.chaptertwo.activity.ContactsActivity;
import com.darren.chaptertwo.activity.PhoneCallActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_call:
                startActivity(new Intent(MainActivity.this, PhoneCallActivity.class));
                break;
            case R.id.btn_contact:
                startActivity(new Intent(MainActivity.this, ContactsActivity.class));
                break;
        }
    }
}
