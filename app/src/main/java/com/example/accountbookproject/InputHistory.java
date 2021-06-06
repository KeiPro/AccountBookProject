package com.example.accountbookproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class InputHistory extends Activity {

    Button m_popupMenuBtn;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputpage);

        m_popupMenuBtn = (Button)findViewById(R.id.categoryBtn);
    }

    public void onClickCancel(View v)
    {
        finish();
    }

    public void onClickConfirm()
    {

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
