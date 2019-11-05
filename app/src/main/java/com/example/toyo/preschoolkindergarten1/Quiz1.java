package com.example.toyo.preschoolkindergarten1;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collections;
import java.util.List;
public class Quiz1 extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;
    private ColorStateList textColorDefaultRb;
    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;
    private int score;
    private boolean answered;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        textViewQuestion=findViewById(R.id.Ques);
        textViewScore=findViewById(R.id.score);
        textViewQuestionCount=findViewById(R.id.no_ques);
        rbGroup=findViewById(R.id.radio_group);
        rb1= findViewById(R.id.radio_button1);
        rb2= findViewById(R.id.radio_button2);
        rb3= findViewById(R.id.radio_button3);
        buttonConfirmNext=findViewById(R.id.b36);

        textColorDefaultRb=rb1.getLinkTextColors();

        QuizDbHelper dbHelper=new QuizDbHelper(this);
        SQLiteDatabase sq = dbHelper.getWritableDatabase();
        dbHelper.fillQuestionsTable(sq);
        questionList=dbHelper.getAllQuestions();
        for(int i=0;i<questionList.size();i++)
        {
            System.out.println(questionList.get(i).getQuestion());
            System.out.println(questionList.get(i).getOption1());
            System.out.println(questionList.get(i).getOption2());
            System.out.println(questionList.get(i).getOption3());
            System.out.println(questionList.get(i).getAnswerNum());
        }
        questionCountTotal=questionList.size();
        Collections.shuffle(questionList);


        showNextQuestion();
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             if(!answered){
                 if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked()){
                     checkAnswer();
                 }else{
                     Toast.makeText(Quiz1.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                 }
             }else{
                 showNextQuestion();
             }
            }
        });


                Button button1 = (Button) findViewById(R.id.b35);


        try {
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if(questionCounter < questionCountTotal){
                        Toast.makeText(Quiz1.this, "Please finish the quiz", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Intent intent = new Intent(Quiz1.this, SecondPage.class);
                    startActivity(intent);


                }
            });

        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    private void showNextQuestion(){
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();
        if(questionCounter < questionCountTotal){
           currentQuestion = questionList.get(questionCounter);
           textViewQuestion.setText(currentQuestion.getQuestion());
           rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            questionCounter++;
            textViewQuestionCount.setText("Ques_No: " + questionCounter + "/" + questionCountTotal);
            answered=false;
            buttonConfirmNext.setText("CONFIRM");
        }else{
            finishQuiz();
        }
    }
    private void checkAnswer(){
        answered=true;
        RadioButton rbSelected=findViewById(rbGroup.getCheckedRadioButtonId());
        int AnswerNum=rbGroup.indexOfChild(rbSelected) + 1;

        if(AnswerNum == currentQuestion.getAnswerNum()){
            score++;
            textViewScore.setText("Score: " + score);
        }
        showSolution();

    }
    private void showSolution()
    {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNum())
        {
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct");
                break;
        }
        if(questionCounter<questionCountTotal)
        {
            buttonConfirmNext.setText("Next");
        }else
        {
            buttonConfirmNext.setText("Finish");
        }
    }
    private void finishQuiz()
    {
        QuizDbHelper.db.execSQL("DROP TABLE IF EXISTS " + QuizDbHelper.TABLE_NAME);
        finish();
    }
}
