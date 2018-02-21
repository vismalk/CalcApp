package jp.techacademy.yamaguchiiori.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText value1;
    EditText value2;
    // エラーメッセージ
    String errorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // +ボタン
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        // -ボタン
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        // *ボタン
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        // /ボタン
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        // 一つ目の入力
        value1 = (EditText) findViewById(R.id.value1);

        // 二つ目の入力
        value2 = (EditText) findViewById(R.id.value2);

        Resources res = getResources();
        errorMsg = res.getString(R.string.errorMsg);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SecondCalc.class);
        String value3 = value1.getText().toString();
        String value4 = value2.getText().toString();

        try {
            // 計算結果
            double result = 0;
            // 一つ目の入力数字
            double suji1 = Double.parseDouble(value3);
            // 二つ目の入力数字
            double suji2 = Double.parseDouble(value4);


            switch (v.getId()) {

                case R.id.button1:
                    result = suji1 + suji2;
                    break;
                case R.id.button2:
                    result = suji1 - suji2;
                    break;
                case R.id.button3:
                    result = suji1 * suji2;
                    break;
                case R.id.button4:
                    result = suji1 / suji2;
                    break;
            }
            intent.putExtra("result", result);
            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
        }

    }
}
