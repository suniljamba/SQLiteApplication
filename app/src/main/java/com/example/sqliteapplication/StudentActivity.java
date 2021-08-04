package com.example.sqliteapplication;

import static android.widget.ListView.*;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqliteapplication.R.layout;

public class StudentActivity extends AppCompatActivity {

    private static final String TAG = "StudentActivity";

    DBHelper mDatabase;
    List<Student> studentList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        listView = findViewById(R.id.lvStudent);
        studentList = new ArrayList<>();

        mDatabase = new DBHelper(this);
        loadEmployees();
    }

    private void loadEmployees() {

        Cursor cursor = mDatabase.getdata();

        if (cursor.moveToFirst()) {
            do {
                studentList.add(new Student(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)
                ));
            } while (cursor.moveToNext());
            cursor.close();

            StudentAdapter studentAdapter = new StudentAdapter(this, R.layout.list_layout_student, studentList, mDatabase);
            listView.setAdapter(studentAdapter);

        }
    }

}


