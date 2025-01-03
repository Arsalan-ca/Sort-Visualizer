package com.example.demo.model;

/**
 * The Step class represents a single step in the process of sorting an array.
 * It holds the current state of the array and a descriptive message explaining
 * the specific operation performed at that step.
 */
public class Step {

    /** The current state of the array at a given step. */
    private int[] array;

    /** A descriptive message for the operation performed at this step. */
    private String message;

    /**
     * Constructs a Step object with the given array and message.
     *
     * @param array  The current state of the array.
     * @param message A descriptive message about the operation.
     */
    public Step(int[] array, String message) {
        this.array = array.clone(); // Clone to avoid mutation
        this.message = message;
    }

    /**
     * Retrieves the current state of the array.
     *
     * @return The current array.
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Sets the current state of the array.
     *
     * @param array The new array state.
     */
    public void setArray(int[] array) {
        this.array = array;
    }

    /**
     * Retrieves the descriptive message for the operation.
     *
     * @return The message explaining the operation at this step.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets a new descriptive message for the operation.
     *
     * @param message The new message explaining the operation.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
