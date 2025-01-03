package com.example.demo.controller;

import com.example.demo.model.Step;
import com.example.demo.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AlgorithmController is a REST controller responsible for handling requests
 * related to various sorting algorithms. It uses a SortingService to perform
 * the sorting operations and returns the steps involved in sorting an array.
 *
 * The controller supports the following sorting algorithms:
 * - Bubble Sort
 * - Insertion Sort
 * - Selection Sort
 * - Radix Sort
 * - Merge Sort
 * - Quick Sort
 *
 * Each sorting method is exposed as a POST endpoint, accepting an integer array
 * as input and returning a list of Step objects representing each step in the
 * sorting process.
 *
 * Exception handling is implemented to catch and log any errors that occur
 * during sorting operations, throwing a RuntimeException with the error message.
 *
 * @RestController - Indicates that this class handles RESTful web service requests.
 * @RequestMapping("/api/sort") - Maps this controller to the base URI "/api/sort".
 * @CrossOrigin(origins = "http://localhost:3000") - Allows cross-origin requests
 *                                               from the specified frontend.
 *
 * @see SortingService
 * @see Step
 */
@RestController
@RequestMapping("/api/sort")
@CrossOrigin(origins = "http://localhost:3000")
public class AlgorithmController {

    @Autowired
    private SortingService sortingService;

    /**
     * Handles a POST request for Bubble Sort.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the bubble sort process.
     * @throws RuntimeException if any error occurs during sorting.
     */
    @PostMapping("/bubble")
    public List<Step> bubbleSort(@RequestBody int[] array) {
        try {
            return sortingService.bubbleSort(array);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error in the console
            throw new RuntimeException("Error in bubbleSort: " + e.getMessage());
        }
    }

    /**
     * Handles a POST request for Insertion Sort.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the insertion sort process.
     * @throws RuntimeException if any error occurs during sorting.
     */
    @PostMapping("/insertionSort")
    public List<Step> insertionSort(@RequestBody int[] array) {
        try {
            return sortingService.insertionSort(array);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error in the console
            throw new RuntimeException("Error in insertionSort: " + e.getMessage());
        }
    }

    /**
     * Handles a POST request for Selection Sort.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the selection sort process.
     * @throws RuntimeException if any error occurs during sorting.
     */
    @PostMapping("/selectionSort")
    public List<Step> selectionSort(@RequestBody int[] array) {
        try {
            return sortingService.selectionSort(array);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error in the console
            throw new RuntimeException("Error in selectionSort: " + e.getMessage());
        }
    }

    /**
     * Handles a POST request for Radix Sort.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the radix sort process.
     * @throws RuntimeException if any error occurs during sorting.
     */
    @PostMapping("/radixSort")
    public List<Step> radixSort(@RequestBody int[] array) {
        try {
            return sortingService.radixSort(array);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error in the console
            throw new RuntimeException("Error in radixSort: " + e.getMessage());
        }
    }

    /**
     * Handles a POST request for Merge Sort.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the merge sort process.
     * @throws RuntimeException if any error occurs during sorting.
     */
    @PostMapping("/mergeSort")
    public List<Step> mergeSort(@RequestBody int[] array) {
        try {
            return sortingService.mergeSort(array);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error in the console
            throw new RuntimeException("Error in mergeSort: " + e.getMessage());
        }
    }

    /**
     * Handles a POST request for Quick Sort.
     *
     * @param array an integer array to be sorted.
     * @return a list of Step objects showing each step of the quick sort process.
     * @throws RuntimeException if any error occurs during sorting.
     */
    @PostMapping("/quickSort")
    public List<Step> quickSort(@RequestBody int[] array) {
        try {
            return sortingService.quickSort(array);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error in the console
            throw new RuntimeException("Error in quickSort: " + e.getMessage());
        }
    }

    /**
     * A simple endpoint to test if the Spring Boot application is running.
     *
     * @return a confirmation message indicating that the application is working.
     */
    @GetMapping("/test")
    public String testEndpoint() {
        return "Spring Boot is working!";
    }
}
