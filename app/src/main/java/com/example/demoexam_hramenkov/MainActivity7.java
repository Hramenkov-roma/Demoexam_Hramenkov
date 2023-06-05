package com.example.demoexam_hramenkov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.demoexam_prudovskiy.R;

import java.util.ArrayList;

public class MainActivity7 extends AppCompatActivity implements ImageView.OnClickListener{


    ImageView pin1, pin2, pin3, pin4;
    Button button4, button5, button6, button7, button8, button9, button10, button11, button15, button16, button17;


    ArrayList<String> numbers_list = new ArrayList<>();
    String passCode= "";
    String num01, num02, num03, num04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        initializeComponents();
    }

    private void initializeComponents() {
        pin1 = findViewById(R.id.pin1);
        pin2 = findViewById(R.id.pin2);
        pin3 = findViewById(R.id.pin3);
        pin4 = findViewById(R.id.pin4);

        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);

        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button15.setOnClickListener(this);
        button16.setOnClickListener(this);
        button17.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button4:
                numbers_list.add("2");
                passNumber(numbers_list);
                break;
            case R.id.button5:
                numbers_list.add("3");
                passNumber(numbers_list);
                break;
            case R.id.button6:
                numbers_list.add("4");
                passNumber(numbers_list);
                break;
            case R.id.button7:
                numbers_list.add("5");
                passNumber(numbers_list);
                break;
            case R.id.button8:
                numbers_list.add("6");
                passNumber(numbers_list);
                break;
            case R.id.button9:
                numbers_list.add("7");
                passNumber(numbers_list);
                break;
            case R.id.button10:
                numbers_list.add("8");
                passNumber(numbers_list);
                break;
            case R.id.button11:
                numbers_list.add("9");
                passNumber(numbers_list);
                break;
            case R.id.button15:
                numbers_list.add("0");
                passNumber(numbers_list);
                break;
            case R.id.button16:
                numbers_list.clear();
                passNumber(numbers_list);
                break;
            case R.id.button17:
                numbers_list.add("1");
                passNumber(numbers_list);
                break;
        }

    }

    private void passNumber(ArrayList<String> numbers_list) {
        if (numbers_list.size() == 0){
            pin1.setBackgroundResource(R.drawable.eps0);
            pin2.setBackgroundResource(R.drawable.eps0);
            pin3.setBackgroundResource(R.drawable.eps0);
            pin4.setBackgroundResource(R.drawable.eps0);
        } else {
            switch (numbers_list.size()){
                case 1:
                    num01 = numbers_list.get(0);
                    pin1.setBackgroundResource(R.drawable.epsb);
                    break;
                case 2:
                    num02 = numbers_list.get(1);
                    pin2.setBackgroundResource(R.drawable.epsb);
                    break;
                case 3:
                    num03 = numbers_list.get(2);
                    pin3.setBackgroundResource(R.drawable.epsb);
                    break;
                case 4:
                    num04 = numbers_list.get(3);
                    pin4.setBackgroundResource(R.drawable.epsb);
                    passCode = num01 + num02 + num03 + num04;
                    if (getPassCode().length() == 0) {
                        savePassCode(passCode);
                    } else {
                        matchPassCode();
                    }
                    break;
            }
        }
    }

    private void matchPassCode() {
        if (getPassCode().equals(passCode)){
            startActivity(new Intent(this, MainActivity8.class));
        } else {
            Toast.makeText(this, "PassCode doesn't match please retry again", Toast.LENGTH_SHORT).show();
        }
    }


    private SharedPreferences.Editor savePassCode(String passCode){
        SharedPreferences preferences = getSharedPreferences("passcode-pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("passcode", passCode);
        editor.commit();

        return editor;
    }

    private String getPassCode(){
        SharedPreferences preferences = getSharedPreferences("passcode-pref", Context.MODE_PRIVATE);
        return preferences.getString("passcode", "");
    }
}