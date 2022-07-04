package com.epam.rd.autotasks;


import java.security.Key;
import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        ArrayList<Map.Entry<String,Integer>> entries = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();


        for (String l: lines) {
            String[] words = l.split("(?U)\\W+");
            for (String w: words){
                if (w.length()>3) {
                    Integer i = wordMap.get(w.toLowerCase());
                    if (i == null)
                        wordMap.put(w.toLowerCase(), 1);
                    else
                        wordMap.put(w.toLowerCase(), ++i);
                }
            }
        }

        for (Map.Entry<String,Integer> entry : wordMap.entrySet()){
            if (entry.getValue()>=10)
                entries.add(entry);
        }

        entries.sort(new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        ArrayList<String> wordCount=new ArrayList<>();

        for (Map.Entry<String,Integer> entry : entries
             ) {
            wordCount.add(entry.getKey()+" - "+entry.getValue());
        }

        return String.join("\n",wordCount);
    }
}
