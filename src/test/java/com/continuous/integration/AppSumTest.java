package com.continuous.integration;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppSumTest {

	@Test
	public void addtest() {
		App junitApp=new App();
		int result= junitApp.add(200, 200);
		assertEquals(400, result);
	
	}

}
