package com.helowd.alg.others.fb;

/**
 * Created by fei on 2018/10/23.
 */
public class MergeSortedArray {

    Integer[] mergeSortedArray(Integer[] arrayA, Integer[] arrayB) {

        int notNullIndex = arrayA.length - arrayB.length - 1;
        int aIndex = notNullIndex; // 0
        int bIndex = arrayB.length - 1; // 0
        for (int i = arrayA.length - 1; i > 0; i--) {
            if ( arrayA[aIndex] < arrayB[bIndex] ) {
                arrayA[i] = arrayB[bIndex];
                bIndex--;
            } else {
                arrayA[i] = arrayA[aIndex];
                aIndex--; //-1
            }
            if (bIndex < 0) {
                break;
            }
        }

        if ( aIndex < 0 && bIndex == 0 ) {
            arrayA[0] = arrayB[0];
        }

        return arrayA;
    }

    public static void main(String[] args) {
        Integer[] arrayA = {0 , null};
        Integer[] arrayB = {-1};

        MergeSortedArray array = new MergeSortedArray();
        for (Object o : array.mergeSortedArray(arrayA, arrayB)) {
            System.out.println( o + "->");
        }

    }
}
