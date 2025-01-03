import React, { useState } from 'react';
import axios from 'axios';
import './SortVisualizer.css';
import sortingService from '../services/sortingService';

/**
 * The `SortVisualizer` component provides a user interface to visualize
 * various sorting algorithms. Users can input an array or generate a random one,
 * select a sorting method, and view step-by-step progress of the sorting process.
 */
function SortVisualizer() {
  // State variables for managing array, steps, loading state, and selected sort method
  const [array, setArray] = useState([]);
  const [steps, setSteps] = useState([]);
  const [loading, setLoading] = useState(false);
  const [sortMethod, setSortMethod] = useState('bubble');

  // Available sorting options
  const sortOptions = [
    { value: 'bubble', label: 'Bubble Sort' },
    { value: 'selection', label: 'Selection Sort' },
    { value: 'insertion', label: 'Insertion Sort' },
    { value: 'merge', label: 'Merge Sort' },
    { value: 'quick', label: 'Quick Sort' },
    { value: 'radix', label: 'Radix Sort' },
  ];

  /**
   * Handles sorting of the array using the selected sort method.
   * Sends a request to the backend service to perform the sorting and
   * updates the steps for visualization.
   */
  const handleSort = async () => {
    if (!array.length) {
      alert('Please enter an array to sort!');
      return;
    }

    setLoading(true);
    try {
      // Call the selected sorting method dynamically
      const response = await sortingService[sortMethod](array);
      setSteps(response.data);
    } catch (error) {
      console.error('Error sorting the array:', error);
    }
    setLoading(false);
  };

  /**
   * Generates a random array of integers between 0 and 100.
   * Updates the state with the generated array.
   */
  const generateRandomArray = () => {
    const randomArray = Array.from({ length: 10 }, () =>
      Math.floor(Math.random() * 101)
    );
    setArray(randomArray);
  };

  /**
   * Renders the steps of the sorting process.
   * Each step includes a description message and the state of the array at that step.
   *
   * @returns {JSX.Element[]} Array of JSX elements representing sorting steps.
   */
  const renderSteps = () => {
    return steps.map((step, index) => (
      <div key={index} className="step-container">
        <p><strong>Step {index + 1}:</strong> {step.message}</p>
        <p>Array: {step.array.join(', ')}</p>
      </div>
    ));
  };

  return (
    <div className="sort-visualizer">
      <h1>Sort Visualizer</h1>
      <div className="controls">
        {/* Dropdown to select sorting method */}
        <select
          value={sortMethod}
          onChange={(e) => setSortMethod(e.target.value)}
          className="sort-method-dropdown"
        >
          {sortOptions.map((option) => (
            <option key={option.value} value={option.value}>
              {option.label}
            </option>
          ))}
        </select>
        {/* Input field for entering an array */}
        <input
          type="text"
          value={array.join(', ')}
          onChange={(e) => setArray(e.target.value.split(',').map(Number))}
          placeholder="Enter numbers separated by commas"
          className="array-input"
        />
        {/* Button to generate a random array */}
        <button onClick={generateRandomArray} className="generate-button">
          Generate Random Array
        </button>
        {/* Button to start the sorting process */}
        <button onClick={handleSort} disabled={loading} className="sort-button">
          {loading ? 'Sorting...' : 'Sort'}
        </button>
      </div>
      {/* Container to display the sorting steps */}
      <div className="steps-container">
        {steps.length > 0 && renderSteps()}
      </div>
    </div>
  );
}

export default SortVisualizer;
