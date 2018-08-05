package jp.techacademy.isobe.tomohiro.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.Snackbar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
         button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        Double d1;
        Double d2;
        Double result;

        try {
            d1 = Double.valueOf(mEditText1.getText().toString());

        } catch (java.lang.NumberFormatException e) {
            d1 = 0.0;
            Snackbar.make(v, "何か数値を入力して下さい", Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show();

        } try {
            d2 = Double.valueOf(mEditText2.getText().toString());

        } catch (java.lang.NumberFormatException e) {
            d2 = 0.0;
            Snackbar.make(v, "何か数値を入力して下さい", Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show();

        }

        if (v.getId() == R.id.button1) {
            result = d1 + d2;
            intent.putExtra("VALUE", result);
            startActivity(intent);

        } else if (v.getId() == R.id.button2) {
            result = d1 - d2;
            intent.putExtra("VALUE", result);
            startActivity(intent);

        } else if (v.getId() == R.id.button3) {
            result = d1 * d2;
            intent.putExtra("VALUE", result);
            startActivity(intent);

        } else if (v.getId() == R.id.button4) {
            if (d2 == 0) {
                Snackbar.make(v, "0で割ることはできません", Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show();
            }
            result = d1 / d2;
            intent.putExtra("VALUE", result);
            startActivity(intent);
        }

    }
}
