package com.example.accountbookproject;

//https://m.blog.naver.com/eominsuk55/220227937851 : 액티비티 이동하는 부분.

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v)
    {
        EditText editId = (EditText) findViewById(R.id.edit_id);
        String id = editId.getText().toString();

        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("신상", new Person("래리 페이지", "남성", "구글"));
        startActivityForResult(intent, 0);
//        Intent intent = new Intent(this, SubActivity.class);
//        intent.putExtra("enterID", id);
//        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode)
        {
            case 0:

                break;
        }
    }
}