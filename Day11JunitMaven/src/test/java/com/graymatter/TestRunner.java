package com.graymatter;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//Ruuniing all tests

@SuiteClasses({App1Test.class, TestJunitMethods.class})
@IncludeCategory(MarkerInterface.class)
@RunWith(Categories.class)
public class TestRunner {

}
