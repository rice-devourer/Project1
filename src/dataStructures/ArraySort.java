package dataStructures;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {
        int[] nums = {71,44,48,63,9,54,72,85,97,77,21,33,37,38,10,54,16,25,89,14};
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("Valid? " + validate(nums));
    }

    public static int[] sort(int[] nums){
        int size = nums.length;
        boolean switched;
        for (int i = 0; i<size-1;i++){
            switched = false;
            for (int j = 0; j<size-i-1;j++){
                if(nums[j]<nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    switched = true;
                }
            } if (!switched){
                break;
            }
        }


        return nums;
    }

    public static boolean validate(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] < nums[i+1]) {
                return false;
            }
        }
        return true;
    }
}
