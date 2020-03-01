package com.mobiquityinc.knapsack.utility;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobiquityinc.knapsack.constant.Constants;

@SpringBootTest
public class KnapsackUtilityTest {
	
	@Autowired
	KnapsackUtility knapsackUtility;
	
	
	@Test
	public void testKnapsack() {
		
	}
	
	@Test
	public void testgetStructuredData() {
		String line = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
		Map<String, Object> map = knapsackUtility.getStructuredData(line);
		assertTrue((Integer)map.get(Constants.CAPACITY) == 81);
	}
	
	@Test
	public void testknapSack() {
		int val[] = new int[]{45, 98,3,76,9,48}; 
	    double wt[] = new double[]{53.38,88.62,78.48,72.30,30.18,46.34}; 
	    int  W = 81; 
	    int n = val.length;
	    assertTrue(76 == knapsackUtility.knapSack(W, wt, val, n));
	}
	
	@Test
	public void testgetKnapsackIndexes() {
		int val[] = new int[]{45, 98,3,76,9,48}; 
	    int wt[] = new int[]{53,88,78,72,30,46};
	    int indices[] = new int[] {1,2,3,4,5,6};
		int  W = 81; 
	    int n = val.length;
		String indicesStr = knapsackUtility.getKnapsackIndexes(76, W, n, wt, val, indices);
	}
}
