package com.example.accountbookproject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputData implements Serializable {

    int reason;
    int money;
    String contents;
    String Date;

    InputData(int reason, int money, String contents) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.Date = simpleDateFormat.format(date);
        this.reason = reason;
        this.money = money;
        this.contents = contents;
    }
}
