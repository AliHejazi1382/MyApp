package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnGJdom, btnJdom, btnGManual, btnManual;
    private ListView listView;
    private List<Books> books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGJdom = findViewById(R.id.btnGJdom);
        btnJdom = findViewById(R.id.btnJdom);
        btnGManual = findViewById(R.id.btnGManual);
        btnManual = findViewById(R.id.btnManual);
        listView = findViewById(R.id.listView);

        btnGJdom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                books = new BookJdomParser(MainActivity.this).parseXml();
                refreshDisplay();
            }
        });

        btnJdom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                books = new XmlJdomParser(MainActivity.this).parseXml();
                refreshDisplay();
            }
        });

        btnManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                books = new XmlJdomParser(MainActivity.this).parseXml();
                refreshDisplay();
            }
        });

        btnGManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void refreshDisplay() {
        CustomAdapter adapter = new CustomAdapter(this, books);
        listView.setAdapter(adapter);
    }
}