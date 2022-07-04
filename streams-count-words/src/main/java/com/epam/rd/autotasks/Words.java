package com.epam.rd.autotasks;


import java.util.*;
import java.util.stream.Collectors;

public class Words {

    public String countWords(List<String> lines) {

        String text = lines.toString();
        String[] words = text.split("(?U)\\W+");

        Comparator<Map.Entry<String, Long>> comparator =
                Map.Entry.comparingByValue(Comparator.reverseOrder());
        comparator=comparator.thenComparing(Map.Entry.comparingByKey());

        Map<String,Long> freq =Arrays.stream(words)
                .collect(Collectors.groupingBy
                        (String::toLowerCase, Collectors.counting()));

        LinkedHashMap<String,Long> freqSorted = freq.entrySet().stream()
                .filter(x->x.getKey().length()>3&&x.getValue()>9)
                .sorted(comparator)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,(a, b)->a,
                        LinkedHashMap::new));

        String dupa = Arrays.stream(words).collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting())).entrySet().stream()
                .filter(x->x.getKey().length()>3&&x.getValue()>9)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,(a, b)->a,
                        String::new));

        return freqSorted.keySet().stream().map(key->key+" - "+freqSorted.get(key)).collect(Collectors.joining("\n","",""));
    }
}
