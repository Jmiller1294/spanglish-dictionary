package com.example.spanglishdictionary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";


    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String[] words = context.getResources()
                .getStringArray(R.array.word_of_day_list);

        Intent mainIntent = new Intent(context, MainActivity.class);

        //create random number
        Random ran = new Random();
        int res = ran.nextInt(5 - 0) + 0;


        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction) {
                case ACTION_CUSTOM_BROADCAST:
                    mainIntent.putExtra("word", words[res]);
                    toastMessage = "custom broadcast sent";
                    break;
            }

            //add flags
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            //start main activity
            context.startActivity(mainIntent);


        }
    }


}