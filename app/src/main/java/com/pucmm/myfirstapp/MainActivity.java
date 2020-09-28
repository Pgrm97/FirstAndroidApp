package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    //Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate = (TextView) findViewById(R.id.textViewDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet (DatePicker datePicker, int year, int month, int day){
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy " + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        final Spinner spinner = findViewById(R.id.spinnerGender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.OnItemSelectedListener(this);
        //buttonEnviar = findViewById(R.id.buttonEnviar);
        //buttonEnviar.setOnClickListener();

        final EditText firstName = findViewById(R.id.firstName);
        final EditText lastName = findViewById(R.id.lastName);

        final CheckBox checkJava = findViewById(R.id.checkboxJava);
        final CheckBox checkCSharp = findViewById(R.id.checkboxCSharp);
        final CheckBox checkCCPlus = findViewById(R.id.checkboxCCPlusPlus);
        final CheckBox checkGo = findViewById(R.id.checkboxGo);
        final CheckBox checkJS = findViewById(R.id.checkboxJS);
        final CheckBox checkPython = findViewById(R.id.checkboxPython);
        final RadioButton yes = findViewById(R.id.radioButtonYes);

        Button reset = (Button) findViewById(R.id.buttonLimpiar);
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mDisplayDate.setText("");
                firstName.setText("");
                lastName.setText("");
                spinner.setSelection(0);
                checkJava.setChecked(false);
                checkCSharp.setChecked(false);
                checkCCPlus.setChecked(false);
                checkGo.setChecked(false);
                checkJS.setChecked(false);
                checkPython.setChecked(false);
                yes.setChecked(true);
            }
        });

        Button button;
        button = (Button) findViewById(R.id.buttonEnviar2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


    }

    public void openActivity2() {
        Intent intent = new Intent(this, TextActivity.class);
        final EditText firstName = findViewById(R.id.firstName);
        final EditText lastName = findViewById(R.id.lastName);
        final Spinner spinner = findViewById(R.id.spinnerGender);
        final TextView date = findViewById(R.id.textViewDate);
        final CheckBox checkJava = findViewById(R.id.checkboxJava);
        final CheckBox checkCSharp = findViewById(R.id.checkboxCSharp);
        final CheckBox checkCCPlus = findViewById(R.id.checkboxCCPlusPlus);
        final CheckBox checkGo = findViewById(R.id.checkboxGo);
        final CheckBox checkJS = findViewById(R.id.checkboxJS);
        final CheckBox checkPython = findViewById(R.id.checkboxPython);
        final RadioButton yes = findViewById(R.id.radioButtonYes);
        final RadioButton no = findViewById(R.id.radioButtonNo);
        if(checkJava.isChecked()){
            intent.putExtra("checkJava", "Java");
        }
        if(checkCSharp.isChecked()){
            intent.putExtra("checkCSharp", "C#");
        }
        if(checkCCPlus.isChecked()){
            intent.putExtra("checkCCPlus", "C/C++");
        }
        if(checkGo.isChecked()){
            intent.putExtra("checkGo", "Go Land");
        }
        if(checkJS.isChecked()){
            intent.putExtra("checkJS", "JS");
        }
        if(checkPython.isChecked()){
            intent.putExtra("checkPython", "Python");
        }
        intent.putExtra("firstName", firstName.getText().toString());
        intent.putExtra("lastName", lastName.getText().toString());
        intent.putExtra("yes", yes.isChecked());
        intent.putExtra("spinner", spinner.getSelectedItem().toString());
        intent.putExtra("date", date.getText().toString());

        startActivity(intent);
    };
}