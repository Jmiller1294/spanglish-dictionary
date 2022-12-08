package com.example.spanglishdictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spanglishAdapter extends RecyclerView.Adapter<spanglishAdapter.ViewHolder> {

    private ArrayList<Words> wordsData;
    private Context context;

    public spanglishAdapter(Context context, ArrayList<Words> wordsArrayList){
        this.context = context;
        wordsData = wordsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder((LayoutInflater.from(context).inflate(R.layout.word_item,parent,false)));
    }

    @Override
    public void onBindViewHolder(@NonNull spanglishAdapter.ViewHolder holder, int position) {
        Words currWord = wordsData.get(position);
        holder.bindItem(currWord);
    }

    @Override
    public int getItemCount() {
        return wordsData.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder{
        private TextView word, def, palabra, use;

        public ViewHolder(View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.word);
            def = itemView.findViewById(R.id.def);
            palabra = itemView.findViewById(R.id.palabra);
            use = itemView.findViewById(R.id.use);
        }

        public void bindItem(Words currentWord){
            word.setText(currentWord.getWord());
            def.setText(currentWord.getDef());
            palabra.setText(currentWord.getPalabra());
            use.setText(currentWord.getUse());
        }


    }
}