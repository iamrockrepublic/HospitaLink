package com.example.marlowex.hopitalink;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements UserTypeSelectionDialog.UserTypeSelectionListener {

    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userLocalStore = new UserLocalStore(this);

    }

    //prompt an AlterDialog to let user choose from Doctor, Nurse and Family member
    public void promptSelection(View view){
        UserTypeSelectionDialog userTypeSelection = new UserTypeSelectionDialog();
        userTypeSelection.show(getFragmentManager(), "userTypeSelection");
    }

    @Override
    public void onChooseUserType(DialogFragment dialog, String msg){
        Button button_chooseUserType = (Button)findViewById(R.id.button_chooseUserType);
        button_chooseUserType.setText(msg);
    }

    //
    public void login(View view){
        Button button_chooseUserType = (Button)findViewById(R.id.button_chooseUserType);
        String userType = button_chooseUserType.getText().toString();
        if(userType.equals(getResources().getStringArray(R.array.userTypes_array)[0])){
            loginDoctor();
        }else if(userType.equals(getResources().getStringArray(R.array.userTypes_array)[1])){
            loginNurse();
        }else if(userType.equals(getResources().getStringArray(R.array.userTypes_array)[2])){
            loginFamily();
        }else{
            NotifyDialog notify_setUserType = new NotifyDialog();
            notify_setUserType.setMsg("Pls choose your userType");
            notify_setUserType.show(getFragmentManager(), "notify_setUserType");
        }
    }

    private void loginDoctor(){
        // userLocalStore.storeUserData("doc123");
        Intent intent = new Intent(this, PatientListActivity.class);
        startActivity(intent);
        finish();
    }

    private void loginNurse(){
        Intent intent = new Intent(this, PatientListActivity.class);
        startActivity(intent);
        finish();
    }

    private void loginFamily(){
        Intent intent = new Intent(this, AdmissionDetailActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
