/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    
    
	static int[][] dp = new int[6][11];
    
	public static void main (String[] args) {
		int[] wt = {1, 3, 4, 6, 2};
		int[] val = {1, 4, 5, 7, 3};
		int n = 5;
		int W = 10;
		
		
    	for(int i=0; i<n; i++){
    	    for(int j=0; j<W; j++){
    	        if(i==0 || j == 0)
    	        dp[i][j] = 0;
    	    }
    	}
		
		int sol = knapsack(wt, val, n, W);
		
		System.out.println(sol);
	}
	
	public static int knapsack(int[] wt, int[]val, int n, int W){
	    for(int i=0; i<n+1; i++){
	        for(int j=0; j<W+1; j++){ 
        	    if(wt[n-1] <= W){
        	        dp[n][W] = Math.max(val[n-1] + dp[n-1][W-wt[n-1]], dp[n-1][W]);
        	    }
        	    else if(wt[n-1] > W){
        	        dp[n][W] = dp[n-1][W];
        	    }
	        }
	    }
	    
	    return dp[n][W];
	}
	
}	