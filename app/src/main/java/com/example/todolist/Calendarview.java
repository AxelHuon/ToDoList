package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import java.util.*;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Calendarview extends AppCompatActivity  {


    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    EditText input;
    EditText dateText;
    DatePickerDialog.OnDateSetListener setListener;
    Button enter;



    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendarview);


        listView = findViewById(R.id.listview);
        input = findViewById(R.id.input);
        dateText = findViewById(R.id.date);
        enter = findViewById(R.id.enter);

        items = new ArrayList<>();







        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_naviggation);


        bottomNavigationView.setSelectedItemId(R.id.calendar);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.add_task:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.calendar:
                        return true;
                }
                return false;
            }
        });




    }


}