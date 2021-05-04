
package com.example.android.androidProject;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    public static final String EXTRA_MESSAGE =
            "com.example.android.androidProject.extra.MESSAGE";

    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        SubscribeActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });

        MyReceiver myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myReceiver, intentFilter);
        textView = findViewById(R.id.food_desc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_pause:
                stopService(new Intent(this, MyService.class));
                return true;
            case R.id.action_play:
                startService(new Intent(this, MyService.class));
                return true;
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this,
                        SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }


    public void showTaboule(View view) {
        Intent food_description = new Intent(MainActivity.this,
                foodDescription.class);
        food_description.putExtra(EXTRA_MESSAGE, "1");
        startActivity(food_description);
    }

    public void showKafta(View view) {
        Intent food_description = new Intent(this,
                foodDescription.class);
        food_description.putExtra(EXTRA_MESSAGE, "2");
        startActivity(food_description);
    }


    public void showHommos(View view) {
        Intent food_description = new Intent(this,
                foodDescription.class);
        food_description.putExtra(EXTRA_MESSAGE, "3");
        startActivity(food_description);
    }

}
