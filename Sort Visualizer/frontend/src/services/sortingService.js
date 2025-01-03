import axios from 'axios';

/**
 * The `sortingService` module provides methods to interact with
 * a backend API for performing various sorting algorithms.
 *
 * Each method sends a POST request to the server with an array to be sorted.
 * The server processes the request and returns the sorted steps.
 *
 * @module sortingService
 */

const API_URL = 'http://localhost:8080/api/sort';

/**
 * Service object containing methods for different sorting algorithms.
 */
const sortingService = {
  /**
   * Sends a POST request to perform bubble sort on the array.
   * @param {number[]} array - The array to be sorted.
   * @returns {Promise} Axios Promise resolving to the server's response.
   */
  bubble: (array) => axios.post(`${API_URL}/bubble`, array),

  /**
   * Sends a POST request to perform selection sort on the array.
   * @param {number[]} array - The array to be sorted.
   * @returns {Promise} Axios Promise resolving to the server's response.
   */
  selection: (array) => axios.post(`${API_URL}/selectionSort`, array),

  /**
   * Sends a POST request to perform insertion sort on the array.
   * @param {number[]} array - The array to be sorted.
   * @returns {Promise} Axios Promise resolving to the server's response.
   */
  insertion: (array) => axios.post(`${API_URL}/insertionSort`, array),

  /**
   * Sends a POST request to perform merge sort on the array.
   * @param {number[]} array - The array to be sorted.
   * @returns {Promise} Axios Promise resolving to the server's response.
   */
  merge: (array) => axios.post(`${API_URL}/mergeSort`, array),

  /**
   * Sends a POST request to perform quick sort on the array.
   * @param {number[]} array - The array to be sorted.
   * @returns {Promise} Axios Promise resolving to the server's response.
   */
  quick: (array) => axios.post(`${API_URL}/quickSort`, array),

  /**
   * Sends a POST request to perform radix sort on the array.
   * @param {number[]} array - The array to be sorted.
   * @returns {Promise} Axios Promise resolving to the server's response.
   */
  radix: (array) => axios.post(`${API_URL}/radixSort`, array),
};

export default sortingService;
