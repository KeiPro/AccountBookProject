package com.example.accountbookproject;

//https://m.blog.naver.com/eominsuk55/220227937851 : 액티비티 이동하는 부분.

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ab_main);

        Button but = (Button)findViewById(R.id.btn_plusHistory);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                History n_layout = new History(getApplicationContext());
                LinearLayout layoutHistory = (LinearLayout)findViewById(R.id.layout_history);
                layoutHistory.addView(n_layout);

                Toast.makeText(MainActivity.this, "클릭되었습니다.", Toast.LENGTH_LONG).show();
            }
        });
    }
}