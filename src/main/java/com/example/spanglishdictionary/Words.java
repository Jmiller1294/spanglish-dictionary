package com.example.spanglishdictionary;

public class Words {

        private String word;
        private String def;
        private String palabra;
        private String use;

        Words(String word, String def, String palabra, String use) {
            this.word = word;
            this.def = def;
            this.palabra = palabra;
            this.use = use;
        }
        public String getWord(){
            return word;
        }
        public String getDef(){
            return def;
        }
        public String getPalabra(){
            return palabra;
        }
        public String getUse(){
            return use;
        }


}

