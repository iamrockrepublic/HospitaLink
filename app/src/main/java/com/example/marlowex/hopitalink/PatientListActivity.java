package com.example.marlowex.hopitalink;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PatientListActivity extends ActivityWithMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.initializePage(R.layout.activity_patient_list, "Patient List");

        initPatientList();
    }


    private void initPatientList(){
        LinearLayout patientListLayout = (LinearLayout) findViewById(R.id.patient_list_layout);
        LinearLayout aPatient;
        LinearLayout aBorder;
        TextView pName;
        String pNameStr = "Blah Blah";
        //get actionbar size from style
        float scale = getResources().getDisplayMetrics().density;
        int height = (int)(150*scale+0.5f);
        int borderWidth = (int)(4*scale + 0.5f);


        for(int i = 0; i < 6; i++){
            //set container
            aPatient = new LinearLayout(this);
            aPatient.setOrientation(LinearLayout.VERTICAL);
            patientListLayout.addView(aPatient);
            aPatient.getLayoutParams().height=height;
            aPatient.setMinimumHeight(height);
            aPatient.setGravity(Gravity.CENTER);

            aPatient.setClickable(true);
            aPatient.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(getBaseContext(), AdmissionDetailActivity.class);
                    intent.putExtra("PatientID", "111111");
                    startActivity(intent);
                }
            });

            //set content
            pName = new TextView(this);
            pName.setText(pNameStr);
            pName.setTextSize(20);
            pName.setMinHeight(height-borderWidth);
            aPatient.addView(pName);

            //set border

            aBorder = new LinearLayout(this);
            Drawable backGround = getResources().getDrawable(R.drawable.patient_list_border);
            aBorder.setBackground(backGround);
            aPatient.addView(aBorder);
            aBorder.getLayoutParams().height=borderWidth;
            aBorder.setGravity(Gravity.LEFT);
        }
    }

}
