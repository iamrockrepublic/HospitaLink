package com.example.marlowex.hopitalink;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by marloweX on 2016/3/2.
 */
public class UserTypeSelectionDialog extends DialogFragment {
    private String userType = null;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.userTypeSelectTitle)
                .setItems(R.array.userTypes_array, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        userType = getResources().getStringArray(R.array.userTypes_array)[which];
                        mListener.onChooseUserType(UserTypeSelectionDialog.this, userType);
                    }
                });
        return builder.create();
    }

    public interface UserTypeSelectionListener{
        public void onChooseUserType(DialogFragment dialog, String msg);
    }

    UserTypeSelectionListener mListener;

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            mListener = (UserTypeSelectionListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement UserTypeSelectionListener");
        }
    }
}
