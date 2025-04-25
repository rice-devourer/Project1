package complexity;

import java.util.Arrays;
import java.util.function.BiFunction;

public class SearchAlgo {

    public static void main(String[] args) {

        System.out.println("Testing linear search");
        testSearch(SearchAlgo::linearSearch);
        System.out.println("Testing binary search");
        testSearch(SearchAlgo::binarySearch);
    }

    public static void testSearch(BiFunction<int[], Integer, Integer> function) {
        for (int n = 1; n <= 100000; n *= 10) {
            int[] arr = random(n);
            Arrays.sort(arr);
            long startTime = System.nanoTime();
            int index = function.apply(arr, -1);
            long duration = System.nanoTime() - startTime;
            System.out.println("Input of size " + n + " returned " + index + " in " + duration + " nanoseconds.");
        }
    }

    public static int[] random(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
        }
        return array;
    }

    public static int linearSearch(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return i; // Return the index, not the value
            }
        }
        return -1;
    }

    public static int binarySearch(int[] sortedArray, int value) {
        int left = 0, right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] == value) {
                return mid; // Return index if found
            } else if (sortedArray[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Value not found
    }
}
