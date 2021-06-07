package com.example.accountbookproject;

import java.io.Serializable;

public class InputData implements Serializable {

    int reason;
    int money;
    String contents;

    InputData(int reason, int money, String contents) {
        this.reason = reason;
        this.money = money;
        this.contents = contents;
    }
}
