package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityTwo extends AppCompatActivity {

    public final static String SUPER_KEY = "text";

    private EditText editText, textResult;
    private Button btnSendToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        init();
    }

    private void init() {
        editText = findViewById(R.id.editText);
        btnSendToMain = findViewById(R.id.btnSendToMain);
        btnSendToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                textResult.setText(s);

                sendResult();
            }
        });


    }

    private void sendResult() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(SUPER_KEY, textResult.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void chooseImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Choose image"), 200);

    }
}
