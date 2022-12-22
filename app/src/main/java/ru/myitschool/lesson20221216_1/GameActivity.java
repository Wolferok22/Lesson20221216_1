package ru.myitschool.lesson20221216_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Random;

import ru.myitschool.lesson20221216_1.databinding.ActivityGameBinding;
import ru.myitschool.lesson20221216_1.databinding.ItemButtonBinding;

public class GameActivity extends AppCompatActivity {
    private ActivityGameBinding binding;
    private final Quest quest = new Quest();
    private PrefsManager prefsManager;
    private PrefsManager prefsManager1;
    final  Random random = new Random();
    static int count=0;
    int c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefsManager = new PrefsManager(getSharedPreferences(PrefsManager.NAME, MODE_PRIVATE));
        prefsManager1 = new PrefsManager(getSharedPreferences(PrefsManager.COUNT, MODE_PRIVATE));
        initQuestion(0);
        count++;
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, GameActivity.class);
    }

    public void initQuestion(int stepNumber) {
        binding.score.setText(String.format("SCORE: %d", quest.getScore()));

        switch (stepNumber) {
            case -1:
                setNegativState();
                break;
            case -2:
                setPositiveState();
                break;
            case -3:
                setQuestionState(5);
                break;
            default:
                setQuestionState((random.nextInt(quest.getLen())-1)+1);
        }


    }

    private void setPositiveState() {
        binding.description.setText("Вы выиграли *_*");
        fillCloseButton();
        writeBestScore();
    }

    private void writeBestScore() {
        prefsManager.setScore(Math.max(prefsManager.getScore(), quest.getScore()));
        prefsManager1.setCount(count);

    }

    private void setNegativState() {
        binding.description.setText("Вы проиграли X_X");
        fillCloseButton();
        writeBestScore();
    }

    private void fillCloseButton() {
        binding.buttons.removeAllViews();
        ItemButtonBinding buttonBinding = ItemButtonBinding.inflate(getLayoutInflater(),
                binding.buttons,
                false);
        buttonBinding.getRoot().setText("Выход в главное меню");
        buttonBinding.getRoot().setOnClickListener(v -> finish());
        binding.buttons.addView(buttonBinding.getRoot());


    }

    private void setQuestionState(int stepNumber) {
        Quest.Question question = quest.getQuestion(stepNumber);
        binding.description.setText(question.getDescription());
        fillButton(question.getAnswers());
    }

    private void fillButton(Quest.Question.Answers[] answers) {
        binding.buttons.removeAllViews();
        for (Quest.Question.Answers answer : answers) {
            ItemButtonBinding buttonBinding = ItemButtonBinding.inflate(getLayoutInflater(),
                    binding.buttons,
                    false);
            buttonBinding.getRoot().setText(answer.getName());
            buttonBinding.getRoot().setOnClickListener(v -> {
                goNext(answer);
            });
            binding.buttons.addView(buttonBinding.getRoot());
        }

    }

    private void goNext(Quest.Question.Answers answer) {
        quest.addScore(answer.getScore());
        initQuestion(answer.getNextStep());

    }


}