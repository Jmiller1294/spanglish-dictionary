package com.example.spanglishdictionary;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class savedWordsAdapter extends RecyclerView.Adapter<savedWordsAdapter.WordViewHolder> {

    private final LayoutInflater mInflater;
    private List<Words> mWords; // Cached copy of words

    savedWordsAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.word_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            Words current = mWords.get(position);
            Log.d("adapter", current.getWord());
            Log.d("adapter", current.getDef());
            Log.d("adapter", current.getPalabra());
            Log.d("adapter", current.getUse());
            holder.wordItemView.setText(current.getWord());
            holder.wordItemView2.setText(current.getDef());
            holder.wordItemView3.setText(current.getPalabra());
            holder.wordItemView4.setText(current.getUse());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    void setWords(List<Words> words){
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView wordItemView2;
        private final TextView wordItemView3;
        private final TextView wordItemView4;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            wordItemView2 = itemView.findViewById(R.id.def);
            wordItemView3 = itemView.findViewById(R.id.palabra);
            wordItemView4 = itemView.findViewById(R.id.use);
        }
    }
}















//public class spanglishAdapter extends RecyclerView.Adapter<spanglishAdapter.ViewHolder>{
//
//    private ArrayList<Words> wordsData;
//    private Context context;
//    public spanglishAdapter(Context context, ArrayList<Words> wordsArrayList){
//        this.context = context;
//        wordsData = wordsArrayList;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new ViewHolder((LayoutInflater.from(context).inflate(R.layout.word_item,parent,false)));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull spanglishAdapter.ViewHolder holder, int position) {
//        Words currWord = wordsData.get(position);
//        holder.bindItem(currWord);
//    }
//
//    @Override
//    public int getItemCount() {
//        return wordsData.size();
//    }
//
//    protected class ViewHolder extends RecyclerView.ViewHolder{
//        private TextView word, def, palabra, use;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            word = itemView.findViewById(R.id.word);
//            def = itemView.findViewById(R.id.def);
//            palabra = itemView.findViewById(R.id.palabra);
//            use = itemView.findViewById(R.id.use);
//        }
//
//        public void bindItem(Words currentWord){
//            word.setText(currentWord.getWord());
//            def.setText(currentWord.getDef());
//            palabra.setText(currentWord.getPalabra());
//            use.setText(currentWord.getUse());
//        }
//
//    }
//
//}
