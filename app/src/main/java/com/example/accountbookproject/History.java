package com.example.accountbookproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

public class History extends LinearLayout{

    private Button myButton;

    public History(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public History(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.history,this,true);
    }

    public void SetHistory(String contents, int money)
    {
        myButton = (Button)findViewById(R.id.history);

        String history = contents + " : " + money;

        myButton.setText(history);
    }
}
