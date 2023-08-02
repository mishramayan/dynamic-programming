class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;

        for(int x : nums){
            sum += x;
        }

        if(sum < target || sum + target < 0 || (sum+target) % 2 != 0){
            return 0;
        }

        int s = (sum+target)/2;

        int[][] dp = new int[n+1][s+1];
        // for(int i=0; i<s+1; i++){
        //     dp[0][i] = 0;
        // }
        // for(int i=0; i<n+1; i++){
        //     dp[i][0] = 1;
        // }

        for(int i=0;i<n+1;i++){
	       for(int j=0;j<s+1;j++){
	           if(i==0)
	           dp[i][j] = 0;
	           if(j==0)
	           dp[i][j] = 1;
	        }
	    }

        for(int i=1; i<n+1; i++){
            for(int j=0; j<s+1; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-nums[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][s];
    }
}
