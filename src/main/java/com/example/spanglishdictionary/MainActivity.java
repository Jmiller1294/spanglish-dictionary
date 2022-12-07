package com.example.spanglishdictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mWordOfDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables
        mWordOfDay = findViewById(R.id.word_of_day);

        if(getIntent().getStringExtra("word") != null) {
            mWordOfDay.setText(getIntent().getStringExtra("word"));
        }
        else {
            mWordOfDay.setText("primo");
        }


    }
    public void startWordLookup(View view) {
        Intent intent = new Intent(MainActivity.this, WordLookupActivity.class);
        startActivity(intent);
    }
    public void viewSavedEntries(View view){
        Intent intent = new Intent(MainActivity.this,SavedWordsActivity.class);
        startActivity(intent);
    }
    public void inviteFriend(View view){
        Runnable objRunnable = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(10000);
                }
                catch (Exception e ){
                    e.printStackTrace();
                }
            }
        };
        Thread objBgThread = new Thread(objRunnable);
        objBgThread.start();
        Log.d("main","message sending");

        String msg = "Download the app Spanglish Dictionary";

        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Complete Action using: ")
                .setText(msg)
                .startChooser();
    }
    public void addWord(View view){
        Intent intent = new Intent(MainActivity.this,AddWordActivity.class);
        startActivity(intent);
    }


}