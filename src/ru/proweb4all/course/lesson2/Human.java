package ru.proweb4all.course.lesson2;

public class Human implements Participant{
    private String name = "";
    private int maxRunDistance = 5000;
    private int maxClimbHeihgt = 3;

    public Human() {
    }

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int maxRunDistance, int maxClimbHeihgt) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxClimbHeihgt = maxClimbHeihgt;
    }

    @Override
    public boolean run(int distance) {
        if (maxRunDistance >= distance) {
            System.out.println("Человек " + name + " успешно пробежал " + distance + "м");
            return true;
        } else {
            System.out.println("Человек " + name + " не смог пробежать " + distance + "м");
            return false;
        }
    }

    @Override
    public boolean climb(int height) {
        if (maxClimbHeihgt >= height) {
            System.out.println("Человек " + name + " успешно преодолел стену " + height + "м");
            return true;
        } else {
            System.out.println("Человек " + name + " не смог преодолеть стену " + height + "м");
            return false;
        }
    }

}