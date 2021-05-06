package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// ===================================================
		// Quiz
		//==================================================
		

		String[] alumns = {"Toni", "Bryan", "Chris", "Shelby", "Alex", "Tyler", "Erin", "Ben", "Tiffany", "Sarah"};
		int[] scores = {87, 90, 80, 100, 95, 70, 65, 100, 72, 56};
		

		Arrays.sort(scores);

		
		int A = 0;
		int B = 0;
		int C = 0;
		int Avg = 0;
		int Sum = 0;
		
		for (int element: scores) {
			
			Sum = Sum + element;
			
			if (element >= 90) {
				A++ ;
			}
				else if ((element < 90 ) && (element >= 80)) {
				  B++ ;
				}
				else {
				   C++ ;
	      }
	    } // End for
		
		Avg = (Sum / (scores.length));
		System.out.println("Minimum = " + scores[0]);
		System.out.println("Maximum = " + scores[scores.length-1]);
		System.out.println("Average = " + Avg);
		System.out.println("Total Students with A = " + A);
		System.out.println("Total Students with B = " + B);
		System.out.println("Total Students with C = " + C);
		
	}
}
