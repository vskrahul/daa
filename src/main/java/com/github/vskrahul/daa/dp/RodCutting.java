package com.github.vskrahul.daa.dp;

import java.time.Duration;
import java.time.LocalDateTime;

import com.github.vskrahul.daa.utils.StringUtils;

public class RodCutting {

	private int[] prices = null;
	Integer[] maxPriceStore = null;
	String[] maxPriceSizes = null;
	
	public RodCutting(int[] prices) {
		this.prices = prices;
		this.maxPriceStore = new Integer[this.prices.length + 1];
		this.maxPriceSizes = new String[this.prices.length + 1];
		this.maxPriceStore[0] = 0;
		this.maxPriceSizes[0] = "";
	}
	
	public int maxPrice(int length) {
		if(length > prices.length)
			throw new RuntimeException("Prices is not available for given length Rod.");
		return cutRod(this.prices, length);
	}
	
	/**
	 * Running time = {@code O(2^n)}
	 * 
	 * @param p
	 * @param n
	 * @return
	 */
	public int cutRod(int[] p, int n) {
		if(n == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, p[i] + cutRod(p, n - i - 1));
		}
		return max;
	}
	
	/**
	 * Running time = {@code O(n)}
	 * 
	 * @param p
	 * @param n
	 * @return
	 */
	public int cutRodDp(int[] p, int n) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			int temp = 0;
			if(maxPriceStore[n - i - 1] != null)
				temp = p[i] + maxPriceStore[n - i - 1];
			else
				temp = p[i] + cutRodDp(p, n - i - 1);
			if(temp > max) {
				max = temp;
				this.maxPriceSizes[n] = StringUtils.concat("+", ""+(i + 1), this.maxPriceSizes[n - i - 1]);
			}
		}
		// store the result for parameter n
		maxPriceStore[n] = max;
		return max;
	}
	
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		RodCutting rodCutting = new RodCutting(prices);
		
		final int pipeLength = 40;
		
		int price = rodCutting.maxPrice(pipeLength);
		
		long duration = Duration.between(startTime, LocalDateTime.now()).toMillis();
		
		System.out.println("Execution Time = " + duration);
		System.out.println("Max Price = " + price);
		System.out.println(rodCutting.maxPriceSizes[pipeLength]);
	}

}
