package ru.proweb4all.course.lesson2;

public class Main {
    public static void main(String[] args) {
        Obstacle[] obstacles = new Obstacle[] {
                new Treadmill(),
                new Wall(),
                new Treadmill(5000),
                new Wall(3)
        };
        Participant[] participants = new Participant[] {
                new Cat(),
                new Cat("Васька"),
                new Cat("Барсик", 1000, 3),
                new Human(),
                new Human("Федор"),
                new Human("Клава", 10000, 2),
                new Robot(),
                new Robot("Вертер"),
                new Robot("Федор", 0, 0)
        };

        for(Participant p: participants) {
            System.out.println("-----------------------");
            for(Obstacle o: obstacles) {
                if (!o.passed(p)) break;
            }
        }
    }
}
