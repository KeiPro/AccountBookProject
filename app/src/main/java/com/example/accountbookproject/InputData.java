package com.example.accountbookproject;

import java.io.Serializable;

public class InputData implements Serializable {
    int money;
    String contents;

    InputData(int money, String contents) {
        this.money = money;
        this.contents = contents;
    }
}
