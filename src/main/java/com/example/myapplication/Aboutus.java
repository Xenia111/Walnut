package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Aboutus extends AppCompatActivity {
    // ЭТО НУЖНО ДЛЯ СИСТЕМНОЙ КНОПКИ
    private Toast backToast;
    private long backPressedTime;
    // ЭТО НУЖНО ДЛЯ СИСТЕМНОЙ КНОПКИ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
    }


    //    private Toast backToast;
    //    private long backPressedTime;
    // Системная кнопка назад, чтобы переходить по ней из этого окна в предыдущее окно.
    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed(){
        //начало конструкции
        try{
            Intent intent = new Intent(Aboutus.this, MainActivitymain.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
        //конец конструкции
    }
    //Системная кнопка "Назад" - конец


}