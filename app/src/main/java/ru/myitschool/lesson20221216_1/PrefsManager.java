package ru.myitschool.lesson20221216_1;

import android.content.SharedPreferences;

public class PrefsManager {
    public final static String NAME = "MY_GAME";
    public final static String COUNT = "MY_COUNT";


    private final static String KEY_SCORE = "KEY_SCORE";
    private final static String KEY_COUNT = "KEY_COUNT";
    private final SharedPreferences sharedPreferences;

    public PrefsManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setScore(int score) {
        sharedPreferences.edit().putInt(KEY_SCORE, score).apply();
    }

    public int getScore() {
        return sharedPreferences.getInt(KEY_SCORE, 0);
    }
    public void setCount(int count) {
        sharedPreferences.edit().putInt(KEY_COUNT, count).apply();
    }

    public int getCount() {
        return sharedPreferences.getInt(KEY_COUNT, 1);
    }
}
