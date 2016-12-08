package com.continuous.integration;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringAdd {

	@Test
	public void conCattest() {
		App junitApps=new App();
		String result= junitApps.conCat("Amit","Saini");
		assertEquals("AmitSaini", result);
	}
}
