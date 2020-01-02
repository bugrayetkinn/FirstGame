package com.example.firstgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button=findViewById(R.id.start);
    }


    public void start(View view){


        Intent ıntent=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(ıntent);
    }




}
