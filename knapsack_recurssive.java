/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class knap {
	public static void main (String[] args) {
		int[] wt = {1, 3, 4, 6, 2};
		int[] val = {1, 4, 5, 7, 3};
		int n = 4;
		int W = 10;
		
		int sol = knapsack(wt, val, n, W);
		
		System.out.println(sol);
	}
	
	public static int knapsack(int[] wt, int[]val, int n, int W){
	    if(n == 0 || W == 0){
	        return 0;
	    }
	    
	    if(wt[n-1] <= W){
	        return Math.max(val[n-1] + knapsack(wt, val, n-1, W-wt[n-1]), 
	        knapsack(wt, val, n-1, W));
	    }
	    
	    else if(wt[n-1] > W){
	        return knapsack(wt, val, n-1, W);
	    }
	    
	    return -1;
	}
	
}	
