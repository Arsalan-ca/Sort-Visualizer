package com.example.demo.service;

import com.example.demo.model.Step;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SortingService is a service class responsible for implementing various
 * sorting algorithms. It provides methods for Bubble Sort, Insertion Sort,
 * Selection Sort, Radix Sort, Merge Sort, and Quick Sort. Each sorting method
 * takes an integer array as input and returns a list of Step objects that represent
 * each intermediate step of the sorting process.
 *
 * The class uses a variety of helper methods to perform sorting and manage the
 * sorting steps for visualization purposes.
 *
 * @Service - Indicates that this class is a Spring service component.
 *
 * @see Step
 */
@Service
public class SortingService {

    /**
     * Performs Bubble Sort on the given array.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the bubble sort process.
     */
    public List<Step> bubbleSort(int[] array) {
        List<Step> steps = new ArrayList<>();
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps.add(new Step(array, "Comparing: " + array[j] + " and " + array[j + 1]));

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    steps.add(new Step(array, "Swapped: " + array[j] + " and " + array[j + 1]));
                }
            }
        }
        steps.add(new Step(array, "Final sorted array."));
        return steps;
    }

    /**
     * Performs Insertion Sort on the given array.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the insertion sort process.
     */
    public List<Step> insertionSort(int[] array) {
        List<Step> steps = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int scan = i - 1;

            steps.add(new Step(array.clone(), "Starting pass: Insert " + key + " at correct position."));

            while (scan >= 0 && array[scan] > key) {
                steps.add(new Step(array.clone(), "Comparing: " + array[scan] + " and " + key));
                array[scan + 1] = array[scan]; // Shift larger element to the right
                steps.add(new Step(array.clone(), "Shifted: " + array[scan] + " to position " + (scan + 1)));
                scan--;
            }
            array[scan + 1] = key; // Insert the key in the correct position
            steps.add(new Step(array.clone(), "Inserted: " + key + " at position " + (scan + 1)));
        }
        steps.add(new Step(array.clone(), "Final sorted array."));
        return steps;
    }

    /**
     * Performs Selection Sort on the given array.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the selection sort process.
     */
    public List<Step> selectionSort(int[] array){
        List<Step> steps = new ArrayList<>();
        int n = array.length;

        for(int i=0; i < n-1; i++){
            int minIndex = i;

            for(int j = i+1; j < n; j++){
                steps.add(new Step(array, "Comparing: " + array[j] + " and " + array[minIndex]));
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                steps.add(new Step(array, "Swapped: " + array[i] + " and " + array[minIndex]));
            }
        }
        steps.add(new Step(array, "Final sorted array."));
        return steps;
    }

    /**
     * Performs Radix Sort on the given array.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the radix sort process.
     */
    public List<Step> radixSort(int[] array){
        List<Step> steps = new ArrayList<>();
        int max = Arrays.stream(array).max().getAsInt();
        int exp = 1;

        while(max / exp > 0){
            int[] output = new int[array.length];
            int[] count = new int[10];

            for(int num : array){
                count[(num / exp) %10]++;
            }
            steps.add(new Step(array, "Counting digits at exp " + exp));
            for(int i= array.length - 1; i >= 0; i--){
                output[--count[(array[i] / exp) % 10]] = array[i];
            }
            System.arraycopy(output, 0, array, 0, array.length);
            steps.add(new Step(array, "Array after sorting by digit at exp " + exp));

            exp *= 10;
        }
        steps.add(new Step(array, "Final sorted array."));
        return steps;
    }

    /**
     * Performs Merge Sort on the given array.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the merge sort process.
     */
    public List<Step> mergeSort(int[] array){
        List<Step> steps = new ArrayList<>();
        mergeSortPart2(array, 0, array.length -1, steps);
        steps.add(new Step(array, "Final sorted array."));
        return steps;
    }

    /**
     * Helper method for recursively sorting and merging arrays during merge sort.
     *
     * @param array the integer array to be sorted.
     * @param left the starting index of the left subarray.
     * @param right the ending index of the right subarray.
     * @param steps a list of Step objects for visualizing the sorting process.
     */
    private void mergeSortPart2(int[] array, int left, int right, List<Step> steps){
        if(left < right){
            int mid = (left + right) / 2;

            mergeSortPart2(array, left, mid, steps);
            mergeSortPart2(array, mid +1, right, steps);
            merge(array, left, mid, right, steps);
        }
    }

    /**
     * Helper method for merging two sorted subarrays during merge sort.
     *
     * @param array the integer array to be sorted.
     * @param left the starting index of the left subarray.
     * @param mid the midpoint index where the left subarray ends.
     * @param right the ending index of the right subarray.
     * @param steps a list of Step objects for visualizing the sorting process.
     */
    private void merge(int[] array, int left, int mid, int right, List<Step> steps){
        int n1 = mid - left +1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid +1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2){
            steps.add(new Step(array, "Comparing: " + leftArray[i] + " and " + rightArray[j]));
            if(leftArray[i] <= rightArray[j]){
                array[k++] = leftArray[i++];
            } else{
                array[k++] = rightArray[j++];
            }
        }

        while(i < n1){
            array[k++] = leftArray[i++];
        }

        while(j < n2){
            array[k++] = rightArray[j++];
        }
        steps.add(new Step(array, "Merged: " + Arrays.toString(array)));
    }

    /**
     * Performs Quick Sort on the given array.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the quick sort process.
     */
    public List<Step> quickSort(int[] array){
        List<Step> steps = new ArrayList<>();
        quickSortPart2(array, 0, array.length -1, steps);
        steps.add(new Step(array, "Final sorted array."));
        return steps;
    }

    /**
     * Helper method for recursively sorting using quick sort.
     *
     * @param array the integer array to be sorted.
     * @param low the starting index of the subarray.
     * @param high the ending index of the subarray.
     * @param steps a list of Step objects for visualizing the sorting process.
     */
    private void quickSortPart2(int[] array, int low, int high, List<Step> steps){
        if(low < high){
            int pi = partition(array, low, high, steps);

            quickSortPart2(array, low, pi -1, steps);
            quickSortPart2(array, pi +1, high, steps);
        }
    }

    /**
     * Helper method for partitioning the array during quick sort.
     *
     * @param array the integer array to be sorted.
     * @param low the starting index of the subarray.
     * @param high the ending index of the subarray.
     * @param steps a list of Step objects for visualizing the sorting process.
     * @return the partition index.
     */
    private int partition(int[] array, int low, int high, List<Step> steps){
        int pivot = array[high];
        steps.add(new Step(array, "Pivot selected: " + pivot));
        int i = low -1;

        for(int j = low; j < high; j++){
            steps.add(new Step(array, "Comparing: " + array[j] + " and " + pivot));
            if(array[j] <= pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                steps.add(new Step(array, "Swapped: " + array[i] + " and " + array[j]));
            }
        }

        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        steps.add(new Step(array, "Swapped pivot: " + array[i + 1] + " with " + array[high]));

        return i + 1;
    }
}
