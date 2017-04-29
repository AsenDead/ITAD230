package com.itad235.andrei.timerandalarm;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity{
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        input = (EditText) findViewById(R.id.message);
    }

    protected void doSearch(View view) {
        String str = input.getText().toString();
        if(str.length() <= 0){
            return;
        }
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH)
                .putExtra(SearchManager.QUERY, str);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
