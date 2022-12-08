package com.example.spanglishdictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
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
    private WordsViewModel wordsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);


        // Initialize private EditText fields with their corresponding EditTexts
        enterWordEdit = findViewById(R.id.enterWordEdit);
        enterDefEdit = findViewById(R.id.enterDefEdit);
        enterPalabraEdit = findViewById(R.id.enterPalabraEdit);
        enterUseEdit = findViewById(R.id.enterUseEdit);
        wordsViewModel = ViewModelProviders.of(this).get(WordsViewModel.class);

        //register broadcast receiver
        IntentFilter filter = new IntentFilter();

        this.registerReceiver(mReceiver, filter);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,
                        new IntentFilter(ACTION_CUSTOM_BROADCAST));

    }

    //sends new word data to database
    public void sendData(View view) {
        Intent intent = new Intent(this, WordLookupActivity.class);
        intent.putExtra("added_word", "new word");
        Words word = new Words(enterWordEdit.getText().toString(),
                enterDefEdit.getText().toString(),
                enterUseEdit.getText().toString(),
                enterPalabraEdit.getText().toString());
        wordsViewModel.insert(word);
        sendCustomBroadcast();
    }

    //sends a custom broadcast to change word of the day
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

