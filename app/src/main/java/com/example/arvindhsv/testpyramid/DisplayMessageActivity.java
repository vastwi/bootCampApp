package com.example.arvindhsv.testpyramid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * A login screen that offers login via email/password.
 */
public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        // Set up the login form.
        TextView userName = (TextView) findViewById(R.id.user_name);
        userName.setText("Hi Arvind");
    }

}

