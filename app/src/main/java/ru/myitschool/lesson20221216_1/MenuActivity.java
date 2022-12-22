package ru.myitschool.lesson20221216_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.myitschool.lesson20221216_1.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding binding;
    private PrefsManager prefsManager,prefsManager1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        prefsManager = new PrefsManager(getSharedPreferences(PrefsManager.NAME, MODE_PRIVATE));
        prefsManager1 = new PrefsManager(getSharedPreferences(PrefsManager.COUNT, MODE_PRIVATE));
        loadScore();

        binding.play.setOnClickListener(view -> {
            startActivity(GameActivity.getInstance(this));

        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        loadScore();
//        if (prefsManager1.getCount() < 2) {
//            binding.play.setVisibility(View.VISIBLE);
//
//        } else {
//            binding.play.setVisibility(View.GONE);
//        }

    }

    private void loadScore() {
        binding.score.setText("SCORE: " + prefsManager.getScore() + " ");

    }
}