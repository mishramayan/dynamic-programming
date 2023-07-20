/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    
    
	static int[][] dp = new int[6][11];
    
	public static void main (String[] args) {
		System.out.println("GfG!");
		int[] wt = {1, 3, 4, 6, 2};
		int[] val = {1, 4, 5, 7, 3};
		int n = 5;
		int W = 10;
		
		
    	for(int i=0; i<6; i++){
    	    for(int j=0; j<11; j++){
    	        dp[i][j] = -1;
    	    }
    	}
		
		int sol = knapsack(wt, val, n, W);
		
		System.out.println(sol);
	}
	
	public static int knapsack(int[] wt, int[]val, int n, int W){
	    if(n == 0 || W == 0){
	        return 0;
	    }
	    
	   if(dp[n][W] != -1){
	       return dp[n][W];
	   }
	    
	    if(wt[n-1] <= W){
	        return dp[n][W] = Math.max(val[n-1] + knapsack(wt, val, n-1, W-wt[n-1]), 
	        knapsack(wt, val, n-1, W));
	    }
	    
	    else if(wt[n-1] > W){
	        return dp[n][W] = knapsack(wt, val, n-1, W);
	    }
	    
	    return -1;
	}
	
}	