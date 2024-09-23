package com.prothes.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class FormPage extends AppCompatActivity {
    private TextView nameDisplay,emailDisplay,voterDisplay,passportDisplay,studentDisplay,ratingDisplay;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        setContentView(R.layout.form_page);

        nameDisplay = findViewById(R.id.nameDisplay);
        emailDisplay = findViewById(R.id.emailDisplay);
        voterDisplay = findViewById(R.id.voterDisplay);
        passportDisplay = findViewById(R.id.passportDisplay);
        studentDisplay = findViewById(R.id.studentDisplay);
        ratingDisplay = findViewById(R.id.ratingDisplay);
        ratingBar = findViewById(R.id.ratingBar);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();



        if (sharedPreferences.contains("names") && sharedPreferences.contains("emails") && sharedPreferences.contains("voterid") && sharedPreferences.contains("passportid") && sharedPreferences.contains("studentid")){
            String getName = sharedPreferences.getString("names",null);
            String getEmail = sharedPreferences.getString("emails",null);
            String getVoterId = sharedPreferences.getString("voterid",null);
            String getPassportId = sharedPreferences.getString("passportid",null);
            String getStudentId = sharedPreferences.getString("studentid",null);

            nameDisplay.setText(""+getName);
            emailDisplay.setText(""+getEmail);
            voterDisplay.setText(""+getVoterId);
            passportDisplay.setText(""+getPassportId);
            studentDisplay.setText(""+getStudentId);
        }



        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat("ratings",rating);
                editor.apply();
                ratingDisplay.setText(""+rating);
            }
        });

        float r = sharedPreferences.getFloat("ratings",0);
        ratingDisplay.setText(""+r);
        ratingBar.setRating(r);





    }

}