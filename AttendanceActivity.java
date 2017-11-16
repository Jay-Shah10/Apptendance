package com.example.jay_s.apptendance;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;


public class AttendanceActivity extends AppCompatActivity{
    private Button deleteButton;
    private Button enterButton;
    private Button forumButton;
    private Button submitButton;
    private EditText studentEditText;
    public AttendanceModel model = new AttendanceModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);



        studentEditText = (EditText)findViewById(R.id.studentNameEditText);
        submitButton = (Button)findViewById(R.id.submitButton);
        forumButton = (Button)findViewById(R.id.forumButton);
        deleteButton = (Button)findViewById(R.id.deleteButton);
        enterButton = (Button)findViewById(R.id.enterButton);

        // all the button click events.
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    enterButtonClicked();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteClick();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitClicked();
            }
        });
        forumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forumClicked();
            }
        });




    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void enterButtonClicked() throws SQLException{
        // adds student's name to the database.
        //this method will call a method in the model class to add it to the data base.

        startActivity(new Intent(getApplicationContext(),StudentActivity.class));

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void deleteClick(){
        /*
        used to delete a select student from the database.
         */
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void forumClicked() {
        /*
        opens another activity for the forum.
        Intent.
         */
        startActivity(new Intent(getApplicationContext(),ForumActivity.class));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void submitClicked(){
        /*
        makes all the students as present.
         */
    }


}
