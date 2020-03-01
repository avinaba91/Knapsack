package com.mobiquityinc.knapsack.packer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobiquityinc.knapsack.exception.APIException;
import com.mobiquityinc.knapsack.service.KnapsackService;

@Component
public class Packer {
	
	@Autowired
	KnapsackService knapsackService;

	public String pack(String filePath) throws APIException {
		StringBuilder sb = new StringBuilder();
		File file = new File(filePath);
		Scanner sc;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new APIException("Exception while reading the file from file path : " + filePath);
		}
		while (sc.hasNextLine()) {
			sb.append(knapsackService.getIndexes(sc.nextLine()));
			sb.append("\n");
		}
		return sb.toString();
	}
}
