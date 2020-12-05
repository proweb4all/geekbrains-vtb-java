package ru.proweb4all.course.lesson2;

public class Treadmill implements Obstacle{
    private int lengthTreadmill = 1000;

    public Treadmill() {}

    public Treadmill(int lengthTreadmill) {
        this.lengthTreadmill = lengthTreadmill;
    }

    @Override
    public boolean passed(int ability) {
        if (ability >= lengthTreadmill) {
            System.out.println("беговая дорожка " + lengthTreadmill + "м пройдена успешно");
            return true;
        } else {
            System.out.println("беговая дорожка " + lengthTreadmill + "м не пройдена");
            return false;
        }
    }

    @Override
    public boolean passed(Participant participant) {
        return participant.run(lengthTreadmill);
    }
}
