package main.java;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Parser {


    public static String toString(BufferedReader buffer) throws Exception{
        StringBuilder text = new StringBuilder();
        String line = "";
        while((line = buffer.readLine())!=null) {
            text.append(line);
        }
        return text.toString();
    }

    public static void parsing(String text){
        text = text.replaceAll("<script[^>]*>[^<]*|<\\/script>|<style[^>]*>[^<]*|<\\/style>|<[^>]*>", "");
        List<String> words = Arrays.asList(text.toLowerCase().trim().split("\\s+|\\.|\"|,|!|\\?|;|—|:|\\[|\\]|\\(|\\)|\n|\r|\t|«|»|–|\\||=|<|>|\\{|\\}"));
        Map<String,Long> data = countDuplicates(words);
        data = sort(data);
        for(Map.Entry<String, Long> entry: data.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
    }
    public static Map<String, Long> countDuplicates(List<String> inputList) {
        return inputList.stream().filter(item -> !item.isEmpty()&&!item.equals("-")&&!item.contains("&")).collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
    }

    public static Map<String,Long> sort(Map<String,Long> map){
        LinkedHashMap<String,Long> sortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> {
                    sortedMap.put(x.getKey(), x.getValue());
                });
        return sortedMap;
    }
}
