package com.example.spanglishdictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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