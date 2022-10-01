package com.example.homeworkbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowBmiResult extends AppCompatActivity {

    private TextView textViewUserAge, textViewUserHeight, textViewUserWeight, textViewUserBMI, textViewMessage;
    private ImageView imageViewStatus;
    double bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bmi_result);
        setTitle(getIntent().getStringExtra("userName")+"的BMI指數");
        initTextView();         //將textView區塊全數初始化
        initImageView();        //將imageView區塊初始化
        showIntentValue();      //顯示接收前頁intent傳來的數值
        showStatusImage();      //由BMI值來判斷應該顯示什麼樣的照片
        showMessage();          //由BMI值來判斷應該顯示什麼樣的訊息
    }

    private void showMessage() {    //由BMI值來判斷應該顯示什麼樣的訊息
        if(bmiResult>25){
            textViewMessage.setText("太胖了！！不可愛了！！");
        }else if(bmiResult>18.5){
            textViewMessage.setText("身材真好，真是萬人迷!");
        }else{
            textViewMessage.setText("太瘦了!!快找個奴才吧!!");
        }
    }

    private void showStatusImage() {    //由BMI值來判斷應該顯示什麼樣的照片
        if(bmiResult>25){
            imageViewStatus.setImageResource(R.drawable.fatcat);        //胖貓
        }else if(bmiResult>18.5){
            imageViewStatus.setImageResource(R.drawable.nicecat);       //苗條貓
        }else{
            imageViewStatus.setImageResource(R.drawable.skincat);       //瘦貓
        }
    }

    private void initImageView() {          //將imageView區塊初始化
        imageViewStatus = (ImageView) findViewById(R.id.imageView_statusImage);
    }

    private void showIntentValue() {    //顯示接收前頁intent傳來的數值
        textViewUserAge.setText(getIntent().getStringExtra("userAge"));
        textViewUserHeight.setText(getIntent().getStringExtra("userHeight"));
        textViewUserWeight.setText(getIntent().getStringExtra("userWeight"));
        double userHeight = Double.parseDouble(getIntent().getStringExtra("userHeight"));
        double userWeight = Double.parseDouble(getIntent().getStringExtra("userWeight"));
        bmiResult = calculateBMI(userHeight, userWeight);               //計算BMI值
        textViewUserBMI.setText(String.valueOf(bmiResult));             //將BMI值轉成String後設定為textViewUserBMI文字
    }

    private double calculateBMI(double height, double weight) {                       //計算BMI值
        double BMI = Math.round((weight/((height/100)*(height/100)))*100.0)/100.0;    //四捨五入到小數後兩位數
        return BMI;
    }

    private void initTextView() {                                                   //將textView區塊全數初始化
        textViewUserAge = (TextView) findViewById(R.id.textView_showUserAge);
        textViewUserHeight = (TextView) findViewById(R.id.textView_showUserHeight);
        textViewUserWeight = (TextView) findViewById(R.id.textView_showUserWeight);
        textViewUserBMI = (TextView) findViewById(R.id.textView_showUserBMI);
        textViewMessage = (TextView) findViewById(R.id.textView_showMessage);
    }
}