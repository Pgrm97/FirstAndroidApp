package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        Bundle extras = getIntent().getExtras();
        String first = extras.getString("firstName");
        String last = extras.getString("lastName");
        String spinner = extras.getString("spinner");
        String date = extras.getString("date");
        String java = extras.getString("checkJava");
        String cSharp = extras.getString("checkCSharp");
        String cCPlus = extras.getString("checkCCPlus");
        String go = extras.getString("checkGo");
        String js = extras.getString("checkJS");
        String python = extras.getString("checkPython");

        Boolean yes = extras.getBoolean("yes");
        String choice = "null";
        TextView text = (TextView) findViewById(R.id.textView);
        text.append(first + " ");
        text.append(last + ". \n \n");
        text.append("Soy " + spinner + " y nací en " + date + ". \n \n");
        if(yes.equals(true)){
            choice = "Sí";
            text.append(choice + " me gusta programar. Mis lenguages favoritos son: ");
            if (java != null)
                text.append(java + ", ");
            if (go != null)
                text.append(go + ", ");
            if (cSharp != null)
                text.append(cSharp + ", ");
            if(cCPlus != null)
                text.append(cCPlus + ", ");
            if (js != null)
                text.append(js + ", ");
            if (python != null)
                text.append(python + ", ");
            text.append(".");
        }
        else{
            choice = "No";
            text.append(choice + " me gusta programar.");
        }



    }
}