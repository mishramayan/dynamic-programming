class Solution {
    //static boolean[][] DP = new boolean[8][48];
    public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;

            for(int i=0; i<n; i++){
                sum += nums[i];
            }

            if(sum % 2 != 0){
                return false;
            }

            int subSetSum = sum/2;

            boolean dp[][] = new boolean[n + 1][subSetSum + 1];
            dp[0][0] = true;

            for(int i=1; i<=n; i++){
            int curr = nums[i-1];
            for(int j=0; j<=subSetSum; j++){
                if(curr > j){
                    dp[i][j] =dp[i-1][j];
                    }
                else{
                    dp[i][j] = dp[i-1][j] || (dp[i-1][j-curr]);
                    }
                }
            }
            return dp[n][subSetSum];
        }
