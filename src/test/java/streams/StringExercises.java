package streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringExercises {

    private final List<String> strings = Arrays.asList("qwq", "this", "is", "a", "sort", "example");

    @Test
    public void stringLengthSort_InnerClass(){
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(strings);
    }

    @Test
    public void stringLengthSort_Lambda(){
        strings.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println(strings);

        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());

        System.out.println(sorted);
        System.out.println(strings);
    }

    private static int compareString(String s1, String s2){
        return s1.length() - s2.length();
    }

    @Test
    public void stringLengthSort_methodCall(){

        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> compareString(s1, s2))
                .collect(Collectors.toList());

        System.out.println(sorted);
    }

    @Test
    public void stringLengthSort_methodRef(){

        List<String> sorted = strings.stream()
                .sorted(StringExercises::compareString)
                .collect(Collectors.toList());

        System.out.println(sorted);
    }

    @Test
    public void stringLengthSort_comparingInt(){

        List<String> sorted = strings.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());

        System.out.println(sorted);

        Map<String, Integer> map = strings.stream().collect(Collectors.toMap(Function.identity(), s -> s.length()));

        System.out.println(map);
    }

}
