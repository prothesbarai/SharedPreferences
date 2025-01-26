package com.prothes.sharedpreferences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText nameField,emailField,voterIdField,passportIdField,studentIdField;
    private AppCompatButton submitBtn,nextPageBtn,editBtn,resetBtn;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameField);
        emailField = findViewById(R.id.emailField);
        voterIdField = findViewById(R.id.voterIdField);
        passportIdField = findViewById(R.id.passportIdField);
        studentIdField = findViewById(R.id.studentIdField);
        submitBtn = findViewById(R.id.submitBtn);
        nextPageBtn = findViewById(R.id.nextPageBtn);
        editBtn = findViewById(R.id.editBtn);
        resetBtn = findViewById(R.id.resetBtn);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names,emails,voters,passports,students;
                names = nameField.getText().toString();
                emails = emailField.getText().toString();
                voters = voterIdField.getText().toString();
                passports = passportIdField.getText().toString();
                students = studentIdField.getText().toString();
                if (names.length()>0 && emails.length()>0 && voters.length()>0 && passports.length()>0 && students.length()>0){

                    editor.putString("names",""+names);
                    editor.putString("emails",""+emails);
                    editor.putString("voterid",""+voters);
                    editor.putString("passportid",""+passports);
                    editor.putString("studentid",""+students);
                    editor.apply();

                    Toast.makeText(MainActivity.this, "Saved Data", Toast.LENGTH_SHORT).show();
                    nameField.setText(null);
                    emailField.setText(null);
                    voterIdField.setText(null);
                    passportIdField.setText(null);
                    studentIdField.setText(null);

                }else if (names.length()>0) {
                    nameField.setError(null);
                    if (emails.length()>0){
                        emailField.setError(null);
                        if (voters.length()>0){
                            voterIdField.setError(null);
                            if (passports.length()>0){
                                passportIdField.setError(null);
                                if (students.length()>0){
                                    studentIdField.setError(null);
                                }else {
                                    studentIdField.setError("Empty");
                                }
                            }else{
                                passportIdField.setError("Empty");
                            }
                        }else {
                            voterIdField.setError("Empty");
                        }
                    }else{
                        emailField.setError("Empty");
                    }
                }else if (emails.length()>0) {
                    emailField.setError(null);
                    if (names.length()>0){
                        nameField.setError(null);
                        if (voters.length()>0){
                            voterIdField.setError(null);
                            if (passports.length()>0){
                                passportIdField.setError(null);
                                if (students.length()>0){
                                    studentIdField.setError(null);
                                }else {
                                    studentIdField.setError("Empty");
                                }
                            }else{
                                passportIdField.setError("Empty");
                            }
                        }else{
                            voterIdField.setError("Empty");
                        }
                    }else{
                        nameField.setError("Empty");
                    }
                }else if (voters.length()>0) {
                    voterIdField.setError(null);
                    if (names.length()>0){
                        nameField.setError(null);
                        if (emails.length()>0){
                            emailField.setError(null);
                            if (passports.length()>0){
                                passportIdField.setError(null);
                                if (students.length()>0){
                                    studentIdField.setError(null);
                                }else {
                                    studentIdField.setError("Empty");
                                }
                            }else{
                                passportIdField.setError("Empty");
                            }
                        }else{
                            emailField.setError("Empty");
                        }
                    }else{
                        nameField.setError("Empty");
                    }
                }else if (passports.length()>0) {
                    passportIdField.setError(null);
                    if (names.length()>0){
                        nameField.setError(null);
                        if (emails.length()>0){
                            emailField.setError(null);
                            if (voters.length()>0){
                                voterIdField.setError(null);
                                if (students.length()>0){
                                    studentIdField.setError(null);
                                }else {
                                    studentIdField.setError("Empty");
                                }
                            }else{
                                voterIdField.setError("Empty");
                            }
                        }else{
                            emailField.setError("Empty");
                        }
                    }else{
                        nameField.setError("Empty");
                    }
                }else if (students.length()>0) {
                    studentIdField.setError(null);
                    if (names.length()>0){
                        nameField.setError(null);
                        if (emails.length()>0){
                            emailField.setError(null);
                            if (voters.length()>0){
                                voterIdField.setError(null);
                                if (passports.length()>0){
                                    passportIdField.setError(null);
                                }else {
                                    passportIdField.setError("Empty");
                                }
                            }else{
                                voterIdField.setError("Empty");
                            }
                        }else{
                            emailField.setError("Empty");
                        }
                    }else{
                        nameField.setError("Empty");
                    }
                }else{
                    nameField.setError("Empty");
                    emailField.setError("Empty");
                    voterIdField.setError("Empty");
                    passportIdField.setError("Empty");
                    studentIdField.setError("Empty");
                }
            }
        });
        

        //============================================================================

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check For Data store in sharedpreference
                if (sharedPreferences.contains("names") && sharedPreferences.contains("emails") && sharedPreferences.contains("voterid") && sharedPreferences.contains("passportid") && sharedPreferences.contains("studentid")){

                    String getName = sharedPreferences.getString("names",null);
                    String getEmail = sharedPreferences.getString("emails",null);
                    String getVoterId = sharedPreferences.getString("voterid",null);
                    String getPassportId = sharedPreferences.getString("passportid",null);
                    String getStudentId = sharedPreferences.getString("studentid",null);

                    nameField.setText(""+getName);
                    emailField.setText(""+getEmail);
                    voterIdField.setText(""+getVoterId);
                    passportIdField.setText(""+getPassportId);
                    studentIdField.setText(""+getStudentId);


                    nameField.setError(null);
                    emailField.setError(null);
                    voterIdField.setError(null);
                    passportIdField.setError(null);
                    studentIdField.setError(null);

                }else{
                    Toast.makeText(MainActivity.this, "Empty Storage", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //============================================================================

        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormPage.class));
            }
        });

        //============================================================================

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.apply();
                nameField.setText(null);
                emailField.setText(null);
                voterIdField.setText(null);
                passportIdField.setText(null);
                studentIdField.setText(null);

                nameField.setError(null);
                emailField.setError(null);
                voterIdField.setError(null);
                passportIdField.setError(null);
                studentIdField.setError(null);
            }
        });




    }


    @Override
    public void onBackPressed() {
        if (isTaskRoot()){
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Warning !!!")
                    .setMessage("Do you want to exit ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.sky));
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getColor(R.color.sky));
        }else {
            super.onBackPressed();
        }
    }
}
