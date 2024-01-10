package com.example.mergesort;
public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // mergeSort method
    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }
        //partition the array
        int mid = (start + end) / 2;
        //left side of the array
        mergeSort(input, start, mid);
        //right side of the array
        mergeSort(input, mid, end);
        //merging both sides that are already sorted
        merge(input, start, mid, end);
    }

    // merge method
    public static void merge(int[] input, int start, int mid, int end) {

        if(input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        //compare left and right arrays
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
