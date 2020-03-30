package com.example.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.util.LocaleData.MeasurementSystem.SI;

public class MainActivity extends AppCompatActivity {
    private EditText amountField,interestField,timeField;
    private TextView interest,amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountField =  findViewById(R.id.amountField);
        interestField =  findViewById(R.id.interestField);
        timeField =  findViewById(R.id.timeFileld);
        interest =  findViewById(R.id.interest);
        amount =  findViewById(R.id.amount);

    }




    public void intBtn(View view) {

    try {


        double principal = Double.parseDouble(amountField.getText().toString());
        double rate = Double.parseDouble(interestField.getText().toString());
        double time = Double.parseDouble(timeField.getText().toString());

        String p = amountField.getText().toString();
        String t = interestField.getText().toString();
        String r = timeField.getText().toString();

        if (p.isEmpty() && t.isEmpty() && r.isEmpty()) {


            gotoMainActivity();
            Toast.makeText(MainActivity.this, "ठाउँ खाली भयो", Toast.LENGTH_SHORT).show();
        } else if (p.isEmpty() || t.isEmpty() || r.isEmpty()) {

            gotoMainActivity();
            Toast.makeText(MainActivity.this, "खाली भयो", Toast.LENGTH_SHORT).show();
        } else {
            if (principal > 0 && rate > 0 && time > 0) {
                double SI = (principal * rate * (time / 12)) / 100;
                interest.setText(SI + "");
                double amt = principal + SI;
                amount.setText((amt + ""));
            } else {
                Toast.makeText(MainActivity.this, "\n" + "Invalid Structure", Toast.LENGTH_SHORT).show();
                gotoMainActivity();
            }
        }
    }
    catch (Exception exception){
        Toast.makeText(MainActivity.this, "ठाउँ खाली भयो", Toast.LENGTH_SHORT).show();
        gotoMainActivity();
    }
    }

    private void gotoMainActivity() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
