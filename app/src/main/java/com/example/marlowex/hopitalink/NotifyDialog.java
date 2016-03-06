package com.example.marlowex.hopitalink;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by marloweX on 2016/3/2.
 */
public class NotifyDialog extends DialogFragment {

    String msg=null;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("A notify")
                .setMessage(msg)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                });
        return builder.create();
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}