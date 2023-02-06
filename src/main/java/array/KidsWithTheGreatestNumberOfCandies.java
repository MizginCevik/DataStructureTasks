package array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {

        System.out.println(hasGreatestNumberOfCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(hasGreatestNumberOfCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(hasGreatestNumberOfCandies(new int[]{12, 1, 12}, 10));

    }

    public static List<Boolean> hasGreatestNumberOfCandies(int[] arr, int extraCandies) {

        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] + extraCandies < arr[j]) {
                    result.add(false);
                    break;
                }
            }
            if (result.size() == i) {
                result.add(true);
            }
        }
        return result;
    }

}
