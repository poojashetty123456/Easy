package javacode;


import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Initialize candidates and their counters
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Phase 1: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Check if candidates appear more than n/3 times
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 5, 5, 5, 1, 2, 2, 2};
        List<Integer> result = majorityElement(nums);

        // Print the result
        System.out.println(result);
    }
}
