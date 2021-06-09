package com.TestLottoApp.junit5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class TestCommonClass {

	
	@Order(1) 
	@DisplayName("Testing valid range...")
	@ParameterizedTest(name = "{index} => prizes= {1}, arraySize= {5}")
	@CsvSource({
        "10, 15",
        "8,  8",
        "20, 21"
    })
//	public static boolean validateRange(int prizes , int arraySize)
	public void validateRange(int prizes , int arraySize)
	{
       	boolean test = true;
       	
       	if (prizes <= arraySize) {
       		test = true;
       	}
       	else {
       		test = false;
	    }
    	assertTrue(test) ;
     	System.out.println( test );

    }
	//return test;
  

	// Tested OK

	@Order(2) 
	@DisplayName("Testing the random parameters ...")	
    @ParameterizedTest(name = "{index} => minVal= {0}, maxVal= {5}")
    @CsvSource({
    	"0, 9",
    	"0, 100",
    	"0, 25"
    })

//	//public int getRandom(int minVal, int maxVal) {
    public  void getRandom(int minVal, int maxVal) {

//    	return (int) ((Math.random() * (maxVal - minVal)) + minVal); 
    	int res = (int) ((Math.random() * (maxVal - minVal)) + minVal);
    	System.out.println( res);
	}

	
	  // Validate if any file exists.
	    @Order(3) 
		@DisplayName("Testing if file exists ...")
	    @ParameterizedTest
	    @ValueSource(strings = {"C:\\LotteryApp\\Files\\Participants.txt"})
		public void fileExists(String fileName)
		{
		   boolean test = false;
		
		   File tempFile = new File(fileName);
		   test = tempFile.exists();
		 
	       if (tempFile.exists() == true)
	       {
	    	   test = true;
	       }
	       else
	       {
	    	   test = false;
	       }
	       assertTrue(test);
	      System.out.println(test);
//	       return test;
	    }
	
}

