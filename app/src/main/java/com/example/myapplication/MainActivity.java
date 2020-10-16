package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button btnGJdom, btnJdom, btnGManual, btnManual;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGJdom = findViewById(R.id.btnGJdom);
        btnJdom = findViewById(R.id.btnJdom);
        btnGManual = findViewById(R.id.btnGManual);
        btnManual = findViewById(R.id.btnManual);
        listView = findViewById(R.id.listView);
    }
}