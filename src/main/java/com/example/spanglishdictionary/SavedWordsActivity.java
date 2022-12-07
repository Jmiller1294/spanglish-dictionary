package com.example.spanglishdictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SavedWordsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Words> wordsData;
    private spanglishAdapter spanglishAdapter;
    private int gridColumnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_words);

        gridColumnCount = 1;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        wordsData = new ArrayList<>();
        spanglishAdapter = new spanglishAdapter(this, wordsData);
        recyclerView.setAdapter(spanglishAdapter);
        loadWordsData();
    }

    private void loadWordsData() {
        wordsData.clear();
        String [] words = getResources().getStringArray(R.array.word_list);
        String [] defs = getResources().getStringArray(R.array.def_list);
        String [] palabras = getResources().getStringArray(R.array.palabra_list);
        String [] uses = getResources().getStringArray(R.array.use_list);
        for(int i=0; i<words.length; i++){
            wordsData.add(new Words(words[i],defs[i], palabras[i],uses[i]));
        }
        spanglishAdapter.notifyDataSetChanged();
    }


}