package com.epam.rd.autotasks;
import java.util.Arrays;
class CycleSwap {
    static void cycleSwap(int[] array) {
        cycleSwap(array, 1);
    }

    static void cycleSwap(int[] array, int shift) {
        int[] arr2 = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            array[i] = arr2[(array.length + i - shift) % array.length];
        }
    }
}