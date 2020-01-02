package com.example.firstgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity { //  SORUN :  Sadece istediğim renge tıklayınca puan artmasını sağlamakk
    TextView time;
    TextView point;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    Runnable runnable;
    Handler handler;
    String[] colorsText;
    boolean tiklanabilir = true;
    boolean puan = false;
    int score = 0;
    TextView colorTextView;
    TextView[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);

        colorTextView = findViewById(R.id.color);

        time = findViewById(R.id.timer);
        point = findViewById(R.id.point);


        colorsText = new String[]{"Red", "Blue","Yellow","Purple"};
        colors = new TextView[]{textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9};

        for (TextView v : colors) {
            v.setVisibility(View.INVISIBLE);
        }
    }

    public void start(final View view) {
        CountDownTimer countDownTimer = new CountDownTimer(31000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("Time : " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {

            }
        }.start();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                for (TextView v : colors) {
                    v.setVisibility(View.INVISIBLE);
                }
                s=true;
                changeColor();
                handler.postDelayed(this, 1500);
            }
        };
        handler.post(runnable);
    }

    public void changeColor() {


        Random random = new Random();
        int x = random.nextInt(9);
        int y = random.nextInt(9);
        while (x == y) {
            x = random.nextInt(9);
        }
        if (x != y) {
            colors[x].setVisibility(View.VISIBLE);
            colors[y].setVisibility(View.VISIBLE);
        }
        // Random random=new Random();
        int j = colorsText.length;
        int i = random.nextInt(j);

        colorTextView.setText(colorsText[i]);

        if (colorTextView.getText().toString().equals("Red")) {

            colorTextView.setTextColor(Color.BLUE);
            colors[x].setBackgroundColor(Color.RED);
            colors[y].setBackgroundColor(Color.BLUE);
        }
        if (colorTextView.getText().toString().equals("Blue")) {
            colorTextView.setTextColor(Color.RED);
            colors[y].setBackgroundColor(Color.BLUE);
            colors[x].setBackgroundColor(Color.RED);
        }
        if(colorTextView.getText().toString().equals("Yellow")){
            colorTextView.setTextColor(Color.DKGRAY);
            colors[x].setBackgroundColor(Color.YELLOW);
            colors[y].setBackgroundColor(Color.DKGRAY);
        }
        if(colorTextView.getText().toString().equals("Purple")){
            colorTextView.setTextColor(Color.CYAN);
            colors[x].setBackgroundColor(Color.MAGENTA);
            colors[y].setBackgroundColor(Color.CYAN);
        }
    }
    int i = 0;
    boolean s;
    public void pointplusplus(View view) {

        if (s) {
            ColorDrawable colorDrawable = (ColorDrawable) view.getBackground(); //Coloru almak için
            boolean isTrue = false;

            switch (colorTextView.getText().toString()) {
                case "Red":
                    if (colorDrawable.getColor() == Color.BLUE) {
                        isTrue = true;
                    }
                    break;
                case "Blue":
                    if (colorDrawable.getColor() == Color.RED) {
                        isTrue = true;
                    }
                    break;
                case "Yellow":
                    if (colorDrawable.getColor() == Color.DKGRAY) {
                        isTrue = true;
                        break;
                    }
                case "Purple":
                    if (colorDrawable.getColor() == Color.CYAN) {
                        isTrue = true;
                        break;
                    }
            }
            if (isTrue) {

                score++;
                point.setText("Point : " + score);
                s=false;
            }
//        if (tiklanabilir) {
//
//            //score++;
//
//            //point.setText("Point : " + score);
//            tiklanabilir = false;
//        }
        }
    }

}
