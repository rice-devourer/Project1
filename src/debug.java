import java.util.Arrays;

public class debug {
    public static int[] fix34(int[] nums) {
        for (int i = 0;i<nums.length;i++){
            if (nums[i]==3){
                for (int j = 0;j<nums.length;j++){
                    if ((nums[j] == 4)&&(nums[j-1]!=3)){
                        int temp = nums[i+1];
                        nums[i+1] = 4;
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
        return nums;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(fix34(new int[]{5, 3, 5, 4, 5, 4, 5, 4, 3, 5, 3, 5})));
    }//[5, 3, 4, 5, 5, 5, 5, 5, 3, 4, 3, 4]
}
