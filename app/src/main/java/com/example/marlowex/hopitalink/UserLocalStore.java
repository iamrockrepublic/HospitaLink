package com.example.marlowex.hopitalink;

import android.content.Context;
import android.content.SharedPreferences;

import user.*;

/**
 * Created by Yee Xin on 3/8/2016.
 */
public class UserLocalStore {

    public static final String SP_NAME = "loggedInUser";
    SharedPreferences userLocalDatabase;

    public UserLocalStore (Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, context.MODE_PRIVATE); //0
    }

    //public void storeUserData(User user) {
    public void storeUserData(String userID) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        //spEditor.putString("userID", user.getID());
        spEditor.putString("userID", userID);
        spEditor.commit();
    }

    public User getLoggedInUser() {
        String userID = userLocalDatabase.getString("userID", "user is not logged in");

        //do something to get data from database (?) using the ID (???)
        User user = new Doctor(userID, "pw", new Hospital("test"), "drname", "drrank", "367834", "dr description", "dr spec");
        return user;
    }

    public void clearLoggedInUser() {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
