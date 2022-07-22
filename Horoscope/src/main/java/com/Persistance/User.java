package com.Persistance;

public class User {

    private int user_id;
    private static String user_name;
    private static String pass_word;
    private static String first_name;
    private static String last_name;
    private static   String email;
    public static String zodiac_sign;
    public  String mood;

    public User() {
    }

    public User(int user_id, String user_name, String pass_word, String first_name, String last_name, String email, String zodiac_sign, String mood) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.zodiac_sign = zodiac_sign;
        this.mood = mood;
    }

    public User(String user_name, String pass_word, String first_name, String last_name, String email, String zodiac_sign) {
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.zodiac_sign = zodiac_sign;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZodiac_sign() {
        return zodiac_sign;
    }

    public void setZodiac_sign(String zodiac_sign) {
        this.zodiac_sign = zodiac_sign;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
