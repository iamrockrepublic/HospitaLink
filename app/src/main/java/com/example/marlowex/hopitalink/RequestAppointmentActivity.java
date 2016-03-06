package com.example.marlowex.hopitalink;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class RequestAppointmentActivity extends Activity {

    int cYear, cMonth, cDay, cHour, cMinute, aYear, aMonth, aDay, aHour, aMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_appointment);
    }

    public void showDatePicker(View view){
        Calendar c = Calendar.getInstance();
        cYear = c.get(Calendar.YEAR);
        cMonth = c.get(Calendar.MONTH);
        cDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, new mDateSetListener(), cYear, cMonth, cDay);
        dialog.show();
    }

    public void showTimePicker(View view){
        Calendar c = Calendar.getInstance();
        cHour = c.get(Calendar.HOUR_OF_DAY);
        cMinute = c.get(Calendar.MINUTE);
        TimePickerDialog dialog = new TimePickerDialog(this, new mTimeSetListener(),cHour,cMinute,false);
        dialog.show();
    }

    public void commit(View view){
        //pass to database and do some local update
        finish();
    }

    class mDateSetListener implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
            aYear = year;
            aMonth = monthOfYear;
            aDay = dayOfMonth;
        }
    }

    class mTimeSetListener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker view, int hh, int mm){
            aHour = hh;
            aMinute = mm;
        }
    }
}
