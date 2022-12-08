package com.example.spanglishdictionary;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordsViewModel extends AndroidViewModel {
    private WordsRepository mRepository;
    private LiveData<List<Words>> mAllWords;

    public WordsViewModel (Application application) {
        super(application);
        mRepository = new WordsRepository(application);
        mAllWords = mRepository.getAllWords();

    }

    LiveData<List<Words>> getAllWords() { return mAllWords; }

    public void insert(Words words) {
        Log.d("word_lookup", words.getWord());
        mRepository.insert(words);
    }
}
