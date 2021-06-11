package com.example.myapplication;
//Это отдельный класс, в котором будем хранить все данные, что введе пользватель ( В нашем случае это имя, фамилия и эмейл)
// Именно этот класс мы и будем записывать в БД
public class User {
    public String id, name, sec_name, email,number;

    public User() {

    }

    public User(String id, String name, String sec_name, String email, String number) {
        this.id = id;
        this.name = name;
        this.sec_name = sec_name;
        this.email = email;
        this.number = number;
    }
}
