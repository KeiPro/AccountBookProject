package com.example.accountbookproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;

import java.io.Serializable;

public class InputHistory extends Activity {

    private Button m_popupMenuBtn;
    private Button m_confirmBtn;

    private RadioGroup radioGroup;

    private int reason = MainActivity.incoming;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputpage);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        m_popupMenuBtn = (Button)findViewById(R.id.categoryBtn);
        m_confirmBtn = (Button)findViewById(R.id.inputPageConfirm);

        m_confirmBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                InputData inputData = SetHistoryData();

                if( inputData == null )
                    return;

                Intent data = new Intent();
                data.putExtra("InputData", inputData);
                setResult(MainActivity.addHistoryCode, data);

                finish();
            }
        });
    }

    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i == R.id.radioIncome){
                reason = MainActivity.incoming;
                Toast.makeText(InputHistory.this, "수입 버튼을 눌렸습니다.", Toast.LENGTH_SHORT).show();
            }
            else if(i == R.id.radioExpenditure){
                reason = MainActivity.expenditure;
                Toast.makeText(InputHistory.this, "지출 버튼을 눌렸습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public void onClickCancel(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    private InputData SetHistoryData()
    {
        EditText inputMoney = (EditText)findViewById(R.id.ET_InputMoney);
        EditText inputContents = (EditText)findViewById(R.id.ET_inputContents);

        int money = Integer.parseInt(inputMoney.getText().toString());
        String contents = inputContents.getText().toString();

        InputData inputData = new InputData(reason, money, contents);

        return inputData;
    }

    public void OnClickCategory(View v)
    {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        Menu menu = popup.getMenu();

        inflater.inflate(R.menu.category_menu, menu);

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            public boolean onMenuItemClick(MenuItem item){

                switch(item.getItemId()){
                    case R.id.fixed_incoming:

                        m_popupMenuBtn.setText(item.getTitle());

                        break;

                    case R.id.expenditure:

                        m_popupMenuBtn.setText(item.getTitle());

                        break;
                }
                return false;
            }
        });

        popup.show();
    }

}
