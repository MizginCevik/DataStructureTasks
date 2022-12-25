package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] numbers = {16, 3, 11, 5, 15, 2};
        System.out.println(Arrays.toString(findSumOfTwoNumbersWithTwoPointer(numbers, 8)));

        System.out.println(Arrays.toString(findIndicesWithTwoPointerAndHashMap(new int[]{16, 3, 11, 5, 15, 2}, 8)));
        System.out.println(Arrays.toString(findIndicesWithTwoPointerAndTreeMap(new int[]{16, 3, 11, 5, 15, 2}, 8)));

        System.out.println(Arrays.toString(findSumOfTwoWithTwoPointer(new int[]{5, 6, 2, 13, 9, 1}, 8)));
        System.out.println(Arrays.toString(findTwoSum(new int[]{5, 6, 2, 13, 9, 1}, 8)));
        System.out.println(Arrays.toString(findTwoSumNestedLoop(new int[]{5, 6, 2, 13, 9, 1}, 8)));

    }

    public static int[] findSumOfTwoNumbersWithTwoPointer(int[] array, int target) {
        // sort the array
        Arrays.sort(array); // nlog(n)
        // create two pointers, one starts from the beginning, other one starts from the end
        int left = 0;
        int right = array.length - 1;

        while (left < right) { // n
            if (array[left] + array[right] == target) { // find the target
                return new int[]{array[left], array[right]};
            } else if (array[left] + array[right] < target) { // when sum less than target, move left pointer
                left++;
            } else { // // when sum greater than target, move right pointer
                right--;
            }
        }
        return new int[0];
    }

    public static int[] findSumOfTwoWithTwoPointer(int[] arr, int target) {
        Arrays.sort(arr);
        int slow = 0;
        int fast = 2;

        while (arr[slow] + arr[fast] != target) {
            if (arr[slow] + arr[fast] < target) {
                fast++;
            } else if (arr[slow] + arr[fast] > target) {
                fast--;
            }
            if (arr[slow] + arr[fast] != target) {
                slow++;
            }
        }
        return new int[]{arr[slow], arr[fast]};
    }

    public static int[] findIndicesWithTwoPointerAndHashMap(int[] arr, int target) {
        // create two pointers, one starts from the beginning, other one starts from the end
        int left = 0;
        int right = arr.length - 1;

        // put elements into the map to find index numbers before sorting
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) { // n
            map.put(arr[i], i);
        }

        // sort the array
        Arrays.sort(arr); // nlog(n)

        while (left < right) { // n
            if (arr[left] + arr[right] == target) {
                return new int[]{map.get(arr[left]), map.get(arr[right])};
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else right--;
        }
        return new int[0];
    }

    public static int[] findIndicesWithTwoPointerAndTreeMap(int[] arr, int target) {
        // put elements into the TreeMap to sort and keep the original index numbers of the elements
        // key: element, value: index
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) { // nlog(n)
            map.put(arr[i], i);
        }

        // get the first key and the last key and check conditions
        while (!map.firstKey().equals(map.lastKey())) { // n
            if (map.firstKey() + map.lastKey() == target) {
                return new int[]{map.firstEntry().getValue(), map.lastEntry().getValue()};
            } else if (map.firstKey() + map.lastKey() < target) {
                map.remove(map.firstKey());
            } else map.remove(map.lastKey());
        }
        return new int[0];
    }

    public static int[] findTwoSum(int[] array, int target) {
        // create map to store targetValue as key, index of targetValue as value
        Map<Integer, Integer> map = new HashMap<>();
        // iterate through array
        for (int i = 0; i < array.length; i++) { // n
            int targetValue = target - array[i]; // complement=targetValue
            if (map.containsKey(targetValue)) {
                return new int[]{map.get(targetValue), i}; // return index of targetValue and current index
            } else {
                map.put(array[i], i); // if it doesn't exist, add targetValue as key and its index as value
            }
        }
        return new int[]{};
    }

    public static int[] findTwoSumNestedLoop(int[] array, int target) {
        // Brute force
        // n^n
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return array;
    }

}
/*
-Given an array of integers nums and an integer target, return the two numbers such that they add up to target.
-Assume that each input would have exactly one solution, and you should not use the same element twice.
-You can return the answer in any order.
 */
