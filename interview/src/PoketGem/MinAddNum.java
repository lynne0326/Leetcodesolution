package PoketGem;

import java.util.Arrays;

/**
 * Created by lingyanjiang on 17/3/1.
 */
public class MinAddNum {

    public static int minAddNum(int[] nums, int N) {
        if (N <= 0) return 0;
        boolean[] canForm =new boolean[N + 1];
        canForm[0] = true;
        for (int num : nums) {
            for (int i = 0; i < canForm.length; i++) {
                if (canForm[i] && i + num <= N && i != num) {
                    canForm[i + num] = true;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (!canForm[i]) {
                for (int j = 0; j < canForm.length; j++) {
                    if (canForm[j] && j + i <= N && j != i) {
                        canForm[i + j] = true;
                    }
                }
                res++;
            }
        }
        System.out.println(res);
        return res;
    }

    public static int addMinNum2(int N, int[] nums) {
        Arrays.sort(nums);
        int j = 0, sum = 0, count = 0;
        for (int i = 1; i <= N; i++) {
            while (j < nums.length && nums[j] <= i) {
                sum += nums[j++];
            }
            if (sum < i) {
                sum += i;
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        minAddNum(new int[]{1,3,111}, 9);
        addMinNum2(9, new int[]{1,3,111});
    }
}
