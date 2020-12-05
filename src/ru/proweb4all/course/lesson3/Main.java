package ru.proweb4all.course.lesson3;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            System.out.println("Сумма элементов входного массива(4х4) равна " + sum4x4(arr));
        } catch (MyException e){
            System.out.println("Exception message --- " + e);
        }
    }
    static int sum4x4(String[][] arr) {
        if (arr.length != 4) {
            throw new MyArraySizeException("Неверный размер массива, требуется 4х4");
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Неверный размер массива, требуется 4х4");
            }
        }
        int sum = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                try {
                    sum += Integer.valueOf(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка: в ячейке входного массива [" + i + "][" + j + "] не целое число");
                }
            }
        }
        return sum;
    }
}
