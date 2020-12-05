package ru.proweb4all.course.lesson6;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        oneThread(arr);
        long b = System.currentTimeMillis();
        System.out.println("oneThread time: " + (b - a) + "  *** Тест " + arr[9999999]);
        System.out.println("=========================");
        Arrays.fill(arr, 1.0f);
        a = System.currentTimeMillis();
        twoThread(arr);
        b = System.currentTimeMillis();
        System.out.println("twoThread time: " + (b - a) + "  *** Тест " + arr[9999999]);
        for (int i = 1; i < 11; i++) {
            System.out.println("=========================");
            Arrays.fill(arr, 1.0f);
            a = System.currentTimeMillis();
            multiThread(arr, (int)Math.pow(2, i));
            b = System.currentTimeMillis();
            System.out.println("multiThread(" + (int)Math.pow(2, i) + ") time: " + (b - a) + "  *** Тест " + arr[9999999]);
        }
    }

    public static void oneThread(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
    public static void oneThread(float[] arr, int startIndex){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + startIndex) / 5) * Math.cos(0.2f + (i + startIndex) / 5) * Math.cos(0.4f + (i + startIndex) / 2));
        }
//        System.out.println("** oneThread с поз." + startIndex + " " + arr.length + "шт.");
    }
    public static void twoThread(float[] arr){
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        try {
            Thread t1 = new Thread(() -> oneThread(a1, 0));
            Thread t2 = new Thread(() -> oneThread(a2, HALF));
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
    }
    public static void multiThread(float[] arr, int countThread) {
        float[][] arrs = new float[countThread][];
        Thread[] threads = new Thread[countThread];
        int delta = (int) Math.ceil((double)arr.length / countThread);
//        System.out.println("Delta=" + delta);
        int currentDelta = delta;
        for (int j = 0; j < countThread; j++) {
            int i = j;
            if (i == countThread - 1) currentDelta = arr.length - delta * i;
            arrs[i] = new float[currentDelta];
            System.arraycopy(arr, i * delta, arrs[i], 0, currentDelta);
            threads[i] = new Thread(() -> oneThread(arrs[i], i * delta));
            threads[i].start();
        }
        for (int i = 0; i < countThread; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < countThread; i++) {
            if (i == countThread - 1) currentDelta = arr.length - delta * i;
            System.arraycopy(arrs[i], 0, arr, i * delta, currentDelta);
        }
    }
}
