package com.example.toyo.preschoolkindergarten1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class QuizDbHelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME="MyQuiz.db";
    private static  final int DATABASE_VERSION=3;
    public static final String TABLE_NAME="quiz_question";
    public static final String ID="_id";
    public static final String COLUMN_QUESTION="question";
    public static final String COLUMN_OPTION1="option1";
    public static final String COLUMN_OPTION2="option2";
    public static final String COLUMN_OPTION3="option3";
    public static final String COLUMN_ANSWER_Num="answer_num";
    public static SQLiteDatabase db;
    private Context context;
    public QuizDbHelper(Context context)   //Property of activity class which holds the info of the activity//
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db)   //Called when the database is created for the first time//
    {
        this.db = db;    //varchar means text,0 - 255 values store//
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                TABLE_NAME + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUESTION + " VARCHAR(255), "+
                COLUMN_OPTION1 + " VARCHAR(255), "+
                COLUMN_OPTION2 + " VARCHAR(255), "+
                COLUMN_OPTION3 + " VARCHAR(255), "+
                COLUMN_ANSWER_Num + " INTEGER "+
                ")";
       
       try {
           db.execSQL(SQL_CREATE_QUESTIONS_TABLE);   //Query for create table// //execSQL(method)=execute an SQL query on the database//
           Toast.makeText(context, "Table created succesfully", Toast.LENGTH_SHORT).show();
       }catch(Exception e)
       {
           Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
       }
       
       }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void fillQuestionsTable(SQLiteDatabase db)
    {
        QuizDbHelper.db=db;
        Question q1=new Question("1 2 3 ____ 5 6", "7", "4", "9", 2);
        addQuestion(q1);
        Question q2=new Question("A B C D ____ F G H", "J", "M", "E", 3);
        addQuestion(q2);
        Question q3=new Question("Which is the name of month?", "Friday", "April", "Monday", 2);
        addQuestion(q3);
        Question q4=new Question("May ____ July", "June", "March", "August", 1);
        addQuestion(q4);
        Question q5=new Question("Which is the name of the day of a week?", "December", "Saturday", "October", 2);
        addQuestion(q5);
        Question q6=new Question("Which sequence is right?", "L I K J", "Q R S T", "Y W X Z", 2);
        addQuestion(q6);
        Question q7=new Question("Which spelling is right?", "Appel", "Appol", "Apple", 3);
        addQuestion(q7);
        Question q8=new Question("Which sequence is right?", "March May June", "September October November", "March January February", 2);
        addQuestion(q8);
        Question q9=new Question("51 52 53 ____ 55", "54", "57", "59", 1);
        addQuestion(q9);
        Question q10=new Question("Which spelling is right?", "Tigar", "Tigre", "Tiger", 3);
        addQuestion(q10);
    }
    private void addQuestion(Question question)
    {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_QUESTION, question.getQuestion());
        cv.put(COLUMN_OPTION1, question.getOption1());
        cv.put(COLUMN_OPTION2, question.getOption2());
        cv.put(COLUMN_OPTION3, question.getOption3());
        cv.put(COLUMN_ANSWER_Num, question.getAnswerNum());
        int rowId= (int) db.insert(TABLE_NAME, null, cv);
        if(rowId>0)
        {
            Toast.makeText(context, "data inserted successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "data insertion failed", Toast.LENGTH_SHORT).show();
        }
    }
    public List<Question> getAllQuestions(){

      List<Question>   questionList=new ArrayList<>();
      db=getReadableDatabase();
        //Cursor c=db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
        Cursor c=null;
        try {
            c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        }catch(Exception e)
        {
            Toast.makeText(context, "Table recreated", Toast.LENGTH_SHORT).show();
            onCreate(db);
        }
        if(c.moveToFirst())    //increment//
        {
            do {
                Question question= new Question();
                question.setQuestion(c.getString(c.getColumnIndex(COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(COLUMN_OPTION3)));
                question.setAnswerNum(c.getInt(c.getColumnIndex(COLUMN_ANSWER_Num)));
                questionList.add(question);
              }while(c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
