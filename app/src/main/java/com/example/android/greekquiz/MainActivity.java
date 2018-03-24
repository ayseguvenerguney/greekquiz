package com.example.android.greekquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    RadioButton radioButtonA2;
    RadioButton radioButtonB1;
    RadioButton radioButtonC4;
    RadioButton radioButtonD4;
    RadioButton radioButtonF2;
    CheckBox checkBoxA1;
    CheckBox checkBoxA3;
    CheckBox checkBoxB1;
    CheckBox checkBoxB2;
    EditText answerQ5;
    EditText answerQ8;
    EditText answerQ10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioButtonA2 = findViewById(R.id.a2_radio);
        radioButtonB1 = findViewById(R.id.b1_radio);
        radioButtonC4 = findViewById(R.id.c4_radio);
        radioButtonD4 = findViewById(R.id.d4_radio);
        radioButtonF2 = findViewById(R.id.f2_radio);
        checkBoxA1 = findViewById(R.id.checkA1);
        checkBoxA3 = findViewById(R.id.checkA3);
        checkBoxB1 = findViewById(R.id.checkB1);
        checkBoxB2 = findViewById(R.id.checkB2);
        answerQ5 = findViewById(R.id.name_field5);
        answerQ8 = findViewById(R.id.name_field8);
        answerQ10 = findViewById(R.id.name_field10);

    }


    public void submit(View v) {


        if((checkBoxA1.isChecked()) && (checkBoxA3.isChecked())) {
            score += 1;
        }

        if((checkBoxB1.isChecked()) && (checkBoxB2.isChecked())) {
            score += 1;
        }

        if (radioButtonA2.isChecked()){
            score += 1;}
        if (radioButtonB1.isChecked()){
            score += 1;}
        if (radioButtonC4.isChecked()){
            score += 1;}
        if (radioButtonD4.isChecked()){
            score += 1;}
        if (radioButtonF2.isChecked()){
            score += 1;}

        String answer5 = answerQ5.getText().toString();
        if (answer5.equals("Proteus")) {
            score += 1;
        }
        String answer8 = answerQ8.getText().toString();
        if (answer8.equals("Gemini")) {
            score += 1;
        }
        String answer10 = answerQ10.getText().toString();
        if (answer10.equals("Venus")) {
            score += 1;}

        if (score == 10)
            // Show message as a toast
            Toast.makeText(this, "Wooww, Congratulations!!!"  + " you scored " + score + " points out of 10!!!", Toast.LENGTH_LONG).show();
        else if (score < 10)
            // Show message as a toast
            Toast.makeText(this, "Congratulations "  +" you scored only " + score + " points out of 10!!!", Toast.LENGTH_LONG).show();


    // Use an intent to launch an email app.
    // Send the quiz results summary in the email body.

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Greek Mythology Quiz Result");
        intent.putExtra(Intent.EXTRA_TEXT, "Hey! "  +" I got " + score + " points out of 10!"+ "Try this quiz to have fun!");
        if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }
    }
}




