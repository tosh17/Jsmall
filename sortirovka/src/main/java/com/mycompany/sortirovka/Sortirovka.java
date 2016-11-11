/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sortirovka;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author shcherbakov
 */
public class Sortirovka {

    ArrayList<Integer> mass = new ArrayList<>();
    long sek = 1000000000;
    static String descr="[eq";

    Sortirovka() {
    }

    public void generate(int size) {
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            mass.add(i + 1);
        }
        for (int i = 0; i < size; i++) {

            Random randNumber = new Random();
            int iNumber = randNumber.nextInt(size);
            int temp = mass.get(iNumber);
            mass.set(iNumber, mass.get(i));
            mass.set(i, temp);
        }
        long finish = System.nanoTime();
        long itog = finish - start;
        System.out.println("Массив случайной сортировки создан за =" + itog / sek);
    }

    public void puzyrek() {
        long start = System.nanoTime();
        int size = mass.size();
        for (int j = 1; j < size - 1; j++) {
            for (int i = 0; i < size - j; i++) {
                int tempi = mass.get(i);
                int tempj = mass.get(i + 1);
                if (tempi > tempj) {
                    mass.set(i, tempj);
                    mass.set(i + 1, tempi);
                }
            }
        }
        long finish = System.nanoTime();
        long itog = finish - start;
        System.out.println("Пузырек=" + itog / sek);
    }

    public void minElement() {
        long start = System.nanoTime();
        int size = mass.size();
        int min;
        for (int i = 0; i < size - 1; i++) {
            min = mass.get(i);
            int tempj = i + 1;
            for (int j = i + 1; j < size; j++) {
                int temp = mass.get(j);
                if (temp < min) {
                    min = temp;
                    tempj = j;
                }
                if (tempj > i + 1) {
                    mass.set(tempj, mass.get(i));
                    mass.set(i, min);

                }

            }
        }
        long finish = System.nanoTime();
        long itog = finish - start;
        System.out.println("Метод минимального элемента=" + itog / sek);
    }

    public void sort_mixer() {
        long start = System.nanoTime();
        int left = 0;
        int right = mass.size() - 1;
        do {
            //Сдвигаем к концу массива "тяжелые элементы"
            for (int i = left; i < right; i++) {
                int temp = mass.get(i);
                int temp1 = mass.get(i + 1);
                if (temp > temp1) {
                    temp ^= temp1;
                    temp1 ^= temp;
                    temp ^= temp1;
                    mass.set(i, temp1);
                    mass.set(i + 1, temp);
                }
            }
            right--; // уменьшаем правую границу
            //Сдвигаем к началу массива "легкие элементы"
            for (int i = right; i > left; i--) {
                int temp = mass.get(i);
                int temp1 = mass.get(i - 1);
                if (temp < temp1) {
                    temp ^= temp1;
                    temp1 ^= temp;
                    temp ^= temp1;
                    mass.set(i, temp1);
                    mass.set(i - 1, temp);
                }
            }
            left++; // увеличиваем левую границу
        } while (left <= right);

        long finish = System.nanoTime();
        long itog = finish - start;
        System.out.println("Сортировка перемешиванием=" + itog / sek);
    }

    public void rascheska() {
        long start = System.nanoTime();
        int size = mass.size();
        boolean stop = true;
        int step = (int) (size / 1.247330950103979);
        int s;
        while (step > 1 || stop) {
            stop = false;
            for (int i = 0; i < size - step; i++) {
                int t = mass.get(i);
                int t1 = mass.get(i + step);
                if (t > t1) {
                    mass.set(i, t1);
                    mass.set(i + step, t);
                    stop = true;
                }

            }
            step--;
        }
        long finish = System.nanoTime();
        long itog = finish - start;
        System.out.println("Расческа=" + itog / sek);
    }

    public void print() {
        int size = mass.size();
        for (int i = 0; i < size; i++) {
            System.out.println(mass.get(i));
        }
    }

    public void sleeps(int i) throws InterruptedException {
        long start = System.nanoTime();
        Thread.sleep(1000 * i);
        long finish = System.nanoTime();
        long itog = finish - start;
        System.out.println("sleep=" + itog / sek);
    }

    public void cl() {
        mass.clear();
    }
}
