package com.github.king.swipeitemlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SwipeItemDeleteLayout sidl_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sidl_menu = findViewById(R.id.sidl_menu);
        sidl_menu.setOnMenuClickListener(new SwipeItemDeleteLayout.OnMenuClickListener() {
            @Override
            public void onDeleteClick(View v) {
                Toast.makeText(getApplicationContext(), "删除", Toast.LENGTH_LONG).show();
                sidl_menu.close();
            }
        });
    }
}
