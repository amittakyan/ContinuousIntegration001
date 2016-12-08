package com.continuous.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppSumTest.class, TestStringAdd.class })
public class RunAllTests {

}
