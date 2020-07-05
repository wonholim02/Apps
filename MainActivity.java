/***************************
This is code for Korean App
***************************/
package com.example.koreanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void gosec1(View view) {
        Intent intent = new Intent(this, sec1.class);
        startActivity(intent);
    }
    public void gosec2(View view) {
        Intent intent = new Intent(this, sec2.class);
        startActivity(intent);
    }
    public void gosec3(View view) {
        Intent intent = new Intent(this, sec3.class);
        startActivity(intent);
    }
    public void gosec4(View view) {
        Intent intent = new Intent(this, sec4.class);
        startActivity(intent);
    }
}
