package com.example.dialog_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    EditText name, surname, city;
    Button birth, gender, save;
    Dialog d;
    RadioButton m,f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editText_name);
        surname = findViewById(R.id.editText_familyname);
        city = findViewById(R.id.editText_city);
        birth = findViewById(R.id.button_date);
        gender = findViewById(R.id.button_gender);
        save = findViewById(R.id.button_save);
        birth.setOnClickListener(this);
        gender.setOnClickListener(this);
        save.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==birth){
            Calendar sCalender=Calendar.getInstance();
            int year = sCalender.get(Calendar.YEAR);
            int month = sCalender.get(Calendar.MONTH);
            int day = sCalender.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,new SetDate(),year,month,day);
            datePickerDialog.show();

        } else if (view==gender) {
            d=new Dialog(this);
            d.setContentView(R.layout.custom_dialog);
            d.setTitle("Gender");
            d.setCancelable(true);
            m=d.findViewById(R.id.radio_male);
            f=d.findViewById(R.id.radio_female);
            d.show();

        }
    }

    public class SetDate implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            i1=i1+1;
            birth.setText(i2+"/"+i1+"/"+i);
        }
    }




}