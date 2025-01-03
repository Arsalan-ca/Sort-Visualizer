# Sorting Algorithm Visualizer

## Overview
This project is a sorting algorithm visualizer with a **React-based frontend** and a **Spring Boot backend**. It demonstrates various sorting algorithms in action by visually displaying each step of the sorting process.

## Features

### Frontend (React):
- A user-friendly interface where users can:
  - Select a sorting algorithm (e.g., Bubble Sort, Quick Sort, etc.).
  - Input an array manually or generate a random array.
  - View the sorting process step by step, including comparisons, swaps, and array updates.
- Real-time updates of the sorting steps using React components.

### Backend (Spring Boot):
- Implements sorting algorithms like:
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
  - Merge Sort
  - Quick Sort
  - Radix Sort
- Processes the input array and returns a step-by-step description of the sorting process as JSON.
- Provides REST API endpoints for each sorting algorithm.

### Integration:
- The frontend communicates with the backend via REST API calls to retrieve the sorting steps for the selected algorithm.

## Technology Stack

### Frontend:
- **React**: For the user interface.
- **CSS**: For styling the components.
- **Axios**: For making HTTP requests to the backend.

### Backend:
- **Spring Boot**: A Java framework for building REST APIs.
- **Java**: For implementing the sorting logic.
- **REST API**: For communication between the frontend and backend.

## How It Works

### User Interaction:
1. The user selects a sorting algorithm and inputs or generates an array.
2. The user clicks the "Sort" button to start the sorting process.

### Backend Processing:
1. The selected algorithm is executed on the backend.
2. For each step of the algorithm (e.g., comparisons, swaps), the backend generates a `Step` object containing:
   - The current state of the array.
   - A description of the operation performed.

### Frontend Display:
1. The steps are returned to the frontend as JSON.
2. React renders each step, showing the description and the current array state, giving the user a visual understanding of the sorting process.

## Use Cases
- **Educational Tool**: Helps users understand how sorting algorithms work by visualizing their steps.
- **Learning Aid**: A hands-on way to learn and compare the efficiency of different sorting algorithms.
- **Demonstration**: A showcase of how frontend and backend systems can integrate seamlessly.

## Example Flow
1. The user selects **Bubble Sort** and inputs `[5, 3, 8, 6]`.
2. The frontend sends the array to the backend's `/bubble` API.
3. The backend processes the array using Bubble Sort and returns the following steps:
   - **Step 1**: Comparing 5 and 3.
   - **Step 2**: Swapped 5 and 3.
   - ...
4. The frontend displays these steps sequentially, showing how the array changes after each operation.

## Conclusion
This project is a practical example of integrating frontend and backend technologies to create an interactive and educational application. It serves as an excellent learning tool for understanding sorting algorithms and demonstrates the power of React and Spring Boot in building cohesive applications.



[Link to the video](https://youtu.be/_8JkWBxQyYk)
