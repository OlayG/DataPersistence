package com.example.admin.datapersistence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MY_PREF_FILE = "mypref_file";
    EditText etVal1, etVal2;
    TextView tvVal1, tvVal2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVal1 = (EditText) findViewById(R.id.etVal1);
        etVal2 = (EditText) findViewById(R.id.etVal2);
    }

    public void saveData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value1", etVal1.getText().toString());
        editor.putString("value2", etVal2.getText().toString());
        editor.commit();
    }

    public void getData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);

        sharedPreferences.getString("value1", "default in case this key returns nothing");
    }

    public void goToNextActivity(View view) {

        switch (view.getId()){

            case R.id.btnNextActivity:
                SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
                Intent intent = new Intent(this, Main2Activity.class);
/*
                intent.putExtra("savedData",sharedPreferences.getString("value1", "default in case this key returns nothing") +
                        sharedPreferences.getString("value2", "default in case this key returns nothing"));
*/
                startActivity(intent);
                break;
        }

    }
}
