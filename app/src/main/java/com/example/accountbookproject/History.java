package com.example.accountbookproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class History extends LinearLayout{

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
}
