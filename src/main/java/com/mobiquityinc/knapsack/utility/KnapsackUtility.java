package com.mobiquityinc.knapsack.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mobiquityinc.knapsack.constant.Constants;

@Component
public class KnapsackUtility {

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public int knapSack(double W, double wt[], int val[], int n) {
	    if (n == 0 || W == 0) {
	        return 0; 
	    }
	    if (wt[n-1] > W) { 
	       return knapSack(W, wt, val, n-1); 
	    }
	    else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), 
	                     knapSack(W, wt, val, n-1) 
	                      );
	}

	public String getKnapsackIndexes(int res, int W, int n, int wt[], int val[], int indices[]) {
		StringBuilder sb = new StringBuilder();
		int w = W;
		int K[][] = new int[n + 1][W + 1];
		for (int i = n; i > 0 && res > 0; i--) {
			if (res == K[i - 1][w]) {
				continue;
			} else {
				sb.append((indices[i - 1] + " "));
				res = res - val[i - 1];
				w = w - wt[i - 1];
			}
		}
		return sb.toString().trim();
	}
	
	public Map<String, Object> getStructuredData(String str) {
		Map<String, Object> map = new HashMap<String, Object>();
		String arr[] = str.split(":");
		int capaity = Integer.parseInt(arr[0].trim());
		String capacityDetailArr[] = arr[1].trim().split(" ");
		double weightArr[] = new double[capacityDetailArr.length];
		int costArr[] = new int[capacityDetailArr.length];
		int indexArr[] = new int[capacityDetailArr.length];
		for (int i = 0; i < capacityDetailArr.length; i++) {
			String detailStr = capacityDetailArr[i].replace("(", "").replace(")", "").replace("€", "");
			String detailArr[] = detailStr.split(",");
			indexArr[i] = Integer.parseInt(detailArr[0]);
			weightArr[i] = Double.parseDouble(detailArr[1]);
			costArr[i] = Integer.parseInt(detailArr[2]);
		}
		map.put(Constants.CAPACITY, capaity);
		map.put(Constants.WEIGHT, weightArr);
		map.put(Constants.COST, costArr);
		map.put(Constants.INDEX, indexArr);
		return map;
	}
}
