package com.example.marlowex.hopitalink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AddPostActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        LinearLayout ll = (LinearLayout)findViewById(R.id.add_post_layout);

        /*if userType is user, remove a button from layout

        Button button_addStatus = (Button)findViewById(R.id.button_addStatus);
        ll.removeView(button_addStatus);*/
    }

    public void cancel(View view){
        finish();
    }

    public void addComment(View view){
        Intent intent = new Intent(this, AddCommentActivity.class);
        startActivity(intent);
        finish();
    }


    public void addStatus(View view){
        Intent intent = new Intent(this, AddStatusActivity.class);
        startActivity(intent);
        finish();
    }

    public void requestAppointment(View view){
        Intent intent = new Intent(this, RequestAppointmentActivity.class);
        startActivity(intent);
        finish();
    }
    
}
