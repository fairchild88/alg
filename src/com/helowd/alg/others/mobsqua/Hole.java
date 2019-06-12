package com.helowd.alg.others.mobsqua;

/**
 * Created by fei on 2018/10/29.
 */
public class Hole {
    public static int countHoles(int num) {
        int[] holeCountArray = {1, 0, 0, 0, 1, 0, 1, 0, 2, 0};
        int holesCount = 0;
        while (num != 0) {
            holesCount += holeCountArray[num % 10];
            num = num / 10;
        }
        return holesCount;
    }

    public static void main(String[] args) {
        System.out.println(Hole.countHoles(630));
        System.out.println(Hole.countHoles(1288));
    }
}
