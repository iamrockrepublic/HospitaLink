package com.example.marlowex.hopitalink;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingActivity extends ActivityWithMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set custom view and assign to actionbar

        initializePage(R.layout.activity_setting, "Setting");
        initSpinners();
        initDrawerLayout();
    }

    public void initSpinners() {
        //set adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.notifyMethods, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.simple_spinner_item);

        //set adapter for each spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_critical);
        spinner.setAdapter(adapter);
        spinner = (Spinner) findViewById(R.id.spinner_unstable);
        spinner.setAdapter(adapter);
        spinner = (Spinner) findViewById(R.id.spinner_stabilising);
        spinner.setAdapter(adapter);
        spinner = (Spinner) findViewById(R.id.spinner_stable);
        spinner.setAdapter(adapter);
    }
}
