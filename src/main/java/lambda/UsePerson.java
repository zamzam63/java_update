package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsePerson {


    public static void main(String[] args){

        List<String> names = Arrays.asList("Bakhrom", "Lola", "Akhmad");

        // old-school way
        List<Person> beatles = new ArrayList<>();
        for (String name: names){
            beatles.add(new Person(name));
        }
        System.out.println(beatles);

        // Functional approach
        List<Person> people = names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());// Convert Stream<Person> to List<Person>
        System.out.println(people);

        people = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
        System.out.println(people);

        Person[] people1 = names.stream()
                .map(Person::new)
                .toArray(Person[]::new);

        System.out.println(Arrays.toString(people1));

    }
}
