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

public class MainActivity extends AppCompatActivity {


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
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listview);
        input = findViewById(R.id.input);
        dateText = findViewById(R.id.date);
        enter = findViewById(R.id.enter);

        items = new ArrayList<>();







        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_naviggation);


        bottomNavigationView.setSelectedItemId(R.id.dashboard);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){
                    case R.id.calendar:
                        startActivity(new Intent(getApplicationContext(), Calendarview.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.add_task:
                        createNewContactDialog();
                        return true;

                    case R.id.dashboard:
                        return true;
                }
                return false;
            }
        });




    }

    public void createNewContactDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View popupTask = getLayoutInflater().inflate(R.layout.popup, null);

        input = popupTask.findViewById(R.id.input);
        dateText = popupTask.findViewById(R.id.date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

    dateText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
            datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            datePickerDialog.show();
        }
    });

    setListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month = month+1;
            String date = day+"/"+month+"/"+year;
            dateText.setText(date);
        }
    };






        enter = popupTask.findViewById(R.id.enter);
        dialogBuilder.setView(popupTask);
        dialog = dialogBuilder.create();
        dialog.show();


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                String date = dateText.getText().toString();
                if (text  == null || text.length() == 0){
                }else{
                    addItem(text + " - " + date);
                    input.setText("");
                    dateText.setText("");

                }
            }

            });

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

    }

    public void addItem(String item){
        items.add(item);
        listView.setAdapter(adapter);
        dialog.dismiss();
    }



}