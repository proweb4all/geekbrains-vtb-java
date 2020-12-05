package ru.proweb4all.course.lesson2;

public class Wall implements Obstacle{
    private int heightWall = 2;

    public Wall() {}

    public Wall(int heightWall) {
        this.heightWall = heightWall;
    }

    @Override
    public boolean passed(int ability) {
        if (ability >= heightWall) {
            System.out.println("стена " + heightWall + "м преодолена успешно");
            return true;
        } else {
            System.out.println("стена " + heightWall + "м не преодолена");
            return false;
        }
    }
    @Override
    public boolean passed(Participant participant) {
        return participant.climb(heightWall);
    }

}
