package com.example.wanle.jishiben;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    myAdapter adapter;
    UserBean userBean;
    List<UserBean> list;
    Button btnAdd;
    MyDBHelper myDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBHelper = new MyDBHelper(this);
        myDBHelper.open();

        list = new ArrayList<>();
        for (int i = 0 ; i < 100 ; i++){/*
            userBean = new UserBean();
            userBean.setId(i);
            userBean.setTitle(i+"11111111");
            userBean.setContent(i+"222222");
            list.add(userBean);*/
            myDBHelper.createNote(i+"11111111",i+"222222");

        }

        adapter = new myAdapter(this,R.layout.activity_mydapter,list);
        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {/*
                UserBean m = list.get(position);*//*
                Toast.makeText(MainActivity.this, m.toString(), Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("content",list.get(position).getContent());
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);

                adapter.notifyDataSetChanged();

                return true;
            }
        });

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                startActivity(intent);
            }
        });


    }
}
