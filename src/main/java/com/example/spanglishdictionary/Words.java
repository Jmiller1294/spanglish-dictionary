package com.example.spanglishdictionary;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Words {

        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "word")
        private String word;

        @NonNull
        @ColumnInfo(name = "def")
        private String def;

        @NonNull
        @ColumnInfo(name = "palabra")
        private String palabra;

        @NonNull
        @ColumnInfo(name = "use")
        private String use;

        public Words(@NonNull String word,String def, String palabra, String use) {
            this.word = word;
            this.def = def;
            this.palabra = palabra;
            this.use = use;
        }

        public String getWord(){
            return this.word;
        }
        public String getDef(){
            return this.def;
        }
        public String getPalabra(){
            return this.palabra;
        }
        public String getUse(){
            return this.use;
        }

}

