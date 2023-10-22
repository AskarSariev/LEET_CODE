package com.leet_code.sliding_window;

public class MaximumAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1 && k != 0) {
            return (double) nums[0] / k;
        }

        double sum = 0.0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double current = sum;

        for (int i = 1, right = k; right < nums.length; right++, i++) {
            current = current - nums[i - 1] + nums[right];
            sum = Math.max(current, sum);
        }

        return sum / k;
    }
}