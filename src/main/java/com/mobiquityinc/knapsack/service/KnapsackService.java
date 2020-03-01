package com.mobiquityinc.knapsack.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiquityinc.knapsack.constant.Constants;
import com.mobiquityinc.knapsack.exception.APIException;
import com.mobiquityinc.knapsack.utility.KnapsackUtility;

@Service
public class KnapsackService {

	@Autowired
	KnapsackUtility knapsackUtility;

	public String getIndexes(String line) {
		Map<String, Object> map = knapsackUtility.getStructuredData(line);
		int val[] = (int[]) map.get(Constants.COST);
		int wt[] = (int[]) map.get(Constants.WEIGHT);
		int indices[] = (int[]) map.get(Constants.INDEX);
		int W = (Integer) map.get(Constants.CAPACITY);
		int n = indices.length;
		int maxCapacityValue = knapsackUtility.knapSack(W, wt, val, n);
		if (maxCapacityValue == 0) {
			return "-";
		}
		return knapsackUtility.getKnapsackIndexes(maxCapacityValue, W, val.length, wt, val, indices);
	}

	private void validation(int val[], int wt[], int indices[], int W) throws APIException {
		if (W > 100) {
			throw new APIException("Max weight that a package can take is ≤ 100");
		}
		if (indices.length > 15) {
			throw new APIException("There might be up to 15 items you need to choose from");
		}
		if (max(wt) > 100) {
			throw new APIException("Max weight of an item is ≤ 100");
		}
		if (max(val) > 100) {
			throw new APIException("Max cost of an item is ≤ 100");
		}
	}

	private int max(int arr[]) {
		int i;
		int max = arr[0];
		for (i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
}
