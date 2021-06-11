package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // ЭТО НУЖНО ДЛЯ СИСТЕМНОЙ КНОПКИ
    private Toast backToast;
    private long backPressedTime;
    // ЭТО НУЖНО ДЛЯ СИСТЕМНОЙ КНОПКИ

    private TextView generateresultextView;
    private EditText edName, edSecName, edEmail,edNumber;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



        // генерируем случайное число начало
        final Random myRandom = new Random();
        final TextView generateresultextView = (TextView) findViewById(R.id.generateresultextView);
        Button buttongeneratenumber = (Button)findViewById(R.id.buttongeneratenumber);
        buttongeneratenumber.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Делаем генерацию чисел методом
                generateresultextView.setText((String.valueOf(myRandom.nextInt(1000000000))));

            }//конец конструкции
        });
        // Кнопка для перехода в меню конец

        // генерируем случайное число конец



    }

    private void init()
    {
        edName = findViewById(R.id.edName);
        edSecName = findViewById(R.id.edSecName);
        edEmail = findViewById(R.id.edEmail);
        edNumber = findViewById(R.id.edNumber);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }
    //  Прописываем на уровне класса наши слушатели кнопок
    // На нажатие кнопки Save будем сохранять все поля(имя, фамилию и почту, в данном случае)
    public void onClickSave(View view)
    {
    String id = mDataBase.getKey();
    String name = edName.getText().toString();
    String sec_name = edSecName.getText().toString();
    String email = edEmail.getText().toString();
    String number = edNumber.getText().toString();

    // Ниже пишем наш класс, который и будет заноситься в БД ( у меня это User)
     User newUser = new User(id, name, sec_name,email,number);
     // И теперь мы сохраним пользователя(строчка, что выше - User newUser = new User(id, name, sec_name,email,number);)
    // И сразу сделаем проверку. Записываем в БД, только в том случае если все Edittext(потому что конкретно сейчас у меня все данные - EditText не пустые(везде есть текст)
        // mDataBase.push().setValue(newUser); - Вот это добавление данных без проверки. Push - значит занести в БД
    if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(sec_name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(number)) // если текст не(!) пустой, то записываем в БД mDataBase.push().setValue(newUser);
        // чтобы проверить не все три поля одновременно, а всего 1 поле, то запись такая  if(!TextUtils.isEmpty(name))
    {
        mDataBase.push().setValue(newUser);
        Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
    }
    // В противном случае(если пустой) оповестим пользователя о том, что поле пустое
        else
    {
        Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
    }
    }
    public void onClickRead(View view)
    {

    }

    //    private Toast backToast;
    //    private long backPressedTime;
    // Системная кнопка назад, чтобы переходить по ней из этого окна в предыдущее окно.
    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed(){
        //начало конструкции
        try{
            Intent intent = new Intent(MainActivity.this, MainActivitymain.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
        //конец конструкции
    }
    //Системная кнопка "Назад" - конец
}