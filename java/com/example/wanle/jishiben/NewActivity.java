package com.example.wanle.jishiben;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

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
                Toast.makeText(NewActivity.this, "进入", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
