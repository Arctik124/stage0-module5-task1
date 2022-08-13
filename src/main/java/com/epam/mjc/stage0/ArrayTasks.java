package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"winter", "spring", "summer", "autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number)
                return i;
        }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reverse = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverse[i] = arr[arr.length - i - 1];
        }
        return reverse;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                len++;
        }
        int[] pos = new int[len];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                pos[--len] = arr[i];
            }
        }
        return pos;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            mergeSort(arr[i]);
        }
        mergeSort(arr);
        return arr;
    }



    private int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return arr;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right, mid, n - mid);
        return arr;
    }

    private void merge(int[] arr, int[] left, int[] right, int leftBound, int rightBound) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;
        while (leftIndex < leftBound && rightIndex < rightBound) {
            if (left[leftIndex] > right[rightIndex]) {
                arr[arrIndex++] = left[leftIndex++];
            } else {
                arr[arrIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < leftBound) {
            arr[arrIndex++] = left[leftIndex++];
        }

        while (rightIndex < rightBound) {
            arr[arrIndex++] = right[rightIndex++];
        }
    }

    private int[][] mergeSort(int[][] arr) {
        int n = arr.length;
        if (n < 2) {
            return arr;
        }
        int mid = n / 2;
        int[][] left = new int[mid][1];
        int[][] right = new int[n - mid][1];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, right, left, n-mid, mid);
        return arr;
    }

    private void merge(int[][] arr, int[][] left, int[][] right, int leftBound, int rightBound) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;
        while (leftIndex < leftBound && rightIndex < rightBound) {
            if (left[leftIndex].length < right[rightIndex].length) {
                arr[arrIndex++] = left[leftIndex++];
            } else {
                arr[arrIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < leftBound) {
            arr[arrIndex++] = left[leftIndex++];
        }

        while (rightIndex < rightBound) {
            arr[arrIndex++] = right[rightIndex++];
        }
    }

}
