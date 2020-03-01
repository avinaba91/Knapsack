package com.mobiquityinc.knapsack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.mobiquityinc.knapsack.packer.Packer;

public class CommandLineAppStartupRunner implements CommandLineRunner {
	
	@Autowired
	private Packer packer;

	@Override
	public void run(String... args) throws Exception {
		String filePath = "src/main/resources/input.txt";
		packer.pack(filePath);
	}
}
