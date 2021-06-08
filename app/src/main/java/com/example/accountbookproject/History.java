package com.example.accountbookproject;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

public class History extends LinearLayout{

    private Button incomingButton;
    private Button expenditureButton;

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

    public void SetHistory(int reason, String contents, int money)
    {
//        if(reason == MainActivity.incoming)
//        {
//            incomingButton = (Button)findViewById(R.id.history_incoming);
//            String history = contents + " : " + money;
//            incomingButton.setText(history);
//        }
//        else
//        {
            expenditureButton = (Button)findViewById(R.id.history_expenditure);
            String history = contents + " : " + money;
            expenditureButton.setText(history);
//        }

//        myButton = (Button)findViewById(R.id.history);
//
//        String history = contents + " : " + money;
//
//        myButton.setText(history);

//        if(reason == MainActivity.incoming)
//        {
//            myButton.setBackgroundColor(getContext().getResources().getColor(R.color.pastelPink));
//        }
//        else
//        {
//            myButton.setBackgroundColor(getContext().getResources().getColor(R.color.skyBlue));
//        }
    }
}
