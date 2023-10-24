package com.leet_code.sliding_window.contains_duplicateII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        boolean res = false;

        if (k == 0) return res;

        if (nums.length == 1) return res;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], i);
            } else {
                int index = map.get(nums[i]);
                if (k >= (i - index)) {
                    res = true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return res;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (k == 0) return false;

        Set<Integer> slidingWindow = new HashSet<>();
        for (int index = 0; index < nums.length; index++) {
            if (slidingWindow.contains(nums[index]))
                return true;
            if (index >= k)
                slidingWindow.remove(nums[index - k]);
            slidingWindow.add(nums[index]);
        }
        return false;
    }
}