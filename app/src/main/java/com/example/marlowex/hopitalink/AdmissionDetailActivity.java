package com.example.marlowex.hopitalink;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdmissionDetailActivity extends ActivityWithMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set custom view and assign to actionbar


        //get key from previous activity
        Intent intent = getIntent();
        String id = intent.getStringExtra("PatientID");

        initializePage(R.layout.activity_admission_detail, "Adam"); //change to patient's name?


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

}
