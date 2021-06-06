package com.example.accountbookproject;

//https://m.blog.naver.com/eominsuk55/220227937851 : 액티비티 이동하는 부분.

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button m_addHistory;

    public static final int addHistoryCode = 1001; /*다른 액티비티를 띄우기 위한 요청코드(상수)*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ab_main);

        Intent intent = new Intent(this, InputHistory.class);

        m_addHistory = (Button)findViewById(R.id.btn_plusHistory);
        m_addHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(intent, addHistoryCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch(requestCode)
        {
            case addHistoryCode:

                if(resultCode == RESULT_CANCELED)
                    return;

                AddHistory(data);

                break;

            default:

                break;
        }
    }

    private boolean AddHistory(Intent data)
    {
        Intent intent = data;

        InputData inputData = (InputData)intent.getSerializableExtra("InputData");

        History n_layout = new History(getApplicationContext());
        n_layout.SetHistory(inputData.contents, inputData.money);

        LinearLayout layoutHistory = (LinearLayout)findViewById(R.id.layout_history);

        layoutHistory.addView(n_layout);

        Toast.makeText(MainActivity.this, "데이터 입력 성공.", Toast.LENGTH_LONG).show();

        return true;
    }
}