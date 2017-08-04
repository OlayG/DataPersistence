package com.example.admin.datapersistence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvShowSavedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvShowSavedData = (TextView) findViewById(R.id.tvShowSavedData);

        //Intent intent = getIntent();
        SharedPreferences sharedPreferences = getSharedPreferences("mypref_file", Context.MODE_PRIVATE);
        tvShowSavedData.setText(sharedPreferences.getString("value1", "default in case this key returns nothing"));
    }

    public void goToNextActivity(View view) {
    }
}
