package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivitymain extends AppCompatActivity {
    //ЭТО НУЖНО ДЛЯ ТАЙМЕРА
    TextView textView3;
    //ЭТО НУЖНО ДЛЯ ТАЙМЕРА

    // ЭТО НУЖНО ДЛЯ СИСТЕМНОЙ КНОПКИ
    private Toast backToast;
    private long backPressedTime;
    // ЭТО НУЖНО ДЛЯ СИСТЕМНОЙ КНОПКИ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitymain);
        //Делаем таймер до конца конкурса в днях начало
        textView3=findViewById(R.id.textView3);
        long duration = TimeUnit.DAYS.toDays(1); //1
        new CountDownTimer(duration,1000) { //1000

            @Override
            public void onTick(long millisUntilFinished) {
                String sDuration = String.format(Locale.ENGLISH, " d'", TimeUnit.DAYS.toDays(1)); //1
                textView3.setText(sDuration);
            }

            @Override
            public void onFinish() {
            // Когда время закончится скроем текстовое поле
                textView3.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext()
                        , "Таймер истек.Подводим итоги розыгрыша",Toast.LENGTH_LONG).show();
            }
        }.start();

    //Делаем таймер до конца конкурса в днях конец



        // Кнопка "Хочу участвовать", которая будет по клику на нее  перекидывать на Layout меню MainActivity, где нужно вводить данные длярозыгрыша.
        // Кнопка для перехода в меню начало
            Button buttonwantprize = (Button)findViewById(R.id.buttonwantprize);
            buttonwantprize.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent intent = new Intent(MainActivitymain.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }//конец конструкции
            }
        });
        // Кнопка для перехода в меню конец

        // Кнопка "О конкурсе", которая будет по клику на нее  перекидывать на Layout меню Aboutcontest, где есть информация о розыгрыше.
        // Кнопка для перехода в "о конкурсе" начало
        Button buttonaboutprize = (Button)findViewById(R.id.buttonaboutprize);
        buttonaboutprize.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent intent = new Intent(MainActivitymain.this, Aboutcontest.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }//конец конструкции
            }
        });
        // Кнопка для перехода в "о конкурсе" конец

        // Кнопка "О нас", которая будет по клику на нее  перекидывать на Layout меню Aboutus, где есть информация о банке.
        // Кнопка для перехода в "о конкурсе" начало
        Button buttonaboutus = (Button)findViewById(R.id.buttonaboutus);
        buttonaboutus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent intent = new Intent(MainActivitymain.this, Aboutus.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }//конец конструкции
            }
        });
        // Кнопка для перехода в "о нас" конец

        // Выход из приложения, посредством клика на кнопку Выход buttonexit

        Button buttonexit = (Button) findViewById(R.id.buttonexit);
        buttonexit.setOnClickListener(
                v -> {
                    AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivitymain.this);
                    a_builder.setMessage("Вы хотите закрыть приложение?")
                            .setCancelable(false)
                            .setPositiveButton("Да", (dialog, which) -> finish())
                            .setNegativeButton("Нет", (dialog, which) -> dialog.cancel());
                    AlertDialog alert = a_builder.create();
                    alert.setTitle("Закрытие приложения");
                    alert.show();

                }
        );


    }
// Выход из приложения при двойном клике на системную кнопку "назад" ( Выход такого плана прописываем только в первом окне, выход из которого = выход из приложения) В остальных случаях из приложения конечно не выходим по этой кнопке
    //Системная кнопка "Назад" - начало
    // Сначала определить вверху,где  public class MainActivity extends AppCompatActivity {
    //    private Toast backToast;
    //    private long backPressedTime;

    @Override
    public void onBackPressed(){

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    //Системная кнопка "назад при двойном клике" - конец

}
