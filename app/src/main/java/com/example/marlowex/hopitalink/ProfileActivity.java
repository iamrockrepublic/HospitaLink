package com.example.marlowex.hopitalink;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileActivity extends ActivityWithMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set custom view and assign to actionbar

        initializePage(R.layout.activity_profile, "Profile");

        //initialize profile
        initProfile();
    }

    public void initProfile(){
        LinearLayout mainProfile = (LinearLayout)findViewById(R.id.main_profile_layout);
        TextView name = Utility.createBasicTextView(this, mainProfile, "blah", 20);
        LinearLayout subProfile = (LinearLayout)findViewById(R.id.sub_profile_layout);
        TextView desc = Utility.createBasicTextView(this, mainProfile, "another blah", 20);
    }


}
