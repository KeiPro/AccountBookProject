package com.example.accountbookproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SubActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        Person person = (Person)intent.getSerializableExtra("신상");

        Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();

        Intent resultIntent = new Intent();
        intent.putExtra("result", "success");
        setResult(0, resultIntent);

//        String id = intent.getStringExtra("enterID");
//        if(id.equals(""))
//            Toast.makeText(this, "입력한 아이디가 없습니다.!", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(this, "입력한 아이디는 " + id + "입니다.", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View v)
    {
        finish();
    }
}
