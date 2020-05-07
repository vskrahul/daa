package com.github.vskrahul.daa.problems.array;

import java.util.Arrays;

public class MaximumContigousSubArray {

	public static void main(String[] args) {
		//int[] arr = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		int[] arr = new int[]{-10, -2, -3, -100};
		int[] result = findMaximumSubArray(arr);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] findMaxCrossingSubArray(int[] arr, int low, int mid, int high) {
		
		int sumLeft = Integer.MIN_VALUE;
		int maxLeft = -1;
		int sum = 0;
		
		for(int i = mid; i >= low; i--) {
			sum += arr[i];
			if(sum > sumLeft) {
				sumLeft = sum;
				maxLeft = i;
			}
		}
		sum = 0;
		int sumRight = Integer.MIN_VALUE;
		int maxRight = -1;
		
		for(int i = mid + 1; i <= high; i++) {
			sum += arr[i];
			if(sum > sumRight) {
				sumRight = sum;
				maxRight = i;
			}
		}
		return new int[]{maxLeft, maxRight, sumLeft + sumRight};
	}
	
	public static int[] findMaximumSubArray(int[] arr, int low, int high) {
		
		if(low == high) {
			return new int[]{low, high, arr[low]};
		}
		
		int mid = (low + high)/2;
		
		int[] LEFT = findMaximumSubArray(arr, low, mid); 
		int[] RIGHT = findMaximumSubArray(arr, mid + 1, high);
		int[] CROSS = findMaxCrossingSubArray(arr, low, mid, high);
		
		if(LEFT[2] > RIGHT[2] && LEFT[2] > CROSS[2]) {
			return LEFT;
		}
		if(RIGHT[2] > LEFT[2] && RIGHT[2] > CROSS[2]) {
			return RIGHT;
		}
		return CROSS;
	}
	
	public static int[] findMaximumSubArray(int[] arr) {
		return findMaximumSubArray(arr, 0, arr.length - 1);
	}

}
