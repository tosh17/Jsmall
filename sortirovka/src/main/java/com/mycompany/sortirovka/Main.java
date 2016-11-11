/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sortirovka;

/**
 *
 * @author shcherbakov
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        Sortirovka s = new Sortirovka();

        Sortirovka s1;
        Sortirovka s2;
        Sortirovka s3;
        Sortirovka s4;
        int t = 1;
        for (int i = 1; i < 2; i++) {
            t = t * 10;
            System.out.println("=======Расчет для 10^" + i + " случайных чисел============");
            s.cl();
            s.generate(t);
            s1 = s;
            s2 = s;
            s3 = s;
            s4 = s;
     
           // s1.puzyrek();
           // s2.minElement();
            //s3.sort_mixer();
           // s4.rascheska();
           
        }
    }
}
