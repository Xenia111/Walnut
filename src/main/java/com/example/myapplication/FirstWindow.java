package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class FirstWindow extends AppCompatActivity {

    // ЭТО НУЖНО ДЛЯ СИСТЕМНОЙ КНОПКИ
    private Toast backToast;
    private long backPressedTime;
    // ЭТО НУЖНО ДЛЯ СИСТЕМНОЙ КНОПКИ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_window);

        // Картинка, которая будет по клику на нее  перекидывать на Layout меню MainActivity. Картинка, которая с орехом
// Кнопка для перехода в меню начало
        //Делаем кликабельной картинку(с кнопкой было бы  то же самое)
        ImageView imageViewclick = (ImageView)findViewById(R.id.imageViewclick);
        imageViewclick.setOnClickListener(new View.OnClickListener(){
            // Это если была бы кликабельная кнопка
            // Button Invisiblebutton = (Button)findViewById(R.id.Invisiblebutton);
            // Invisiblebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent intent = new Intent(FirstWindow.this, MainActivitymain.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }//конец конструкции
            }
        });
        // Кнопка для перехода в меню конец

        // Картинка, которая будет по клику на нее  перекидывать на Layout меню MainActivity. Картинка, которая с травой
// Кнопка для перехода в меню начало
        //Делаем кликабельной картинку(с кнопкой было бы  то же самое)
        ImageView imageViewgreenclick = (ImageView)findViewById(R.id.imageViewgreenclick);
        imageViewgreenclick.setOnClickListener(new View.OnClickListener(){
            // Это если была бы кликабельная кнопка
            // Button Invisiblebutton = (Button)findViewById(R.id.Invisiblebutton);
            // Invisiblebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent intent = new Intent(FirstWindow.this, MainActivitymain.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }//конец конструкции
            }
        });
        // Кнопка для перехода в меню конец

    }

    // Выход из приложения при двойном клике на системную кнопку "назад"
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