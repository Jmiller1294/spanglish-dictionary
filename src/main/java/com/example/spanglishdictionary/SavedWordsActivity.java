package com.example.spanglishdictionary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SavedWordsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Words> wordsData;
    private savedWordsAdapter savedWordsAdapter;
    private WordsViewModel mWordsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_words);

        mWordsViewModel = ViewModelProviders.of(this).get(WordsViewModel.class);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        savedWordsAdapter = new savedWordsAdapter(this);
        recyclerView.setAdapter(savedWordsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWordsViewModel.getAllWords().observe(this, new Observer<List<Words>>() {
            @Override
            public void onChanged(@Nullable final List<Words> words) {
                // Update the cached copy of the words in the adapter.
                Log.d("word_look", words.toString());
                savedWordsAdapter.setWords(words);
            }
        });
    }

}