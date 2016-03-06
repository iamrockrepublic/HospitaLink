package com.example.marlowex.hopitalink;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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

public class AdmissionDetailActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_detail);

        //use custom toolbar
        Toolbar mToolBar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolBar);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        //set custom view and assign to actionbar
        View mCustomView = mInflater.inflate(R.layout.custom_action_bar_layout, null);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
        TextView titleText = (TextView)findViewById(R.id.title_text);
        titleText.setText("Adam");

        //initialize drawerlayout
        initDrawerLayout();

        //get key from previous activity
        Intent intent = getIntent();
        String id = intent.getStringExtra("PatientID");

        //initialize admission detail
        initAdmissionDetail();
    }

    public void initAdmissionDetail(){
        LinearLayout admissionDetailLayout = (LinearLayout)findViewById(R.id.admission_detail_layout);
        LinearLayout profile, timeline, post;
        TextView room, illness, admitted, postContent;
        String pNameStr = "Blah Blah";
        float scale = getResources().getDisplayMetrics().density;
        int height = (int)(150*scale+0.5f);
        int borderWidth = (int)(4*scale + 0.5f);
        int margin = (int)(20*scale + 0.5f);

        //set profile
        profile = new LinearLayout(this);
        profile.setOrientation(LinearLayout.VERTICAL);
        admissionDetailLayout.addView(profile);
        profile.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(profile.getLayoutParams());
        lp.setMargins(margin,margin,margin,margin);
        profile.setLayoutParams(lp);

        //set content in profile
        room = Utility.createBasicTextView(this, profile, "Room:", 20);
        illness = Utility.createBasicTextView(this, profile, "Illness:", 20);
        admitted = Utility.createBasicTextView(this, profile, "Admitted on:", 20);

        Drawable backGround = getResources().getDrawable(R.drawable.post_border);
        profile.setBackground(backGround);



        //set timeline
        timeline = new LinearLayout(this);
        timeline.setOrientation(LinearLayout.VERTICAL);
        admissionDetailLayout.addView(timeline);
        for(int i = 0; i <15; i++){
            //set post
            post = new LinearLayout(this);
            post.setOrientation(LinearLayout.VERTICAL);
            timeline.addView(post);
            backGround = getResources().getDrawable(R.drawable.patient_list_border);
            post.setBackground(backGround);
            //set margin
            lp = new LinearLayout.LayoutParams(post.getLayoutParams());
            lp.setMargins(margin,margin,margin,margin);
            post.setLayoutParams(lp);


            //set content
            postContent = Utility.createBasicTextView(this, post, "Blah", 20);
        }
    }

    public void addPost_doctor(View view){
        Intent intent = new Intent(this, AddPostActivity.class);
        startActivity(intent);
    }

    //-----------------------------Left-side Navigation bar---------------------
    public void profile(View view){
        if(this.getClass().isAssignableFrom(ProfileActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void patientList(View view){
        if(this.getClass().isAssignableFrom(PatientListActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, PatientListActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void appointmments(View view){
        if(this.getClass().isAssignableFrom(AppointmentsActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, AppointmentsActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void logOut(View view){
        if(this.getClass().isAssignableFrom(LoginActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void setting(View view){
        if(this.getClass().isAssignableFrom(SettingActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //-----------------------------------DrawerLayout-------------------------------------
    private void initDrawerLayout(){
        drawerLayout = (DrawerLayout)findViewById(R.id.layout_drawer);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        Toolbar mToolBar = (Toolbar)findViewById(R.id.main_toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, mToolBar, R.string.app_name, R.string.app_name){
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
            }

            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(toggle);
    }

    private void toggleLeftSliding(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    public void menuSliding(View view){
        toggleLeftSliding();
    }
}
