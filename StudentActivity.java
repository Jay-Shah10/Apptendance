package com.example.jay_s.apptendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.SQLException;

public class StudentActivity extends AppCompatActivity {

    private AttendanceModel model = new AttendanceModel();

    private TextView firstnameText;
    private TextView lastnameText;
    private TextView panternumberText;
    private Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        firstnameText = (TextView)findViewById(R.id.firstnameText);
        lastnameText = (TextView)findViewById(R.id.lastnameText);
        panternumberText = (TextView)findViewById(R.id.panthernumberText);
        enterButton = (Button)findViewById(R.id.enterButton);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewStudent();
            }

        });
    }
    public void createNewStudent(){
        String firstName = firstnameText.getText().toString();
        String lastName = lastnameText.getText().toString();
        String pantherNumber = panternumberText.getText().toString();


        model.addStudentToDataBase(pantherNumber,firstName,lastName);


    }
}
