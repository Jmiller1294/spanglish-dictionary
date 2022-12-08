package com.example.spanglishdictionary;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordsRepository {
    private WordsDao mWordDao;
    private LiveData<List<Words>> mAllWords;

    WordsRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Words>> getAllWords() {
        return mAllWords;
    }

    public void insert (Words word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Words, Void, Void> {

        private WordsDao mAsyncTaskDao;

        insertAsyncTask(WordsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Words... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
