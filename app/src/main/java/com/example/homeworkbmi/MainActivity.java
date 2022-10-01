package com.example.homeworkbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserName, editTextUserAge, editTextUserHeight, editTextUserWeight;
    private Button buttonClear, buttonSubmit;
    String userName, userAge, userHeight, userWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI計算機");                                                     //將title改成BMI計算機
        editTextAreaInit();                                                       //將所有EditText區全部初始化
        buttonSubmitInit();                                                       //將送出的按鈕初始化
        buttonClearInit();                                                        //將清除的按鈕初始化
    }
    private void editTextAreaInit() {                                               //將所有EditText區全部初始化
        editTextUserName = (EditText) findViewById(R.id.editText_userName);
        editTextUserAge = (EditText) findViewById(R.id.editText_userAge);
        editTextUserHeight = (EditText) findViewById(R.id.editText_userHeight);
        editTextUserWeight = (EditText) findViewById(R.id.editText_userWeight);
    }
    private void buttonSubmitInit() {                                             //將submit的按鈕初始化
        buttonSubmit = (Button) findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {              //送出按鈕初始化方法內容
            @Override
            public void onClick(View v) {
                userName = editTextUserName.getText().toString();
                userAge = editTextUserAge.getText().toString();
                userHeight = editTextUserHeight.getText().toString();
                userWeight = editTextUserWeight.getText().toString();
                if(userName.isEmpty() || userAge.isEmpty() || userHeight.isEmpty() || userWeight.isEmpty()){
                    Toast.makeText(MainActivity.this, "輸入的資料不完整", Toast.LENGTH_LONG).show();
                }else{
                    if(Double.parseDouble(userWeight) == 0 || Double.parseDouble(userHeight) == 0 || Integer.parseInt(userAge) == 0){
                        Toast.makeText(MainActivity.this, "資料輸入錯誤", Toast.LENGTH_LONG).show();
                    }else{
                        Intent intent = new Intent(MainActivity.this, ShowBmiResult.class);
                        intent.putExtra("userName", userName);
                        intent.putExtra("userAge", userAge);
                        intent.putExtra("userHeight", userHeight);
                        intent.putExtra("userWeight", userWeight);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    private void buttonClearInit() {                                            //將clear的按鈕初始化
        buttonClear = (Button) findViewById(R.id.button_clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextUserAge.setText("");
                editTextUserName.setText("");
                editTextUserHeight.setText("");
                editTextUserWeight.setText("");
            }
        });
    }
}