package com.example.wanle.jishiben;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    private EditText mEt_title;
    private EditText mEt_content;
    private Button mBtn_confirm;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        
        mEt_title = findViewById(R.id.et_title);
        mEt_content = findViewById(R.id.et_content);
        mBtn_confirm = findViewById(R.id.btn_confirm);
        
        mBtn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditActivity.this, "", Toast.LENGTH_SHORT).show();
                finish();/*
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(EditActivity.this, "", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                },3000);*/
            }
        });


        Bundle bundle = getIntent().getExtras();
        String title= bundle.getString("title");
        String content = bundle.getString("content");
        int id = bundle.getInt("id");
        if(title!=null){
            mEt_title.setText(title);
        }
        if(content!=null){
            mEt_content.setText(content);
        }
    }
}
