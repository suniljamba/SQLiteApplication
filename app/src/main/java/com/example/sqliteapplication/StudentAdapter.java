package com.example.sqliteapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class StudentAdapter extends ArrayAdapter {
    Context mContext;
    int layoutRes;
    List<Student> students;
    //    SQLiteDatabase mDatabase;
    DBHelper mDatabase;

    public StudentAdapter(Context mContext, int layoutRes, List<Student> students, DBHelper mDatabase) {
        super(mContext, layoutRes, students);
        this.mContext = mContext;
        this.layoutRes = layoutRes;
        this.students = students;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(layoutRes, null);
        TextView tvName = v.findViewById(R.id.tv_name);
        TextView tvContact = v.findViewById(R.id.tv_contact);
        TextView tvDob = v.findViewById(R.id.tv_dob);


        final Student student = students.get(position);
        tvName.setText(student.getName());
        tvContact.setText(student.getContact());
        tvDob.setText(student.getDob());

        return v;
    }

}
