/******************************************
This is a java code for MobileSanitizer App
*******************************************/
package com.example.mobilesanitizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Foods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
    }
    public void openz(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/news-room/fact-sheets/detail/food-safety"));
        startActivity(browserIntent);
    }
}
