package ru.proweb4all.course.lesson2;

public interface Obstacle {
    boolean passed(int ability);
    boolean passed(Participant participant);
}
