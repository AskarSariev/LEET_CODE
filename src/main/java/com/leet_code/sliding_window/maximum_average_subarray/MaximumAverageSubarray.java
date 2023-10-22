package com.leet_code.sliding_window.maximum_average_subarray;

public class MaximumAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        // Считаем сумму первого окна
        double sum = 0.0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double result = sum; // Храним максимальную сумму

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Добавляем вошедший/убираем ушедший
            result = Math.max(result, sum);
        }

        return result / k;
    }
}