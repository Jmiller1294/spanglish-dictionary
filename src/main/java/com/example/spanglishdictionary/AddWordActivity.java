package com.example.spanglishdictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddWordActivity extends AppCompatActivity {
    private CustomReceiver mReceiver = new CustomReceiver();
    private TextView enterWordView, enterDefView, enterPalabraView, enterUseView;
    private EditText enterWordEdit, enterDefEdit, enterPalabraEdit, enterUseEdit;
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);


        // Initialize private TextView fields with their corresponding TextViews
        enterWordView = findViewById(R.id.enterWordView);
        enterDefView = findViewById(R.id.enterDefView);
        enterPalabraView = findViewById(R.id.enterPalabraView);
        enterUseView = findViewById(R.id.enterUseView);

        // Initialize private EditText fields with their corresponding EditTexts
        enterWordEdit = findViewById(R.id.enterWordEdit);
        enterDefEdit = findViewById(R.id.enterDefEdit);
        enterPalabraEdit = findViewById(R.id.enterPalabraEdit);
        enterUseEdit = findViewById(R.id.enterUseEdit);

        //
        IntentFilter filter = new IntentFilter();

        this.registerReceiver(mReceiver, filter);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,
                        new IntentFilter(ACTION_CUSTOM_BROADCAST));

    }

    // Method to Send Data Items (new word info) to MainActivity here
    public void sendData(View view) {
        Intent intent = new Intent(this, WordLookupActivity.class);
        intent.putExtra("added_word", "new word");
        sendCustomBroadcast();
        // Word data info below
    finish();
    }

    public void sendCustomBroadcast() {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }

    @Override
    protected void onDestroy() {
        // Unregister the receiver.
        this.unregisterReceiver(mReceiver);
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(mReceiver);
        super.onDestroy();
    }

}

