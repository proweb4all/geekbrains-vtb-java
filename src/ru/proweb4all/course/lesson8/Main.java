package ru.proweb4all.course.lesson8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    static class Person {
        private String name;
        private int age;
        private int salary;

        public Person(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getSalary() {
            return salary;
        }
    }
    public static void main(String[] args) {
        String[] words = {"A", "A", "B", "A", "C", "C", "D"};
        String result = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
               .entrySet().stream()
               .max(Comparator.comparingLong(e -> e.getValue()))
               .get().getKey();
        System.out.println("Самое часто встречающееся слово: " + result);
        Person[] persons = {new Person("Yury", 47, 150000),
                            new Person("Vasiliy", 45, 60000),
                            new Person("Maria", 42, 40001)};
        result = String.format("%.2f", Arrays.stream(persons).mapToDouble(Person::getSalary).average().getAsDouble());
        System.out.println("Средняя зарплата сотрудников равна " + result + " руб.");
        final int N = 2;
        System.out.println(Arrays.stream(persons).sorted((o1, o2) -> o2.age - o1.age).limit(N).map(Person::getName)
              .collect(Collectors.joining(", ", N + "-х самых старших сотрудников зовут: ", ".")));
    }
}
