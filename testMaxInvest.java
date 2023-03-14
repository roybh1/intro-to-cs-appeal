import java.util.Arrays;

public class testMaxInvest{
    public static void main(String[] args) throws Exception {
        int[][] testArrs = generateTestArrs(10, 10000000, 10);
        for (int[] arr : testArrs) {
            int res = maxInvest(arr);
            int resOfficial = maxInvestOfficial(arr);
            if (res != resOfficial) {
                throw (new Exception("FAILED. arr: " + Arrays.toString(arr) + " res: " + res + " while the official is: " + resOfficial));
            }
            // Uncomment to see the arrays and results. WARNING adds significant runtime overhead

            //else {
            //    System.out.println("Array: " + Arrays.toString(arr) + " Worked. Result: " + maxInvest(arr));
            //}
        }
        System.out.println("DONE");
    }

    public static int[][] generateTestArrs(int maxVal, int arrCount, int valCount) {
        int[][] arrs = new int[arrCount][valCount];
        for (int i = 0; i < arrCount; i++) {
            int[] arr = new int[valCount];
            for (int j = 0; j < valCount; j++) {
                arr[j] = (int) (maxVal * Math.random());
            }
            arrs[i] = arr;
        }
        return arrs;
    }

    public static int maxInvestOfficial(int[] nums) { 
        return maxInvestOfficial(nums, nums.length -1);
    }

    public static int maxInvestOfficial(int[] nums, int i){
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return nums[0];
        }
        if (i == 1) { 
            return Math.max(nums[0], nums[1]);
        }
        int firstOpt = maxInvestOfficial(nums, i-2) + nums[i];
        int secondOpt = maxInvestOfficial(nums, i-1);
        return Math.max(firstOpt, secondOpt);
    }

    public static int maxInvest(int[] nums) {
        return maxInvest(nums, nums.length -1);
    }

    public static int maxInvest(int[] nums, int i){
        if (i == 0) {
            return nums[0];
        } else {
            if (i < 0) {
                return 0;
            }
        }
        int firstOpt = maxInvest(nums, i-2) + nums[i];
        int secondOpt = maxInvest(nums, i-3) + nums[i-1];
        return Math.max(firstOpt, secondOpt);
    }
}
