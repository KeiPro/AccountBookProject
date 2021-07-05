package com.example.accountbookproject;

//https://m.blog.naver.com/eominsuk55/220227937851 : 액티비티 이동하는 부분.

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    private Button m_addHistory;

    private TextView m_allInComing;
    private TextView m_allExpenditure;
    private TextView m_allBalance;

    private InputData m_saveInputData = null;
    private List<InputData> m_savedHistoryList = null;

    public static final int addHistoryCode = 1001; /*다른 액티비티를 띄우기 위한 요청코드(상수)*/
    public static final int incoming = 0; /*다른 액티비티를 띄우기 위한 요청코드(상수)*/
    public static final int expenditure = 1; /*다른 액티비티를 띄우기 위한 요청코드(상수)*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ab_main);

        InitMainActivity();
    }

    private void InitMainActivity()
    {
        LoadSavedData();
        SetFindViewByID();
        SetButtonForInputHistoryClass();
    }

    private void LoadSavedData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("HistoryData", Context.MODE_PRIVATE);

    }

    private void SetFindViewByID()
    {
        m_addHistory = (Button)findViewById(R.id.btn_plusHistory);
        m_allInComing = (TextView)findViewById(R.id.AllIncoming);
        m_allExpenditure= (TextView)findViewById(R.id.AllExpenditure);
        m_allBalance = (TextView)findViewById(R.id.AllBalance);
    }

    private void SetButtonForInputHistoryClass()
    {
        Intent intent = new Intent(this, InputHistory.class);
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

                if( AddHistory(data) )
                {
                    SaveData();
                }

                break;

            default:

                break;
        }
    }

    private void SaveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("HistoryData", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();


    }

    private boolean AddHistory(Intent data)
    {
        Intent intent = data;

        InputData m_saveInputData = (InputData)intent.getSerializableExtra("InputData");

        History n_layout = new History(getApplicationContext());
        n_layout.SetHistory(m_saveInputData.reason, m_saveInputData.contents, m_saveInputData.money);

        LinearLayout layoutHistory = (LinearLayout)findViewById(R.id.layout_history);

        layoutHistory.addView(n_layout);

        String saveSuccessText = "데이터 입력 성공! (저장된 시각 : " + m_saveInputData.Date + ")";

        Toast.makeText(MainActivity.this, saveSuccessText, Toast.LENGTH_LONG).show();

        UpdateMainData(m_saveInputData);

        return true;
    }

    private void UpdateMainData(InputData inputData)
    {
        int prevAllIncoming = Integer.parseInt(m_allInComing.getText().toString());
        int prevAllExpenditure = Integer.parseInt(m_allExpenditure.getText().toString());
        int prevAllBalance = Integer.parseInt(m_allBalance.getText().toString());

        if(inputData.reason == incoming)
        {
            m_allInComing.setText(String.valueOf(prevAllIncoming + inputData.money));
            m_allBalance.setText(String.valueOf(prevAllBalance + inputData.money));
        }
        else
        {
            m_allExpenditure.setText(String.valueOf(prevAllExpenditure + inputData.money));
            m_allBalance.setText(String.valueOf(prevAllIncoming - (prevAllExpenditure + inputData.money)));
        }
    }
}