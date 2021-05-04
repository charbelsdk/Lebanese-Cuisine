package com.example.android.androidProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class foodDescription extends AppCompatActivity {
    TextView textView ;
    TextView heading;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_description);
        textView = findViewById(R.id.food_desc);
        heading = findViewById(R.id.food_name);
        imageView = findViewById(R.id.food_image);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        try {
            ReadTextFile(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ReadTextFile(String mess) throws IOException {
        String string = "";
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = this.getResources().openRawResource(R.raw.kafta);
        if (mess.equals("1")) {
             is = this.getResources().openRawResource(R.raw.kafta);
             heading.setText("Kafta");
             imageView.setImageResource(R.drawable.kafta2);
        }
        if (mess.equals("2")) {
            is = this.getResources().openRawResource(R.raw.taboule);
            heading.setText("Taboule");
            imageView.setImageResource(R.drawable.taboule2);
        }
        if (mess.equals("3")) {
            is = this.getResources().openRawResource(R.raw.taboule);
            heading.setText("Hommos");
            imageView.setImageResource(R.drawable.hommos2);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while (true) {
            try {
                if ((string = reader.readLine()) == null) break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(string).append("\n");
            textView.setText(stringBuilder);
        }
        is.close();

    }
}