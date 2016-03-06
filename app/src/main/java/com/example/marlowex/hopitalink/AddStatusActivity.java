package com.example.marlowex.hopitalink;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddStatusActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_status);
    }

    public void cancel(View view){
        finish();
    }

    public void addHealthCheck(View view){

    }

    public void addMedicalReport(View view){

    }

    public void addRoomChange(View view){

    }

    public void addInfoChange(View view){

    }
}
