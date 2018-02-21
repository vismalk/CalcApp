package jp.techacademy.yamaguchiiori.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondCalc extends AppCompatActivity {

    private double answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_calc);

        Intent intent = getIntent();

        answer = intent.getDoubleExtra("result",0);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(answer));

    }
}
