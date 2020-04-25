package com.example.mobilesanitizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Sunny extends AppCompatActivity {
    TextView cityName;
    Button searchButton;
    TextView result;

    class Weather extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... address) {
            try {
                URL url = new URL(address[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                int data = isr.read();
                String content = "";
                char ch;
                while (data != -1){
                    ch = (char) data;
                    content = content + ch;
                    data = isr.read();
                }
                return content;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public void search(View view){
        cityName = findViewById(R.id.cityName);
        searchButton = findViewById(R.id.searchButton);
        result = findViewById(R.id.resut);

        String cName = cityName.getText().toString();


        String content;
        Weather weather = new Weather();
        try {
            content = weather.execute("https://openweathermap.org/data/2.5/weather?q=" +
                    cName + "&appid=b6907d289e10d714a6e88b30761fae22").get();
            Log.i("contentData",content);
            JSONObject jsonObject = new JSONObject(content);
            String weatherData  = jsonObject.getString("weather");
            String mainTemperature = jsonObject.getString("main");
            double visibility;

            //Log.i("weatherData",weatherData);
            JSONArray array = new JSONArray(weatherData);
            String main ="";
            String description ="";
            String temperature ="";

            for(int i=0; i<array.length(); i++){
                JSONObject weatherPart = array.getJSONObject(i);
                main = weatherPart.getString("main");
                description = weatherPart.getString("description");
            }
            JSONObject mainPart = new JSONObject(mainTemperature);
            temperature = mainPart.getString("temp");
            visibility = Double.parseDouble(jsonObject.getString("visibility"));
            int visibilityKm = (int) visibility/1000;
            Log.i("temperature",temperature);


            /*
            Log.i("main",main);
            Log.i("description",description);*/
            String resultText ="Main: "+ main + "\nDescription: " +description +
                    "\nTemperature: " + temperature +"'c" +
                    "\nVisibility: " + visibilityKm + "Km";
            result.setText(resultText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunny);
    }
}
